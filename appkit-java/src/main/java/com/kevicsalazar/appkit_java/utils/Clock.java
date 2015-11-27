package com.kevicsalazar.appkit_java.utils;

/**
 * Created by Kevin Salazar
 */
public class Clock {

    public static long millis() {
        return System.currentTimeMillis();
    }

    public static long nanos() {
        return System.nanoTime();
    }

}
