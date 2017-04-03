package ferry.booking;

import ferry.booking.dto.TimeTableEntry;
import ferry.booking.manager.FerryManager;

public class FerryModule {

    public static long timeReady(TimeTableEntry timetable, PortModel destination) {
        if (timetable == null) {
            return 0;
        }
        if (destination == null) {
            throw new NullPointerException("destination");
        }

        long arrivalTime = timetable.time + timetable.journeyTime;
        int turnaroundTime = FerryManager.getFerryTurnaroundTime(destination);
        long timeReady = arrivalTime + turnaroundTime;
        return timeReady;
    }
}
