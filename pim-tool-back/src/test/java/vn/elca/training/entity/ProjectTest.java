package vn.elca.training.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.exception.EndDateBeforeOrEqualStartDateException;
import vn.elca.training.model.exception.EndDateSetWhenStartDateIsNullException;
import vn.elca.training.model.exception.FieldOutOfRangeException;
import vn.elca.training.model.exception.NullOrBlankFieldException;
import vn.elca.training.util.DateUtils;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
class ProjectTest {

    private static final String NULL_OR_BLANK = "%s is Null or Blank";
    private static final String OUT_OF_RANGE = "%s is Out of Range";
    private static final String END_DATE_BEFORE_EQUAL_START_DATE =
            "End Date of the Project happens before the Start Date";
    private static final String END_DATE_WITH_START_DATE_NULL =
            "End Date of the Project is set when the Start Date is Null";

    private Project projectTest;

    @BeforeEach
    void initiateTestObject() {
        projectTest = new Project();
    }

    @AfterEach
    void cleanTestObjects() {
        projectTest = null;
    }

    @Test
    void givenProject_whenSetIdNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setId(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "id");
    }

    @Test
    void givenProject_whenSetIdBelow0_thenThrowFieldOutOfRangeException() {
        BigDecimal belowZero = BigDecimal.valueOf(-1);
        assertThatThrownBy(() -> projectTest.setId(belowZero))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "id");
    }

    @Test
    void givenProject_whenSetIdAbove19Digits_thenThrowFieldOutOfRangeException() {
        BigDecimal above19Digits = new BigDecimal("10000000000000000000");
        assertThatThrownBy(() -> projectTest.setId(above19Digits))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "id");
    }

    @Test
    void givenProject_whenSetTeamNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setGroup(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "group");
    }

    @Test
    void givenProject_whenSetProjectNumberNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setProjectNumber(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "projectNumber");
    }

    @Test
    void givenProject_whenSetProjectNumberBelow0_thenThrowFieldOutOfRangeException() {
        assertThatThrownBy(() -> projectTest.setProjectNumber(-1))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "projectNumber");
    }

    @Test
    void givenProject_whenSetProjectNumberAbove4Digits_thenThrowFieldOutOfRangeException() {
        assertThatThrownBy(() -> projectTest.setProjectNumber(10000))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "projectNumber");
    }

    @Test
    void givenProject_whenSetNameNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setName(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "name");
    }

    @Test
    void givenProject_whenSetNameBlankOrFullOfWhiteSpaces_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setName(""))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "name");
        assertThatThrownBy(() -> projectTest.setName("                     "))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "name");
    }

    @Test
    void givenProject_whenSetNameAbove50Characters_thenThrowFieldOutOfRangeException() {
        assertThatThrownBy(() -> projectTest.setName("9M{7r;zqCm)J?m:tN8yk*KbLCx{Y7tj&Jj9keYB4{$8:K#_MEe4"))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "name");
    }

    @Test
    void givenProject_whenSetCustomerNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setCustomer(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "customer");
    }

    @Test
    void givenProject_whenSetCustomerBlankOrFullOfWhiteSpaces_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setCustomer(""))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "customer");
        assertThatThrownBy(() -> projectTest.setCustomer("                     "))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "customer");
    }

    @Test
    void givenProject_whenSetCustomerAbove50Characters_thenThrowFieldOutOfRangeException() {
        assertThatThrownBy(() -> projectTest.setCustomer("9M{7r;zqCm)J?m:tN8yk*KbLCx{Y7tj&Jj9keYB4{$8:K#_MEe4"))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "customer");
    }

    @Test
    void givenProject_whenSetStatusNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setStatus(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "status");
    }

    @Test
    void givenProject_whenSetEndDateWhileStartDateNull_thenThrowEndDateSetWhenStartDateIsNullException() {
        Date testDate = DateUtils.getCurrentDateUTC0();
        assertThatThrownBy(() -> projectTest.setEndDate(testDate))
                .isInstanceOf(EndDateSetWhenStartDateIsNullException.class)
                .hasMessage(END_DATE_WITH_START_DATE_NULL);
    }

    @Test
    void givenProject_whenSetEndDateTheSameAsStartDate_thenThrowEndDateBeforeOrEqualStartDateException() {
        Date startDate = DateUtils.getCurrentDateUTC0();
        Date endDate = Date.from(startDate.toInstant().minus(1000, ChronoUnit.MILLIS));
        projectTest.setStartDate(startDate);

        assertThatThrownBy(() -> projectTest.setEndDate(endDate))
                .isInstanceOf(EndDateBeforeOrEqualStartDateException.class)
                .hasMessage(END_DATE_BEFORE_EQUAL_START_DATE);
        assertThatThrownBy(() -> projectTest.setEndDate(startDate))
                .isInstanceOf(EndDateBeforeOrEqualStartDateException.class)
                .hasMessage(END_DATE_BEFORE_EQUAL_START_DATE);
    }

    @Test
    void givenProject_whenSetVersionNull_thenThrowNullOrBlankFieldException() {
        assertThatThrownBy(() -> projectTest.setVersion(null))
                .isInstanceOf(NullOrBlankFieldException.class)
                .hasMessage(NULL_OR_BLANK, "version");
    }

    @Test
    void givenProject_whenSetVersionBelow0_thenThrowFieldOutOfRangeException() {
        assertThatThrownBy(() -> projectTest.setVersion(-1L))
                .isInstanceOf(FieldOutOfRangeException.class)
                .hasMessage(OUT_OF_RANGE, "version");
    }
}
