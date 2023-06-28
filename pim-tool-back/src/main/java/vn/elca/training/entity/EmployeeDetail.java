package vn.elca.training.entity;

import vn.elca.training.entity.exception.BirthDateIsTodayOrInTheFutureException;
import vn.elca.training.entity.exception.FieldOutOfRangeException;
import vn.elca.training.entity.exception.NullOrBlankFieldException;
import vn.elca.training.entity.validator.EntityValidator;
import vn.elca.training.util.DateUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class EmployeeDetail implements Serializable {

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public EmployeeDetail() { }

    public EmployeeDetail(String firstName, String lastName, Date birthDate) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        EntityValidator.validateString(firstName, "firstName", 50);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        EntityValidator.validateString(lastName, "lastName", 50);
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        EntityValidator.validateBirthDate(birthDate, "birthDate");
        this.birthDate = birthDate;
    }
}
