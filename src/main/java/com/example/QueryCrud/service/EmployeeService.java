package com.example.QueryCrud.service;

import com.example.QueryCrud.entity.Employee;
import com.example.QueryCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void insertEmployee(String name, String department, Double salary) {
        employeeRepository.insertEmployee(name, department, salary);
    }

    public List<Employee> getEmployee(String department) {
        return employeeRepository.getByDepartment(department);
    }

    public void updateEmployee(Long id, Double salary) {
        employeeRepository.updateSalaryById(id, salary);
    }

    public void deleteEmployee(String name) {
        employeeRepository.deleteByName(name);
    }
}
