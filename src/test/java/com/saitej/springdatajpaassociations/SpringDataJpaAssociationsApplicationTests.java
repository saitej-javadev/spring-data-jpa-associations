package com.saitej.springdatajpaassociations;


import com.saitej.springdatajpaassociations.associations.manytomany.entities.Programmer;
import com.saitej.springdatajpaassociations.associations.manytomany.entities.Project;
import com.saitej.springdatajpaassociations.associations.onetomany.entities.Customer;
import com.saitej.springdatajpaassociations.associations.onetomany.entities.PhoneNumber;
import com.saitej.springdatajpaassociations.associations.onetoone.entities.Licence;
import com.saitej.springdatajpaassociations.associations.onetoone.entities.Person;
import com.saitej.springdatajpaassociations.repos.CustomerRepository;
import com.saitej.springdatajpaassociations.repos.LicenceRepository;
import com.saitej.springdatajpaassociations.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class SpringDataJpaAssociationsApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProgrammerRepository programmerRepository;


    @Autowired
    private LicenceRepository licenceRepository;

   /*Customer related test cases    -  @OneToMany*/

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Tillu");
        PhoneNumber pn1 = new PhoneNumber();
        pn1.setNumber("123456789");
        pn1.setType("cell");

        PhoneNumber pn2 = new PhoneNumber();
        pn2.setNumber("123456789");
        pn2.setType("home");

        customer.addPhoneNumber(pn1);
        customer.addPhoneNumber(pn2);
        customerRepository.save(customer);
    }

    @Test
    @Transactional
    void testgetCustomer() {
        Optional<Customer> customer = customerRepository.findById(3L);
        System.out.println(customer.get().getName());

        Set<PhoneNumber> numbers = customer.get().getNumbers();
        numbers.forEach(phoneNumber -> System.out.println(phoneNumber.getNumber()));
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = customerRepository.findById(3L).orElse(null);
        customer.setName("John");
        customer.getNumbers().forEach(phoneNumber -> phoneNumber.setType("home"));
        customerRepository.save(customer);
    }

    @Test
    void deleteCustomer() {
        customerRepository.deleteById(4L);
    }


   /* Programmer related testcases   -  @ManyToMany*/

    @Test
    void testCreateProgrammer() {

        Programmer programmer = new Programmer();
        programmer.setName("John");
        programmer.setSal(10000);
        HashSet<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("Hibernate Project");
        projects.add(project);
        programmer.setProjects(projects);
        programmerRepository.save(programmer);


    }


    @Test
    @Transactional//to avoid org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role:
    void testGetProgrammer() {
        Programmer programmer = programmerRepository.findById(2).orElse(null);
        System.out.println(programmer);
        System.out.println(programmer.getProjects());
    }

    /* Licence related testcases   -  @OneToOne*/

    @Test
    void testCreateLicence() {

        Licence licence = new Licence();
        licence.setType("House");
        licence.setValidFrom(new Date());
        licence.setValidTo(new Date());

        Person person = new Person();
        person.setFirstName("Elon");
        person.setLastName("Musk");
        person.setAge(50);

        licence.setPerson(person);

        licenceRepository.save(licence);

    }
}
