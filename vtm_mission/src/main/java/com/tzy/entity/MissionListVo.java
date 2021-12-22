package com.tzy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Gk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@ApiModel(value = "任务表现层对象",description = "用于展示所有任务")
public class MissionListVo {
    @ApiModelProperty("状态")
    public String state;
    @ApiModelProperty("标签")
    public String label;
    @ApiModelProperty("标题")
    public String headline;
    @ApiModelProperty("类型")
    public String style;
    @ApiModelProperty("创建时间")
    public Date createTime;
    @ApiModelProperty("负责人名字")
    public String principalUserName;
    @ApiModelProperty("优先级")
    public String priority;
}
