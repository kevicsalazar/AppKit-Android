package com.kevicsalazar.appkit_java.utils;

import java.util.Date;

/**
 * Created by Kevin Salazar
 */
public enum UpdateTime {

    NOW(0), // Ahora
    MIN(10), // 10 segundos
    AUTOHIGH(60 * 30), // 30 minutos
    AUTOMED(60 * 60 * 6), //  6 horas
    AUTOLOW(60 * 60 * 12); // 12 horas

    private int time;

    UpdateTime(int time) {
        this.time = time;
    }

    public boolean isTimeToUpdate(long lastUpdatedTime) {
        return (lastUpdatedTime == 0) || AppDateUtils.addSeconds(new Date(lastUpdatedTime), time).getTime() < new Date().getTime();
    }

}
