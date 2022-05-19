package com.example.neo4jdemo.controller.dto;

import com.example.neo4jdemo.neo4j.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class ViewerDto {
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
}
