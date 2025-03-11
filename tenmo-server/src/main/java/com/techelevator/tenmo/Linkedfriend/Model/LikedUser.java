package com.techelevator.tenmo.Linkedfriend.Model;

import java.time.LocalTime;

public class LikedUser {
    private int likedId;
    private int firstUserId;
    private int secondUserId;

    private LocalTime likedTime;


    public int getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(int firstUserId) {
        this.firstUserId = firstUserId;
    }

    public int getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(int secondUserId) {
        this.secondUserId = secondUserId;
    }

    public int getLikedId() {
        return likedId;
    }

    public void setLikedId(int likedId) {
        this.likedId = likedId;
    }

    public LocalTime getLikedTime() {
        return likedTime;
    }

    public void setLikedTime(LocalTime likedTime) {
        this.likedTime = likedTime;
    }
}


