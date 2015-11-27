package com.kevicsalazar.appkit_java.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kevin Salazar
 */
public class AppDateUtils {

    SimpleDateFormat F1 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    SimpleDateFormat F2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    SimpleDateFormat F3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
    SimpleDateFormat F4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public Date addSeconds(Date date, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

}
