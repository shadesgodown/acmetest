package com.acme.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for an ACME Spring Boot Test Application that has a diverse set of endpoints:
 * 1. A "Hello World" endpoint that basically returns "Hello World"
 * 2. Three Fibonacci sequence endpoints that take a number, N, and return an array with
 * the first N Fibonacci numbers. The three endpoints use recursive algorithms of various
 * complexity (exponential O(2^n), O(n), and a tail recursive algorithm).
 * 3. A Deadlock endpoint that causes two threads to become deadlocked and returns
 * the deadlock state after a timeout of 3 seconds. This implementation simulates a real-life deadlock
 * situation in which a <code>Pedestrian</code> and a <code>Driver</code> are waiting for each other
 * to cross a <code>Crosswalk</code>.
 * 4. Several CRUD endpoints that add, query, and delete rows representing Pearl Jam
 * <code>Album</code>s from a HyperSQL, in-memory database.
 * 5. An External endpoint that uses Spring <code>RestTemplate</code> to return the data
 * from a specific external endpoint (https://jsonplaceholder.typicode.com/posts).
 */
@SpringBootApplication
public class Application {

    /**
     * Main method for the ACME Spring Boot Test Application.
     *
     * @param args <code>String</code> array of command line arguments (none needed for this application)
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}