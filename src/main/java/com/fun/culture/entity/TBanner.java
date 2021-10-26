package com.fun.culture.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
    /**
     * 
     */
    private Integer id;

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
     * 主图标题
     */
    private String bannerTitle;

    /**
     * 主图地址URL
     */
    private String bannerUrl;

    /**
     * 主图图片URL
     */
    private String bannerImg;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}