package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedestrian implements ICrosswalkCrosser, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Pedestrian.class);

    private String name;
    private Crosswalk crosswalk;

    public Pedestrian(String name, Crosswalk crosswalk) {
        this.name = name;
        this.crosswalk = crosswalk;
    }

    @Override
    public void run() {
        this.waitFor(crosswalk.getDriver());
    }

    @Override
    public synchronized void waitFor(ICrosswalkCrosser crosser) {
        LOG.info("Pedestrian, " + this.getName() + ", is waiting to cross the crosswalk after " + crosser.getName() + ".");
        ICrosswalkCrosser.super.waitFor(crosser);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
