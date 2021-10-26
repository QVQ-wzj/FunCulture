package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统公告
 * @TableName t_notice
 */
@TableName(value ="t_notice")
@Data
public class TNotice implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Date updatedAt;

    /**
     * 
     */
    private Date deletedAt;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 通知标题
     */
    private String noticeTitle;

    /**
     * 通知内容，支持富文本
     */
    private String notice;

    /**
     * 公告级别
     */
    private Integer level;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}