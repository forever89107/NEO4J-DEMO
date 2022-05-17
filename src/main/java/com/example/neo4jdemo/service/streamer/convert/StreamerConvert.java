package com.example.neo4jdemo.service.streamer.convert;

import com.example.neo4jdemo.controller.streamer.StreamerDto;
import com.example.neo4jdemo.neo4j.entity.streamer.StreamerDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StreamerConvert {
    StreamerConvert INSTANCE = Mappers.getMapper(StreamerConvert.class);

    @Mapping(target = "uuid", ignore = true)
    StreamerDao toStreamer(StreamerDto dto);

    Iterable<StreamerDto> toStreamerList(Iterable<StreamerDto> dtos);

//    StreamerDto toStreamerDto(Streamer dto);
//    List<StreamerDto> toStreamerList(List<Streamer> dtos);


}
