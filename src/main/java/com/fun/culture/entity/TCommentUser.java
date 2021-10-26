package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Long commentId;

    /**
     * 
     */
    @TableId
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}