package com.acme.test.app.service;

import com.acme.test.app.domain.Crosswalk;
import com.acme.test.app.domain.Driver;
import com.acme.test.app.domain.Pedestrian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class DeadlockService implements IDeadlockService {
    private static final Logger LOG = LoggerFactory.getLogger(DeadlockService.class);

    @Override
    public boolean createDeadlock() throws InterruptedException {
        Crosswalk crosswalk = new Crosswalk();

        Driver driver = new Driver("Speedy McSpeedster", crosswalk);
        Pedestrian pedestrian = new Pedestrian("Vigorous Walker", crosswalk);

        crosswalk.setDriver(driver);
        crosswalk.setPedestrian(pedestrian);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(driver);
        executorService.submit(pedestrian);

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        int counter = 0;
        long[] threadIds = null;
        while(threadIds == null && counter < 3) {
            threadIds = bean.findDeadlockedThreads();
            counter++;
            Thread.sleep(1000);
        }
        int numThreadsLocked = (threadIds == null) ? 0 : threadIds.length;
        LOG.info("Number of threads deadlocked: " + numThreadsLocked);

        return numThreadsLocked == 2 && !executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}
