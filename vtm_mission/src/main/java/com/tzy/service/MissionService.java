package com.tzy.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzy.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

/**
 * @author
 * @date
 */
public interface MissionService {


    /**
     * 分页展示任务
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<MissionListVo> getMissionList(Page<MissionListVo> page, @Param(Constants.WRAPPER) QueryWrapper<MissionListVo> queryWrapper);

    /**
     * 通过id找到任务实体类
     * @param id
     * @return
     */
    Mission getDetailedMissonById(int id);


    /**
     * 创建任务
     * @param projectId
     * @return
     */
    MissionCreateVo createMission(Long projectId,MissionRequestDto missionRequestDto) throws ParseException;
 /*   *//**
     * 创建任务时选定任务的负责人和成员
     * @param projectId
     * @return
     *//*
    List<MissionUserAuthority> chooseLeaderAndMember(Long projectId);
    *//**
     * 通过项目id查找该项目的成员的id
     * @param projectId
     * @return
     *//*
    List<Long> findProjectUserId(Long projectId);
    *//**
     * 返回选定负责人展示的视图
     *//*
    List<MissionUserAuthorityVo> findMissionCreateVo(@Param("missionId") Long missionId);*/

}
