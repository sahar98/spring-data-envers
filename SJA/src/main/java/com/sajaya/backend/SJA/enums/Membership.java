package com.sajaya.backend.SJA.enums;

public enum Membership {



    MAIN_MEMBER("عضو اصلی "),
    GUEST_MEMBER("عضو مهمان ");
    private final String description;
    Membership(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
