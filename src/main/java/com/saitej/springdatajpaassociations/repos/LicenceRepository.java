package com.saitej.springdatajpaassociations.repos;

import com.saitej.springdatajpaassociations.associations.onetoone.entities.Licence;
import org.springframework.data.repository.CrudRepository;

public interface LicenceRepository extends CrudRepository<Licence,Long> {
}
