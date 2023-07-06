package vn.elca.training.util;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDateUTC0() {
        return Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS).atZone(ZoneOffset.UTC).toInstant());
    }

    private DateUtils() { }
}
