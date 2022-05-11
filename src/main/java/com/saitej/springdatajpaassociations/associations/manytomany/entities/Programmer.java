package com.saitej.springdatajpaassociations.associations.manytomany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Programmer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "salary")
    private int sal;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programmers_projects",
            joinColumns = @JoinColumn(name = "programmer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id"))
    private Set<Project> projects;

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
