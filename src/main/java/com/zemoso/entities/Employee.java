package com.zemoso.entities;

import lombok.*;

import javax.persistence.*;
import com.zemoso.entities.*;

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
    private Integer salary;
    private String email;
    private Integer hikePercentage;


    @JoinColumn(name = "department_id", referencedColumnName = "id", columnDefinition = "uuid")
    private Departments department;

    @JoinColumn(name = "designation_id", referencedColumnName = "id", columnDefinition = "uuid")
    private Designations designation;


}
