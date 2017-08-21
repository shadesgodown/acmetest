package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver implements ICrosswalkCrosser, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);

    private String name;
    private Crosswalk crosswalk;

    public Driver(String name, Crosswalk crosswalk) {
        this.name = name;
        this.crosswalk = crosswalk;
    }

    @Override
    public void run() {
        this.waitFor(crosswalk.getPedestrian());
    }

    @Override
    public synchronized void waitFor(ICrosswalkCrosser crosser) {
        LOG.info("Driver, " + this.getName() + ", is waiting to cross the crosswalk after " + crosser.getName() + ".");
        ICrosswalkCrosser.super.waitFor(crosser);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
