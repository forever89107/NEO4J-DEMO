package com.example.neo4jdemo.neo4j.entity;

import com.example.neo4jdemo.neo4j.entity.example.PersonInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@Builder
@NoArgsConstructor
@NodeEntity("Viewer")
public class ViewerDao extends PersonInfo {
}
