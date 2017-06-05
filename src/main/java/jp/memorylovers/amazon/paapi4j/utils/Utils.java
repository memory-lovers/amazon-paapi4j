package jp.memorylovers.amazon.paapi4j.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String format(Calendar calendar) {
        return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
    }

    public static String getCurDateTIme() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}
