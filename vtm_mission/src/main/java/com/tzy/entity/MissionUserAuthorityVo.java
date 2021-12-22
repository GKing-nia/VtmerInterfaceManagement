package com.tzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Gking
 * @date : 2021-12-20 21:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel("任务中成员权限")
public class MissionUserAuthorityVo {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("该任务中该用户的权限")
    private String authority;

}
