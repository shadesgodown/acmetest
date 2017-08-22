package com.acme.test.app.repository;

import com.acme.test.app.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface IAlbumRepository extends CrudRepository<Album, Long> {
}
