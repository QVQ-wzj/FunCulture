package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdAt;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    @ApiModelProperty("逻辑删除")
    @TableLogic("deletedAt")
    private Long deletedAt;

    /**
     * 通知标题
     */
    @ApiModelProperty("通知标题")
    private String noticeTitle;

    /**
     * 通知内容，支持富文本
     */
    @ApiModelProperty("通知内容，支持富文本")
    private String notice;

    /**
     * 公告级别
     */
    @ApiModelProperty("公告级别")
    private Integer level;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}