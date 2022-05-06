package com.sample.springboot.cruddemo.rest;

import com.sample.springboot.cruddemo.entity.Employee;
import com.sample.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("EmployeeId - " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveNewEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public boolean deleteEmployee(@PathVariable int employeeId){
        if(employeeService.getEmployeeById(employeeId)==null){
            return false;
        }
        employeeService.deleteEmployee(employeeId);
        return true;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        employee.setId(employeeId);
        employeeService.saveEmployee(employee);

        return employee;

    }



}
