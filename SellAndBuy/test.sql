/*
Navicat MySQL Data Transfer

Source Server         : gc
Source Server Version : 50541
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2015-07-04 15:05:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for table_buyshop
-- ----------------------------
DROP TABLE IF EXISTS `table_buyshop`;
CREATE TABLE `table_buyshop` (
  `BuyID` varchar(20) NOT NULL,
  `GoodNum` varchar(20) DEFAULT NULL,
  `GoodName` varchar(20) DEFAULT NULL,
  `Price` float(255,0) DEFAULT NULL,
  `Number` int(255) DEFAULT NULL,
  `BusinessName` varchar(255) DEFAULT NULL,
  `GoodUnit` varchar(255) DEFAULT NULL,
  `BuyDate` date DEFAULT NULL,
  PRIMARY KEY (`BuyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_buyshop
-- ----------------------------
INSERT INTO `table_buyshop` VALUES ('BI1433048982999', '1001', '苹果', '5', '10', 'sut', '斤', '2015-05-31');
INSERT INTO `table_buyshop` VALUES ('BI1433051828680', '1002', '梨', '4', '10', '沈阳工业大学', '斤', '2015-05-31');
INSERT INTO `table_buyshop` VALUES ('BI1433051872229', '1003', '牙刷', '3', '100', '沈阳工业大学', '个', '2015-05-31');
INSERT INTO `table_buyshop` VALUES ('BI1433051894492', '1005', '洗衣粉', '3', '100', '沈阳工业大学', '袋', '2015-05-31');
INSERT INTO `table_buyshop` VALUES ('BI1433051913667', '1008', '手表', '120', '10', '沈阳工业大学', '个', '2015-05-31');
INSERT INTO `table_buyshop` VALUES ('BI1433493058753', '1001', '苹果', '5', '123', 'sut', '斤', '2015-06-05');
INSERT INTO `table_buyshop` VALUES ('BI1434515170837', '1001', '苹果', '5', '100', '沈阳工业大学', '斤', '2015-06-17');

-- ----------------------------
-- Table structure for table_sellshop
-- ----------------------------
DROP TABLE IF EXISTS `table_sellshop`;
CREATE TABLE `table_sellshop` (
  `SellID` varchar(20) NOT NULL,
  `GoodID` varchar(20) DEFAULT NULL,
  `GoodPrice` float(10,2) DEFAULT NULL,
  `Number` int(11) NOT NULL,
  `GoodUnit` varchar(255) DEFAULT NULL,
  `SellDate` date DEFAULT NULL,
  PRIMARY KEY (`SellID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_sellshop
-- ----------------------------
INSERT INTO `table_sellshop` VALUES ('XS1433049904534', '1001', '5.00', '1', '斤', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433049927182', '1002', '4.00', '1', '斤', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433049936130', '1003', '3.00', '1', '个', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433049957443', '1004', '5.00', '10', '盒', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433049989730', '1005', '3.00', '1', '袋', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433050004554', '1009', '2.00', '1', '袋', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433050020825', '1010', '2.00', '2', '盒', '2015-05-31');
INSERT INTO `table_sellshop` VALUES ('XS1433140924129', '1001', '5.00', '10', '个', '2015-06-01');
INSERT INTO `table_sellshop` VALUES ('XS1433290066802', '1004', '5.00', '2', '盒', '2015-06-03');
INSERT INTO `table_sellshop` VALUES ('XS1433290101975', '1003', '4.00', '5', '斤', '2015-06-03');
INSERT INTO `table_sellshop` VALUES ('XS1433290172826', '1002', '4.60', '5', '斤', '2015-06-03');
INSERT INTO `table_sellshop` VALUES ('XS1433943935224', '1003', '3.00', '2', '个', '2015-06-10');
INSERT INTO `table_sellshop` VALUES ('XS1433947689201', '1001', '5.00', '3', '斤', '2015-06-10');
INSERT INTO `table_sellshop` VALUES ('XS1434515031571', '1001', '5.00', '1', '斤', '2015-06-17');

-- ----------------------------
-- Table structure for table_shopinformation
-- ----------------------------
DROP TABLE IF EXISTS `table_shopinformation`;
CREATE TABLE `table_shopinformation` (
  `GoodID` varchar(20) NOT NULL,
  `GoodName` varchar(255) DEFAULT NULL,
  `GoodPrice` float(10,2) DEFAULT NULL,
  `GoodNum` int(11) DEFAULT NULL,
  `GoodUnit` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`GoodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_shopinformation
-- ----------------------------
INSERT INTO `table_shopinformation` VALUES ('1000', '矿泉水', '1.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1001', '苹果', '5.00', '219', '斤');
INSERT INTO `table_shopinformation` VALUES ('1002', '梨', '4.00', '104', '斤');
INSERT INTO `table_shopinformation` VALUES ('1003', '牙刷', '3.00', '700', '个');
INSERT INTO `table_shopinformation` VALUES ('1004', '雀巢咖啡', '1.00', '0', '袋');
INSERT INTO `table_shopinformation` VALUES ('1005', '洗衣粉', '3.00', '222', '个');
INSERT INTO `table_shopinformation` VALUES ('1006', '水杯', '10.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1007', '打火机', '2.00', '20', '个');
INSERT INTO `table_shopinformation` VALUES ('1008', '鼠标', '24.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1009', '清风纸巾', '5.00', '99', '个');
INSERT INTO `table_shopinformation` VALUES ('1010', '铅笔', '2.00', '98', '盒');
INSERT INTO `table_shopinformation` VALUES ('1011', '奥莉奥', '5.00', '240', '盒');
INSERT INTO `table_shopinformation` VALUES ('1012', '小当家方便面', '0.50', '0', '袋');
INSERT INTO `table_shopinformation` VALUES ('1013', '康师傅红烧牛肉面', '2.50', '0', '袋');
INSERT INTO `table_shopinformation` VALUES ('1014', '老碳酸菜方便面', '2.50', '0', '袋');
INSERT INTO `table_shopinformation` VALUES ('1015', '牙签', '4.00', '0', '盒');
INSERT INTO `table_shopinformation` VALUES ('1016', '键盘', '65.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1017', '台灯', '25.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1018', '洗发水', '25.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1019', '洗脸盆', '12.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1020', '蒙牛纯牛奶', '2.30', '0', '袋');
INSERT INTO `table_shopinformation` VALUES ('1021', ' 可口可乐', '3.00', '0', '个');
INSERT INTO `table_shopinformation` VALUES ('1022', '魔方', '10.00', '0', '个');
