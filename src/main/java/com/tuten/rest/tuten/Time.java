package com.tuten.rest.tuten;
import java.util.Date;
public class Time {
    private int  timezone;
    private final Date time;

    public Time(int timezone, Date time) {
        this.timezone = timezone;
        this.time = time;
    }

    public int getTimezone() {
        return timezone;
    }

    public Date getTime() {
        return time;
    }
}
