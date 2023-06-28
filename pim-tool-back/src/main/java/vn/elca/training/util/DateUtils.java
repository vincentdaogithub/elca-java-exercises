package vn.elca.training.util;

import java.time.Instant;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDateUTC0() {
        return Date.from(Instant.now());
    }

    private DateUtils() { }
}
