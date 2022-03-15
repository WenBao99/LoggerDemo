-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: mybatis_plus
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除',
  `version` int DEFAULT '1' COMMENT '乐观锁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `age`, `email`, `deleted`, `version`, `create_time`, `modified_time`) VALUES (1,'test2',18,'test1@baomidou.com',1,4,NULL,'2022-02-22 10:11:06'),(2,'Jack',20,'test2@baomidou.com',1,1,NULL,NULL),(3,'test2',28,'test3@baomidou.com',0,3,NULL,'2022-03-15 11:35:42'),(4,'Sandy',21,'test4@baomidou.com',0,1,NULL,NULL),(5,'Billie',24,'test5@baomidou.com',0,1,NULL,NULL),(6,'wenbao1_test',22,'wenbao1102@icloud.com',0,1,NULL,'2022-02-22 09:46:00'),(8,'wenzhuzhu',22,'wenbao1102@icloud.com',0,1,'2022-02-22 09:44:56',NULL),(9,'test2',22,'wenbao1102@icloud.com',0,1,'2022-02-22 09:47:54',NULL),(10,'test223',22,'wenbao1102@icloud.com',0,1,NULL,'2022-02-22 09:50:21'),(11,'test222',22,'wenbao1102@icloud.com',0,3,'2022-02-22 09:49:08','2022-02-22 10:15:16'),(12,'1111',11,'111@qq.com',0,1,'2022-02-24 10:10:18',NULL),(13,'222',22,'222@qq.com',0,1,'2022-02-24 10:15:04',NULL),(14,'1111',11,'111@qq.com',0,1,'2022-02-24 13:35:12',NULL),(15,'1111',21,'111@qq.com',0,1,'2022-02-24 17:52:51',NULL),(16,'WenBao',13,'wenbao1102@icloud.com',0,1,'2022-03-07 13:59:41',NULL),(17,'test',11,'123@qq.com',0,1,'2022-03-07 14:04:11',NULL),(18,'级我由已',15331431,'g.qatpjd@qq.com',0,1,'2022-03-15 00:00:00','2022-03-15 00:00:00');
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

-- Dump completed on 2022-03-15 13:45:48
