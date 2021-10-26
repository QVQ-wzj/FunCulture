package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModelProperty;
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
    @MppMultiId
    @TableField("friend_id")
    private Long friendId;

    /**
     * 
     */
    @MppMultiId
    @TableField("user_id")
    private Long userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}