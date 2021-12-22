package com.tzy.dao;

import com.tzy.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    /**
     * 添加一个评论
     * @param comment
     * @return
     */
    @Insert("INSERT INTO mission_comment (id,user_id,nickname,content,avatar,create_time,mission_id,parent_comment_id,update_time) \n" +
            "VALUES (#{id},#{user_id},#{nickname},#{content},#{avatar},#{create_time},#{mission_id},#{parent_comment_id},#{update_time})")
    int saveComment(Comment comment);

    /**
     * 查询父级评论
     * @param parentId
     * @return
     */
    @Select("        select *" +
            "        from mission_comment c" +
            "        where c.mission_id = #{missionId} and c.parent_comment_id = #{parentId}" +
            "        order by c.create_time desc")
    List<Comment> findByMissionIdParentIdNull(@Param("missionId") Long missionId,@Param("parentId") Long parentId);

    /**
     * 查询一级评论
     * @param id
     * @return
     */
    @Select("select *\n" +
            "        from mission_comment c\n" +
            "        where c.mission_id = #{missionId} and c.parent_comment_id = #{id}\n" +
            "        order by c.create_time desc\n")
    List<Comment> findByMissionIdParentIdNotNull(@Param("missionId") Long missionId,@Param("id") Long id);

    /**
     * 查询二级以及所有子集回复
     * @param childId
     * @return
     */
    @Select("select *\n" +
            "        from mission_comment c\n" +
            "        where c.mission_id = #{missionId} and c.parent_comment_id = #{childId}\n" +
            "        order by c.create_time desc\n")
    List<Comment> findMissionIdAndReplayId(@Param("missionId") Long missionId,@Param("childId") Long childId);

    /**
     * 删除评论
     * @param id
     */
    @Delete("delete from mission_comment where id = #{id}")
    void deleteComment(Long id);


}
