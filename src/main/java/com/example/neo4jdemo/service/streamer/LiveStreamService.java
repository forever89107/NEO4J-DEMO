package com.example.neo4jdemo.service.streamer;

import com.example.neo4jdemo.controller.dto.StreamerDto;
import com.example.neo4jdemo.controller.dto.ViewerDto;
import com.example.neo4jdemo.neo4j.entity.SubscribeRel;
import com.example.neo4jdemo.neo4j.entity.StreamerDao;
import com.example.neo4jdemo.neo4j.entity.ViewerDao;
import com.example.neo4jdemo.neo4j.repository.SubscribeRepository;
import com.example.neo4jdemo.neo4j.repository.StreamerRepository;
import com.example.neo4jdemo.neo4j.repository.ViewrRepository;
import com.example.neo4jdemo.neo4j.response.Response;
import com.example.neo4jdemo.service.streamer.convert.StreamerConvert;
import com.example.neo4jdemo.service.streamer.convert.ViewerConvert;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;


/**
 * 直播 service 層
 */
@Service
public class LiveStreamService {

    private final StreamerRepository streamerRepository;
    private final ViewrRepository viewrRepository;
    private final SubscribeRepository subscribeRepository;


    public LiveStreamService(StreamerRepository repository, ViewrRepository viewrRepository,
                             SubscribeRepository liveStreamingRelRepository) {
        this.streamerRepository = repository;
        this.viewrRepository = viewrRepository;
        this.subscribeRepository = liveStreamingRelRepository;
    }

    /**
     * 創建 主播 節點
     *
     * @return Response
     */
    public Response createNode(StreamerDto dto) {
        // convert to dao Object
        StreamerDao dao = StreamerConvert.INSTANCE.toStreamerDao(dto);

        // check unique property
        StreamerDao resultOp = streamerRepository.selectByName(dto.getName());
        Assert.isTrue(resultOp == null, "重複Name，不可創建節點");

        // 儲存新node
        StreamerDao saveDao = streamerRepository.save(dao);
        // convert to dto Object
        StreamerDto resDto = StreamerConvert.INSTANCE.toStreamerDto(saveDao);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(node.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);

        // return
        Response result = new Response(true);
        result.getMap().put("res", resDto);
        return result;
    }

    /**
     * 尋找 主播 節點 by Name
     *
     * @return Response
     */
    public Response selectByName(String name) {
        StreamerDao resultOp = streamerRepository.selectByName(name);
        Assert.notNull(resultOp, "查無此名");
        // convert to dto Object
        StreamerDto dto = StreamerConvert.INSTANCE.toStreamerDto(resultOp);
        // return
        Response result = new Response(true);
        result.getMap().put("res", dto);
        return result;
    }


    /**
     * 尋找 主播 Node by UuId
     *
     * @return Response
     */
    public Response selectByUuId(String UuId) {
        StreamerDao resultOp = streamerRepository.selectByUuId(UuId);

        // convert to dto Object
        StreamerDto dto = StreamerConvert.INSTANCE.toStreamerDto(resultOp);

        // return
        Response result = new Response(true);
        result.getMap().put("res", dto);
        return result;
    }

    /**
     * 尋找 主播 UuId by name
     *
     * @return Response
     */
    public Response selectUuIdByName(String name) {
        String UuId = streamerRepository.selectUuIdByName(name);

        // return
        Response result = new Response(true);
        result.getMap().put("res", UuId);
        return result;
    }

    /**
     * 更新 主播 by Name
     *
     * @return Response
     */
    public Response updateByName(StreamerDto dto) {
        // convert to dao Object
        StreamerDao dao = StreamerConvert.INSTANCE.toStreamerDao(dto);

        int resultOp = streamerRepository.updateByName(dao.getName(), dao.getLocation(), dao.getTags());
        // return
        Response result = new Response(true);
        result.getMap().put("res", resultOp);
        return result;
    }

    public Response addViewer(ViewerDto dto) {
        // convert to dao Object
        ViewerDao dao = ViewerConvert.INSTANCE.toViewerDao(dto);

        // check unique property
        ViewerDao resultOp = viewrRepository.selectByName(dto.getName());
        Assert.isTrue(resultOp == null, "重複Name，不可創建節點");

        // 儲存新node
        ViewerDao saveDao = viewrRepository.save(dao);
        // convert to dto Object
        ViewerDto resDto = ViewerConvert.INSTANCE.toViewerDto(saveDao);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(node.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);

        // return
        Response result = new Response(true);
        result.getMap().put("res", resDto);
        return result;
    }

    /**
     * 新增 主播&粉絲關係
     *
     * @param strNodeUuId 粉絲節點
     * @param endNodeUuId 主播節點
     * @return Response
     */
    public Response addRelationShip(String strNodeUuId, String endNodeUuId) {
        // 檢查節點是否存在
        ViewerDao strNode = viewrRepository.selectByUuId(strNodeUuId);
        StreamerDao endNode = streamerRepository.selectByUuId(endNodeUuId);

        SubscribeRel relationShip = SubscribeRel.builder().
                viwer(strNode).streamer(endNode).subscribeDate(new Date()).build();
        subscribeRepository.save(relationShip);
        return new Response(true);

    }

    /**
     * 獲取訂閱關係開始節點
     * @return Response
     */
    public Response getSubRelNode(Long Id) {
        // 檢查節點是否存在
        Assert.notNull(Id, "查無此關係節點");

        ViewerDao strNode = subscribeRepository.getSubRelStrNode(Id);
        StreamerDao endNode = subscribeRepository.getSubRelEndNode(Id);
//        Assert.isNull(strNode, "查無開始節點");
//        Assert.isNull(endNode, "查無結束節點");

        Response result = new Response(true);
        result.getMap().put("strNode", strNode);
        result.getMap().put("endNode", endNode);
        return result;

    }

}
