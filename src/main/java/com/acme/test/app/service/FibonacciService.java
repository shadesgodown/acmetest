package com.acme.test.app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService implements IFibonacciService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> fibRecO2Expn(int n) {
        this.validateExp(n);
        return fibRecO2Expn(n, new ArrayList<>(n));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> fibRecOn(int n) {
        this.validateMax(n);
        return fibRecOn(n, new ArrayList<>(n));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Long> fibRecTail(int n) {
        this.validateMax(n);
        List<Long> cur = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cur.add(fibRecTail(i, 0, 1));
        }

        return cur;
    }

    private void validateMax(int n) {
        // Fibonacci numbers after the 93rd value exceed Long.MAX_VALUE
        if (n > 93) {
            throw new IllegalArgumentException("Fibonacci Service does not support calculating more than 93 of the first fibonacci numbers.");
        }

        this.validatePositive(n);
    }

    private void validateExp(int n) {
        // The exponential implementation takes too long for more than 40 values
        if (n > 40) {
            throw new IllegalArgumentException("Fibonacci Service does not support calculating more than 40 of the first fibonacci numbers for O(2^n) (exponential complexity).");
        }

        this.validatePositive(n);
    }

    private void validatePositive(int n) {
        // An n less than 1 is of no value
        if (n < 1) {
            throw new IllegalArgumentException("Fibonacci Service does no support calculating for values less than 1.");
        }
    }

    // Used to demonstrate StackOverflow
    private List<Long> fibRecO2ExpnRaw(int n) {
        return fibRecO2Expn(n, new ArrayList<>(n));
    }

    // Used to demonstrate StackOverflow
    private List<Long> fibRecOnRaw(int n) {
        return fibRecOn(n, new ArrayList<>(n));
    }

    // Used to demonstrate no StackOverflow
    private List<Long> fibRecTailRaw(int n) {
        List<Long> cur = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cur.add(fibRecTail(i, 0l, 1l));
        }

        return cur;
    }

    private List<Long> fibRecO2Expn(int n, List<Long> cur) {
        if (n == 1) {
            cur.add(0l);
        }

        if (n == 2) {
            cur = fibRecO2Expn(n - 1, cur);
            cur.add(1l);
        }

        if (n > 2) {
            cur = fibRecO2Expn(n - 1, cur);
            cur.add(cur.get(n - 2) + fibRecO2Expn(n - 2).get(n - 3));
        }

        return cur;
    }

    private List<Long> fibRecOn(int n, List<Long> cur) {
        if (n == 1) {
            cur.add(0l);
        }

        if (n == 2) {
            cur = fibRecOn(n - 1, cur);
            cur.add(1l);
        }

        if (n > 2) {
            cur = fibRecOn(n - 1, cur);
            cur.add(cur.get(n - 2) + cur.get(n - 3));
        }

        return cur;
    }

    private long fibRecTail(int n, long prev, long cur) {
        if (n == 0) {
            return prev;
        }

        if (n == 1) {
            return cur;
        }

        return fibRecTail(n - 1, cur, prev + cur);
    }
}
