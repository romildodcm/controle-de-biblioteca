CREATE DATABASE  IF NOT EXISTS `dbLibrary` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dbLibrary`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: dbLibrary
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbBook`
--

DROP TABLE IF EXISTS `tbBook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbBook` (
  `tbBook_id` int NOT NULL AUTO_INCREMENT,
  `tbBook_name` varchar(300) NOT NULL,
  `tbBook_date` date DEFAULT NULL,
  `tbBook_author` varchar(250) DEFAULT NULL,
  `tbBook_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tbBook_id`),
  CONSTRAINT `chk_tbBook_status` CHECK ((`tbBook_status` in (1,2,3)))
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbBook`
--

LOCK TABLES `tbBook` WRITE;
/*!40000 ALTER TABLE `tbBook` DISABLE KEYS */;
INSERT INTO `tbBook` VALUES (1,'Clean Code: A Handbook of Agile Software Craftsmanship','2011-08-11','Robert C. Martin',2),(2,'Clean Code: A Handbook of Agile Software Craftsmanship','2011-08-11','Robert C. Martin',1),(3,'Clean Code: A Handbook of Agile Software Craftsmanship','2011-08-11','Robert C. Martin',3),(4,'Clean Code: A Handbook of Agile Software Craftsmanship','2011-08-11','Robert C. Martin',1),(5,'Clean Code: A Handbook of Agile Software Craftsmanship','2011-08-11','Robert C. Martin',2),(6,'Fluent Python: Clear, Concise, and Effective Programming','2022-04-10','Luciano Ramalho',2),(7,'Fluent Python: Clear, Concise, and Effective Programming','2022-04-10','Luciano Ramalho',2),(8,'Fluent Python: Clear, Concise, and Effective Programming','2022-04-10','Luciano Ramalho',1),(9,'Fluent Python: Clear, Concise, and Effective Programming','2022-04-10','Luciano Ramalho',3),(10,'Fluent Python: Clear, Concise, and Effective Programming','2022-04-10','Luciano Ramalho',1),(11,'IDA Pro Book','2011-06-07','Chris Eagle',1),(12,'IDA Pro Book','2011-06-07','Chris Eagle',2),(13,'Practical Binary Analysis','2018-12-11','Dennis Andriesse',1),(14,'Practical Binary Analysis','2018-12-11','Dennis Andriesse',1),(15,'Practical Binary Analysis','2018-12-11','Dennis Andriesse',1),(16,'Ching Liu Junzu full crack password','2013-11-01','Liu Jun Zu',2),(17,'Ching Liu Junzu full crack password','2013-11-01','Liu Jun Zu',2),(18,'Ching Liu Junzu full crack password','2013-11-01','Liu Jun Zu',1),(19,'The Hardware Hacking Handbook','2021-12-21','Jasper Van Woudenberg',1),(20,'The Hardware Hacking Handbook','2021-12-21','Jasper Van Woudenberg',2),(21,'The Hardware Hacking Handbook','2021-12-21','Jasper Van Woudenberg',1),(22,'The Hardware Hacking Handbook','2021-12-21','Jasper Van Woudenberg',2),(23,'Linux Basics for Hackers','2018-12-04','OccupyTheWeb',1),(24,'Linux Basics for Hackers','2018-12-04','OccupyTheWeb',2),(25,'Linux Basics for Hackers','2018-12-04','OccupyTheWeb',2),(26,'Linux Basics for Hackers','2018-12-04','OccupyTheWeb',1),(27,'Introdução à Linguagem SQL','2016-04-22','Thomas Nield',1),(28,'Introdução à Linguagem SQL','2016-04-22','Thomas Nield',1),(29,'Introdução à Linguagem SQL','2016-04-22','Thomas Nield',1),(30,'Introdução à Linguagem SQL','2016-04-22','Thomas Nield',1),(31,'Rootkits and Bootkits','2019-04-03','Alex Matrosov',1),(32,'Rootkits and Bootkits','2019-04-03','Alex Matrosov',2),(33,'Rootkits and Bootkits','2019-04-03','Alex Matrosov',1),(34,'Rootkits and Bootkits','2019-04-03','Alex Matrosov',1),(35,'Hacking the Xbox','2003-06-03','Andrew Huang',1),(36,'Hacking the Xbox','2003-06-03','Andrew Huang',1),(37,'Hacking the Xbox','2003-06-03','Andrew Huang',2),(38,'Hacking the Xbox','2003-06-03','Andrew Huang',1),(39,'Hacking the Xbox','2003-06-03','Andrew Huang',1),(40,'The Information','2011-03-01','James Gleick',2),(41,'The Information','2011-03-01','James Gleick',1),(42,'The Information','2011-03-01','James Gleick',1),(43,'The Information','2011-03-01','James Gleick',2),(44,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','2015-10-13','Clay Shirky',1),(45,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','2015-10-13','Clay Shirky',1),(46,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','2015-10-13','Clay Shirky',2),(47,'Little Rice: Smartphones, Xiaomi, and the Chinese Dream','2015-10-13','Clay Shirky',1),(48,'The Huawei Model','2020-11-02','Yun Wen',1),(49,'The Huawei Model','2020-11-02','Yun Wen',2),(50,'The Huawei Model','2020-11-02','Yun Wen',1);
/*!40000 ALTER TABLE `tbBook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbUser`
--

DROP TABLE IF EXISTS `tbUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbUser` (
  `tbUser_id` int NOT NULL AUTO_INCREMENT,
  `tbUser_name` varchar(250) NOT NULL,
  `tbUser_username` varchar(64) NOT NULL,
  `tbUser_password` varchar(64) NOT NULL,
  `tbUser_type` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tbUser_id`),
  UNIQUE KEY `unique_tbUser_username` (`tbUser_username`),
  KEY `idx_tbUser_username` (`tbUser_username`),
  CONSTRAINT `chk_tbUser_type` CHECK ((`tbUser_type` in (0,1)))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbUser`
--

LOCK TABLES `tbUser` WRITE;
/*!40000 ALTER TABLE `tbUser` DISABLE KEYS */;
INSERT INTO `tbUser` VALUES (1,'Administrador Teste 2','admin','test5@',0),(3,'Mateus','mateus','test@1',1),(4,'Romildo','romildo','romildo',0),(5,'Test','testetestetest','123456789',1),(6,'Outro Teste 6','test6','test5',1),(8,'Roger','rogerroger','rogerroger',1),(9,'huehuehue2','huehuehue','huehuehue',1);
/*!40000 ALTER TABLE `tbUser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16  2:38:54
