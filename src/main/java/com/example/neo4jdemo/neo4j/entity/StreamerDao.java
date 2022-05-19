package com.example.neo4jdemo.neo4j.entity;

import com.example.neo4jdemo.neo4j.entity.example.PersonInfo;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;


/**
 * 主播 Node
 */

@Data
@NodeEntity("Streamer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("主播")
// CREATE CONSTRAINT ON (s:主播) ASSERT s.Name IS UNIQUE
public class StreamerDao extends PersonInfo {
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
}
