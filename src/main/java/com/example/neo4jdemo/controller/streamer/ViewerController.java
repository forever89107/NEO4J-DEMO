package com.example.neo4jdemo.controller.streamer;

import com.example.neo4jdemo.controller.dto.ViewerDto;
import com.example.neo4jdemo.neo4j.response.Response;
import com.example.neo4jdemo.service.streamer.LiveStreamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 粉絲 Controller層
 */
@Api(value = "粉絲操作接口",tags = "viewer")
@RestController
@RequestMapping(value = "/viewer", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViewerController {
    private final LiveStreamService liveStreamService;

    @Autowired
    public ViewerController(LiveStreamService liveStreamService) {
        this.liveStreamService = liveStreamService;
    }

    @ApiOperation(value = "新增粉絲節點")
    @PostMapping("addviewer")
    public Response addviewer(@RequestBody ViewerDto dto) {
        return liveStreamService.addViewer(dto);
    }

    @ApiOperation(value = "新增訂閱關係")
    @PostMapping("addRel")
    public Response addRelationShip(@RequestParam(name = "strNodeUuId") String strNodeUuId,
                                    @RequestParam(name = "endNodeUuId") String endNodeUuId) {
        return liveStreamService.addRelationShip(strNodeUuId, endNodeUuId);
    }

    @ApiOperation(value = "取得訂閱關係的雙節點")
    @GetMapping("getSubRelNodes")
    public Response getSubRelStrNode(@RequestParam(name = "id") Long id) {
        return liveStreamService.getSubRelNode(id);
    }
}
