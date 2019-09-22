import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
        LocalDateTime timeTocheck;
    Gigasecond(LocalDate moment) {
        timeTocheck=moment.atTime(0,0,0);
    }

    Gigasecond(LocalDateTime moment) {
       timeTocheck=moment;
    }

    LocalDateTime getDateTime() {
        return timeTocheck.plusSeconds(1000000000);
    }

}
