package com.example.QueryCrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 10, message = "Name must be between 3 and 10 characters")
    String name;

    @NotBlank(message = "Department cannot be blank")
    @Size(min = 2, max = 15, message = "Department must be between 2 and 15 characters")
    String department;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 100000, message = "Salary must not exceed 100000")
    Double salary;
}
