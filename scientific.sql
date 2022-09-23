/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : scientific

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2022-01-25 17:27:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `about`
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about` (
  `id` int(11) NOT NULL,
  `about` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of about
-- ----------------------------
INSERT INTO `about` VALUES ('2', 'https://zhidao.baidu.com/question/131283312.html');
INSERT INTO `about` VALUES ('3', 'https://zhidao.baidu.com/question/1453954096384644940.html?fr=iks&word=%C2%DB%CE%C4%BC%AF%C4%DA%C8%DD&ie=gbk');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL auto_increment,
  `child1` varchar(255) NOT NULL,
  `child2` varchar(255) NOT NULL,
  `child3` varchar(255) NOT NULL,
  `child4` varchar(255) NOT NULL,
  `child5` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('2', '期刊论文', '计算机论文', '教育', '王俊凯', '2022年1月20日');
INSERT INTO `item` VALUES ('3', '会议论文集', '论文', '教育', '李伟', '2020-01');
INSERT INTO `item` VALUES ('4', '报纸', '论文', '学科', '作者', '2022年1月22日');
INSERT INTO `item` VALUES ('5', '学位论文', '武术研究', '武术', '李伟', '2022年1月22日');
INSERT INTO `item` VALUES ('6', '期刊论文', '计算机论文', '计算机', '作者', '2022年1月22日');
INSERT INTO `item` VALUES ('7', '会议论文集', '计算机论文', '计算机', '作者', '2022年1月22日');
INSERT INTO `item` VALUES ('8', '报纸', '计算机论文', '计算机', '作者', '2022年1月22日');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL auto_increment,
  `idcard` varchar(255) NOT NULL COMMENT '身份证',
  `username` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL COMMENT '学历',
  `education` varchar(255) NOT NULL COMMENT '学历',
  `birthday` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`,`idcard`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '513029199907281450', '王俊凯', '教授', '博士', '2018-01-31T16:00:00.000Z');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `iphone` varchar(255) NOT NULL,
  `idcards` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`,`iphone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '17628223627', '513029199907281450', '123');
