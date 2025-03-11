package com.techelevator.tenmo.Linkedfriend.Model;

public class ScheduleEventReview {
    private int scheduleRId;
    private int scheduleEVId;
    private int rating;
    private String comments;

    public int getScheduleRId() {
        return scheduleRId;
    }

    public void setScheduleRId(int scheduleRId) {
        this.scheduleRId = scheduleRId;
    }

    public int getScheduleEVId() {
        return scheduleEVId;
    }

    public void setScheduleEVId(int scheduleEVId) {
        this.scheduleEVId = scheduleEVId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
