package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.streamer.StreamerDao;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

//import org.springframework.data.neo4j.repository.query.Query;
//Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: C
//原因：springboot查詢數據庫，如果節點實體中關聯多個其它對象，則其會深度查詢這些對象。要解決這個問題，可以在關系類中要關聯的實體上加@JsonIgnore注解，或者在主實體上加@JsonIgnoreProperties("actor")
//Neo4j 將重用已刪除的節點 ID。建議用戶為其域對象提供自己的唯一標識符（或使用 UUID）

/**
 * 主播個人資訊 DAO層，label= 主播
 */
@Repository
public interface StreamerRepository extends Neo4jRepository<StreamerDao, UUID> {
    //CREATE CONSTRAINT FOR (n:Person) REQUIRE n.name IS UNIQUE
    @Query("MATCH (p:主播 {Name:{title}}) RETURN p.uuid")
    Optional<StreamerDao> findByName(@Param("title") String name);

    @Query("MATCH (p:主播 {Name:{title}}) RETURN p.uuid")
    String findUUIDByName(@Param("title") String name);

// repository.findAll(PageRequest.of(1, 20));
    //返回節點n以及n指向的所有節點與關系
//    @Query("MATCH p=(n:Bot)-[r:BotRelation]->(m:Bot) WHERE id(n)={0} RETURN p")
//    List<BotRelation> findAllByBotNode(StreamerInfoNode botNode);

//    Stream<StreamerDao> findAllByNode();
//
//    //返回節點n以及n指向或指向n的所有節點與關系
//    @Query("MATCH p=(n:Bot)<-[r:BotRelation]->(m:Bot) WHERE m.name={name} RETURN p")
//    List<BotRelation> findAllBySymptom(@Param("name") String name);
//
//    //返回節點n以及n指向或指向n的所有節點以及這些節點間的所有關系
//    @Query("MATCH p=(n:Bot)<-[r:BotRelation]->(m:Bot)<-[:BotRelation]->(:Bot)<-[:BotRelation]->(n:Bot) WHERE n.name={name} RETURN p")
//    List<BotRelation> findAllByStartNode(@Param("name") String name);

}
