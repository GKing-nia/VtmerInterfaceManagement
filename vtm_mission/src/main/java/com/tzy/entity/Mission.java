package com.tzy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author Gking
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "mission")
@ApiModel(value = "任务实体类")
public class Mission {
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


    public enum Label{
        bug,question,功能错误,代码错误,内容相关,表单相关,用户界面,安装部署,配置相关,设计文档
    }
    public enum Type{
        任务,需求,设计,缺陷
    }
    public enum Condition{
        待办的,进行中,已完成,已验收
    }
    public enum Priority{
        严重,主要,次要,不重要
    }
}
