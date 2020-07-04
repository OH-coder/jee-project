package com.iit.jee.springboot.springsecurity.service;


import com.iit.jee.springboot.springsecurity.model.Convention;
import com.iit.jee.springboot.springsecurity.repository.ConventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;


@Service
@Transactional
public class ConventionService {
    @Autowired
    private ConventionRepository repository;

    public Page<Convention> listAll(int page, int size) {
        Page<Convention> conventions = repository.findAll(PageRequest.of(page, size));
        return conventions;
    }

    public Page<Convention> chercher(Date mc, int page, int size) throws ParseException {
        Page<Convention> conventions = repository.findAllBySignatureContains(mc, PageRequest.of(page, size));
        return conventions;
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

    public Page<Convention> listAll2(String mc, int page, int size) {
        Page<Convention> conventions = repository.findAllByObjetContainingOrTypeContaining(mc, mc, PageRequest.of(page, size));
        return conventions;
    }
}
