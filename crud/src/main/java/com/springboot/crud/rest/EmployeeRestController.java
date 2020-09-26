package com.springboot.crud.rest;

import com.springboot.crud.dao.EmployeeDAO;
import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id not found " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmloyee) {

        // to force a save of new employee
        theEmloyee.setId(0);

        employeeService.save(theEmloyee);

        return theEmloyee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmloyee){

        employeeService.save(theEmloyee);

        return theEmloyee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null ) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
