package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.ViewerDao;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViewrRepository extends Neo4jRepository<ViewerDao, UUID> {

    @Query("MATCH (v:Viewer {uuid: {uuid}}) RETURN v")
    ViewerDao selectByUuId(@Param("uuid") String uuid);

    @Query("MATCH (v:Viewer {Name: {name}}) RETURN v")
    ViewerDao selectByName(@Param("name") String name);
}
