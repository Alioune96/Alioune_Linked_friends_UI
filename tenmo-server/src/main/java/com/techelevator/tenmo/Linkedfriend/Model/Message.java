package com.techelevator.tenmo.Linkedfriend.Model;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Message extends User{
    private int messageId;
    private int matchId;
    private String secondLast;
    private String secondFirst;
    private String messageContent;
    @Nullable
    private LocalDate messageDate;
    private LocalDate messageCreated;
    private String messageTime;
    private boolean messageRead;
   public Message(){
        super();
    }

    public String getSecondLast() {
        return secondLast;
    }

    public void setSecondLast(String secondLast) {
        this.secondLast = secondLast;
    }

    public String getSecondFirst() {
        return secondFirst;
    }

    public void setSecondFirst(String secondFirst) {
        this.secondFirst = secondFirst;
    }

    public LocalDate getMessageCreated() {
        return messageCreated;
    }

    public void setMessageCreated(LocalDate messageCreated) {
        this.messageCreated = messageCreated;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDate getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDate messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }
}
