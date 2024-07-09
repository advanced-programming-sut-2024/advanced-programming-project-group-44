package com.ap.gwentgame.client.enums;

public enum Question {
    QUESTION_1("What is your mother's maiden name?"),
    QUESTION_2("What was the name of your first pet?"),
    QUESTION_3("What is your favorite book?");

    private final String text;

    Question(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
