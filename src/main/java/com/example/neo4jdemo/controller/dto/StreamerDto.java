package com.example.neo4jdemo.controller.dto;

import com.example.neo4jdemo.neo4j.enums.Gender;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class StreamerDto {
    // 主播暱稱
    private String name;
    // 複數labels
    private Set<String> labels;
    // 生日
    private Date birthday;
    // 所在區域
    private String location;
    //性別
    private Gender gender;
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
}
