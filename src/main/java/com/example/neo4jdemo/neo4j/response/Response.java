package com.example.neo4jdemo.neo4j.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 * 正確回傳
 */
@Getter
@Setter
public class Response extends ResponseEntity {
    //檢核碼
    private HttpStatus code;
    //回傳訊息
    private String message;

    public Response(HttpStatus status) {
        super(status);
    }

    public Response(HttpStatus status, String message) {
        super(status);
        this.message = message;
    }
}
