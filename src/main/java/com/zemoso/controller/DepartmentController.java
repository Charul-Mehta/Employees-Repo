package com.zemoso.controller;

import com.zemoso.entities.*;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zemoso.service.DepartmentsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/depts")
public class DepartmentController {

    @Autowired
    DepartmentsService departmentsService;

    // save department
    @PostMapping("depts/{name}")
    public Department createDept(@PathVariable(value = "name") String name){
        System.out.println("entered");
        return departmentsService.saveDept(name);
    }

    // get all departments
    @GetMapping
    public List<Department> getAllDepts(){
        return departmentsService.getDepts();
    }

    // get department by Id
    @GetMapping("/depts/{id}")
    public Department getDeptsById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return departmentsService.getDeptsById(uuid);
    }

    @DeleteMapping("/depts/delete/{id}")
    public boolean deleteDeptById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return departmentsService.deleteDept(uuid);
    }

    @PutMapping("/depts/update/{id}")
    public Department updateById(@PathVariable(value = "id") String id, @RequestBody Department dept) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        System.out.println(uuid);
        return departmentsService.updateDept(uuid, dept);
    }
}
