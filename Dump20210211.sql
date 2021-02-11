-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: browar_sarenka_recipes
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id_accounts` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(15) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id_accounts`),
  UNIQUE KEY `idaccounts_UNIQUE` (`id_accounts`),
  UNIQUE KEY `nick_UNIQUE` (`nick`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'JA','7110eda4d09e062aa5e4a390b0a572ac0d2c0220');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `dry_hopping_step_view`
--

DROP TABLE IF EXISTS `dry_hopping_step_view`;
/*!50001 DROP VIEW IF EXISTS `dry_hopping_step_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `dry_hopping_step_view` AS SELECT 
 1 AS `recipe_id`,
 1 AS `name`,
 1 AS `grams`,
 1 AS `days`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `dry_hopping_steps`
--

DROP TABLE IF EXISTS `dry_hopping_steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dry_hopping_steps` (
  `id_dry_hopping_steps` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL,
  `hop_id` int(11) NOT NULL,
  `grams` int(11) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_dry_hopping_steps`),
  KEY `recipe_id_dry_hopping_idx` (`recipe_id`),
  KEY `hop_id_dry_hopping_idx` (`hop_id`),
  CONSTRAINT `hop_id_dry_hopping` FOREIGN KEY (`hop_id`) REFERENCES `hops` (`id_hops`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recipe_id_dry_hopping` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id_recipes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dry_hopping_steps`
--

LOCK TABLES `dry_hopping_steps` WRITE;
/*!40000 ALTER TABLE `dry_hopping_steps` DISABLE KEYS */;
INSERT INTO `dry_hopping_steps` VALUES (1,7,3,50,7),(2,8,3,25,7),(3,8,4,25,7),(4,8,3,25,3),(5,8,4,25,3),(6,12,9,30,2),(7,12,9,30,1),(8,14,10,50,7);
/*!40000 ALTER TABLE `dry_hopping_steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `hopping_step_view`
--

DROP TABLE IF EXISTS `hopping_step_view`;
/*!50001 DROP VIEW IF EXISTS `hopping_step_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `hopping_step_view` AS SELECT 
 1 AS `recipe_id`,
 1 AS `name`,
 1 AS `grams`,
 1 AS `minutes`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `hopping_steps`
--

DROP TABLE IF EXISTS `hopping_steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopping_steps` (
  `id_hopping_steps` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL,
  `hop_id` int(11) NOT NULL,
  `grams` int(11) DEFAULT NULL,
  `minutes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_hopping_steps`),
  KEY `recipe_id_hopping_idx` (`recipe_id`),
  KEY `hop_id_hopping_idx` (`hop_id`),
  CONSTRAINT `hop_id_hopping` FOREIGN KEY (`hop_id`) REFERENCES `hops` (`id_hops`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recipe_id_hopping` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id_recipes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopping_steps`
--

LOCK TABLES `hopping_steps` WRITE;
/*!40000 ALTER TABLE `hopping_steps` DISABLE KEYS */;
INSERT INTO `hopping_steps` VALUES (1,7,3,20,60),(2,7,3,30,20),(3,7,3,20,0),(4,7,3,30,-5),(5,8,3,20,60),(6,8,3,30,20),(7,8,3,20,0),(8,8,3,30,-5),(9,9,5,35,60),(10,10,6,50,60),(11,11,7,50,60),(12,12,8,15,60),(13,12,8,20,15),(14,12,8,15,5),(15,14,10,10,60),(16,14,10,20,5),(17,14,10,20,0),(18,15,3,15,60),(19,15,11,15,60),(20,15,3,15,5),(21,15,11,15,5),(22,15,3,20,-5),(23,15,11,20,-5);
/*!40000 ALTER TABLE `hopping_steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hops`
--

DROP TABLE IF EXISTS `hops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hops` (
  `id_hops` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `alpha_acid` decimal(4,1) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_hops`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hops`
--

LOCK TABLES `hops` WRITE;
/*!40000 ALTER TABLE `hops` DISABLE KEYS */;
INSERT INTO `hops` VALUES (1,'Summit',15.8,'USA'),(2,'Northdown',7.9,'UK'),(3,'Sabro',15.0,'USA'),(4,'Enigma',16.5,'AUS'),(5,'Lubelski',4.0,'PL'),(6,'Marynka',8.8,'PL'),(7,'Iunga',11.0,'PL'),(8,'Simco',12.9,'USA'),(9,'Cashmere',8.8,'USA'),(10,'Southern Dawn',13.5,'RPA'),(11,'Mosaic',12.3,'USA'),(12,'Galaxy',13.6,'AUS');
/*!40000 ALTER TABLE `hops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `malts`
--

DROP TABLE IF EXISTS `malts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `malts` (
  `id_malts` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `ebc` int(11) DEFAULT NULL,
  `malthause` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_malts`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `malts`
--

LOCK TABLES `malts` WRITE;
/*!40000 ALTER TABLE `malts` DISABLE KEYS */;
INSERT INTO `malts` VALUES (1,'Pale Ale','podstawowy',6,'Strzegom VIking Malt'),(2,'Czekoladowy ciemny','palony',900,'Strzegom VIking Malt'),(3,'Palony Jęczmień','palony',1050,'Strzegom VIking Malt'),(4,'Wędzony Bukiem','wędzony',10,'Strzegom VIking Malt'),(5,'Pilzneński','podstawowy',4,'Strzegom VIking Malt'),(6,'Pszeniczny Jasny','pszeniczny',5,'Bestmalz'),(7,'Karmelowy','karmelowy',300,'Strzegom VIking Malt'),(8,'Żytni Czekoladowy','palony, żytni',650,'Thomas Fawcett'),(9,'Pszeniczny Wędzony Dębem','wędzony, pszeniczny',10,'Strzegom VIking Malt'),(10,'Wędzony Bukiem','wędzony',5,'Steinbach'),(11,'Pale Ale Viking Malt',NULL,NULL,NULL),(12,'Pale Ale Viking Malt','Jęczmienny',NULL,NULL);
/*!40000 ALTER TABLE `malts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `mash_step_view`
--

DROP TABLE IF EXISTS `mash_step_view`;
/*!50001 DROP VIEW IF EXISTS `mash_step_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mash_step_view` AS SELECT 
 1 AS `recipe_id`,
 1 AS `step_nr`,
 1 AS `temperature`,
 1 AS `minutes`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `mash_steps`
--

DROP TABLE IF EXISTS `mash_steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mash_steps` (
  `id_mash_steps` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL,
  `step_nr` tinyint(4) DEFAULT NULL,
  `temperature` tinyint(4) DEFAULT NULL,
  `minutes` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id_mash_steps`),
  KEY `recipe_id_idx` (`recipe_id`),
  CONSTRAINT `recipe_id_mash` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id_recipes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mash_steps`
--

LOCK TABLES `mash_steps` WRITE;
/*!40000 ALTER TABLE `mash_steps` DISABLE KEYS */;
INSERT INTO `mash_steps` VALUES (1,2,1,68,60),(2,3,1,67,70),(3,3,2,67,10),(4,3,3,78,5),(5,5,1,63,40),(6,5,2,72,20),(7,5,3,78,5),(8,7,1,63,40),(9,7,2,70,30),(10,7,3,78,5),(11,8,1,63,40),(12,8,2,70,20),(13,9,1,66,70),(14,9,2,78,5),(15,11,1,63,40),(16,11,2,70,30),(17,12,1,68,70),(18,12,2,72,10),(19,12,3,78,5),(20,14,1,66,40),(21,14,2,72,20),(22,15,1,63,40),(23,15,2,70,35),(24,15,3,78,5);
/*!40000 ALTER TABLE `mash_steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mashbill`
--

DROP TABLE IF EXISTS `mashbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mashbill` (
  `id_mashbill` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL,
  `malt_id` int(11) NOT NULL,
  `kilograms` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_mashbill`),
  KEY `recipe_id_mashbill_idx` (`recipe_id`),
  KEY `malt_id_mashbill_idx` (`malt_id`),
  CONSTRAINT `malt_id_mashbill` FOREIGN KEY (`malt_id`) REFERENCES `malts` (`id_malts`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recipe_id_mashbill` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id_recipes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mashbill`
--

LOCK TABLES `mashbill` WRITE;
/*!40000 ALTER TABLE `mashbill` DISABLE KEYS */;
INSERT INTO `mashbill` VALUES (1,2,1,2.80),(2,3,1,4.60),(3,3,2,0.40),(4,3,3,0.25),(5,5,4,2.00),(6,5,1,5.00),(7,7,1,6.00),(8,8,1,6.00),(9,9,5,2.70),(10,9,6,0.70),(11,9,7,0.10),(12,10,5,5.00),(13,11,1,3.00),(14,11,8,1.00),(15,11,9,1.00),(16,11,3,1.00),(17,11,10,2.00),(18,14,1,5.00),(19,14,6,1.00),(20,15,1,5.00),(21,15,6,1.00);
/*!40000 ALTER TABLE `mashbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `mashbill_view`
--

DROP TABLE IF EXISTS `mashbill_view`;
/*!50001 DROP VIEW IF EXISTS `mashbill_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `mashbill_view` AS SELECT 
 1 AS `recipe_id`,
 1 AS `name`,
 1 AS `kilograms`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id_recipes` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `style` varchar(45) DEFAULT NULL,
  `expected_volume` int(11) DEFAULT NULL,
  `blg_og` tinyint(4) DEFAULT NULL,
  `blg_fg` tinyint(4) DEFAULT NULL,
  `abv` decimal(4,2) DEFAULT NULL,
  `ibu` tinyint(4) DEFAULT NULL,
  `yeast_id` int(11) DEFAULT NULL,
  `yeast_add` tinyint(4) DEFAULT '20',
  `fermentation_specifications` varchar(200) DEFAULT NULL,
  `recipe_comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_recipes`),
  UNIQUE KEY `id_recipes_UNIQUE` (`id_recipes`),
  KEY `yeast_id_recipe_idx` (`yeast_id`),
  CONSTRAINT `yeast_id_recipe` FOREIGN KEY (`yeast_id`) REFERENCES `yeast` (`id_yeast`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Sarnie Żniwo','Ale',20,10,2,4.13,10,1,26,'temperatura pokojowa','poprawić chłodzenie'),(2,'3 Razy NIE','IPA',9,15,4,5.68,40,2,21,'temperatura garażowa','poprawić filtracje'),(3,'Gruzowe Mocne','Milk Stout',19,19,6,6.71,40,4,22,NULL,'poprawić dokumentacje, nie dać więcej kiełtowi wrzucić oleju do brzeczki'),(4,'Teatralna Próba S','IPA',NULL,NULL,NULL,NULL,120,4,20,NULL,'tak'),(5,'Technowiking','Sahti',19,18,4,7.22,0,3,26,'temperatura strychu 30+',NULL),(6,'pLato','Radler',14,7,-2,4.64,0,NULL,26,NULL,'kwaśne'),(7,'Magiczna Flet','Blu IPA',21,15,3,6.19,70,3,28,'temperatura pokojowa','wyszło fioletowe'),(8,'IPAnienko','IPA',20,NULL,NULL,NULL,70,3,20,NULL,'konkursowe, zbity balingomierz'),(9,'Kwaśne Tango','Sour',NULL,NULL,NULL,NULL,NULL,NULL,20,NULL,'grześ robił'),(10,'Lejowe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,20,NULL,'wyszedł niby belg'),(11,'Russian Imperial','Smoked RIS',22,19,4,7.74,NULL,3,24,'Dogrzewane butelkami z wodą',NULL),(12,'Drinknt Drive','American Stout',19,15,4,5.68,40,3,30,'sterownik, 30 stopni',NULL),(13,'Gruzowe 3','Stout',NULL,NULL,NULL,NULL,NULL,4,20,NULL,'bogata receptura, grześ robił'),(14,'Zebra','African APA',28,13,2,5.68,25,5,27,'sterownik 32','wyszło z fermentora, za małe wiadro'),(15,'Pawłowe','IPA',16,16,2,7.22,100,5,NULL,'sterownik 24,5',NULL);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yeast`
--

DROP TABLE IF EXISTS `yeast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yeast` (
  `id_yeast` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `min_temperature` int(11) DEFAULT NULL,
  `max_temperature` int(11) DEFAULT NULL,
  `max_alcohol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_yeast`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yeast`
--

LOCK TABLES `yeast` WRITE;
/*!40000 ALTER TABLE `yeast` DISABLE KEYS */;
INSERT INTO `yeast` VALUES (1,'kuaivahiva','tak',15,25,10),(2,'SafAle S-33','Ale',15,20,11),(3,'FM53 Voss','Kveik',20,40,10),(4,'SafAle US-05','Ale',15,22,11),(5,'OYL-090 Espe','Kveik',20,37,12);
/*!40000 ALTER TABLE `yeast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `dry_hopping_step_view`
--

/*!50001 DROP VIEW IF EXISTS `dry_hopping_step_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `dry_hopping_step_view` AS select `dry_hopping_steps`.`recipe_id` AS `recipe_id`,(select `hops`.`name` from `hops` where (`hops`.`id_hops` = `dry_hopping_steps`.`hop_id`)) AS `name`,`dry_hopping_steps`.`grams` AS `grams`,`dry_hopping_steps`.`days` AS `days` from `dry_hopping_steps` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `hopping_step_view`
--

/*!50001 DROP VIEW IF EXISTS `hopping_step_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `hopping_step_view` AS select `hopping_steps`.`recipe_id` AS `recipe_id`,(select `hops`.`name` from `hops` where (`hops`.`id_hops` = `hopping_steps`.`hop_id`)) AS `name`,`hopping_steps`.`grams` AS `grams`,`hopping_steps`.`minutes` AS `minutes` from `hopping_steps` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mash_step_view`
--

/*!50001 DROP VIEW IF EXISTS `mash_step_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mash_step_view` AS select `mash_steps`.`recipe_id` AS `recipe_id`,`mash_steps`.`step_nr` AS `step_nr`,`mash_steps`.`temperature` AS `temperature`,`mash_steps`.`minutes` AS `minutes` from `mash_steps` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `mashbill_view`
--

/*!50001 DROP VIEW IF EXISTS `mashbill_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `mashbill_view` AS select `mashbill`.`recipe_id` AS `recipe_id`,(select `malts`.`name` from `malts` where (`malts`.`id_malts` = `mashbill`.`malt_id`)) AS `name`,`mashbill`.`kilograms` AS `kilograms` from `mashbill` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-11 11:50:16
