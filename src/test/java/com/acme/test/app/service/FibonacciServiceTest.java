package com.acme.test.app.service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FibonacciServiceTest {

    private IFibonacciService fibonacciService = new FibonacciService();

    @Test
    public void fibRecTest() {
//        List<Long> result = fibonacciService.fibRec2(1);
//        List<Long> check = new ArrayList<>();
//        check.add(0);
//        assertThat(result, equalTo(check));
//
//        result = fibonacciService.fibRec(2, null);
//        check = new ArrayList<>(2);
//        check.addAll(new ArrayList(Arrays.asList(0, 1)));
//        assertThat(result, equalTo(check));

//        List<Long> result = fibonacciService.fibRecO2Expn(7);
//        List<Long> check = new ArrayList<>(7);
//        check.addAll(new ArrayList(Arrays.asList(0, 1, 1)));
//        assertThat(result, equalTo(check));

//        List<Long> result = fibonacciService.fibRecOn(6);
//        List<Long> check = new ArrayList<>(6);
//        check.addAll(new ArrayList(Arrays.asList(0, 1, 1)));
//        assertThat(result, equalTo(check));

        List<Long> result = fibonacciService.fibRecTail(93);
        List<Long> check = new ArrayList<>(93);
        check.addAll(new ArrayList(Arrays.asList(0, 1, 1)));
        assertThat(result, equalTo(check));

//        List<Long> result = fibonacciService.fibRecOn(10000);
//        List<Long> check = new ArrayList<>(10000);
//        check.addAll(new ArrayList(Arrays.asList(0, 1, 1)));
//        assertThat(result, equalTo(check));

//        List<Long> result = fibonacciService.fibRecO2Expn(10000);
//        List<Long> check = new ArrayList<>(10000);
//        check.addAll(new ArrayList(Arrays.asList(0, 1, 1)));
//        assertThat(result, equalTo(check));
    }
}
