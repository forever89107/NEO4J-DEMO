package com.example.neo4jdemo.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * 粉絲 Node
 */
@Data
@NodeEntity(label = "Followers")
public class Follower {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;

    @Relationship(type = "NEXT", direction = Relationship.OUTGOING)
    private Follower next;

    @Transient
    private Follower previous;

//    public void setNext(Followers next) {
//        this.next = next;
//        if (next != null) {
//            next.previous = this;
//        }
//
//    }
//
//    public Followers getPrevious() {
//        return previous;
//    }
//
//    public void setPrevious(Followers previous) {
//        this.previous = previous;
//    }
//
//    @Override
//    public String toString() {
//        return name + "(" + id + ")";
//    }

}
