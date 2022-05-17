package com.example.neo4jdemo.neo4j.entity;


import com.example.neo4jdemo.neo4j.entity.streamer.StreamerDao;
import com.example.neo4jdemo.neo4j.entity.viewer.Viewer;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * 公會關係 Node
 */
@Data
@Builder
@RelationshipEntity(type = "ability_of")
public class LiveStreamingRelationship {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode
    private Viewer start;
    @EndNode
    private StreamerDao end;
    @Property
    private String propOne;
    @Property
    private String propTwo;
    @Property
    private String propThree;
}
