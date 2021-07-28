package com.zemoso.controller;

import com.zemoso.dao.EmployeeDAO;
import com.zemoso.entities.Departments;
import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;
import com.zemoso.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("employee")
    public Employee saveEmployee( @RequestBody Employee emp) throws NotFoundException {
        System.out.println(emp.getDepartment());
        return employeeService.saveEmployee(emp);
    }
}
