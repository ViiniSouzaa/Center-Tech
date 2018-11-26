CREATE DATABASE  IF NOT EXISTS `sistemainformatica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `sistemainformatica`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemainformatica
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `nota_fiscal`
--

DROP TABLE IF EXISTS `nota_fiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nota_fiscal` (
  `id` int(11) NOT NULL,
  `cpfCliente` varchar(45) DEFAULT NULL,
  `cpfFuncionario` varchar(45) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quant` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nota_fiscal_ibfk_1` (`cpfCliente`),
  KEY `nota_fiscal_ibfk_2` (`cpfFuncionario`),
  KEY `nota_fiscal_ibfk_3` (`idProduto`),
  CONSTRAINT `nota_fiscal_ibfk_1` FOREIGN KEY (`cpfCliente`) REFERENCES `pessoa` (`cpf`),
  CONSTRAINT `nota_fiscal_ibfk_2` FOREIGN KEY (`cpfFuncionario`) REFERENCES `pessoa` (`cpf`),
  CONSTRAINT `nota_fiscal_ibfk_3` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_fiscal`
--

LOCK TABLES `nota_fiscal` WRITE;
/*!40000 ALTER TABLE `nota_fiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_fiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pessoa` (
  `cpf` char(15) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `telefone` char(13) NOT NULL,
  `funcionario` tinyint(4) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `quant` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-13 21:42:28
