/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.128.66
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : 192.168.128.66:3307
 Source Schema         : wydatabase

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 26/10/2021 20:48:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `part_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '分区ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章标题',
  `cover_img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '文章封面',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '文章内容，富文本格式类似html',
  `releaser_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_message_deleted_at`(`deleted_at`) USING BTREE,
  INDEX `fk_t_message_releaser`(`releaser_id`) USING BTREE,
  INDEX `fk_t_partition_messages`(`part_id`) USING BTREE,
  CONSTRAINT `fk_t_message_releaser` FOREIGN KEY (`releaser_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_partition_messages` FOREIGN KEY (`part_id`) REFERENCES `t_partition` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文章表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner`  (
  `id` int(11) NOT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `banner_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主图标题',
  `banner_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主图地址URL',
  `banner_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主图图片URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = 'banner首页轮播大图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_browsed
-- ----------------------------
DROP TABLE IF EXISTS `t_browsed`;
CREATE TABLE `t_browsed`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '用户ID',
  `article_id` bigint(20) NULL DEFAULT NULL COMMENT '文章ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_browsed_deleted_at`(`deleted_at`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_browsed_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户浏览历史' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `article_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_collection_deleted_at`(`deleted_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父级评论，回复评论时需要',
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `article_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '文章ID',
  `releaser_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '发布者ID',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL COMMENT '评论内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_comment_deleted_at`(`deleted_at`) USING BTREE,
  INDEX `fk_t_comment_releaser`(`releaser_id`) USING BTREE,
  CONSTRAINT `fk_t_comment_releaser` FOREIGN KEY (`releaser_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `t_comment_like`;
CREATE TABLE `t_comment_like`  (
  `id` bigint(20) NOT NULL,
  `created_at` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `updated_at` datetime NULL DEFAULT NULL,
  `deleted_at` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `comment_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '评论点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comment_user
-- ----------------------------
DROP TABLE IF EXISTS `t_comment_user`;
CREATE TABLE `t_comment_user`  (
  `comment_id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`comment_id`, `user_id`) USING BTREE,
  INDEX `fk_t_comment_user_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_t_comment_user_comment` FOREIGN KEY (`comment_id`) REFERENCES `t_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_comment_user_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_friends
-- ----------------------------
DROP TABLE IF EXISTS `t_friends`;
CREATE TABLE `t_friends`  (
  `friend_id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`friend_id`, `user_id`) USING BTREE,
  INDEX `fk_t_friends_friends`(`user_id`) USING BTREE,
  CONSTRAINT `fk_t_friends_friends` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_friends_user` FOREIGN KEY (`friend_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户自关联表，关注表。主动发起关注的是user_id,被关注的是friend_id' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_label
-- ----------------------------
DROP TABLE IF EXISTS `t_label`;
CREATE TABLE `t_label`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `label_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标签名称',
  `label_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标签类型',
  `label_router` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '标签指向链接，点击标签调整过去',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_label_deleted_at`(`deleted_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文章标签' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_label_article
-- ----------------------------
DROP TABLE IF EXISTS `t_label_article`;
CREATE TABLE `t_label_article`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `label_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `article_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文章标签中间表，多对多' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_like
-- ----------------------------
DROP TABLE IF EXISTS `t_like`;
CREATE TABLE `t_like`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `user_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  `article_id` bigint(20) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_like_deleted_at`(`deleted_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户点赞' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_link
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link`  (
  `id` bigint(20) NOT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `link_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `link_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `link_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '友情链接' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` bigint(20) NOT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `notice_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '通知标题',
  `notice` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '通知内容，支持富文本',
  `level` int(4) NULL DEFAULT NULL COMMENT '公告级别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_part_user
-- ----------------------------
DROP TABLE IF EXISTS `t_part_user`;
CREATE TABLE `t_part_user`  (
  `partition_id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`partition_id`, `user_id`) USING BTREE,
  INDEX `fk_t_part_user_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_t_part_user_partition` FOREIGN KEY (`partition_id`) REFERENCES `t_partition` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_part_user_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分区用户中间表，用户可订阅分区' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_partition
-- ----------------------------
DROP TABLE IF EXISTS `t_partition`;
CREATE TABLE `t_partition`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `part_type_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '分区类型ID',
  `part_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分区名称',
  `part_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分区介绍',
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分区图标',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_partition_deleted_at`(`deleted_at`) USING BTREE,
  INDEX `fk_t_partition_partition_type`(`part_type_id`) USING BTREE,
  CONSTRAINT `fk_t_partition_partition_type` FOREIGN KEY (`part_type_id`) REFERENCES `t_partition_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文章分区' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_partition_type
-- ----------------------------
DROP TABLE IF EXISTS `t_partition_type`;
CREATE TABLE `t_partition_type`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `part_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '分区类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_partition_type_deleted_at`(`deleted_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '分区类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created_at` datetime(3) NULL DEFAULT NULL,
  `updated_at` datetime(3) NULL DEFAULT NULL,
  `deleted_at` datetime(3) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `top_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '主页大图',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '个性签名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime(3) NULL DEFAULT NULL COMMENT '生日',
  `state` int(4) NULL DEFAULT NULL COMMENT '账号状态：200可用，205禁用',
  `root` int(4) NULL DEFAULT NULL COMMENT '管理员标识',
  `currency` bigint(20) NULL DEFAULT NULL COMMENT '金币',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_t_user_deleted_at`(`deleted_at`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
