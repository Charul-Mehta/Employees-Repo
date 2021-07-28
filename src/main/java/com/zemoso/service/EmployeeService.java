package com.zemoso.service;

import com.zemoso.dao.DepartmentsDAO;
import com.zemoso.dao.DesignationsDAO;
import com.zemoso.dao.EmployeeDAO;
import com.zemoso.entities.Departments;
import com.zemoso.entities.Designations;
import com.zemoso.entities.Employee;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private static final Logger logger = Logger.getLogger(String.valueOf(EmployeeService.class));

    @Override
    public Employee saveEmployee(Employee emp) throws NotFoundException {
        logger.log(Level.INFO,departmentsDAO.findAll().toString());
        logger.log(Level.INFO,emp.getDepartment().getName().toString());
        Departments dept= departmentsDAO.findAll().stream().filter(x->x.getName().toLowerCase().trim()== emp.getDepartment().getName().toLowerCase().trim()).findFirst().orElseThrow(() -> new NotFoundException("No dept by name :" + emp.getDepartment().getName()));

        emp.setDepartment(dept);

        Designations designations= designationsDAO.findAll().stream().filter(x->x.getName()==emp.getDesignation().getName()).collect(Collectors.toList()).get(0);
        if(designations!=null)
            emp.setDesignation(designations);


        return employeeDAO.save(emp);
    }
}
