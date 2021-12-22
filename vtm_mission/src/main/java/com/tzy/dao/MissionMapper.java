package com.tzy.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzy.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date
 */

public interface MissionMapper extends BaseMapper<Mission> {

    /**
     * 找出该项目的负责人
     * @param projectId
     * @return
     */
    @Select("SELECT user_id FROM project_user WHERE project_id = #{projectId} AND authority = '负责人'")
    Long findLeaderInProjectByAuthority(@Param("projectId") Long projectId);

    /**
     * 新增任务
     * @param
     * @param projectId
     */
    @Insert("INSERT INTO mission (headline,style,state,label,begin_time,end_time,priority,description,project_id,creator_id,create_time,update_time) \n" +
            "VALUES (#{headline},#{style},#{state},#{label},#{beginTime},#{endTime},#{priority},#{description},#{projectId},#{creatorId},#{createTime},#{updateTime})")
    Mission createMission(@Param("projectId ") Long projectId);

    /**
     * 项目选择负责人和成员
     * @param projectId
     */
    @Insert("INSERT INTO mission_user_authority (mission_id,user_id,authority,create_time,update_time) \n" +
            "VALUES (#{missionId},#{userId},#{authority},#{createTime},#{updateTime})")
    MissionUserAuthority chooseLeaderAndMember(Long projectId);



    @Select("SELECT mission.`state`,mission.`label`,\n" +
            "mission.`headline`,mission.`style`,\n" +
            "mission.`create_time`,mission.`priority`,\n" +
            "user.`username` FROM USER , mission,mission_user_authority \n" +
            "WHERE mission.`id` = mission_user_authority.`mission_id`\n" +
            "AND user.`id`=mission_user_authority.`user_id` \n" +
            "AND mission_user_authority.`authority`='负责人'")
    IPage<MissionListVo> getMissionList(Page<MissionListVo> page, @Param(Constants.WRAPPER) QueryWrapper<MissionListVo> queryWrapper);

    /**
     * 根据id获取任务实体类
     */
    @Select("select * from mission where id = #{id}")
    Mission getDetailedMissonById(@Param("id") int id);

    /**
     * 查找该项目的成员id
     * @param projectId
     * @return
     */
    @Select("SELECT user_id FROM project_user WHERE project_id=#{projectId}")
    List<Long> findProjectUserId(@Param("projectId") Long projectId);

    /**
     * 当新建任务后，从该任务获取负责人和成员
     * @param missionId
     * @return
     */
    @Select("SELECT user.`username`,mission_user_authority.`authority`\n" +
            "FROM USER,mission_user_authority \n" +
            "WHERE mission_user_authority.mission_id =#{missionId}\n" +
            "AND user.`id`= mission_user_authority.`user_id`")
    List<MissionUserAuthorityVo> findMissionCreateVo(@Param("missionId") Long missionId);

    /**
     * 通过id查找project名
     * @param id
     * @return
     */
    @Select("SELECT project_name FROM project WHERE id =#{id}")
    String findProjectNameById(@Param("id") Long id);


}
