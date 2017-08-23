package com.acme.test.app.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeadlockServiceTest {

    private IDeadlockService deadlockService = new DeadlockService();

    @Test
    public void testDeadlock() throws InterruptedException {
        assertThat(deadlockService.createDeadlock(), is(true));
    }
}
