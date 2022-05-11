package com.example.neo4jdemo.neo4j.service;

import java.util.Optional;

/**
 *
 */
public interface Service {

//    Optional createNode();
//
//    Optional selectNodeById();


    /**
     * id 是否存在
     * @param id
     * @return
     */
    Boolean existById(Long id);


}
