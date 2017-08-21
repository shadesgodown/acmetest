package com.acme.test.app.service;

import java.util.List;

public interface IFibonacciService {
    List<Long> fibRecO2Expn(int n);
    List<Long> fibRecOn(int n);
    List<Long> fibRecTail(int n);
}
