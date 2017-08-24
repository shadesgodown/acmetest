package com.acme.test.app.service;

import com.acme.test.app.domain.Album;
import com.acme.test.app.repository.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Default implementation of the service used to create, read, and delete <code>Album</code> entities.
 */
@Service
public class CrudService implements ICrudService {

    @Autowired
    private IAlbumRepository albumRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Album create(Album album) {
        return albumRepository.save(album);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Album findById(Long id) {
        return albumRepository.findOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Album> findAll() {
        return (List<Album>) albumRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Album album) {
        albumRepository.delete(album);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        albumRepository.delete(id);
    }
}
