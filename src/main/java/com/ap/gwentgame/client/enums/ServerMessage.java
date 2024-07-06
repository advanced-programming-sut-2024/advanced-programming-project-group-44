package com.ap.gwentgame.client.enums;

import java.io.Serializable;

public class ServerMessage implements Serializable {
    private final String messageText;
    private final String additionalText;

    public ServerMessage(String messageText, String additionalText) {
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
