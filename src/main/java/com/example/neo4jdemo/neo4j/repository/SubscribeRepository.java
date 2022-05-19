package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.SubscribeRel;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubscribeRepository extends Neo4jRepository<SubscribeRel, UUID> {
    // 尋找 關係
    //MATCH (a)-[r]-(b) WHERE id(r) = 84 RETURN a,b,r
    @Query("MATCH (a)-[r]-(b) WHERE id(r) = {id} RETURN r.identity")
    Long getRelationShip(Long id);


    //返回節點n以及n指向的所有節點與關系
//    @Query("MATCH p=(n:Bot)-[r:BotRelation]->(m:Bot) WHERE id(n)={0} RETURN p")
//    List<SubscribeRel> findAllByBotNode(StreamerInfoNode botNode);

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
