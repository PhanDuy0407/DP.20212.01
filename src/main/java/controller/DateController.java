package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateController {
    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
