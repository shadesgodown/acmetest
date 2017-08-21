package com.acme.test.app.service;

public interface IDeadlockService {
    boolean createDeadlock() throws InterruptedException;
}
