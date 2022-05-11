package com.example.neo4jdemo.neo4j.web;

import com.example.neo4jdemo.neo4j.entity.Followers;
import com.example.neo4jdemo.neo4j.entity.Friends;
import com.example.neo4jdemo.neo4j.enums.Gender;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.annotation.typeconversion.EnumString;

import java.util.Date;
import java.util.Set;

import static java.util.UUID.randomUUID;

@Data
@Builder
@NodeEntity(label = "主播")
public class StreamerDto {
    @Id
    @GeneratedValue
    private Long Id;
    @Property
    private String name;
    // 複數labels
    @Labels
    private Set<String> labels;
    // 生日
    @DateString("yy-MM-dd")
    private Date birthday;
    // 所在區域
    private String location;
    //性別
    @EnumString(Gender.class)
    private Gender gender;
    // 被追蹤數
//    @Relationship(type = "following", direction = Relationship.INCOMING)
//    private Set<Followers> followers;
//    // 好友數
//    @Relationship(type = "following", direction = Relationship.TYPE)
//    private Set<Friends> friends;
//    // 追蹤數
//    @Relationship(type = "following", direction = Relationship.OUTGOING)
//    private Set<Followers> following;
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
}
