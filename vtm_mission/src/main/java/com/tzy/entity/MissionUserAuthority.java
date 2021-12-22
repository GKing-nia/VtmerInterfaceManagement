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

import java.util.Date;

/**
 * @author
 * @date
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "mission_user_authority")
@ApiModel(value = "任务用户权限实体类")
public class MissionUserAuthority {
    public Integer id;
    @ApiModelProperty("任务id")
    public Integer missionId;
    @ApiModelProperty("用户id")
    public Integer userId;
    @ApiModelProperty(value = "权限")
    public String authority;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    public Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    public Date updateTime;

    public enum Authority{
        负责人,协作者
    }
}
