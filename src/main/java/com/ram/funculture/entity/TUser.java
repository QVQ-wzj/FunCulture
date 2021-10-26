package com.ram.funculture.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class TUser implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headImg;

    /**
     * 主页大图
     */
    @ApiModelProperty("主页大图")
    private String topImg;

    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String signature;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 账号状态：200可用，205禁用
     */
    @ApiModelProperty("账号状态：200可用，205禁用")
    private Integer state;

    /**
     * 管理员标识
     */
    @ApiModelProperty("管理员标识")
    private Integer root;

    /**
     * 金币
     */
    @ApiModelProperty("金币")
    private Long currency;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}