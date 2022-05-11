package com.example.neo4jdemo.neo4j.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 錯誤回傳
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseException extends RuntimeException{
    private int errorCode;
    private String message;

    // 可自訂義回傳的錯誤function
}
