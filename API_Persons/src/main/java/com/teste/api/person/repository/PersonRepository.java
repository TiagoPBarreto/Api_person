package com.teste.api.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.api.person.model.PersonEntity;



@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
