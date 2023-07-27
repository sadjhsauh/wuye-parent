/*
 Navicat Premium Data Transfer

 Source Server         : conn
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 127.0.0.1:3306
 Source Schema         : wy_db

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 26/07/2023 23:31:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fee_power
-- ----------------------------
DROP TABLE IF EXISTS `fee_power`;
CREATE TABLE `fee_power`  (
  `power_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `house_id` int(0) NULL DEFAULT NULL COMMENT '房屋id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '业主id',
  `pay_power_month` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缴费年月',
  `pay_power_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  `power_num` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表显',
  `pay_power_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0:未缴费  1：已缴费',
  `pay_power_time` datetime(0) NULL DEFAULT NULL COMMENT '缴费时间',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0：删除】【1：未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '电费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fee_power
-- ----------------------------
INSERT INTO `fee_power` VALUES (1, 1, 1, '2022-12-31T16:00:00.000Z', 100.00, '90', '0', NULL, 1, '2023-07-26 23:19:49', '2023-07-26 23:19:49');

-- ----------------------------
-- Table structure for fee_water
-- ----------------------------
DROP TABLE IF EXISTS `fee_water`;
CREATE TABLE `fee_water`  (
  `water_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `house_id` int(0) NULL DEFAULT NULL COMMENT '房屋id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '业主id',
  `pay_water_month` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缴费年月',
  `pay_water_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  `waterr_num` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表显',
  `pay_water_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '0:未缴费  1：已缴费',
  `pay_water_time` datetime(0) NULL DEFAULT NULL COMMENT '缴费时间',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0：删除】【1：未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`water_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '水费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fee_water
-- ----------------------------
INSERT INTO `fee_water` VALUES (1, 2, 2, '2023-01-31T16:00:00.000Z', 100.00, '90', '0', NULL, 1, '2023-07-26 23:20:11', '2023-07-26 23:20:11');

-- ----------------------------
-- Table structure for house_build
-- ----------------------------
DROP TABLE IF EXISTS `house_build`;
CREATE TABLE `house_build`  (
  `build_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `build_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '栋楼名称',
  `type` int(0) NOT NULL DEFAULT 1 COMMENT '栋楼类型【0：普通房】【1：电梯房】',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '序号【排序字段】',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0：删除】【1：未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`build_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '楼栋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_build
-- ----------------------------
INSERT INTO `house_build` VALUES (1, 'A栋', 1, 1, 1, '2023-07-26 23:15:35', '2023-07-26 23:15:35');
INSERT INTO `house_build` VALUES (2, 'B栋', 0, 2, 1, '2023-07-26 23:15:45', '2023-07-26 23:15:45');

-- ----------------------------
-- Table structure for house_list
-- ----------------------------
DROP TABLE IF EXISTS `house_list`;
CREATE TABLE `house_list`  (
  `house_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '房屋主键',
  `unit_id` int(0) NOT NULL COMMENT '单元外键',
  `house_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房屋编号',
  `house_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '房屋面积',
  `status` int(0) NULL DEFAULT 0 COMMENT '使用状态【0未使用，1使用】',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0删除1，未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`house_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '房屋表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_list
-- ----------------------------
INSERT INTO `house_list` VALUES (1, 1, 'A-101-1', '100', 1, 1, '2023-07-26 23:17:28', '2023-07-26 23:20:43');
INSERT INTO `house_list` VALUES (2, 2, 'A-102-1', '120', 1, 1, '2023-07-26 23:17:47', '2023-07-26 23:20:50');
INSERT INTO `house_list` VALUES (3, 3, 'B-101-1', '50', 1, 1, '2023-07-26 23:18:10', '2023-07-26 23:19:10');
INSERT INTO `house_list` VALUES (4, 4, 'B-102-1', '88', 0, 1, '2023-07-26 23:18:30', '2023-07-26 23:18:30');

-- ----------------------------
-- Table structure for house_unit
-- ----------------------------
DROP TABLE IF EXISTS `house_unit`;
CREATE TABLE `house_unit`  (
  `unit_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '单元主键',
  `build_id` int(0) NOT NULL COMMENT '楼栋id(外键)',
  `unit_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '单元名称',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序字段',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0删除】【1未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`unit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '单元表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of house_unit
-- ----------------------------
INSERT INTO `house_unit` VALUES (1, 1, 'A-101-单元', 1, 1, '2023-07-26 23:16:20', '2023-07-26 23:16:20');
INSERT INTO `house_unit` VALUES (2, 1, 'A-102-单元', 2, 1, '2023-07-26 23:16:34', '2023-07-26 23:16:34');
INSERT INTO `house_unit` VALUES (3, 2, 'B-101-单元', 1, 1, '2023-07-26 23:16:49', '2023-07-26 23:16:49');
INSERT INTO `house_unit` VALUES (4, 2, 'B-102-单元', 4, 1, '2023-07-26 23:17:06', '2023-07-26 23:17:06');

-- ----------------------------
-- Table structure for live_house
-- ----------------------------
DROP TABLE IF EXISTS `live_house`;
CREATE TABLE `live_house`  (
  `live_house_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '业主id',
  `house_id` int(0) NULL DEFAULT NULL COMMENT '房屋id',
  `use_status` int(0) NULL DEFAULT 1 COMMENT '使用状态【0退房】【1使用中】',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0删除】【1未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`live_house_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '业主房屋关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of live_house
-- ----------------------------
INSERT INTO `live_house` VALUES (1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `live_house` VALUES (2, 2, 2, 1, 1, NULL, NULL);
INSERT INTO `live_house` VALUES (3, 3, 3, 1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for live_role
-- ----------------------------
DROP TABLE IF EXISTS `live_role`;
CREATE TABLE `live_role`  (
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `user_id` int(0) NOT NULL COMMENT '业主id',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删【0删除】【1未删除】',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '业主角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of live_role
-- ----------------------------
INSERT INTO `live_role` VALUES (2, 1, 1, NULL, NULL);
INSERT INTO `live_role` VALUES (2, 2, 1, NULL, NULL);
INSERT INTO `live_role` VALUES (2, 3, 1, NULL, NULL);

-- ----------------------------
-- Table structure for live_user
-- ----------------------------
DROP TABLE IF EXISTS `live_user`;
CREATE TABLE `live_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `true_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别 0：女 1：男',
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `enabled` int(0) NULL DEFAULT 1 COMMENT '账号是否可用；0不可用，1可用',
  `account_non_locked` int(0) NULL DEFAULT 1 COMMENT '账户是否锁定;0锁定，1未锁定',
  `account_non_expired` int(0) NULL DEFAULT 1 COMMENT '账号是否过期;0过期，1未过期',
  `credentials_non_expired` int(0) NULL DEFAULT 1 COMMENT '密码是否过期;0过期，1未过期',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删字段；0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '业主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of live_user
-- ----------------------------
INSERT INTO `live_user` VALUES (1, '唐三', '138389438', 1, 'test1', '$2a$10$f5K8SZp8OZX1QOAuduzv..GxYNQQzX5z7NBjTRNeuaFyWYVTL7nRm', 1, 1, 1, 1, 1, '2023-07-26 22:40:06', '2023-07-26 23:23:23');
INSERT INTO `live_user` VALUES (2, '小舞', '12525333666', 0, 'test2', '$2a$10$f5K8SZp8OZX1QOAuduzv..GxYNQQzX5z7NBjTRNeuaFyWYVTL7nRm', 1, 1, 1, 1, 1, '2023-07-26 22:40:09', '2023-07-26 23:23:27');
INSERT INTO `live_user` VALUES (3, '奥斯卡', '13898111000', 1, 'test3', '$2a$10$p9wHxWYAXVnsQCzJIR/OhezadtV.Nsosqh4AjnYcaB7xmtqhuAAc.', 1, 1, 1, 1, 1, '2023-07-26 22:40:16', '2023-07-26 23:23:30');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(0) NOT NULL DEFAULT 0 COMMENT '父级菜单id;0顶级菜单',
  `module_label` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限码',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由名称',
  `path` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由地址',
  `url` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路由',
  `type` int(0) NULL DEFAULT 0 COMMENT '类名;0目录，1菜单，2按钮',
  `icon` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `order_num` int(0) NULL DEFAULT NULL COMMENT '排序字段',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `parent_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上级菜单名称',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删;0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '首页', 'wy:index', NULL, NULL, NULL, 0, 'el-icon-s-grid', 1, NULL, '顶级菜单', 1, '2023-07-26 22:44:46', '2023-07-26 22:44:46');
INSERT INTO `sys_menu` VALUES (2, 0, '系统管理', 'wy:system', NULL, NULL, NULL, 0, 'el-icon-setting', 2, NULL, '顶级菜单', 1, '2023-07-26 22:45:36', '2023-07-26 22:45:36');
INSERT INTO `sys_menu` VALUES (3, 0, '房屋管理', 'wy:house', NULL, NULL, NULL, 0, 'el-icon-s-home', 3, NULL, '顶级菜单', 1, '2023-07-26 22:46:51', '2023-07-26 22:46:51');
INSERT INTO `sys_menu` VALUES (4, 0, '业主管理', 'wy:live', NULL, NULL, NULL, 0, 'el-icon-s-custom', 4, NULL, '顶级菜单', 1, '2023-07-26 22:47:28', '2023-07-26 22:47:28');
INSERT INTO `sys_menu` VALUES (5, 0, '收费管理', 'wy:fee', NULL, NULL, NULL, 0, 'el-icon-shopping-bag-2', 5, NULL, '顶级菜单', 1, '2023-07-26 22:48:52', '2023-07-26 22:48:52');
INSERT INTO `sys_menu` VALUES (6, 0, '投诉管理', 'sys:complaint', NULL, NULL, NULL, 0, 'el-icon-reading', 6, NULL, '顶级菜单', 1, '2023-07-26 22:50:15', '2023-07-26 22:50:15');
INSERT INTO `sys_menu` VALUES (7, 0, '维修管理', 'sys:repair', NULL, NULL, NULL, 0, 'el-icon-s-tools', 7, NULL, '顶级菜单', 1, '2023-07-26 22:50:59', '2023-07-26 22:50:59');
INSERT INTO `sys_menu` VALUES (8, 1, '首页', 'wy:index:index', 'Welcome', '/welcome', '/welcome', 1, 'el-icon-s-home', 1, NULL, '首页', 1, '2023-07-26 22:53:33', '2023-07-26 22:53:47');
INSERT INTO `sys_menu` VALUES (9, 2, '用户管理', 'wy:system:user', 'SysUserList', '/user/list', '/user/list', 1, 'el-icon-user-solid', 1, NULL, '系统管理', 1, '2023-07-26 22:55:16', '2023-07-26 22:55:16');
INSERT INTO `sys_menu` VALUES (10, 2, '角色管理', 'wy:system:role', 'SysRoleList', '/role/list', '/role/list', 1, 'el-icon-s-help', 2, NULL, '系统管理', 1, '2023-07-26 22:56:30', '2023-07-26 22:56:30');
INSERT INTO `sys_menu` VALUES (11, 2, '菜单管理', 'wy:system:menu', 'SysMenuList', '/menu/list', '/menu/list', 1, 'el-icon-menu', 3, NULL, '系统管理', 1, '2023-07-26 22:59:36', '2023-07-26 22:59:36');
INSERT INTO `sys_menu` VALUES (12, 3, '楼栋管理', 'wy:house:build', 'HouseBuildList', '/build/list', '/build/list', 1, 'el-icon-s-data', 1, NULL, '房屋管理', 1, '2023-07-26 23:01:18', '2023-07-26 23:01:18');
INSERT INTO `sys_menu` VALUES (13, 3, '单元管理', 'wy:house:unit', 'HouseUnitList', '/unit/list', '/unit/list', 1, 'el-icon-s-grid', 2, NULL, '房屋管理', 1, '2023-07-26 23:02:21', '2023-07-26 23:02:21');
INSERT INTO `sys_menu` VALUES (14, 3, '房屋管理', 'wy:house:house', 'HouseList', '/house/list', '/house/list', 1, 'el-icon-s-home', 3, NULL, '房屋管理', 1, '2023-07-26 23:04:50', '2023-07-26 23:04:50');
INSERT INTO `sys_menu` VALUES (15, 4, '业主管理', 'wy:live:list', 'LiveUserList', '/liveUser/list', '/liveUser/list', 1, 'el-icon-s-custom', 1, NULL, '业主管理', 1, '2023-07-26 23:06:16', '2023-07-26 23:06:16');
INSERT INTO `sys_menu` VALUES (16, 5, '电费管理', 'wy:fee:power', 'FeePowerList', '/feePower/list', '/feePower/list', 1, 'el-icon-s-opportunity', 1, NULL, '收费管理', 1, '2023-07-26 23:07:24', '2023-07-26 23:07:32');
INSERT INTO `sys_menu` VALUES (17, 5, '水费管理', 'wy:fee:water', 'FeeWaterList', '/feeWater/list', '/feeWater/list', 1, 'el-icon-cold-drink', 2, NULL, '收费管理', 1, '2023-07-26 23:09:46', '2023-07-26 23:09:46');
INSERT INTO `sys_menu` VALUES (18, 6, '投诉列表', 'wy:complaint:list', 'UserComplaintList', '/complaint/list', '/complaint/list', 1, 'el-icon-box', 1, NULL, '投诉管理', 1, '2023-07-26 23:11:10', '2023-07-26 23:11:10');
INSERT INTO `sys_menu` VALUES (19, 6, '我的投诉', 'wy:complaint:mylist', 'MyUserComplaintList', '/complaint/myList', '/complaint/myList', 1, 'el-icon-notebook-1', 2, NULL, '投诉管理', 1, '2023-07-26 23:12:35', '2023-07-26 23:12:35');
INSERT INTO `sys_menu` VALUES (20, 7, '维修列表', 'wy:repair:list', 'UserRepairList', '/repair/list', '/repair/list', 1, 'el-icon-s-unfold', 1, NULL, '维修管理', 1, '2023-07-26 23:13:46', '2023-07-26 23:13:46');
INSERT INTO `sys_menu` VALUES (21, 7, '我的维修', 'wy:repair:mylist', 'MyRepairList', '/repair/myList', '/repair/myList', 1, 'el-icon-s-tools', 2, NULL, '维修管理', 1, '2023-07-26 23:14:59', '2023-07-26 23:14:59');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删字段;0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '拥有所有权限', 1, '2023-07-26 22:43:05', '2023-07-26 22:43:05');
INSERT INTO `sys_role` VALUES (2, '业主', '拥有投诉和报修权限', 1, '2023-07-26 22:43:33', '2023-07-26 22:43:33');
INSERT INTO `sys_role` VALUES (3, '物业', '拥有收费和房屋管理权限', 1, '2023-07-26 22:43:53', '2023-07-26 22:43:53');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `menu_id` int(0) NOT NULL COMMENT '菜单id',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删;0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色菜单中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 2, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 3, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 4, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 5, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 6, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 7, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 8, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 9, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 10, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 11, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 12, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 13, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 14, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 15, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 16, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 17, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 18, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 19, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 20, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (1, 21, 1, '2023-07-26 23:24:40', '2023-07-26 23:24:40');
INSERT INTO `sys_role_menu` VALUES (2, 1, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (2, 6, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (2, 7, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (2, 8, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (2, 19, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (2, 21, 1, '2023-07-26 23:25:08', '2023-07-26 23:25:08');
INSERT INTO `sys_role_menu` VALUES (3, 1, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 3, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 4, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 5, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 6, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 7, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 8, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 12, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 13, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 14, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 15, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 16, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 17, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 18, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');
INSERT INTO `sys_role_menu` VALUES (3, 20, 1, '2023-07-26 23:25:54', '2023-07-26 23:25:54');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `true_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` int(0) NULL DEFAULT NULL COMMENT '性别 0：女 1：男',
  `id_card` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `is_admin` int(0) NULL DEFAULT 0 COMMENT '是否是管理员 0：不是 1：是',
  `status` int(0) NULL DEFAULT 0 COMMENT '0：在职  1：离职',
  `username` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `enabled` int(0) NULL DEFAULT 1 COMMENT '账号是否可用；0不可用，1可用',
  `account_non_locked` int(0) NULL DEFAULT 1 COMMENT '账户是否锁定;0锁定，1未锁定',
  `account_non_expired` int(0) NULL DEFAULT 1 COMMENT '账号是否过期;0过期，1未过期',
  `credentials_non_expired` int(0) NULL DEFAULT 1 COMMENT '密码是否过期;0过期，1未过期',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删字段；0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '虚竹', '138389438', 1, '11022612129121', 1, 0, 'admin', '$2a$10$f5K8SZp8OZX1QOAuduzv..GxYNQQzX5z7NBjTRNeuaFyWYVTL7nRm', 1, 1, 1, 1, 1, '2023-07-19 00:42:33', '2023-07-25 12:10:10');
INSERT INTO `sys_user` VALUES (2, '乔峰', '13838111222', 1, '11022612121221', 0, 0, 'wy1', '$2a$10$f5K8SZp8OZX1QOAuduzv..GxYNQQzX5z7NBjTRNeuaFyWYVTL7nRm', 1, 1, 1, 1, 1, '2023-07-26 22:39:09', '2023-07-20 15:17:03');
INSERT INTO `sys_user` VALUES (3, '段誉', '19889555777', 1, '11021212124141', 0, 0, 'wy2', '$2a$10$f5K8SZp8OZX1QOAuduzv..GxYNQQzX5z7NBjTRNeuaFyWYVTL7nRm', 1, 1, 1, 1, 1, '2023-07-26 22:39:12', '2023-07-26 22:39:15');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `role_id` int(0) NOT NULL COMMENT '角色id',
  `deleted` int(0) NULL DEFAULT 1 COMMENT '假删字段;0删除，1未删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1, 1, '2023-07-26 23:26:29', '2023-07-26 23:26:29');
INSERT INTO `sys_user_role` VALUES (3, 3, 1, '2023-07-26 23:26:50', '2023-07-26 23:26:50');

SET FOREIGN_KEY_CHECKS = 1;
