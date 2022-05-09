package com.example.neo4jdemo.neo4j.web;


import com.example.neo4jdemo.neo4j.entity.Streamer;
import com.example.neo4jdemo.neo4j.repository.StreamerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping(value = "/neo4j", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
    @Resource
    private StreamerRepository streamerDtoRepository;
//    @Resource
//    private RelationShipRepository relationShipRepository;


    @PostMapping
    public String create(@RequestBody Streamer info){
//        Streamer tmp = neo4jUtil.newNode(info);
//        streamerDtoRepository.save(tmp);
//        return "Create Node "+ info.getName() + " Success" ;
        return "";
    }

    @GetMapping("selectNodeById")
    public Streamer selectNodeById(Long nodeId){
        Optional<Streamer> op_NodeId = streamerDtoRepository.findById(nodeId);
        if(op_NodeId.isPresent()){
            return op_NodeId.get();
        }else{
            return op_NodeId.orElse(null);
        }
    }

    @GetMapping("addRelationShip")
    public String addRelationShip(Long parentId, Long childId, String name){
        Streamer parent ;
        Streamer child ;
        Optional<Streamer> op_ParentId = streamerDtoRepository.findById(parentId);
        if(op_ParentId.isPresent()){
             parent = op_ParentId.get();
        }else{
            return "ParentId is NULL";
        }

        Optional<Streamer> op_ChildId = streamerDtoRepository.findById(childId);
        if(op_ChildId.isPresent()){
            child = op_ChildId.get();
        }else{
            return "ChildId is null";

        }
//        RelationShip relationShip = RelationShip.builder().parent(parent).child(child).name(name).build();
//        relationShipRepository.save(relationShip);
        return "Add RelationShip Success";
    }

//    @GetMapping("selectRelationShipById")
//    public RelationShip get(Long id){
//        Optional<RelationShip> byId = relationShipRepository.findById(id);
//        return byId.orElse(null);
//    }

    @GetMapping("deleteRelationShip")
    public void deleteRelationShip(Long id){
//        relationShipRepository.deleteById(id);
    }

    @GetMapping("deleteStreamerDto")
    public void deleteStreamerDto(Long id){
        streamerDtoRepository.deleteById(id);
    }

    @DeleteMapping
    public String deleteAll(){
        streamerDtoRepository.deleteAll();
//        relationShipRepository.deleteAll();
        return "Delete All Success";
    }


}
