package com.tzy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.*;

/**
 * @author : Gking
 * @date : 2021-12-22 09:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class MissionRequestDto {
    public Long id;
    //任务标题
    public String headline;
    //任务类型
    public String style;
    //任务状态
    public String state;
    //任务标签
    public String label;
    //任务开始时间
    @TableField(value = "begin_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date beginTime;
    //任务截止时间
    @TableField(value = "end_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date endTime;
    //优先级
    public String priority;
    //任务描述说明
    public String description;
    //关联项目id
    @TableField(value = "project_id")
    public Long projectId;
    //创建者id
    @TableField(value = "creator_id")
    public Long creatorId;
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date createTime;
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date updateTime;
    //存放任务中用户的权限
    private List<MissionUserAuthority> missionUserAuthorities=new ArrayList<>();

}
