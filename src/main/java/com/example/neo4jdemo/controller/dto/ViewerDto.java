package com.example.neo4jdemo.controller.dto;

import com.example.neo4jdemo.neo4j.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@ApiModel(description = "粉絲模組")
public class ViewerDto {
    @ApiModelProperty(value = "名稱", required = true)
    private String name;
    @ApiModelProperty(value = "別名")
    private Set<String> labels;
    @ApiModelProperty(value = "生日")
    private Date birthday;
    @ApiModelProperty(value = "所在區域")
    private String location;
    @ApiModelProperty(value = "性別")
    private Gender gender;
}
