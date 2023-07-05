package vn.elca.training.repository;

import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Employee;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Long countAllEmployees();

    Employee getEmployeeById(BigDecimal id);
}
