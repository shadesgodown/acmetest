package com.acme.test.app.repository;

import com.acme.test.app.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A JPA <code>Repository</code> used for creating, reading, updating, and deleting
 * <code>Album</code> entities.
 */
@Repository
public interface IAlbumRepository extends CrudRepository<Album, Long> {
}
