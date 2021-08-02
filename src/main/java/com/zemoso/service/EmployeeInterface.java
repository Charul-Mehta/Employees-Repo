package com.zemoso.service;

import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;

public interface EmployeeInterface {
    Employee saveEmployee(Employee emp) throws NotFoundException;

    Employee updateEmployee(String id, int hike) throws NotFoundException;
}
