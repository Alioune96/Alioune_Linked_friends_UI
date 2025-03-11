package com.techelevator.tenmo.Linkedfriend.Model;

import java.math.BigDecimal;

public class Event {
    private int eventId;
    private String eventTitle;
    private String eventPicture;
    private String description;
    private BigDecimal price;
    private String eventOptimum;
    private  String typeRelation;
    private String category;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(String eventPicture) {
        this.eventPicture = eventPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getEventOptimum() {
        return eventOptimum;
    }

    public void setEventOptimum(String eventOptimum) {
        this.eventOptimum = eventOptimum;
    }

    public String getTypeRelation() {
        return typeRelation;
    }

    public void setTypeRelation(String typeRelation) {
        this.typeRelation = typeRelation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static Event check(Event e){
        return e;
    }
}
