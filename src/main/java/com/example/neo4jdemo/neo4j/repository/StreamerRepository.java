package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.example.NodeUuId;
import com.example.neo4jdemo.neo4j.entity.example.PersonInfo;
import com.example.neo4jdemo.neo4j.entity.streamer.Streamer;
import com.example.neo4jdemo.neo4j.web.StreamerDto;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
//Failed to write HTTP message: org.springframework.http.converter.HttpMessageNotWritableException: C
//原因：springboot查询数据库，如果节点实体中关联多个其它对象，则其会深度查询这些对象。要解决这个问题，可以在关系类中要关联的实体上加@JsonIgnore注解，或者在主实体上加@JsonIgnoreProperties("actor")
//Neo4j 將重用已刪除的節點 ID。建議用戶為其域對象提供自己的唯一標識符（或使用 UUID）
/**
 * 主播個人資訊 DAO層
 */
@Repository
public interface StreamerRepository extends Neo4jRepository<StreamerDto, Long> {
// repository.findAll(PageRequest.of(1, 20));
    //返回節點n以及n指向的所有節點與關系
//    @Query("MATCH p=(n:Bot)-[r:BotRelation]->(m:Bot) WHERE id(n)={0} RETURN p")
//    List<BotRelation> findAllByBotNode(StreamerInfoNode botNode);
//
//    //返回節點n以及n指向或指向n的所有節點與關系
//    @Query("MATCH p=(n:Bot)<-[r:BotRelation]->(m:Bot) WHERE m.name={name} RETURN p")
//    List<BotRelation> findAllBySymptom(@Param("name") String name);
//
//    //返回節點n以及n指向或指向n的所有節點以及這些節點間的所有關系
//    @Query("MATCH p=(n:Bot)<-[r:BotRelation]->(m:Bot)<-[:BotRelation]->(:Bot)<-[:BotRelation]->(n:Bot) WHERE n.name={name} RETURN p")
//    List<BotRelation> findAllByStartNode(@Param("name") String name);

}
