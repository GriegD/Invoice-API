package com.greg;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class Invoice {

    private String id;

    @JsonProperty("user_id")
    private String userID;

    @JsonProperty("pdf_url")
    private String URL;

    private int amount;


    public Invoice(String userID, int amount, String URL) {
        this.id = UUID.randomUUID().toString();
        this.userID = userID;
        this.URL = URL;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getURL() {
        return URL;
    }
    public void setURL(String URL) {
        this.URL = URL;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
