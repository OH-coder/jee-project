package com.iit.jee.springboot.springsecurity.repository;


import com.iit.jee.springboot.springsecurity.model.Convention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConventionRepository extends JpaRepository <Convention,Long>{
    public Page<Convention> findAllByObjetContains(String object, Pageable pageable);

    @Query(value = " select * FROM convention where objet sounds like  ?1" +
            " OR date_edition sounds like ?1 OR declenche sounds like ?1 OR type sounds like ?1 OR " +
            "signature  sounds like ?1 OR date_expiration  sounds like ?1 ", nativeQuery = true)
    public Page<Convention> findAll(String mc, Pageable janaya);







}
