package com.example.neo4jdemo.neo4j.entity.viewer;

import com.example.neo4jdemo.neo4j.entity.example.PersonInfo;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@Builder
@NodeEntity("Viewer")
public class Viewer extends PersonInfo {
}
