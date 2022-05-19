package com.example.neo4jdemo.service.streamer.convert;

import com.example.neo4jdemo.controller.dto.StreamerDto;
import com.example.neo4jdemo.neo4j.entity.StreamerDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StreamerConvert {
    StreamerConvert INSTANCE = Mappers.getMapper(StreamerConvert.class);

    @Mapping(target = "uuid", ignore = true)
    StreamerDao toStreamerDao(StreamerDto dto);
//    Iterable<StreamerDto> toStreamerList(Iterable<StreamerDto> dtos);

    StreamerDto toStreamerDto(StreamerDao dao);
//    List<StreamerDto> toStreamerList(List<Streamer> dtos);


}
