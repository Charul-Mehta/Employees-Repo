package com.zemoso.controller;

import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;
import com.zemoso.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("employee")
    public Employee saveEmployee( @RequestBody Employee emp) throws NotFoundException {
        return employeeService.saveEmployee(emp);
    }

    @PutMapping("promoteEmployee")
    public Employee updateEmployee(String id, int hike) throws NotFoundException {
        return employeeService.updateEmployee(id, hike);
    }

    @GetMapping("employeesByDept/{name}")
    public List<Employee> getEmployeesByDept(@PathVariable(value = "name") String name){
        return  employeeService.getEmployeesByDept(name);
    }
}
