/*
Navicat MySQL Data Transfer

Source Server         : localmysqlserver
Source Server Version : 50624
Source Host           : 172.7.4.58:3306
Source Database       : emall

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-08-26 19:59:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `price` bigint(10) DEFAULT NULL COMMENT '价格',
  `location` varchar(500) DEFAULT NULL COMMENT '商品所在地址',
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `is_physical_store` bit(1) NOT NULL DEFAULT b'0' COMMENT '是不是实体店',
  `store_name` varchar(255) DEFAULT NULL COMMENT '店铺名称',
  `store_location` varchar(255) DEFAULT NULL COMMENT '店铺地址',
  `is_delivery_door` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否送货上门',
  `is_used_goods` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是二手商品',
  `is_changed_eachother` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否支持以物换物',
  `is_hot` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否是热卖商品',
  `popularity_index` bigint(20) NOT NULL DEFAULT '0' COMMENT '人气指数',
  `status` int(3) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
