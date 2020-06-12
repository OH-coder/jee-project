package com.iit.jee.Conventions.Services;

import com.iit.jee.Conventions.Dao.ConventionRepository;
import com.iit.jee.Conventions.entities.Convention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ConventionService {
    @Autowired
    private ConventionRepository repository;
    public List<Convention> listAll() {
        Page <Convention> conventions=repository.findAll(PageRequest.of(0,5));
        return conventions.getContent();
    }

    public void save(Convention convention) {
        repository.save(convention);
    }

    public Convention get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
