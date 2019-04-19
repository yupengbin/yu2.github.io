/*
Navicat MySQL Data Transfer

Source Server         : 11
Source Server Version : 50715
Source Host           : localhost:3307
Source Database       : face

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2019-04-18 16:37:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentID` int(10) NOT NULL,
  `departmentName` varchar(50) NOT NULL,
  PRIMARY KEY (`departmentID`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`departmentID`) REFERENCES `major` (`departmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机科学与工程系');
INSERT INTO `department` VALUES ('2', '信息管理与软件系');
INSERT INTO `department` VALUES ('3', '外语系');

-- ----------------------------
-- Table structure for `laboratory`
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `labID` int(10) NOT NULL,
  `labName` varchar(50) NOT NULL,
  `teacherName` varchar(50) NOT NULL,
  PRIMARY KEY (`labID`),
  KEY `teacherName` (`teacherName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', '云计算实验室', '罗国涛');
INSERT INTO `laboratory` VALUES ('2', '人工智能实验室', '罗频捷');
INSERT INTO `laboratory` VALUES ('3', 'ISO实验室', '张小华');
INSERT INTO `laboratory` VALUES ('4', '虚拟现实实验室', '陈文飞');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `majorID` int(20) NOT NULL,
  `majorName` varchar(50) NOT NULL,
  `departmentID` int(10) NOT NULL,
  PRIMARY KEY (`majorID`),
  KEY `departmentID` (`departmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '计算机科学与技术', '1');
INSERT INTO `major` VALUES ('2', '软件工程', '2');
INSERT INTO `major` VALUES ('3', '物联网工程', '1');
INSERT INTO `major` VALUES ('4', '商务英语', '3');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` varchar(20) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `phoneNum` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL,
  `labID` int(10) NOT NULL,
  `major` int(20) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  KEY `labID` (`labID`),
  KEY `major` (`major`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`labID`) REFERENCES `laboratory` (`labID`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`major`) REFERENCES `major` (`majorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('16310121008', '余彭斌', '13678037335', '123456', '1', '1', null);
