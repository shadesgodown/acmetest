package com.acme.test.app.service;

import com.acme.test.app.domain.Vinyl;
import com.acme.test.app.repository.IVinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService implements ICrudService {

    @Autowired
    IVinylRepository vinylRepository;

    public Vinyl create(Vinyl vinyl) {
        return vinylRepository.save(vinyl);
    }

    public Vinyl findById(Long id) {
        return vinylRepository.findOne(id);
    }

    public List<Vinyl> findAll() {
        return (List<Vinyl>) vinylRepository.findAll();
    }

    public void delete(Vinyl vinyl) {
        vinylRepository.delete(vinyl);
    }

    public void deleteById(Long id) {
        vinylRepository.delete(id);
    }
}
