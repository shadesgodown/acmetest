package com.acme.test.app.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface for a <code>Crosswalk</code> crosser.
 */
public interface ICrosswalkCrosser {
    Logger LOG = LoggerFactory.getLogger(ICrosswalkCrosser.class);

    /**
     * Default implementation to simulate this <code>ICrosswalkCrosser</code> waiting on another
     * <code>ICrosswalkCrosser</code>.
     *
     * @param crosser the <code>ICrosswalkCrosser</code> this <code>ICrosswalker</code> must wait for
     */
    default void waitFor(ICrosswalkCrosser crosser) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOG.warn("InterruptedException occurred in waitFor " + crosser.getName() + ".", e);
        }
        crosser.waitFor(this);
    }

    /**
     * Returns the name of the <code>ICrosswalkCrosser</code>.
     *
     * @return the name of the <code>ICrosswalkCrosser</code>
     */
    String getName();
}
