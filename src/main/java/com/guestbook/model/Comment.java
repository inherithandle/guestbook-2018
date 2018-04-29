package com.guestbook.model;

import java.time.LocalDate;

/**
 * Created by hello on 22/04/2018.
 */
public class Comment {

    private String username;
    private String text;
    private LocalDate insertDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }
}
