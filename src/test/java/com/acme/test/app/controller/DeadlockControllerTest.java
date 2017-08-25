package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.acme.test.app.service.IDeadlockService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

@RunWith(JMockit.class)
public class DeadlockControllerTest {

    @Tested
    DeadlockController deadlockController;

    @Injectable
    IDeadlockService deadlockService;

    @Test
    public void testCreateDeadlock() throws Exception {
        new Expectations() {{
            deadlockService.createDeadlock();
            result = true;
            result = false;
        }};

        assertThat(deadlockController.deadlock(), equalTo(new Response(ResponseType.DEADLOCK, "Deadlock occurred between Pedestrian and Driver at the Crosswalk.")));

        try {
            deadlockController.deadlock();
            fail();
        } catch (Exception ex) {
            assertThat(ex.getMessage(), equalTo("Deadlock did not occur between Pedestrian and Driver at the Crosswalk."));
        }
    }

}
