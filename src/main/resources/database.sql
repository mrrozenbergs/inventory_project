CREATE DATABASE  IF NOT EXISTS `inventory_directory`;
USE `inventory_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) DEFAULT NULL,
  `reg_no` varchar(45) DEFAULT NULL,
  `contacts` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `client` VALUES
	(1,'Maxima','1111111','info@maxima.lv'),
	(2,'Rimi','2222222','info@rimi.lv'),
	(3,'Mego','3333333','info@mego.lv'),
	(4,'Lats','4444444','info@lats.lv'),
	(5,'TOP','55555555','info@top.lv');


    DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `ean_number` varchar(45) DEFAULT NULL,
  `in_stock` int(11) DEFAULT NULL,
  `price` float(53) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;