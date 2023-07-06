package vn.elca.training.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.entity.Group;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@ComponentScan(basePackageClasses = { GroupRepository.class })
class GroupRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    void givenGroupRepositoryTest_whenInit_thenAllFieldsExist() {
        assertThat(entityManager).isNotNull();
        assertThat(groupRepository).isNotNull();
    }

    @Test
    void givenGroupRepository_whenGetGroupById_returnGroup() {
        Group expectedGroup = entityManager.find(Group.class, BigDecimal.ONE);
        Group actualGroup = groupRepository.getGroupById(BigDecimal.ONE);

        assertThat(actualGroup).isNotNull().isEqualTo(expectedGroup);
    }
}
