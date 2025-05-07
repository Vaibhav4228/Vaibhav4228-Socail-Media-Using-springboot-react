package com.vaibhav.dto;

public class CallResponse {
    private String toUser;
    private boolean accepted;

    // Getters and Setters
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}