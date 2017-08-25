package com.acme.test.app.service;

/**
 * Interface for service used to create a deadlock scenario between two threads.
 */
public interface IDeadlockService {
    /**
     * Creates a deadlock scenario between two threads (each thread is waiting on the other).
     * Simulates a deadlock between a <code>Pedestrian</code> and a <code>Driver</code>
     * at a <code>Crosswalk</code>, each one waiting for the other to cross. The method
     * times out after 3 seconds and returns the deadlock state.
     *
     * @return <code>boolean</code> true if deadlock occurred or false if it did not
     * @throws InterruptedException if the threads are interrupted while waiting
     */
    boolean createDeadlock() throws InterruptedException;
}
