package com.example.neo4jdemo.service.streamer.convert;

import com.example.neo4jdemo.controller.dto.ViewerDto;
import com.example.neo4jdemo.neo4j.entity.ViewerDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ViewerConvert {
    ViewerConvert INSTANCE = Mappers.getMapper(ViewerConvert.class);

    @Mapping(target = "uuid", ignore = true)
    ViewerDao toViewerDao(ViewerDto dto);

    ViewerDto toViewerDto(ViewerDao dao);


}
