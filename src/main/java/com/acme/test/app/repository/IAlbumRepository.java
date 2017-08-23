package com.acme.test.app.repository;

import com.acme.test.app.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends CrudRepository<Album, Long> {
}
