package com.acme.test.app.domain;

public class Crosswalk {
    private ICrosswalkCrosser pedestrian;
    private ICrosswalkCrosser driver;

    public ICrosswalkCrosser getPedestrian() {
        return pedestrian;
    }

    public void setPedestrian(final ICrosswalkCrosser pedestrian) {
        this.pedestrian = pedestrian;
    }

    public ICrosswalkCrosser getDriver() {
        return driver;
    }

    public void setDriver(final ICrosswalkCrosser driver) {
        this.driver = driver;
    }
}
