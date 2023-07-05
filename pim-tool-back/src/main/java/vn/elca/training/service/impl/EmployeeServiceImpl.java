package vn.elca.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.elca.training.model.dto.EmployeeDto;
import vn.elca.training.model.mapper.EntityMapper;
import vn.elca.training.repository.EmployeeRepository;
import vn.elca.training.service.EmployeeService;
import vn.elca.training.service.custom.AbstractService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl extends AbstractService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EntityMapper entityMapper, EmployeeRepository employeeRepository) {
        super(entityMapper);
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.getAllEmployees()
                .stream()
                .map(entityMapper::mapEmployeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long countAllEmployees() {
        return employeeRepository.countAllEmployees();
    }
}
