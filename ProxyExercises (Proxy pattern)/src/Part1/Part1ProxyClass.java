package Part1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Part1ProxyClass {
    private List<Integer> AllowedDays = new ArrayList<>();
    private List<Integer> AllowedTimeRange = new ArrayList<>();
    private GregorianCalendar calendar;
    private Part1RealClass realClass;

    public Part1ProxyClass() {
        calendar = new GregorianCalendar();
        realClass = new Part1RealClass();

        AllowedDays.add(2);
        AllowedDays.add(3);
        AllowedDays.add(6);

        AllowedTimeRange.add(2);
        AllowedTimeRange.add(15);
    }

    public void printHello() throws Exception {
        boolean available = checkTimes();
        if (available) { realClass.printHello(); }
        else { throw new Exception("Not allowed at this time"); }
    }

    public void printGoodbye() throws Exception {
        boolean available = checkTimes();
        if (available) { realClass.printGoodbye(); }
        else { throw new Exception("Not allowed at this time"); }
    }

    public boolean checkTimes() {
        int DayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int HourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (AllowedDays.contains(DayOfWeek) && (AllowedTimeRange.get(0) <= HourOfDay) && (HourOfDay <= AllowedTimeRange.get(1))) {
            return true;
        } else { return false; }
    }
}
