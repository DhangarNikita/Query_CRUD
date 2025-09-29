package com.example.QueryCrud.repository;

import com.example.QueryCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // insert query
    @Modifying
    @Transactional
    @Query(value = "insert into employee (name,department,salary) values (:name, :department,:salary) ", nativeQuery = true)
    void insertEmployee(@Param("name") String name,
                        @Param("department") String department,
                        @Param("salary") Double salary);

    // read by department
    @Query(value = "SELECT * FROM employee WHERE department = :department", nativeQuery = true)
    List<Employee> getByDepartment(@Param("department") String department);

    //update
    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET salary = :salary WHERE id = :id", nativeQuery = true)
    int updateSalaryById(@Param("id") Long id, @Param("salary") Double salary);

    //delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM employee WHERE name = :name", nativeQuery = true)
    int deleteByName(@Param("name") String name);
}
