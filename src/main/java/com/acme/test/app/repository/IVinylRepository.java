package com.acme.test.app.repository;

import com.acme.test.app.domain.Vinyl;
import org.springframework.data.repository.CrudRepository;

public interface IVinylRepository extends CrudRepository<Vinyl, Long> {
}
