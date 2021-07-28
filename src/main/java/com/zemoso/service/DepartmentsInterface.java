package com.zemoso.service;


import com.zemoso.entities.Departments;
import com.zemoso.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface DepartmentsInterface {

    List<Departments> getDepts();

    Departments getDeptsById(UUID id) throws NotFoundException;

    Departments saveDept(String name);

    Departments updateDept(UUID id, Departments dept) throws NotFoundException;

    Boolean deleteDept(UUID id) throws NotFoundException;
}
