package com.runlala.scaffold.dto;

import lombok.Data;

@Data
public class R<T> {
    private Boolean success;
    private String message;
    private T data;

    public R(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success() {
        return R.success(null);
    }

    public static <T> R<T> success(T object) {
        return R.success("Ok", object);
    }

    public static <T> R<T> success(String message, T object) {
        return new R<>(true, message, object);
    }

    public static <T> R<T> error() {
        return R.error(null);
    }

    public static <T> R<T> error(String message) {
        return R.error(message, null);
    }

    public static <T> R<T> error(String message, T object) {
        return new R<>(false, message, object);
    }
}