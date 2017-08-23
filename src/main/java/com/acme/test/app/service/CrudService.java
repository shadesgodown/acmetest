package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import com.acme.test.app.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class CrudService implements ICrudService {

    @Autowired
    private IAlbumRepository albumRepository;

    @Override
    public Album create(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.delete(id);
    }
}
