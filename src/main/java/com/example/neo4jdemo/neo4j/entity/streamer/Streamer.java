package com.example.neo4jdemo.neo4j.entity.streamer;

import com.example.neo4jdemo.neo4j.entity.example.PersonInfo;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.NodeEntity;
import java.util.Set;


@Data
@NodeEntity("主播")
@Builder
public class Streamer extends PersonInfo {
    // 類型(歌唱、聊天、跳舞、偶像)
    private Set<Type> tags;
}
