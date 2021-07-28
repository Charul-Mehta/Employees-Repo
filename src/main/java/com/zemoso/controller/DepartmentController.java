package com.zemoso.controller;

import com.zemoso.entities.*;
import com.zemoso.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import com.zemoso.service.DepartmentsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class DepartmentController {

    @Autowired
    DepartmentsService departmentsService;

    // save department
    @PostMapping("depts/{name}")
    public Departments createDept(@PathVariable(value = "name") String name){
        System.out.println("entered");
        return departmentsService.saveDept(name);
    }

    // get all departments
    @GetMapping("/depts")
    public List<Departments> getAllDepts(){
        return departmentsService.getDepts();
    }

    // get department by Id
    @GetMapping("/depts/{id}")
    public Departments getDeptsById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return departmentsService.getDeptsById(uuid);
    }

    @DeleteMapping("/depts/delete/{id}")
    public boolean deleteDeptById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return departmentsService.deleteDept(uuid);
    }

    @PutMapping("/depts/update/{id}")
    public Departments updateById(@PathVariable(value = "id") String id, @RequestBody Departments dept) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        System.out.println(uuid);
        return departmentsService.updateDept(uuid, dept);
    }
}
