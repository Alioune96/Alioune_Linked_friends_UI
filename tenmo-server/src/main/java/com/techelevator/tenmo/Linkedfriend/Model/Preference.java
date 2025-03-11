package com.techelevator.tenmo.Linkedfriend.Model;

public class Preference {
    private int preferenceId;
    private int userId;
    private String relationshipStatus;
    private String [] hobbies;

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
