package com.saitej.springdatajpaassociations;

import com.saitej.springdatajpaassociations.entities.Customer;
import com.saitej.springdatajpaassociations.entities.PhoneNumber;
import com.saitej.springdatajpaassociations.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class SpringDataJpaAssociationsApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

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
        ;
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
}
