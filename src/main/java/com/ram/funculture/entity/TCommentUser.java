package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_comment_user
 */
@TableName(value ="t_comment_user")
@Data
public class TCommentUser implements Serializable {
    /**
     * 
     */
    @MppMultiId
    @TableField("comment_id")
    private Long commentId;

    /**
     * 
     */
    @MppMultiId
    @TableField("user_id")
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}