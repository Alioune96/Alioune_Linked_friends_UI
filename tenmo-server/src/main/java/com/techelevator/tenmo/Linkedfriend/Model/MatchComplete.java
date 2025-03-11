package com.techelevator.tenmo.Linkedfriend.Model;

import org.apache.tomcat.jni.Local;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MatchComplete {
    private int likedUserId;

    private String likedFirstName;
    private String likedLastName;
    private String profilePicture;
    private String[] hobbies;
    private String relationshipStatus;
    private LocalTime likedTime;
    private int age;
    private String gender;
    private String birthDate;

    private int matchId;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Nullable
    private String userBio;
    @Nullable
    private LocalDate matchDate;

    @Nullable
    public String getUserBio() {
        return userBio;
    }

    @Nullable
    public LocalDate getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(@Nullable LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public void setUserBio(@Nullable String userBio) {
        this.userBio = userBio;
    }

    public int getLikedUserId() {
        return likedUserId;
    }

    public void setLikedUserId(int likedUserId) {
        this.likedUserId = likedUserId;
    }

    public String getLikedFirstName() {
        return likedFirstName;
    }

    public void setLikedFirstName(String likedFirstName) {
        this.likedFirstName = likedFirstName;
    }

    public String getLikedLastName() {
        return likedLastName;
    }

    public void setLikedLastName(String likedLastName) {
        this.likedLastName = likedLastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public LocalTime getLikedTime() {
        return likedTime;
    }

    public void setLikedTime(LocalTime likedTime) {
        this.likedTime = likedTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
