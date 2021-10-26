package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * banner首页轮播大图
 * @TableName t_banner
 */
@TableName(value ="t_banner")
@Data
public class TBanner implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

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
     * 主图标题
     */
    @ApiModelProperty("主图标题")
    private String bannerTitle;

    /**
     * 主图地址URL
     */
    @ApiModelProperty("主图地址URL")
    private String bannerUrl;

    /**
     * 主图图片URL
     */
    @ApiModelProperty("主图图片URL")
    private String bannerImg;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}