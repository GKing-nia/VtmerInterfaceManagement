package com.tzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzy.dao.MissionMapper;
import com.tzy.entity.*;
import com.tzy.service.MissionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date
 */
@Service
public class MissionServiceImpl implements MissionService {

    @Resource
    private MissionMapper missionMapper;


    /**
     * 得到所有任务
     * @param page
     * @param queryWrapper
     * @return
     */
    @Override
    public IPage<MissionListVo> getMissionList(Page<MissionListVo> page, @Param(Constants.WRAPPER) QueryWrapper<MissionListVo> queryWrapper){

        return missionMapper.getMissionList(page, queryWrapper);
    }

    /**
     * 通过任务id获得任务
     * @param id
     * @return
     */
    @Override
    public Mission getDetailedMissonById(int id) {
        return missionMapper.getDetailedMissonById(id);
    }

    /**
     * 创建任务
     * @param projectId
     * @return
     */
    @Override
    public MissionCreateVo createMission(Long projectId,MissionRequestDto missionRequestDto) throws ParseException {
        Mission  mission=new Mission();
        MissionCreateVo missionCreateVo=new MissionCreateVo();
        BeanUtils.copyProperties(mission,missionRequestDto);
        Long userId=missionMapper.findLeaderInProjectByAuthority(projectId);
        mission.setCreateTime(new Date());
        mission.setUpdateTime(new Date());
        mission.setCreatorId(userId);
        missionMapper.createMission(projectId);
        BeanUtils.copyProperties(missionCreateVo,mission);
        List<MissionUserAuthority> missionUserAuthorities=missionRequestDto.getMissionUserAuthorities();
        List<MissionUserAuthorityVo> missionUserAuthorityVos=new ArrayList<>();
        for (MissionUserAuthority missionUserAuthority: missionUserAuthorities) {
            missionMapper.chooseLeaderAndMember(projectId);
        }
        missionCreateVo.setProjectName(missionMapper.findProjectNameById(projectId));
        missionCreateVo.setMissionUserAuthorityVos(missionMapper.findMissionCreateVo(missionRequestDto.getId()));
            return missionCreateVo;

    }



}
