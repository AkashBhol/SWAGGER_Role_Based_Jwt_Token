package com.example.MOdel;

import lombok.Data;

import java.util.Objects;

@Data
public class Result {

    private String code;

    private String message;

    private Object data;
}