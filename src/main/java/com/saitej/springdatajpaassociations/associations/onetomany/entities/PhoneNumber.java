package com.saitej.springdatajpaassociations.associations.onetomany.entities;



import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Setter
@Getter

public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private  String type;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


}
