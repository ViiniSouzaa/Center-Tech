CREATE DATABASE  IF NOT EXISTS `sistemainformatica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemainformatica`;
-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: sistemainformatica
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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `cpf` char(17) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES ('00000000000','TESTE CLIENTE','XXXXXX','123456789'),('12345678','Igor','XXXX','43a1245');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estoque`
--

DROP TABLE IF EXISTS `Estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estoque` (
  `id_Produto` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` varchar(45) NOT NULL,
  PRIMARY KEY (`id_Produto`),
  CONSTRAINT `fk_Estoque_1` FOREIGN KEY (`id_Produto`) REFERENCES `Produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estoque`
--

LOCK TABLES `Estoque` WRITE;
/*!40000 ALTER TABLE `Estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `Estoque_Produto`
--

DROP TABLE IF EXISTS `Estoque_Produto`;
/*!50001 DROP VIEW IF EXISTS `Estoque_Produto`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `Estoque_Produto` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `marca`,
 1 AS `preco`,
 1 AS `quantidade`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `cpf` char(17) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
INSERT INTO `Funcionario` VALUES ('0000000000','TESTE FUNCIONARIO','987654321','XXXXX');
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orcamento`
--

DROP TABLE IF EXISTS `Orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Orcamento` (
  `Cliente_cpf` char(17) DEFAULT NULL,
  `Funcionario_cpf` char(17) DEFAULT NULL,
  `Produto_id_Produto` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `quantidade_Produtos` int(11) NOT NULL,
  PRIMARY KEY (`Produto_id_Produto`,`id`),
  KEY `fk_Orcamento_Cliente_idx` (`Cliente_cpf`),
  KEY `fk_Orcamento_Produto1_idx` (`Produto_id_Produto`),
  KEY `fk_Orcamento_Funcionario_idx` (`Funcionario_cpf`),
  CONSTRAINT `fk_Orcamento_1` FOREIGN KEY (`Produto_id_Produto`) REFERENCES `Produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_Cliente` FOREIGN KEY (`Cliente_cpf`) REFERENCES `Cliente` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orcamento_Funcionario` FOREIGN KEY (`Funcionario_cpf`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orcamento`
--

LOCK TABLES `Orcamento` WRITE;
/*!40000 ALTER TABLE `Orcamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `Orcamento_Nomes`
--

DROP TABLE IF EXISTS `Orcamento_Nomes`;
/*!50001 DROP VIEW IF EXISTS `Orcamento_Nomes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `Orcamento_Nomes` AS SELECT 
 1 AS `id`,
 1 AS `Cliente`,
 1 AS `Funcionario`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Venda`
--

DROP TABLE IF EXISTS `Venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Venda` (
  `id_Produto` int(11) DEFAULT NULL,
  `Funcionario_cpf` char(17) DEFAULT NULL,
  `Cliente_cpf` char(17) NOT NULL,
  `quantidade_Produtos` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Cliente_cpf`),
  KEY `fk_Venda_Funcionario1_idx` (`Funcionario_cpf`),
  KEY `fk_Venda_Cliente1_idx` (`Cliente_cpf`),
  KEY `fk_Venda_1_idx` (`id_Produto`),
  CONSTRAINT `fk_Venda_1` FOREIGN KEY (`id_Produto`) REFERENCES `Produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Cliente1` FOREIGN KEY (`Cliente_cpf`) REFERENCES `Cliente` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Funcionario1` FOREIGN KEY (`Funcionario_cpf`) REFERENCES `Funcionario` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Venda`
--

LOCK TABLES `Venda` WRITE;
/*!40000 ALTER TABLE `Venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `Venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `Venda_Nomes`
--

DROP TABLE IF EXISTS `Venda_Nomes`;
/*!50001 DROP VIEW IF EXISTS `Venda_Nomes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `Venda_Nomes` AS SELECT 
 1 AS `id`,
 1 AS `Cliente`,
 1 AS `Funcionario`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `Estoque_Produto`
--

/*!50001 DROP VIEW IF EXISTS `Estoque_Produto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`vini`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `Estoque_Produto` AS select `Produto`.`id` AS `id`,`Produto`.`nome` AS `nome`,`Produto`.`marca` AS `marca`,`Produto`.`preco` AS `preco`,`Estoque`.`quantidade` AS `quantidade` from (`Produto` join `Estoque` on((`Produto`.`id` = `Estoque`.`id_Produto`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `Orcamento_Nomes`
--

/*!50001 DROP VIEW IF EXISTS `Orcamento_Nomes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`vini`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `Orcamento_Nomes` AS select `Orcamento`.`id` AS `id`,`c`.`nome` AS `Cliente`,`f`.`nome` AS `Funcionario` from ((`Orcamento` join `Cliente` `c` on((`Orcamento`.`Cliente_cpf` = `c`.`cpf`))) join `Funcionario` `f` on((`Orcamento`.`Funcionario_cpf` = `f`.`cpf`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `Venda_Nomes`
--

/*!50001 DROP VIEW IF EXISTS `Venda_Nomes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`vini`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `Venda_Nomes` AS select `Venda`.`id` AS `id`,`c`.`nome` AS `Cliente`,`f`.`nome` AS `Funcionario` from ((`Venda` join `Cliente` `c` on((`Venda`.`Cliente_cpf` = `c`.`cpf`))) join `Funcionario` `f` on((`Venda`.`Funcionario_cpf` = `f`.`cpf`))) */;
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

-- Dump completed on 2018-11-27 12:58:24
