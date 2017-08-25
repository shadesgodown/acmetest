package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a pedestrian who waits to cross a crosswalk and waits for a driver.
 */
public class Pedestrian implements ICrosswalkCrosser, Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Pedestrian.class);

    // the naame of the Pedestrian
    private String name;

    // the Crosswalk the Pedestrian is waiting to cross
    private Crosswalk crosswalk;

    /**
     * Constructor to create a <code>Pedestrian</code> that has the passed in name and is trying to cross
     * the passed in <code>Crosswalk</code>.
     *
     * @param name      the name of the <code>Pedestrian</code>
     * @param crosswalk the <code>Crosswalk</code> the <code>Pedestrian</code> is waiting to cross
     */
    public Pedestrian(String name, Crosswalk crosswalk) {
        this.name = name;
        this.crosswalk = crosswalk;
    }

    /**
     * The method that runs when the Thread is created. Forces the <code>Pedestrian</code>
     * to wait for the <code>Driver</code> at the <code>Crosswalk</code>.
     */
    @Override
    public void run() {
        this.waitFor(crosswalk.getDriver());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void waitFor(ICrosswalkCrosser crosser) {
        LOG.info("Pedestrian, " + this.getName() + ", is waiting to cross the crosswalk after " + crosser.getName() + ".");
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

        final Pedestrian that = (Pedestrian) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return crosswalk != null ? crosswalk.equals(that.crosswalk) : that.crosswalk == null;
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
        return "Pedestrian{" +
                "name='" + name + '\'' +
                ", crosswalk=" + crosswalk +
                '}';
    }
}
