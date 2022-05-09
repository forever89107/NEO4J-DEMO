package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.Streamer;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamerRepository extends Neo4jRepository<Streamer,Long>{
}
