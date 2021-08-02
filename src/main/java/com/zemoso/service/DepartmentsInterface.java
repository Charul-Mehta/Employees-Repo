package com.zemoso.service;


import com.zemoso.entities.Department;
import com.zemoso.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface DepartmentsInterface {

    List<Department> getDepts();

    Department getDeptsById(UUID id) throws NotFoundException;

    Department saveDept(String name);

    Department updateDept(UUID id, Department dept) throws NotFoundException;

    Boolean deleteDept(UUID id) throws NotFoundException;
}
