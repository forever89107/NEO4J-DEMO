package com.example.neo4jdemo.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@Data
@NodeEntity(label = "朋友")
public class Friends {

    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;
}
