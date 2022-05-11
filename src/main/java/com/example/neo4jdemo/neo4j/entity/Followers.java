package com.example.neo4jdemo.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@NodeEntity(label = "粉絲")
public class Followers {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;

    @Relationship(type = "NEXT", direction = Relationship.OUTGOING)
    private Followers next;
//
    @Transient
    private Followers previous;
//
//
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
