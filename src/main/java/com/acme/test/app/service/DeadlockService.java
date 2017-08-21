package com.acme.test.app.service;

import com.acme.test.app.domain.Crosswalk;
import com.acme.test.app.domain.Driver;
import com.acme.test.app.domain.Pedestrian;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class DeadlockService implements IDeadlockService {
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

        return executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}
