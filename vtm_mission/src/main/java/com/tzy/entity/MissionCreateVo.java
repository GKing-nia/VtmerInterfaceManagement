package com.tzy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@TableName(value = "mission")
@ApiModel(value = "创建任务视图对象",description = "展示任务创建的数据")
public class MissionCreateVo {
    @ApiModelProperty("标题")
    public String headline;
    @ApiModelProperty("类型")
    public String style;
    //任务标签
    @ApiModelProperty("标签")
    public String label;
    @ApiModelProperty("状态")
    public String state;
    //任务开始时间
    @ApiModelProperty("开始时间")
    @TableField(value = "begin_time")
    public Date beginTime;
    //任务截止时间
    @ApiModelProperty("任务截止时间")
    @TableField(value = "end_time")
    public Date endTime;
    //优先级
    @ApiModelProperty("优先级")
    public String priority;
    //任务描述说明
    @ApiModelProperty("任务描述")
    public String description;
    @ApiModelProperty("所在的项目名")
    public String projectName;
    @ApiModelProperty("从项目成员中选定的负责人和成员")
    private List<MissionUserAuthorityVo> missionUserAuthorityVos=new ArrayList<>();
}
