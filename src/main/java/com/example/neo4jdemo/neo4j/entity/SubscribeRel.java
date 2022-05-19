package com.example.neo4jdemo.neo4j.entity;


import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.util.Date;

/**
 * 主播 RelationShip Node
 * (Viewer)-[:subscribe]->(Streamer)
 */
@Data
@Builder
@RelationshipEntity(type = "subscribe")
public class SubscribeRel {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode
    private ViewerDao viwer;
    @EndNode
    private StreamerDao streamer;
    @Property
    @DateString("yyyy-MM-dd")
    Date subscribeDate;
}
