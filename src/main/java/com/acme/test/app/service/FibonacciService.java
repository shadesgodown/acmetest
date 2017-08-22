package com.acme.test.app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService implements IFibonacciService {

    @Override
    public List<Long> fibRecO2Expn(int n) throws IllegalArgumentException {
        this.validateExp(n);
        return fibRecO2Expn(n, new ArrayList<>(n));
    }

    @Override
    public List<Long> fibRecOn(int n) throws IllegalArgumentException {
        this.validate(n);
        return fibRecOn(n, new ArrayList<>(n));
    }

    @Override
    public List<Long> fibRecTail(int n) throws IllegalArgumentException {
        this.validate(n);
        List<Long> cur = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cur.add(fibRecTail(i, 0, 1));
        }

        return cur;
    }

    private void validate(int n) {
        if (n > 93) {
            throw new IllegalArgumentException("Service does not support calculating more than 93 of the first fibonacci numbers.");
        }
    }

    private void validateExp(int n) {
        if (n > 40) {
            throw new IllegalArgumentException("Service does not support calculating more than 40 of the first fibonacci numbers for O(2^n) (exponential complexity).");
        }
    }

    public List<Long> fibRecO2ExpnRaw(int n) throws IllegalArgumentException {
        return fibRecO2Expn(n, new ArrayList<>(n));
    }

    public List<Long> fibRecOnRaw(int n) throws IllegalArgumentException {
        return fibRecOn(n, new ArrayList<>(n));
    }

    public List<Long> fibRecTailRaw(int n) throws IllegalArgumentException {
        List<Long> cur = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cur.add(fibRecTail(i, 0, 1));
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
            cur.add(cur.get(n - 2) + fibRecO2ExpnRaw(n - 2).get(n - 3));
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

    private long fibRecTail(long n, long prev, long cur) {
        if (n == 0) {
            return prev;
        }

        if (n == 1) {
            return cur;
        }

        return fibRecTail(n - 1, cur, prev + cur);
    }
}
