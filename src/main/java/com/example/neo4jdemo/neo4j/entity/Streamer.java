package com.example.neo4jdemo.neo4j.entity;

import com.example.neo4jdemo.neo4j.enums.Gender;
import com.example.neo4jdemo.neo4j.enums.streamertype.TypqModel;
import com.example.neo4jdemo.neo4j.matadata.schema.NodeImpl;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.annotation.typeconversion.EnumString;

import java.util.Date;
import java.util.Set;

@NodeEntity
public class Streamer extends NodeImpl {
    public Streamer(String label) {
        super(label);
    }
    @Id @GeneratedValue
    private Long id;

    // 主播名稱
    @Property
    private String name;

    // 生日
    @DateString("yy-MM-dd")
    @Property(name = "BirthDay")
    private Date birthday;

    //性別
    @EnumString(Gender.class)
    private Gender gender;

    // 所在區域
    private String location;

    // 類型(歌唱、聊天、跳舞、偶像)
    @Relationship(type = "TAGGED_WITH")
    private Set<TypqModel> tags;

    // 被追蹤數
    private Integer followers;
    // 追蹤數
    private Integer following;
    // 好友數
    private Integer friends;



//    @DateString(lenient = true)
//    private Date entityDate;
}
