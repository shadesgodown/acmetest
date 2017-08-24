package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a driver who waits to cross a crosswalk and waits for a pedestrian.
 */
public class Driver implements ICrosswalkCrosser, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);

    // the name of the Driver
    private String name;

    // the Crosswalk the Driver is waiting to cross
    private Crosswalk crosswalk;

    /**
     * Constructor to create a <code>Driver</code> that has the passed in name and is trying to cross
     * the passed in <code>Crosswalk</code>.
     *
     * @param name the name of the <code>Driver</code>
     * @param crosswalk the <code>Crosswalk</code> the <code>Driver</code> is waiting to cross
     */
    public Driver(String name, Crosswalk crosswalk) {
        this.name = name;
        this.crosswalk = crosswalk;
    }

    /**
     * The method that runs when the Thread is created. Forces the <code>Driver</code>
     * to wait for the <code>Pedestrian</code> at the <code>Crosswalk</code>.
     */
    @Override
    public void run() {
        this.waitFor(crosswalk.getPedestrian());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void waitFor(ICrosswalkCrosser crosser) {
        LOG.info("Driver, " + this.getName() + ", is waiting to cross the crosswalk after " + crosser.getName() + ".");
        ICrosswalkCrosser.super.waitFor(crosser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Driver driver = (Driver) o;

        if (name != null ? !name.equals(driver.name) : driver.name != null) return false;
        return crosswalk != null ? crosswalk.equals(driver.crosswalk) : driver.crosswalk == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (crosswalk != null ? crosswalk.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", crosswalk=" + crosswalk +
                '}';
    }
}
