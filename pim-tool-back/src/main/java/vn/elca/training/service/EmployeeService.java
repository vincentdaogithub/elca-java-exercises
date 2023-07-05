package vn.elca.training.service;

import vn.elca.training.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    Long countAllEmployees();
}
