package vn.elca.training.service;

import vn.elca.training.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Long countAllEmployees();
}
