package com.acme.test.app.domain;

/**
 * Represents a crosswalk that a pedestrian and driver want to cross.
 */
public class Crosswalk {
    // the pedestrian waiting to cross the crosswalk
    private ICrosswalkCrosser pedestrian;

    // the driver waiting to cross the crosswalk
    private ICrosswalkCrosser driver;

    /**
     * Gets the <code>Pedestrian</code> waiting to cross the <code>Crosswalk</code>.
     *
     * @return the <code>Pedestrian</code> waiting to cross the <code>Crosswalk</code>
     */
    public ICrosswalkCrosser getPedestrian() {
        return pedestrian;
    }

    /**
     * Sets the <code>Pedestrian</code> waiting to cross the <code>Crosswalk</code>.
     *
     * @param pedestrian the <code>Pedestrian</code> waiting to cross the <code>Crosswalk</code>
     */
    public void setPedestrian(final ICrosswalkCrosser pedestrian) {
        this.pedestrian = pedestrian;
    }

    /**
     * Gets the <code>Driver</code> waiting to cross the <code>Crosswalk</code>.
     *
     * @return the <code>Driver</code> waiting to cross the <code>Crosswalk</code>
     */
    public ICrosswalkCrosser getDriver() {
        return driver;
    }

    /**
     * Sets the <code>Driver</code> waiting to cross the <code>Crosswalk</code>.
     *
     * @param driver the <code>Driver</code> waiting to cross the <code>Crosswalk</code>
     */
    public void setDriver(final ICrosswalkCrosser driver) {
        this.driver = driver;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Crosswalk crosswalk = (Crosswalk) o;

        if (pedestrian != null ? !pedestrian.equals(crosswalk.pedestrian) : crosswalk.pedestrian != null) return false;
        return driver != null ? driver.equals(crosswalk.driver) : crosswalk.driver == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = pedestrian != null ? pedestrian.hashCode() : 0;
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Crosswalk{" +
                "pedestrian=" + pedestrian +
                ", driver=" + driver +
                '}';
    }
}
