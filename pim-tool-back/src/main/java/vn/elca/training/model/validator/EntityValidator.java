package vn.elca.training.model.validator;

import vn.elca.training.model.exception.*;
import vn.elca.training.util.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

public class EntityValidator {

    EntityValidator() { }

    public static void validateId(BigDecimal id) {
        if (id == null) {
            throw new NullOrBlankFieldException("id");
        }
        if (id.compareTo(BigDecimal.ZERO) <= 0 || id.compareTo(new BigDecimal("9999999999999999999")) > 0) {
            throw new FieldOutOfRangeException("id");
        }
    }

    public static void validateString(String stringToCheck, String fieldName, int maxLength) {
        if (stringToCheck == null || stringToCheck.trim().isEmpty()) {
            throw new NullOrBlankFieldException(fieldName);
        }
        if (stringToCheck.length() > maxLength) {
            throw new FieldOutOfRangeException(fieldName);
        }
    }

    public static void validateNotNull(Object objectToCheck, String fieldName) {
        if (objectToCheck == null) {
            throw new NullOrBlankFieldException(fieldName);
        }
    }

    public static void validateVersion(Long version) {
        if (version == null) {
            throw new NullOrBlankFieldException("version");
        }
        if (version < 0L) {
            throw new FieldOutOfRangeException("version");
        }
    }

    public static void validateBirthDate(Date birthDate, String fieldName) {
        if (birthDate == null) {
            throw new NullOrBlankFieldException(fieldName);
        }
        if (birthDate.compareTo(DateUtils.getCurrentDateUTC0()) >= 0) {
            throw new BirthDateIsTodayOrInTheFutureException();
        }
    }

    public static void validateProjectNumber(Integer projectNumber) {
        if (projectNumber == null) {
            throw new NullOrBlankFieldException("projectNumber");
        }
        if (projectNumber < 0 || projectNumber > 9999) {
            throw new FieldOutOfRangeException("projectNumber");
        }
    }

    public static void validateEndDate(Date endDate, Date startDate) {
        if (endDate == null) {
            return;
        }
        if (startDate == null) {
            throw new EndDateSetWhenStartDateIsNullException();
        }
        if (endDate.compareTo(startDate) <= 0) {
            throw new EndDateBeforeOrEqualStartDateException();
        }
    }
}
