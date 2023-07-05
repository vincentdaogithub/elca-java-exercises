package vn.elca.training.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.elca.training.model.entity.Employee;
import vn.elca.training.model.entity.QEmployee;
import vn.elca.training.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;
    private static final QEmployee employee = QEmployee.employee;

    @Autowired
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new JPAQuery<Employee>(entityManager)
                .from(employee)
                .fetch();
    }

    @Override
    public Long countAllEmployees() {
        return new JPAQuery<Employee>(entityManager)
                .from(employee)
                .fetchCount();
    }

    @Override
    public Employee getEmployeeById(BigDecimal id) {
        return new JPAQuery<Employee>(entityManager)
                .from(employee)
                .where(employee.id.eq(id))
                .fetchOne();
    }
}
