package com.sony.task1;

/**
 * Created by SONY on 20.03.2016.
 */
public class Claim {
    private String title;
    private String value;

    public Claim() {
    }

    public Claim(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
