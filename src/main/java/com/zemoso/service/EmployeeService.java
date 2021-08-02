package com.zemoso.service;

import com.zemoso.dao.DepartmentsDAO;
import com.zemoso.dao.DesignationsDAO;
import com.zemoso.dao.EmployeeDAO;
import com.zemoso.entities.Department;
import com.zemoso.entities.Designation;
import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class EmployeeService implements EmployeeInterface {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    DesignationsDAO designationsDAO;

    @Autowired
    DepartmentsDAO departmentsDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    private static final Logger logger = Logger.getLogger(String.valueOf(EmployeeService.class));

    @Override
    public Employee saveEmployee(Employee emp) throws NotFoundException {
        return employeeDAO.save(emp);
    }

    @Override
    public Employee updateEmployee(String id, int hike) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        Employee employee=employeeDAO.findById(uuid).orElseThrow(() -> new NotFoundException("No dept by id :" + id));
        employee.setSalary((int)employee.getSalary()*hike/100+employee.getSalary());
        employeeDAO.save(employee);
        return employee;
    }


}
