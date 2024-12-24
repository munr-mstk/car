package com.munirmustakoglu.car.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorMessage {

    private MessageType messageType;

    private String ofStatic;

    public ErrorMessage(MessageType messageType, String ofStatic) {
        this.messageType = messageType;
        this.ofStatic = ofStatic;

    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getOfStatic() {
        return ofStatic;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public void setOfStatic(String ofStatic) {
        this.ofStatic = ofStatic;
    }

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getMessageType().getMessage());
        if (this.ofStatic != null) {
            builder.append(" : " + this.ofStatic);
        }

        return builder.toString();
    }
}