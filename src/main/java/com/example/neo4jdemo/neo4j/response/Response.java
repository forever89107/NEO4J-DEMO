package com.example.neo4jdemo.neo4j.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Map;


/**
 * 正確回傳
 */
@Getter
@Setter
//@AllArgsConstructor
public class Response extends ResponseEntity {
    // 狀態碼
    private int code;
    //回傳訊息
    private String msg;
    //回傳內容 <"list", items>
    private Map<String, Object> map;


    public Response(HttpStatus status) {
        super(status);
    }

}
