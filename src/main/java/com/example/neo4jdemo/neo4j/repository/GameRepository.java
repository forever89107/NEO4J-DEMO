package com.example.neo4jdemo.neo4j.repository;

import com.example.neo4jdemo.neo4j.entity.streamer.StreamerDao;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface GameRepository extends Neo4jRepository<StreamerDao, UUID> {
}
