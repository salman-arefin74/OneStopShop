-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: one_stop_shop
-- ------------------------------------------------------
-- Server version	10.1.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `buys`
--

DROP TABLE IF EXISTS `buys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buys` (
  `customer_id` int(11) NOT NULL,
  `category_id` varchar(100) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `Price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`,`category_id`,`product_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `fk_buys` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buys`
--

LOCK TABLES `buys` WRITE;
/*!40000 ALTER TABLE `buys` DISABLE KEYS */;
INSERT INTO `buys` VALUES (58,'007','W03','Rolex Yacht Master',42000,1),(62,'004','T05','Bandarban',800,5),(79,'005','Ph02','One Plus 3T',45000,1),(81,'003','Pa03','Pasta Basta',289,2),(91,'006','Ta02','I Pad Pro',46000,1),(95,'002','P02','Bolognese Pizza',1100,2),(99,'001','B02','Chicken Supreme',320,4);
/*!40000 ALTER TABLE `buys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `Total_cost` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `payment` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,50000),(2,4000),(3,45000),(4,550),(5,46000),(6,2200),(7,1300);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_items` (
  `cart_id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`,`product_id`),
  CONSTRAINT `cart_items_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
INSERT INTO `cart_items` VALUES (1,'W03','Rolex Yacht Master',1,50000),(2,'T05','Bandarban',5,4000),(3,'Ph02','One Plus 3T',1,45000),(4,'Pa03','Pasta Basta',2,550),(5,'Ta02','I Pad Pro',1,46000),(6,'P02','Bolognese Pizza',2,2200),(7,'B02','Chicken Supreme',4,1300);
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` varchar(100) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('001','Burger'),('002','Pizza'),('003','Pasta'),('004','Tickets'),('005','Phones'),('006','Tablets'),('007','Watches');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `cart_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `payment_type` varchar(100) NOT NULL,
  `Amount` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`,`customer_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,58,'bKash',50000),(2,62,'bKash',4000),(3,79,'Paypal',45000),(4,81,'Credit Card',550),(5,91,'Credit Card',46000),(6,95,'Paypal',2200),(7,99,'bKash',1300);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `category_id` varchar(100) NOT NULL,
  `category_name` varchar(100) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `gadget_type` varchar(100) DEFAULT NULL,
  `gadget_details` varchar(200) DEFAULT NULL,
  `resturant` varchar(100) DEFAULT NULL,
  `shop` varchar(100) DEFAULT NULL,
  `Tickets` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('001','Burger','B01','Chicken Cheese Delight',220,NULL,NULL,'Takeout',NULL,NULL),('001','Burger','B02','Chicken Supreme',320,NULL,NULL,'Takeout',NULL,NULL),('001','Burger','B03','Cheezuzi',410,NULL,NULL,'Madchef',NULL,NULL),('001','Burger','B04','Smokin Chic',290,NULL,NULL,'Madchef',NULL,NULL),('001','Burger','B05','Mushroom Delight',300,NULL,NULL,'Chefs Cuisine',NULL,NULL),('002','Pizza','P01','Crown Crust Pizza',1300,NULL,NULL,'Pizza Hut',NULL,NULL),('002','Pizza','P02','Bolognese Pizza',1100,NULL,NULL,'Pizza Guy',NULL,NULL),('002','Pizza','P03','Chicken Fajita Pizza',1100,NULL,NULL,'Pizza Inn',NULL,NULL),('002','Pizza','P04','Grilled Chicken Pizza',1249,NULL,NULL,'Pizza Inn',NULL,NULL),('002','Pizza','P05','Express Special Pizza',1249,NULL,NULL,'Pizza Express',NULL,NULL),('003','Pasta','Pa01','Cheese Delight Pasta',345,NULL,NULL,'Pasta State',NULL,NULL),('003','Pasta','Pa02','Cream Pasta',245,NULL,NULL,'Pizza Square',NULL,NULL),('003','Pasta','Pa03','Pasta Basta',289,NULL,NULL,'Cafe Apeliano',NULL,NULL),('003','Pasta','Pa04','Chicken Cheese Pasta',420,NULL,NULL,'Al Fresco',NULL,NULL),('003','Pasta','Pa05','Regular Cheese Pasta',200,NULL,NULL,'Delicious Food Express',NULL,NULL),('004','Tickets','T01','Dhaka',500,NULL,NULL,NULL,NULL,'Bus'),('004','Tickets','T02','Chittagong',400,NULL,NULL,NULL,NULL,'Train'),('004','Tickets','T03','Coxs Bazar',700,NULL,NULL,NULL,NULL,'Bus'),('004','Tickets','T04','Sylhet',800,NULL,NULL,NULL,NULL,'Train'),('004','Tickets','T05','Bandarban',800,NULL,NULL,NULL,NULL,'Bus'),('005','Phones','Ph01','Samsung S8',50000,'Smart Phone','Android 7.0 Camera : 12MP Battery : 3000mAh',NULL,NULL,NULL),('005','Phones','Ph02','One Plus 3T',45000,'Smart Phone','Android 7.0 Camera : 15MP Battery : 2700mAh',NULL,NULL,NULL),('005','Phones','Ph03','LG G5',40000,'Smart Phone','Android 7.0 Camera : 13MP Battery : 3200mAh',NULL,NULL,NULL),('006','Tablets','Ta01','I Pad',50000,'Tablets','Apple A9 Camera : 8MP Display: 9.7 Inch',NULL,NULL,NULL),('006','Tablets','Ta02','I Pad Pro',46000,'Tablets','Apple A8 Camera : 12MP Display: 9.9 Inch',NULL,NULL,NULL),('006','Tablets','Ta03','Samsung Galaxy Tab S3',41000,'Tablets','4 Quad Speakers Camera : 15MP Display: 9.7 Inch',NULL,NULL,NULL),('007','Watches','W01','Cartier Rose Gold',50000,NULL,NULL,NULL,'Cartier',NULL),('007','Watches','W02','Patek Philippe',46000,NULL,NULL,NULL,'Phillips',NULL),('007','Watches','W03','Rolex Yacht Master',42000,NULL,NULL,NULL,'Rolex',NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `customer_id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `spot_id` int(11) NOT NULL,
  `spot_name` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`,`product_id`,`spot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (62,'T05',5,'Bandarban',5,4000);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS `travel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travel` (
  `spot_id` int(11) NOT NULL,
  `spot_name` varchar(100) NOT NULL,
  PRIMARY KEY (`spot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

LOCK TABLES `travel` WRITE;
/*!40000 ALTER TABLE `travel` DISABLE KEYS */;
INSERT INTO `travel` VALUES (1,'Dhaka'),(2,'Chittagong'),(3,'Coxs Bazar'),(4,'Sylhet'),(5,'Bandarban');
/*!40000 ALTER TABLE `travel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_type` varchar(100) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Customer',57,'Zuheb','zuheb57@gmail.com','258'),('Customer',58,'Alif','alif58@gmail.com','789'),('Customer',62,'Mashrur','mashrur62@gmail.com','147'),('Admin',74,'Salman','salman74@gmail.com','123'),('Admin',75,'Ayon','ayon75@gmail.com','456'),('Customer',79,'Arony','arony79@gmail.com','369'),('Customer',81,'Rizvi','rizvi81@gmail.com','753'),('Customer',89,'Rafa','rafa89@gmail.com','852'),('Customer',91,'Sami','sami91@gmail.com','159'),('Customer',95,'Shanta','shanta95@gmail.com','256'),('Customer',99,'Humayara','humayara99@gmail.com','796');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-06 22:17:45
