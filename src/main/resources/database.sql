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

INSERT INTO `product` VALUES
	(1,'22','1111111','50', 'Risi'),
	(2,'33','2222222','50', 'Griki'),
	(3,'44','3333333','50', 'Lasis'),
	(4,'55','4444444','50', 'Cuka'),
	(5,'44','55555555','50', 'Vista');


CREATE TABLE `orderEntries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
  ADD FOREIGN KEY (order_id)
  ADD FOREIGN KEY (customer_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;