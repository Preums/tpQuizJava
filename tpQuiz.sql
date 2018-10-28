-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tp_quiz
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `id_answer` int(11) NOT NULL AUTO_INCREMENT,
  `id_question` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `success` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_answer`),
  KEY `fk_id_question` (`id_question`),
  CONSTRAINT `fk_id_question` FOREIGN KEY (`id_question`) REFERENCES `questions` (`id_question`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,1,'oui',1),(2,1,'non',0),(3,1,'je ne suis pas sur',0),(4,1,'pas trop',0),(5,2,'oui',1),(6,2,'non',0),(7,2,'à crédit',0),(8,2,'je ne suis pas sur',0),(9,3,'le maximum air cargo hoverload',0),(10,3,'la masse au chargement',0),(11,3,'La vitesse du son',1),(12,3,'le minimum air cargo hoverload',0),(28,4,'Un événement prévisible, sinon c\'est une coïncidence',0),(29,4,'l\'ange entre la flèche de l\'aile et l\'axe du fuselage',0),(30,4,'l\'angle entre la corde et le vent relatif',1),(31,4,'l\'angle entre le vent météorologique et le vecteur vitesse',0),(32,5,'la dimension hors tout sur la somme des charges',0),(33,5,'la somme des charges sur la dimension hors tout',0),(34,5,'la somme des masses sur la somme des moments',0),(35,5,'La somme des moments sur la somme des masses',1),(36,6,'le rapport entre le poids apparent et le poids réel',1),(37,6,'un agent de la poste affecté à la manutention de l\'aéropostal',0),(38,6,'la poids du fret sur le centrage de l\'appareil',0),(39,6,'La répartition du chargement dans la soute',0),(50,7,'gyrochoptère',0),(51,7,'girocoptère',0),(52,7,'gyrocoptère',1),(53,7,'gyrochoptaire',0),(54,8,'re',0),(55,8,'oire',0),(56,8,'er',0),(57,8,'ir',0),(58,9,'vous eûtes été',0),(59,9,'que nous fussions',0),(60,9,'que nous eussions été',0),(61,9,'que nous soyons',1),(62,10,'or ni car',1),(63,10,'ornithorynque',0),(64,10,'hornitorinque',0),(65,10,'ornikar',0),(66,11,'HKS2O',0),(67,11,'HKSO3',1),(68,11,'H2SO',0),(69,11,'H2SO',0),(70,12,'Une réaction, au cours de laquelle on observe le transfert d\'un ou plusieurs électrons depuis un réducteur vers un oxydant',0),(71,12,'Une réaction dans laquelle un composé est scindé en espèces plus simples',0),(72,12,'Une réaction, dans laquelle un composé chimique subit une modification structurale sans modification de sa formule brute',0),(73,12,'une réaction, dans laquelle au moins un des intermédiaires réactionnels est un radical',0),(74,13,'Fe2O3',1),(75,13,'FeO',0),(76,13,'Fe3O4',0),(77,13,'FeO2',0),(78,14,'solvant',0),(79,14,'éluant',1),(80,14,'révélateur',0),(81,14,'séparateur',0);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dones_test`
--

DROP TABLE IF EXISTS `dones_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dones_test` (
  `id_dones_Tests` int(11) NOT NULL,
  `id_student` int(11) NOT NULL,
  `id_tests` int(11) NOT NULL,
  `id_questions` int(11) NOT NULL,
  `id_answers` int(11) NOT NULL,
  PRIMARY KEY (`id_dones_Tests`),
  KEY `fk_tests` (`id_tests`),
  KEY `fk_questions` (`id_questions`),
  KEY `fk_answers` (`id_answers`),
  KEY `fk_student` (`id_student`),
  CONSTRAINT `fk_answers` FOREIGN KEY (`id_answers`) REFERENCES `answers` (`id_answer`),
  CONSTRAINT `fk_questions` FOREIGN KEY (`id_questions`) REFERENCES `questions` (`id_question`),
  CONSTRAINT `fk_student` FOREIGN KEY (`id_student`) REFERENCES `students` (`id_student`),
  CONSTRAINT `fk_tests` FOREIGN KEY (`id_tests`) REFERENCES `tests` (`id_test`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dones_test`
--

LOCK TABLES `dones_test` WRITE;
/*!40000 ALTER TABLE `dones_test` DISABLE KEYS */;
/*!40000 ALTER TABLE `dones_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id_question` int(11) NOT NULL AUTO_INCREMENT,
  `id_test` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id_question`),
  KEY `fk_id_test` (`id_test`),
  CONSTRAINT `fk_id_test` FOREIGN KEY (`id_test`) REFERENCES `tests` (`id_test`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'Etes vous motivé?'),(2,1,'Pouvez vous payer votre formation?'),(3,2,'Qu\'est ce que le nombre de mach?'),(4,2,'Qu\'est que l\'incidence d\'un profil?'),(5,2,'Comment ce calcul le centrage?'),(6,2,'Qu\'est ce que le facteur de charge?'),(7,3,'Quel est la bonne orthographe?'),(8,3,'Comment  ce termine un verbe du deuxième groupe?'),(9,3,'Quel est le subjonctif présent?'),(10,3,'Mais où est donc?'),(11,4,'Quel est la formule chimique du bisulfite de potassium?'),(12,4,'Qu\'est ce que l\'isomérisation?'),(13,4,'Quel est la formule de la \"rouille\"?'),(14,4,'Lorsqu’on fait une chromatographie sur couche mince (CCM), la phase mobile\r\nentraînant les espèces à séparer est appelée');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `results` (
  `id_results` int(11) NOT NULL AUTO_INCREMENT,
  `id_test` int(11) NOT NULL,
  `id_student` int(11) NOT NULL,
  `result` int(11) NOT NULL,
  PRIMARY KEY (`id_results`),
  KEY `fk_student_id` (`id_student`),
  KEY `fk_test_id` (`id_test`),
  CONSTRAINT `fk_student_id` FOREIGN KEY (`id_student`) REFERENCES `students` (`id_student`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_test_id` FOREIGN KEY (`id_test`) REFERENCES `tests` (`id_test`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,1,1,100);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `admission_score` float NOT NULL,
  `graduate` tinyint(1) NOT NULL DEFAULT '0',
  `completed_courses` int(3) NOT NULL DEFAULT '0',
  `corrected_courses` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_student`),
  KEY `fk_id_users` (`id_user`),
  CONSTRAINT `fk_id_users` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,1,100,0,1,0);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tests` (
  `id_test` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `published` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
INSERT INTO `tests` VALUES (1,'Admission',1),(2,'Aéronautique',1),(3,'Français',1),(4,'Chimie',1),(5,'Hélicoptères',0),(6,'Javascript',0);
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `function` varchar(7) NOT NULL DEFAULT 'visitor',
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `Unique_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Loic','Francois','preums@gmx.com','password','student'),(2,'Mourad','Filali','mourad.filali@aston.com','superpassword','teacher'),(3,'aston','ecole','admin@aston.com','admin','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-28 23:49:26
