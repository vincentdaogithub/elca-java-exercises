package vn.elca.training.repository;

import vn.elca.training.model.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Long countAllEmployees();
}
