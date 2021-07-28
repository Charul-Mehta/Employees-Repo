package com.zemoso.controller;

import com.zemoso.entities.Departments;
import com.zemoso.entities.Designations;
import com.zemoso.exception.NotFoundException;
import com.zemoso.service.DesignationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class DesignationController {

    @Autowired
    DesignationsService designationsService;

    // save Designation
    @PostMapping("/designation/{name}")
    public Designations createDesignation(@PathVariable(value = "name") String name){
        System.out.println("entered");
        return designationsService.saveDesignation(name);
    }

    // get all departments
    @GetMapping("/designation")
    public List<Designations> getAllDepts(){
        return designationsService.getDesignation();
    }

    // get department by Id
    @GetMapping("/designation/{id}")
    public Designations getDeptsById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return designationsService.getDesignationById(uuid);
    }

    @DeleteMapping("/designation/delete/{id}")
    public boolean deleteDeptById(@PathVariable(value = "id") String id) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        return designationsService.deleteDesignation(uuid);
    }

    @PutMapping("/designation/update/{id}")
    public Designations updateById(@PathVariable(value = "id") String id, @RequestBody Designations dept) throws NotFoundException {
        UUID uuid=UUID.fromString(id);
        System.out.println(uuid);
        return designationsService.updateDesignation(uuid, dept);
    }
}
