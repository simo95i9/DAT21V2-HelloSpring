package al.gred.hellospring.services;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;

public class TimeUtils {
    public static Boolean isItFriday(ZoneId inTimeZone) {
        return Instant.now().atZone( inTimeZone ).getDayOfWeek().equals( DayOfWeek.FRIDAY );
    }
}
