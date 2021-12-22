package com.tzy.service.impl;

import com.tzy.dao.CommentMapper;
import com.tzy.dao.MissionMapper;
import com.tzy.entity.Comment;
import com.tzy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gking
 * @date
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentDao;

    @Autowired
    private MissionMapper missionDao;

    //存放 找出的所有子评论的集合
    private List<Comment> tempReplys=new ArrayList<>();

    /**
     * 通过任务id获取任务评论列表
     * @param missionId
     * @return
     */
    @Override
    public List<Comment> listCommentByMissionId(Long missionId) {
        List<Comment> comments=commentDao.findByMissionIdParentIdNull(missionId,Long.parseLong("-1"));
        for (Comment comment:comments){
            Long id = comment.getId();
            String parentNickname1=comment.getNickname();
            List<Comment> childComments= commentDao.findByMissionIdParentIdNotNull(missionId,id);
            combineChildren(missionId,childComments,parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys=new ArrayList<>();
        }

        return comments;
    }

    /**
     * 查出一级子评论
     * @param missionId
     * @param childComments
     * @param parentNickname1
     */
    private void combineChildren(Long missionId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
//                    查询出子二级评论
                recursively(missionId, childId, parentNickname);
            }
        }
    }

    /**
     * 查询二级子评论
     * @param missionId
     * @param childId
     * @param parentNickname1
     */
    private void recursively(Long missionId, Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findMissionIdAndReplayId(missionId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(missionId,replayId,parentNickname);
            }
        }
    }

    /**
     * 新增评论
     * @param comment
     * @return
     */
    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int comments = commentDao.saveComment(comment);
        return comments;
    }

    /**
     * 删除评论
     * @param comment
     * @param id
     */
    @Override
    public void deleteComment(Comment comment,Long id) {
        commentDao.deleteComment(id);

    }

}
