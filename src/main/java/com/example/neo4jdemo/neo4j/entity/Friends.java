package com.example.neo4jdemo.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.id.UuidStrategy;
/**
 * 朋友 Node
 */
@Data
@NodeEntity(label = "Friends")
public class Friends {

    @Id @GeneratedValue(strategy = UuidStrategy.class )
    private String id;
    @Property
    private String name;
}
