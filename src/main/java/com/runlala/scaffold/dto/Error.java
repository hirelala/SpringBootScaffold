package com.runlala.scaffold.dto;

import lombok.Data;

import java.util.List;

@Data
public class Error {
    private List<String> messages;
    private int code;

    public Error(List<String> messages, int code) {
        this.messages = messages;
        this.code = code;
    }

    public static Error of() {
        return Error.of(List.of(), 0);
    }

    public static Error of(List<String> messages) {
        return Error.of(messages, 0);
    }

    public static Error of(List<String> messages, int code) {
        return new Error(messages, code);
    }
}