package com.acme.test.app.service;

import com.acme.test.app.domain.Album;

import java.util.List;

/**
 * Interface for service used to create, read, and delete <code>Album</code> entities.
 */
public interface ICrudService {

    /**
     * Creates an <code>Album</code> in the repository.
     *
     * @param album <code>Album</code> to create
     * @return the <code>Album</code> that is created
     */
    Album create(Album album);

    /**
     * Finds an <code>Album</code> by id in the repository.
     *
     * @param id the id of the <code>Album</code> to find
     * @return the <code>Album</code> or <code>null</code> if not found
     */
    Album findById(Long id);

    /**
     * Find all <code>Album</code> entities in the repository.
     *
     * @return all the <code>Album</code> entities in the repository
     */
    List<Album> findAll();

    /**
     * Deletes the <code>Album</code> passed in from the repository.
     *
     * @param album the <code>Album</code> to delete
     */
    void delete(Album album);

    /**
     * Deletes the <code>Album</code> with the passed in id from the repository.
     *
     * @param id the id of the <code>Album</code> to delete
     */
    void deleteById(Long id);
}
