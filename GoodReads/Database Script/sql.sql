CREATE DATABASE  IF NOT EXISTS `goodreads` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `goodreads`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: goodreads
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `translator` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) NOT NULL,
  `published` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Kuyucaklı Yusuf','Sabahattin Ali',NULL,'Yapı Kredi Yayınları','Ocak 1999'),(2,'Kayıp Zamanın İzinde','Marcel Proust','Roza Hakmen','Yapı Kredi Yayınları','Haziran 2010'),(3,'İlahi Komedya','Dante Alighieri','Rekin Teksoy','Oğlak Yayıncılık','Kasım 2014'),(4,'Öteki','Fyodor Dostoyevsky','Ergin Altay','İletişim Yayınevi','Kasım 2014'),(5,'Arka Direkte Yalnız','Kaan Koç','','İthaki Yayınları','Temmuz 2019'),(6,'Don Quijote','Miguel de Cervantes Saavedra','Roza Hakmen','YKY','Nisan 1996');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readed_books`
--

DROP TABLE IF EXISTS `readed_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `readed_books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `book_id` int NOT NULL,
  `read_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rate` int NOT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `readed_year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `readed_books_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `readed_books_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `readed_books`
--

LOCK TABLES `readed_books` WRITE;
/*!40000 ALTER TABLE `readed_books` DISABLE KEYS */;
INSERT INTO `readed_books` VALUES (1,1,1,'2020-01-21 11:09:07',5,'Like it.','2017'),(2,1,3,'2020-01-23 04:08:58',5,'Great.','2018'),(3,1,2,'2020-01-23 10:37:43',1,'','2019'),(4,2,1,'2020-01-23 10:41:01',5,'','2019'),(5,4,1,'2020-01-23 10:43:20',2,'','2019'),(6,3,5,'2020-01-23 22:22:23',5,'Great.','2020'),(7,2,4,'2020-01-23 22:24:35',5,'Great.','2020');
/*!40000 ALTER TABLE `readed_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tckn` varchar(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tckn_UNIQUE` (`tckn`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'12345678901','Alptuğ','Yaman'),(2,'98765432109','Bülent','Özdil'),(3,'65432198701','Memduh','Er'),(4,'4569873215','Beste','Oğuz'),(5,'9867541238','Hande','Işık'),(6,'5789641328','Ali','Alper'),(7,'5789641318','Mustafa','Çimen'),(8,'5789641329','Ceyda','Eren'),(9,'9867545238','Metin','Ekinci');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'goodreads'
--

--
-- Dumping routines for database 'goodreads'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-23 22:33:17
