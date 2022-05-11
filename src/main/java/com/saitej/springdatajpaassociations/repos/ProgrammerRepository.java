package com.saitej.springdatajpaassociations.repos;

import com.saitej.springdatajpaassociations.associations.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;



public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
}
