package com.zemoso.entities;

import lombok.*;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(name = "employee")
public class Employee{
    @Id
    private UUID id=UUID.randomUUID();
    private String name;
    private int salary;
    private String email;
    @Column(name = "hike_percentage")
    private int hikePercentage;

    public Employee(UUID id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary=salary;
    }

    public Employee(){

    }
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", columnDefinition = "uuid")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "id", columnDefinition = "uuid")
    private Designation designation;


}
