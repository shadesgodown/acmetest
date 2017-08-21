package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ICrosswalkCrosser {
    Logger LOG = LoggerFactory.getLogger(ICrosswalkCrosser.class);

    String getName();

    default void waitFor(ICrosswalkCrosser crosser) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.warn("InterruptionException occurred in waitFor " + crosser.getName() + ".", e);
        }
        crosser.waitFor(this);
    }
}
