package com.acme.test.app.service;

import com.acme.test.app.domain.Album;

import java.util.List;

public interface ICrudService {

    Album create(Album album);

    Album findById(Long id);

    List<Album> findAll();

    void delete(Album album);

    void deleteById(Long id);
}
