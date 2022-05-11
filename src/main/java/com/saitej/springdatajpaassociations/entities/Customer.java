package com.saitej.springdatajpaassociations.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

      public void addPhoneNumber(PhoneNumber phoneNumber){
          if(phoneNumber !=null){
              if(numbers == null){
                  numbers = new HashSet<>();
              }
              phoneNumber.setCustomer(this);
              numbers.add(phoneNumber);
          }
      }


}
