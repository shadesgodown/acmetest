package com.acme.test.app.service;

import java.util.List;

/**
 * Interface for service used to calculate and return the first <code>n</code> values in the Fibonacci sequence.
 * Three versions of the algorithm are implemented (one that has exponential complexity, one that
 * has complexity of O(n), and one that is tail recursive (will not cause a <code>StackOverflowError</code>).
 */
public interface IFibonacciService {
    /**
     * Calculates the first <code>n</code> values in the Fibonacci sequence using an
     * implementation with O(2^n) complexity. This method takes too long to calculate
     * the sequence after 40 values. An <code>IllegalArgumentException</code> is
     * thrown if <code>n</code> is less than 1 or greater than 40.
     *
     * @param n the number of values in the sequence to calculate (between 1 and 40)
     * @return <code>List</code> containing the calculated values
     */
    List<Long> fibRecO2Expn(int n);

    /**
     * Calculates the first <code>n</code> values in the Fibonacci sequence using an
     * implementation with O(n) complexity. Values after the 93rd exceed Long.MAX_VALUE.
     * An <code>IllegalArgumentException</code> is thrown if <code>n</code> is less than
     * 1 or greater than 93.
     *
     * @param n the number of values in the sequence to calculate (between 1 and 93)
     * @return <code>List</code> containing the calculated values
     */
    List<Long> fibRecOn(int n);

    /**
     * Calculates the first <code>n</code> values in the Fibonacci sequence using an
     * implementation with complexity of calculating the previous value plus <code>n - 1</code>
     * but with a tail recursive algorithm (will not cause a <code>StackOverflowError</code>).
     * Values after the 93rd exceed Long.MAX_VALUE. An <code>IllegalArgumentException</code>
     * is thrown if <code>n</code> is less than 1 or greater than 93.
     *
     * @param n the number of values in the sequence to calculate (between 1 and 93)
     * @return <code>List</code> containing the calculated values
     */
    List<Long> fibRecTail(int n);
}
