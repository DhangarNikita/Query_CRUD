package com.example.QueryCrud.controller;

import com.example.QueryCrud.entity.Employee;
import com.example.QueryCrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<String> addEmployee(@Valid@RequestBody Employee employee) {
        employeeService.insertEmployee(employee.getName(), employee.getDepartment(), employee.getSalary());
        return ResponseEntity.ok("Data inserted successfully");
    }

    @GetMapping("/get/{department}")
    public ResponseEntity<List<Employee>> readEmployee(@PathVariable("department") String department) {
        return ResponseEntity.ok(employeeService.getEmployee(department));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSalary(@PathVariable("id") Long id, @Valid@RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee.getSalary());
        return ResponseEntity.ok("Salary updated successfully");
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("name") String name) {
        employeeService.deleteEmployee(name);
        return ResponseEntity.ok("data delete successfully");
    }
}
