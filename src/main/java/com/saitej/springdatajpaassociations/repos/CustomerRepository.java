package com.saitej.springdatajpaassociations.repos;


import com.saitej.springdatajpaassociations.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
