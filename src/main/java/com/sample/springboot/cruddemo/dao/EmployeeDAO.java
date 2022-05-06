package com.sample.springboot.cruddemo.dao;

import com.sample.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee getEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);

}
