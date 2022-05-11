package com.example.neo4jdemo.neo4j.web;


import com.example.neo4jdemo.converter.StreamerMapping;
import com.example.neo4jdemo.neo4j.entity.streamer.Streamer;
import com.example.neo4jdemo.neo4j.response.Response;
import com.example.neo4jdemo.neo4j.service.StreamerService;
import org.neo4j.ogm.annotation.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 主播個人資訊 Controller層
 */
@RestController
@RequestMapping(value = "/streamer", produces = MediaType.APPLICATION_JSON_VALUE)
public class StreamerController {
    @Autowired
    private StreamerService streamerService;
//    @Autowired
//    private StreamerMapping streamerMapping;
//    @Resource
//    private RelationShipRepository relationShipRepository;


    @PostMapping
    public Response create(@RequestBody StreamerDto dto) {
//        Streamer streamer = streamerMapping.streamerDtoToStreamer(dto);
        return streamerService.createNode(dto);
    }

    @GetMapping("selectNodeById")
    public void selectNodeById(Long nodeId) {
//        Optional<StreamerNode> op_NodeId = StreamerService.findById(nodeId);
//        if (op_NodeId.isPresent()) {
//            return op_NodeId.get();
//        } else {
//            return op_NodeId.orElse(null);
//        }
    }

    @GetMapping("addRelationShip")
    public String addRelationShip(Long parentId, Long childId, String name) {
//        StreamerNode parent;
//        StreamerNode child;
//        Optional<StreamerNode> op_ParentId = StreamerService.findById(parentId);
//        if (op_ParentId.isPresent()) {
//            parent = op_ParentId.get();
//        } else {
//            return "ParentId is NULL";
//        }
//
//        Optional<StreamerNode> op_ChildId = StreamerService.findById(childId);
//        if (op_ChildId.isPresent()) {
//            child = op_ChildId.get();
//        } else {
//            return "ChildId is null";
//
//        }
//        RelationShip relationShip = RelationShip.builder().parent(parent).child(child).name(name).build();
//        relationShipRepository.save(relationShip);
        return "Add RelationShip Success";
    }

    //    @GetMapping("selectRelationShipById")
//    public RelationShip get(Long id){
//        Optional<RelationShip> byId = relationShipRepository.findById(id);
//        return byId.orElse(null);
//    }
    @PostLoad
    public void StreamerController() {
        System.out.println("StreamerController");
    }

    @GetMapping("deleteRelationShip")
    public void deleteRelationShip(Long id) {
//        relationShipRepository.deleteById(id);
    }

    @GetMapping("deleteStreamerDto")
    public void deleteStreamerDto(Long id) {
//        StreamerService.deleteById(id);
    }

    @DeleteMapping
    public String deleteAll() {
//        StreamerService.deleteAll();
//        relationShipRepository.deleteAll();
        return "Delete All Success";
    }


}
