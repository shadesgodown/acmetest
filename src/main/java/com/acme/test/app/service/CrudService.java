package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import com.acme.test.app.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService implements ICrudService {

    @Autowired
    IAlbumRepository albumRepository;

    public Album create(Album album) {
        return albumRepository.save(album);
    }

    public Album findById(Long id) {
        return albumRepository.findOne(id);
    }

    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    public void delete(Album album) {
        albumRepository.delete(album);
    }

    public void deleteById(Long id) {
        albumRepository.delete(id);
    }
}
