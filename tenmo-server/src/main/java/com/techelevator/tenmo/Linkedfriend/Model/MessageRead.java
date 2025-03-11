package com.techelevator.tenmo.Linkedfriend.Model;

public class MessageRead extends User{
    private int matchId;
    private boolean isMessageRead;
    private int toUserId;
    private String messageContent;

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public MessageRead(){
        super();
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public boolean isMessageRead() {
        return isMessageRead;
    }

    public void setMessageRead(boolean messageRead) {
        isMessageRead = messageRead;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }


}
