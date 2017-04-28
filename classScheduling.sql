-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: classscheduling
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `classtime`
--

DROP TABLE IF EXISTS `classtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classtime` (
  `day` char(5) NOT NULL,
  `starting` time NOT NULL,
  `ending` time NOT NULL,
  `sectionID` char(5) NOT NULL,
  `location` char(10) NOT NULL,
  PRIMARY KEY (`day`,`sectionID`,`ending`,`starting`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classtime`
--

LOCK TABLES `classtime` WRITE;
/*!40000 ALTER TABLE `classtime` DISABLE KEYS */;
INSERT INTO `classtime` VALUES ('Fi','10:10:00','14:10:00','12863','3N 111'),('Fi','10:10:00','12:20:00','13085','4N 123'),('Fi','08:00:00','12:20:00','23444','1P 211'),('Mo','08:00:00','10:10:00','12324','3N 233'),('Mo','10:10:00','12:40:00','12325','3S 224'),('Mo','10:10:00','12:10:00','12334','1S 111'),('Mo','15:35:00','18:20:00','12343','1S 214'),('Mo','10:10:00','12:10:00','12349','2S 214'),('Mo','10:10:00','12:10:00','12601','2S 103'),('Mo','14:40:00','16:40:00','12800','2S 114'),('Mo','10:10:00','12:05:00','12801','5N 108'),('Mo','18:30:00','20:10:00','12803','5N 108'),('Mo','16:40:00','18:20:00','12811','1P 228'),('Mo','18:30:00','21:10:00','12819','5N 106'),('Mo','15:35:00','18:20:00','12830','1N 005'),('Mo','10:10:00','12:10:00','12860','1N 001'),('Mo','12:45:00','14:10:00','12890','5S 109'),('Mo','14:30:00','16:25:00','13085','4N 123'),('Mo','12:45:00','14:45:00','14038','5S 208'),('Mo','16:20:00','18:20:00','14056','4N 111'),('Mo','08:10:00','09:25:00','23412','3S 112'),('Mo','16:40:00','18:20:00','24905','2S 221'),('Mo','20:30:00','22:20:00','26032','3S 104'),('Mo','14:10:00','16:10:00','27172','3N 0001'),('Mo','08:00:00','10:00:00','27384','3N 102'),('Mo','20:45:00','21:35:00','77777','5N 001'),('Mo','08:00:00','10:00:00','80019','2N 123'),('Mo','10:10:00','12:00:00','80394','1P 105'),('Mo','12:10:00','14:00:00','81123','3N 0001'),('Mo','14:10:00','16:00:00','81231','1P 208'),('Mo','16:10:00','18:00:00','82012','1P 105'),('Mo','18:10:00','20:00:00','82038','4S 103'),('Mo','10:10:00','12:00:00','85241','3N 0001'),('Mo','16:10:00','18:00:00','87392','2N 001'),('Mo','14:10:00','16:00:00','89637','3S 001'),('Mo','12:10:00','14:00:00','92378','4N 111'),('Mo','08:00:00','10:00:00','95637','5N 218'),('Mo','16:20:00','18:20:00','98102','1P 123'),('Sa','12:00:00','16:00:00','08923','1A 001'),('Sa','10:10:00','14:10:00','12594','3S 143'),('Sa','10:10:00','12:10:00','12601','2S 103'),('Sa','12:20:00','14:15:00','24897','1S 114'),('Sa','08:00:00','10:00:00','87654','4N 111'),('Sa','10:30:00','12:30:00','87654','3S 001'),('Th','20:45:00','21:35:00','09273','2S 001'),('Th','20:30:00','22:00:00','10029','4S 103'),('Th','18:30:00','20:30:00','12342','3N 211'),('Th','10:10:00','12:10:00','12350','2S 214'),('Th','10:10:00','11:10:00','12491','3S 102'),('Th','14:40:00','16:40:00','12507','3S 001'),('Th','12:20:00','14:20:00','12593','3S 110'),('Th','10:10:00','11:00:00','12802','5N 108'),('Th','18:30:00','21:10:00','12826','2N 213'),('Th','12:20:00','14:20:00','12867','5N 123'),('Th','08:20:00','09:10:00','12869','1S 213'),('Th','08:10:00','10:00:00','12908','1P 105'),('Th','20:30:00','21:20:00','13088','5N 104'),('Th','18:30:00','19:20:00','13580','5N 108'),('Th','10:20:00','12:10:00','13811','3N 0001'),('Th','20:10:00','10:10:00','39326','4S 111'),('Th','12:20:00','14:15:00','49819','1N 114'),('Th','12:10:00','14:00:00','72637','2S 102'),('Th','20:10:00','22:00:00','82231','1P 105'),('Th','08:10:00','10:00:00','83920','4S 103'),('Th','12:10:00','14:00:00','86273','3N 0001'),('Th','14:10:00','16:00:00','86542','1P 208'),('Th','12:10:00','14:00:00','88192','1P 208'),('Th','14:10:00','16:00:00','89738','1P 208'),('Th','20:10:00','22:00:00','89912','3S 001'),('Th','10:10:00','12:00:00','98102','4S 103'),('Th','14:10:00','16:00:00','99283','4S 103'),('Tu','20:45:00','21:35:00','09273','2S 001'),('Tu','20:30:00','22:00:00','10029','4S 103'),('Tu','18:30:00','20:30:00','12342','3N 211'),('Tu','10:10:00','12:10:00','12350','2S 211'),('Tu','10:10:00','12:10:00','12491','3S 102'),('Tu','14:40:00','16:40:00','12507','3S 001'),('Tu','12:20:00','14:20:00','12593','3S 110'),('Tu','10:10:00','14:15:00','12609','1P 208'),('Tu','10:10:00','12:05:00','12802','1P 105'),('Tu','18:30:00','20:10:00','12826','2N 103'),('Tu','12:20:00','14:20:00','12867','5N 123'),('Tu','08:20:00','09:10:00','12869','1S 213'),('Tu','08:10:00','10:00:00','12908','1P 105'),('Tu','20:30:00','21:20:00','13088','5N 104'),('Tu','08:10:00','12:10:00','13407','2N 001'),('Tu','18:30:00','20:10:00','13580','5N 108'),('Tu','10:20:00','12:10:00','13811','4N 102'),('Tu','20:10:00','22:10:00','39326','4S 111'),('Tu','12:20:00','14:15:00','49819','1N 114'),('Tu','12:20:00','13:00:00','72637','2S 102'),('Tu','20:10:00','22:00:00','82231','2N 001'),('Tu','12:10:00','14:00:00','82718','3N 0001'),('Tu','08:10:00','10:00:00','82910','2N 123'),('Tu','12:10:00','14:00:00','86273','4N 111'),('Tu','14:10:00','16:00:00','86542','2N 001'),('Tu','12:10:00','14:00:00','88192','4S 103'),('Tu','14:10:00','16:00:00','89738','5N 218'),('Tu','20:10:00','22:00:00','89912','5N 218'),('Tu','10:10:00','12:00:00','98102','3S 001'),('Tu','14:10:00','16:00:00','99283','1P 208'),('We','08:00:00','10:10:00','12324','3N 233'),('We','10:10:00','12:10:00','12334','1S 111'),('We','15:35:00','18:20:00','12343','1S 214'),('We','10:10:00','12:10:00','12349','2S 214'),('We','14:40:00','16:40:00','12800','2S 114'),('We','10:10:00','11:00:00','12801','5N 106'),('We','18:30:00','19:20:00','12803','5N 106'),('We','16:40:00','17:20:00','12811','1P 228'),('We','18:30:00','21:10:00','12819','5N 106'),('We','15:35:00','18:20:00','12830','1N 005'),('We','10:10:00','12:10:00','12860','1N 003'),('We','12:45:00','14:10:00','12890','5S 109'),('We','12:45:00','14:45:00','14038','5S 208'),('We','16:20:00','18:20:00','14056','4N 111'),('We','08:10:00','09:25:00','23412','3S 112'),('We','12:20:00','14:15:00','24897','1S 114'),('We','16:40:00','17:20:00','24905','2S 221'),('We','20:30:00','21:20:00','26032','3S 104'),('We','14:10:00','16:10:00','27172','3N 0001'),('We','08:00:00','09:00:00','27384','3N 102'),('We','14:40:00','16:40:00','66666','5S 104'),('We','20:45:00','21:35:00','77777','5N 001'),('We','08:00:00','10:00:00','80019','5N 218'),('We','10:10:00','12:00:00','80394','2N 123'),('We','12:10:00','14:00:00','81123','5N 218'),('We','14:10:00','16:00:00','81231','5N 218'),('We','16:10:00','18:00:00','82012','2N 123'),('We','18:10:00','20:00:00','82038','3N 0001'),('We','10:10:00','12:00:00','85241','5N 218'),('We','16:10:00','18:00:00','87392','3N 0001'),('We','14:10:00','16:00:00','89637','4S 103'),('We','12:10:00','14:00:00','92378','1P 208'),('We','08:00:00','10:00:00','95637','4N 111'),('We','16:20:00','18:20:00','98102','1P 123');
/*!40000 ALTER TABLE `classtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentID` char(5) NOT NULL,
  `courseNumber` char(6) NOT NULL,
  `professorName` char(30) NOT NULL,
  `Date` char(15) NOT NULL,
  `content` varchar(50) NOT NULL,
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES ('10000','CSC115','Daniel Agman','2015-01-01',' Very Good, a lot of details.'),('10023','MTH229','Antonia Foldes','2014-02-03','Very Bad, don\'t take her class.'),('21938','CSC424','Zhangyang Zhang','2016-10-28','One of my favrite professor, and very nice. '),('23412','MTH233','Prabudh Misra','2013-09-10','Easy Class.'),('83284','MTH311','Antonia Foldes','2015-08-11','You will learn nothing.'),('83728','ENG111','Annie Gom','2013-9-29','Learn more about English.'),('83920','CSC126','Richard Weir','2015-12-02','Easy class and easy CSC life.'),('87283','ART130','David Loncle','2012-10-11','You will love the class.'),('93729','CHN405','Jean Tsu','2016-11-11','Top Chinese professor in CHN Department.');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseNumber` char(10) NOT NULL,
  `sectionID` char(10) NOT NULL,
  `professorName` char(30) NOT NULL,
  `unit` int(11) NOT NULL,
  `state` tinyint(4) NOT NULL,
  PRIMARY KEY (`sectionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('ENG111','08923','Annie Gom',3,1),('CSC119','09273','Staff',4,1),('ART100','10029','Anthony Conte',3,1),('MTH232','12324','Stephen Wollman',4,1),('MTH229','12325','Antonia Foldes',1,1),('MTH231','12334','Antonia Foldes',4,1),('MTH233','12342','Stephen Wollman',4,1),('MTH311','12343','Antonia Foldes',4,1),('MTH231','12349','Issam El-Achkar',4,1),('MTH232','12350','Anthony Conte',4,1),('CHN114','12491','Chao Li',4,1),('ITL114','12507','Alessandra Zavaglia',3,1),('ENG151','12594','Staff',4,1),('ENG151','12601','John Maerhofer',4,1),('ITL112','12800','Blerina Likollari',3,1),('CSC 115','12801','Staff',4,1),('CSC115','12802','Mendsaikhan Kapaj',4,1),('CSC115','12803','Daniel Agman',4,1),('ART100','12811','Staff',3,1),('CSC126','12819','Richard Weir',4,1),('CSC126','12826','Sandra Nevins',4,1),('CSC211','12830','XiaowenZhang',4,1),('CSC332','12860','Anatolly Gordonov',4,1),('CSC347','12863','Shuqun Zhang',1,1),('CSC446','12867','Xiaoke Shen',4,1),('CSC446','12869','Shuqun Zhang',4,1),('ART130','12890','David Loncle',4,1),('ART480','12908','Chris Verene',4,1),('PHY116','13085','Anshel Gorokhovsky',3,1),('PHY120','13088','William Schreiber',3,1),('CSC347','13407','Shuqun Zhang',1,0),('CSC119','13580','Luigi Kapaj',4,1),('MTH233','13811','Prabudh Misra',4,1),('CHN112','14038','Niu Bi',4,1),('PHY116','14056','Staff',3,1),('ENG111','23444','Staff',3,1),('CHN405','24897','Jean Tsu',4,1),('CHN112','24905','Ping Shi',4,1),('ENG710','26032','Sohomjit Ray',4,1),('CSC332','27172','Staff',4,1),('MTH229','27384','Staff',1,1),('ITL471','39326','Chiara Ferrari',4,1),('CSC424','49819','Zhangyang Zhang',4,1),('CSC490','66666','Deborah Sturm',4,1),('CSC126','72637','Zhangyang Zhang',4,1),('CSC490','77777','Zhangyang Zhang',4,1),('ENG111','80019','Annie Gom',3,1),('ART100','80394','Chris Verene',3,1),('MTH232','81123','Staff',4,1),('MTH231','81231','Staff',4,1),('MTH231','82012','Antonia Foldes',4,1),('MTH231','82038','Antonia Foldes',4,1),('ENG111','82231','Annie Gom',3,1),('CSC221','82718','Daniel Agman',4,1),('MTH229','82910','Antonia Foldes',1,1),('MTH229','83920','Staff',1,1),('CHN114','85241','Jean Tsu',4,1),('CHN114','86273','Jean Tsu',4,1),('ART100','86542','David Loncle',3,1),('CSC221','87392','Daniel Agman',4,1),('ART100','87654','David Loncle',3,1),('MTH232','88192','Staff',4,1),('CHN114','89637','Jean Tsu',4,1),('CSC126','89738','Zhangyang Zhang',4,1),('ENG111','89912','Annie Gom',3,1),('PHY120','92378','William Schreiber',3,1),('CSC126','95637','Zhangyang Zhang',4,1),('ENG710','98102','Anshel Gorokhovsky',3,1),('PHY120','99283','William Schreiber',3,1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorited`
--

DROP TABLE IF EXISTS `favorited`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorited` (
  `sectionID` char(5) NOT NULL,
  `userID` char(10) NOT NULL,
  PRIMARY KEY (`sectionID`,`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorited`
--

LOCK TABLES `favorited` WRITE;
/*!40000 ALTER TABLE `favorited` DISABLE KEYS */;
INSERT INTO `favorited` VALUES ('12802','00002'),('12803','00002'),('12811','00002'),('12819','00002'),('12826','00003'),('12863','00003'),('12867','00003'),('12890','00003'),('13811','00001'),('24905','00001'),('49819','00001'),('66666','00001');
/*!40000 ALTER TABLE `favorited` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `professorID` char(10) NOT NULL,
  `professorName` char(30) NOT NULL,
  `department` char(20) NOT NULL,
  PRIMARY KEY (`professorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('01823988','John Maerhofer','ENG'),('08755644','David Loncle','ART'),('09876293','William Schreiber','PHY'),('10927468','Sohomjit Ray','ENG'),('13426790','Daniel Agman','CSC'),('20908283','Sandra Nevins','CSC'),('23679800','Luigi Kapaj','CSC'),('23847203','Zhangyang Zhang','CSC'),('23897428','Richard Weir','CSC'),('24565445','Blerina Likollari','ITL'),('32343782','Ping Shi','CHN'),('32435756','Alessandra Zavaglia','ITL'),('34564356','Jean Tsu','CHN'),('35468657','Anatolly Gordonov','CSC'),('35764455','Anthony Conte','MTH'),('35786545','Chris Verene','ART'),('67845564','Chao Li','CHN'),('67866734','Chiara Ferrari','ITL'),('72837019','Shuqun Zhang','CSC'),('76198273','Xiaoke Shen','CSC'),('78363456','Antonia Foldes','MTH'),('79128379','Prabudh Misra','MTH'),('86453454','Deborah Sturm','ART'),('86464646','Anshel Gorokhovsky','MTH'),('87238424','Mendsaikhan Kapaj','CSC'),('89729301','XiaowenZhang','CSC'),('92038293','Annie Gom','ENG');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` char(10) NOT NULL,
  `name` char(30) NOT NULL,
  `passwords` varchar(20) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('00001','Quintus','Lin00001'),('00002','Yingfa','He00002'),('00003','Liang','Li00003'),('00004','Weiming','Zhu00005'),('00005','Kai','Liu00005'),('00006','Zha','Xue00006'),('00007','Ba','Xue00007'),('00008','Sheng','Da00008'),('00009','Biubiu','Biu00009'),('00010','NiuNiu','Niu00010');
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

-- Dump completed on 2016-12-05  9:55:36
