package com.example.neo4jdemo.controller.streamer;

import com.example.neo4jdemo.neo4j.entity.Followers;
import com.example.neo4jdemo.neo4j.entity.Friends;
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
    // 被追蹤數
    private Set<Followers> followers;
    // 好友數
    private Set<Friends> friends;
    // 追蹤數
    private Set<Followers> following;
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
}
