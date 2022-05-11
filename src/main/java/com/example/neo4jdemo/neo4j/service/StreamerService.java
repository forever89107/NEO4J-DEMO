package com.example.neo4jdemo.neo4j.service;

import com.example.neo4jdemo.neo4j.entity.streamer.Streamer;
import com.example.neo4jdemo.neo4j.repository.StreamerRepository;
import com.example.neo4jdemo.neo4j.response.Response;
import com.example.neo4jdemo.neo4j.web.StreamerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


/**
 * 主播個人資訊 service 層
 */
@Service
public class StreamerService {

    @Autowired
    private StreamerRepository repository;

    /**
     * @param node
     * @return
     */
    public Response createNode(StreamerDto node) {
        // 查看是否擁有此node
//        Optional<StreamerNode> resultOp = repository.findById(node.getId());
//        Assert.isTrue(resultOp.isPresent(), "重複ID，不可創建節點");

        // 儲存新node
        repository.save(node);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(node.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);

        Response res = new Response(HttpStatus.OK);
        return res;
    }



}
