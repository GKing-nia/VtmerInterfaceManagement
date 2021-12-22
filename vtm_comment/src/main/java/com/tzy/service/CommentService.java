package com.tzy.service;

import com.tzy.entity.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 查询评论列表
     * @return
     */
    List<Comment> listCommentByMissionId(Long missionId);

    /**
     * 保存评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);

    /**
     * 删除评论
     * @param comment
     * @param id
     */
    void deleteComment(Comment comment, Long id);


}
