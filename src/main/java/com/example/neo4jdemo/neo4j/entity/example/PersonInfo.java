package com.example.neo4jdemo.neo4j.entity.example;

import com.example.neo4jdemo.neo4j.entity.Followers;
import com.example.neo4jdemo.neo4j.entity.Friends;
import com.example.neo4jdemo.neo4j.enums.Gender;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.annotation.typeconversion.EnumString;

import java.util.Date;
import java.util.Set;

/**
 * 個人資訊 - Entity層(Node)
 */
@NodeEntity
@Data
public abstract class PersonInfo extends NodeUuId {
    // 生日
    @DateString("yy-MM-dd")
    @Property(name = "BirthDay")
    private Date birthday;
    // 所在區域
    @Property(name = "Location")
    private String location;
    //性別
    @EnumString(Gender.class)
    @Property(name = "Gender")
    private Gender gender;
    // 被追蹤數
    @Relationship(type = "follwing", direction = Relationship.INCOMING)
    private Set<Followers> followers;
    // 好友數
    @Relationship(type = "follwing", direction = Relationship.DIRECTION)
    private Set<Friends> friends;
    // 追蹤數
    @Relationship(type = "follwing", direction = Relationship.OUTGOING)
    private Set<Followers> following;
}
