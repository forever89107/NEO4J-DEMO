package com.example.neo4jdemo.neo4j.entity;

import org.neo4j.graphdb.Label;

public enum NodeLabel implements Label {
    STREAMER("主播"),
    AUDIENCE("觀眾")
    ;

    public String desc;
    private NodeLabel(String desc){
        this.desc=desc;
    }


}
