package com.tzy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date
 */
@Data
@NoArgsConstructor
@ToString
@TableName("mission_comment")
@ApiModel(value = "任务评论实体类",description = "任务评论区存储评论数据")
public class Comment {
    private Long id;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "用户头像")
    private String avatar;
    @ApiModelProperty(value ="创建时间" )
    private Date createTime;
    @ApiModelProperty(value = "任务id")
    private Long missionId;
    @ApiModelProperty("父楼评论id")
    private Long parentCommentId;
    @ApiModelProperty("父楼评论的楼主昵称")
    private String parentNickname;

    //回复评论
    @ApiModelProperty("回复评论")
    private List<Comment> replyComments = new ArrayList<>();
    @ApiModelProperty("父楼评论实体类")
    private Comment parentComment;
    @ApiModelProperty("任务实体类")
    private Mission mission;


}
