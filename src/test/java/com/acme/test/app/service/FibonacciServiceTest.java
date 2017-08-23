package com.acme.test.app.service;

import mockit.Deencapsulation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FibonacciServiceTest {

    private IFibonacciService fibonacciService = new FibonacciService();

    @Test(expected = IllegalArgumentException.class)
    public void testFibExpValueNegative() {
        fibonacciService.fibRecO2Expn(41);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibOnValueNegative() {
        fibonacciService.fibRecOn(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibTailRecValueNegative() {
        fibonacciService.fibRecTail(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibExpValueTooHigh() {
        fibonacciService.fibRecO2Expn(41);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibOnValueTooHigh() {
        fibonacciService.fibRecO2Expn(94);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibTailRecValueTooHigh() {
        fibonacciService.fibRecO2Expn(94);
    }

    @Test(expected = StackOverflowError.class)
    public void testFibExpStackOverflow() {
        Deencapsulation.invoke(fibonacciService, "fibRecO2ExpnRaw", 10000);
    }

    @Test(expected = StackOverflowError.class)
    public void testFibOnStackOverflow() {
        Deencapsulation.invoke(fibonacciService, "fibRecOnRaw", 10000);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testFibTailRecNoStackOverflow() {
        List<Long> value = (ArrayList<Long>) Deencapsulation.invoke(fibonacciService, "fibRecTailRaw", 10000);
        assertThat(value.size(), equalTo(10000));
    }

    @Test
    public void testFibExp() {
        List<Long> result = fibonacciService.fibRecO2Expn(8);
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));
        assertThat(result, equalTo(check));
    }

    @Test
    public void testFibOn() {
        List<Long> result = fibonacciService.fibRecOn(8);
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));
        assertThat(result, equalTo(check));
    }

    @Test
    public void testFibTailRec() {
        List<Long> result = fibonacciService.fibRecTail(8);
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));
        assertThat(result, equalTo(check));
    }
}
