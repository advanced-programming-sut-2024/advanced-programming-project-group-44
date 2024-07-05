package com.ap.gwentgame.enums;

import java.io.Serializable;

public class ClientMessage implements Serializable {
    private final String messageText;
    private final String additionalText;

    public ClientMessage(String messageText, String additionalText) {
        this.messageText = messageText;
        this.additionalText = additionalText;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getAdditionalText() {
        return additionalText;
    }
}
