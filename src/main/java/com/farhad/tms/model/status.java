package com.farhad.tms.model;

public enum status {
    PENDING(0),
    DONE(1);
    private int value;
    status(int value) {
        this.value = value;
    }
}
