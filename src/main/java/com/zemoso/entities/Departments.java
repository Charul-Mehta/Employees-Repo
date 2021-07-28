package com.zemoso.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Data
@Table(name="departments")
public class Departments{
    @Id
    private UUID id=UUID.randomUUID();
    private String name;

    public Departments() {
    }

    public Departments(String name) {
        this.name=name;
    }
}
