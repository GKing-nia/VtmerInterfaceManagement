package com.tzy.controller;

import com.tzy.entity.AjaxResult;
import com.tzy.entity.Comment;
import com.tzy.entity.Mission;
import com.tzy.service.CommentService;
import com.tzy.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Gking
 *         任务控制类
 */
@RestController
@PropertySource({"classpath:/application.properties"})
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private MissionService missionService;

    /**
     * 头像地址
     */
    @Value("${comment.avatar}")
    private String avatar;

    /**
     * 查询评论列表
     * @param missionId
     * @param model
     * @return
     */
    @GetMapping("/comments/{missionId}")
    public List<Comment> comments(@PathVariable Long missionId, Model model) {
        List<Comment> comments = commentService.listCommentByMissionId(missionId);
        model.addAttribute("comments", comments);
        return comments;
    }

    /**
     * 新增评论
     * @param comment
     * @param session
     * @param model
     * @return
     */
    @PostMapping("/comments")
    public AjaxResult post(Comment comment, HttpSession session, Model model) {
        Long missionId = comment.getMissionId();
        //TODO   引入用户实体类之后设置头像
  /*      User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            //设置头像
            comment.setAvatar(avatar);
        }*/

        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.listCommentByMissionId(missionId);
        model.addAttribute("comments", comments);
        if (comment==null){
            return AjaxResult.error("新增评论失败");
        }else {
            return AjaxResult.success("评论发表成功！！！");
        }
    }

    /**
     * 删除评论
     * @param missionId
     * @param id
     * @param comment
     * @param attributes
     * @param model
     * @return
     */
    @GetMapping("/comment/{missionId}/{id}/delete")
    public AjaxResult delete(@PathVariable Long missionId, @PathVariable Long id, Comment comment, RedirectAttributes attributes, Model model){
        commentService.deleteComment(comment,id);
        Mission detailedMission = missionService.getDetailedMissonById(Math.toIntExact(missionId));
        if (detailedMission==null){
            return AjaxResult.warn("删除失败");
        }else {
            List<Comment> comments = commentService.listCommentByMissionId(missionId);
            model.addAttribute("mission", detailedMission);
            model.addAttribute("comments", comments);
            return AjaxResult.success("删除成功！！！");
        }


    }



}
