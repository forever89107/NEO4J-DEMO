package com.example.neo4jdemo.neo4j.matadata.schema;

import org.neo4j.ogm.metadata.schema.Node;
import org.neo4j.ogm.metadata.schema.Relationship;

import java.util.*;

public class NodeImpl implements Node {
    private final String label;
    private final Map<String, Relationship> relationships = new HashMap<>();
    private final Map<String, Set<String>> typesByRelationship = new HashMap<>();

    public NodeImpl(String label) {
        this.label = label;
    }
    @Override
    public Optional<String> label() {
        return Optional.ofNullable(label);
    }

    @Override
    public Collection<String> labels() {
        // fixme 代調整final結構
        return null;
    }

    @Override
    public Map<String, Relationship> relationships() {
        return relationships;
    }

    @Override
    public Collection<String> types(String relationshipName) {
        return typesByRelationship.getOrDefault(relationshipName, Collections.emptySet());
    }

}
