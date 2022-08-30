package com.quant360.parser;

public class Message {
    public String timestamp;
    public long sequence_number;
    public long sending_time;
    public int sbeTemplateId;

    public Message() {}

    public Message(Message other) {
        this.timestamp = other.timestamp;
        this.sequence_number = other.sequence_number;
        this.sending_time = other.sending_time;
        this.sbeTemplateId = other.sbeTemplateId;
    }
}
