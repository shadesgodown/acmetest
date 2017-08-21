package com.acme.test.app.service;

import com.acme.test.app.domain.Vinyl;

import java.util.List;

public interface ICrudService {

    Vinyl create(Vinyl vinyl);

    Vinyl findById(Long id);

    List<Vinyl> findAll();

    void delete(Vinyl vinyl);

    void deleteById(Long id);
}
