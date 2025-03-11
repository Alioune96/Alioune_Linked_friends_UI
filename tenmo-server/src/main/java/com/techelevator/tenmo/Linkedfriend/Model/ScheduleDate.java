package com.techelevator.tenmo.Linkedfriend.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDate {
    private int scheduleId;
    private int matchId;
    private int eventId;
    private LocalTime scheduleTime;
    private LocalDate scheduleDate;
    private boolean eventStatus;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalTime getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(LocalTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean isEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(boolean eventStatus) {
        this.eventStatus = eventStatus;
    }
}
