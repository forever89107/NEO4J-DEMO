package com.example.neo4jdemo.neo4j.entity.streamer;

import com.example.neo4jdemo.neo4j.entity.Followers;
import com.example.neo4jdemo.neo4j.enums.Gender;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateString;
import org.neo4j.ogm.annotation.typeconversion.EnumString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 主播個人資訊Entity層(Node)
 */
@NodeEntity(label = "主播個人資訊")
@Builder
@Data
//@JsonIdentityInfo(generator=JSOGGenerator.class)
public class PersonInfoNode {
    // super
//    public PersonInfoNode(String label, List<String> labels) {
//        super(label, labels);
//    }
//    @Id @GeneratedValue(generatorClass = UUIDStringGenerator.class)
//    private String id;
    @Id
    @GeneratedValue
    private Long id;
    // 節點名稱
    private String label;
    // 複數節點名稱
    // 生日
    @DateString("yy-MM-dd")
    @Property(name = "BirthDay")
    private Date birthday;
    // 所在區域
    private String location;

//    // 追蹤數
//    private Integer following;
//    // 好友數
//    private Integer friends;

    //性別
    @EnumString(Gender.class)
    private Gender gender;
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
    // 複數節點名稱
    @Labels
    private Set<String> labels = new HashSet<>();
    // 被追蹤數
//    private Integer followers;

    @Relationship(type = "follwing", direction = Relationship.OUTGOING)
    private Set<Followers> followers ;


//    public void addLabel(String newLabel) {
//        if (StringUtils.isNotEmpty(newLabel)) {
//            labels.add(newLabel.toUpperCase());
//        }
//    }
//    @DateString(lenient = true)
//    private Date entityDate;

}
