package vn.elca.training.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.entity.Employee;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = { EmployeeRepository.class })
class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void givenEmployeeRepositoryTest_whenInit_thenAllFieldsExist() {
        assertThat(entityManager).isNotNull();
        assertThat(employeeRepository).isNotNull();
    }

    @Test
    void givenEmployeeRepository_whenGetEmployeeById_returnEmployee() {
        Employee expectedGroup = entityManager.find(Employee.class, BigDecimal.ONE);
        Employee actualGroup = employeeRepository.getEmployeeById(BigDecimal.ONE);

        assertThat(actualGroup).isNotNull().isEqualTo(expectedGroup);
    }
}
