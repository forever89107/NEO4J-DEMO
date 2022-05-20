package com.example.neo4jdemo.controller.streamer;


import com.example.neo4jdemo.controller.dto.StreamerDto;
import com.example.neo4jdemo.controller.dto.ViewerDto;
import com.example.neo4jdemo.neo4j.response.Response;
import com.example.neo4jdemo.service.streamer.LiveStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * 主播 Controller層
 */
@RestController
@RequestMapping(value = "/streamer", produces = MediaType.APPLICATION_JSON_VALUE)
public class StreamerController {

    private final LiveStreamService liveStreamService;

    @Autowired
    public StreamerController(LiveStreamService liveStreamService) {
        this.liveStreamService = liveStreamService;
    }

    @PostMapping
    public Response createNode(@RequestBody StreamerDto dto) {
        return liveStreamService.createNode(dto);
    }

    @GetMapping
    public Response selectByName(@RequestParam  (name = "name") String name) {
        return liveStreamService.selectByName(name);
    }

    @GetMapping("node")
    public Response selectByUuId(@RequestParam (name = "uuid") String uuid) {
        return liveStreamService.selectByUuId(uuid);
    }

    @GetMapping("id")
    public Response selecUuIdByName(@RequestParam (name = "name") String name) {
        return liveStreamService.selectUuIdByName(name);
    }

    @PutMapping
    public Response updateByName(@RequestBody StreamerDto dto) {
        return liveStreamService.updateByName(dto);
    }

//    @GetMapping("deleteStreamerDto")
//    public void deleteStreamerDto(Long id) {
//        liveStreamService.deleteById(id);
//    }


//    @DeleteMapping("deleteRelationShip")
//    public void deleteRelationShip(Long id) {
//        relationShipRepository.deleteById(id);
//    }

//    @DeleteMapping
//    public String deleteAll() {
//        liveStreamService.deleteAll();
//        relationShipRepository.deleteAll();
//        return "Delete All Success";
//    }


}
