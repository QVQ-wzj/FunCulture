package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户自关联表，关注表。主动发起关注的是user_id,被关注的是friend_id
 * @TableName t_friends
 */
@TableName(value ="t_friends")
@Data
public class TFriends implements Serializable {
    /**
     * 
     */
    private Long friendId;

    /**
     * 
     */
    @TableId
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}