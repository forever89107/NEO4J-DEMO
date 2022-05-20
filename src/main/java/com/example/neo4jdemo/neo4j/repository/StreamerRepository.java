package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.StreamerDao;
import com.example.neo4jdemo.neo4j.enums.streamertype.Type;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

//import org.springframework.data.neo4j.repository.query.Query;
//Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: C
//原因：springboot查詢數據庫，如果節點實體中關聯多個其它對象，則其會深度查詢這些對象。要解決這個問題，可以在關系類中要關聯的實體上加@JsonIgnore注解，或者在主實體上加@JsonIgnoreProperties("actor")
//Neo4j 將重用已刪除的節點 ID。建議用戶為其域對象提供自己的唯一標識符（或使用 UUID）

/**
 * 主播個人資訊 DAO層，label= 主播，name 為 unique index
 * CREATE CONSTRAINT FOR (n:Person) REQUIRE n.name IS UNIQUE
 */
@Repository
public interface StreamerRepository extends Neo4jRepository<StreamerDao, UUID> {
    //Match(s:Streamer {Name:"Joe"}) return s;
    @Query("MATCH (s:Streamer {Name: {name}}) RETURN s")
    StreamerDao selectByName(@Param("name") String name);

    @Query("MATCH (p:Streamer {Name:{name}}) RETURN p.uuid")
    String selectUuIdByName(@Param("name") String name);

    //Match(s:Streamer{uuid:"f82de68a-dc28-4c37-a112-bbf7bb39f997"}) return s;
    @Query("MATCH (s:Streamer {uuid:{uuid}}) RETURN s")
    StreamerDao selectByUuId(@Param("uuid") String uuid);
    //MATCH (s:Streamer {Name:"Sara"})-[r]->() RETURN type(r)
    @Query("MATCH (s:Streamer {Name:{name}})-[r]->() RETURN type(r)")
    List<String> getRelName(@Param("name") String name);
    //

    //MATCH (s:Streamer {Name: "Joe"})
    //SET s.location = "US"
    //RETURN s
    @Query("MATCH (p:Streamer {Name: {name}})" +
            "SET p.location = location({location})" +
            "SET p.tags = tags({tags}})" +
            "RETURN p")
    int updateByName(@Param("name") String name, @Param("location") String location,
                     @Param("tags") Set<Type> tags);

    //
}
