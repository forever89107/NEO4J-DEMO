package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.Follower;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FollowerRepository extends Neo4jRepository<Follower, UUID> {
//MATCH (x:Developer)-[r]-()
//RETURN startNode(r)
}
