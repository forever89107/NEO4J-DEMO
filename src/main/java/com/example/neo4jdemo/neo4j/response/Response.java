package com.example.neo4jdemo.neo4j.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * 正確回傳
 */
@Getter
@Setter
public class Response {
    // 狀態碼
    private int code;
    //回傳訊息
    private String msg;
    //回傳內容 <"list", items>
    private Map<String, Object> map;

    public Response() {
        map = new HashMap<String, Object>();
//        code = ErrorCode.OK.getCode();
        code = HttpStatus.OK.value();
    }

    /**
     * constructor.
     *
     * @param flag 成功 or 失敗
     */
    public Response(boolean flag) {
        map = new HashMap<String, Object>();
        if (flag) {
//            code = ErrorCode.OK.getCode();
            code = HttpStatus.OK.value();

            msg = "操作成功";
        } else {
//            code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
//            msg = ErrorCode.INTERNAL_SERVER_ERROR.getMessage();

            code = HttpStatus.INTERNAL_SERVER_ERROR.value();
            msg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        }
    }



}
