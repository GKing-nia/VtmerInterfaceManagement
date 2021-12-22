package com.tzy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tzy.entity.*;
import com.tzy.service.MissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date
 */
@RestController
@RequestMapping("mission")
public class MissionController {
    @Autowired
    private MissionService missionService;

    /**
     * 展示全部任务
     * @return
     */
    @GetMapping("list")
    public Object missionList(){
        Page<MissionListVo> page = new Page<>(1, 10);
        IPage<MissionListVo> missionListVoIPage=missionService.getMissionList(page,new QueryWrapper<>());
        return  missionListVoIPage;
    }

    /**
     * 新增任务
     * @param projectId
     * @return
     */
    @PostMapping("create/{projectId}")
    public AjaxResult createMission(@PathVariable Long projectId,@RequestBody MissionRequestDto missionRequestDto) throws ParseException {
        if (projectId!=null){
             MissionCreateVo missionCreateVo= missionService.createMission(projectId,missionRequestDto);
             if (missionCreateVo==null){
                 return AjaxResult.error("添加任务失败！！！");
             }else{
                 return AjaxResult.success("添加任务成功！！！");
             }
        }else {
            return AjaxResult.error("没有该项目！！！");
        }
    }


}
