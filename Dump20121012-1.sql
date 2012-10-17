CREATE DATABASE  IF NOT EXISTS `imprenta` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `imprenta`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: imprenta
-- ------------------------------------------------------
-- Server version	5.5.19

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
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `razonsocial` varchar(45) DEFAULT NULL,
  `cuit` varchar(13) DEFAULT '99-99999999-9',
  `idIva` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  ` nombreContacto` varchar(45) DEFAULT NULL,
  `telefonoContacto` varchar(45) DEFAULT NULL,
  `mailContacto` varchar(45) DEFAULT NULL,
  `direccionRetiro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `idIva` (`idIva`),
  CONSTRAINT `idIva` FOREIGN KEY (`idIva`) REFERENCES `iva` (`idiva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Pepe Hermanos','cuitxxx',1,'direccion','telefono',' mail',' nombreContacto',' telefonoContacto',' mailContacto',' direccionRetiro'),(2,'Imprenta db2','cuityyxxx',2,'direccionnnnnnnnnn','telefonosss',' mails',' nombreContactossss',' telefonoContactossss',' mailContactosss',' direccionRetirossssss'),(1000,'CMYK','xxxxxx',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iva`
--

DROP TABLE IF EXISTS `iva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iva` (
  `idiva` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ivaInscripto` double DEFAULT NULL,
  `ivaNoInscripto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idiva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iva`
--

LOCK TABLES `iva` WRITE;
/*!40000 ALTER TABLE `iva` DISABLE KEYS */;
INSERT INTO `iva` VALUES (1,'21',21,'xx'),(2,'11',11,'xy'),(3,'iva modificado',440.01,'es un varchar');
/*!40000 ALTER TABLE `iva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiaprimadelaot`
--

DROP TABLE IF EXISTS `materiaprimadelaot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiaprimadelaot` (
  `NroOrdenTrabajo` int(11) NOT NULL,
  `NroDeProducto` int(11) NOT NULL,
  `NroDeElemento` int(11) NOT NULL,
  `MarcaDescripcion` varchar(45) NOT NULL DEFAULT 'marca',
  `CalidadDescripcion` varchar(45) NOT NULL DEFAULT 'calidad',
  `VarianteDescripcion` varchar(45) NOT NULL DEFAULT 'variante',
  `FormatoDescripcion` varchar(45) CHARACTER SET big5 NOT NULL DEFAULT 'formato',
  `posesXpliego` int(11) DEFAULT NULL,
  `pliegosnetos` int(11) DEFAULT NULL,
  `pliegosEnDemasia` int(11) DEFAULT NULL,
  `pliegosXhoja` int(11) DEFAULT NULL,
  `hojas` int(11) DEFAULT NULL,
  `gramaje` int(11) DEFAULT NULL,
  `CantidadXunidadTrabajo` int(11) DEFAULT NULL,
  PRIMARY KEY (`NroOrdenTrabajo`,`NroDeProducto`,`NroDeElemento`,`MarcaDescripcion`,`CalidadDescripcion`,`VarianteDescripcion`,`FormatoDescripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiaprimadelaot`
--

LOCK TABLES `materiaprimadelaot` WRITE;
/*!40000 ALTER TABLE `materiaprimadelaot` DISABLE KEYS */;
INSERT INTO `materiaprimadelaot` VALUES (1,1,1,'Definir','Ilustracion','Brillante','45X64',12,NULL,23,23,NULL,50,500),(1,1,2,'Definir','Autoadhesivo','Transparente','45X64',12,NULL,23,23,NULL,50,2),(2,1,1,'Definir','Ilustracion','Brillante','45X64',12,NULL,12,12,NULL,12,12),(3,1,1,'Definir','Ilustracion','Brillante','45X64',123,NULL,123,123,NULL,123,23),(5,2,3,'Definir','Ilustracion','Brillante','45X64',1,231,1,1,3,1,1),(5,2,5,'Definir','Ilustracion','Brillante','45X64',1,2,1,1,3,1,1),(6,1,1,'Definir','Ilustracion','Brillante','45X64',23,NULL,23,23,NULL,23,3),(6,1,2,'Definir','Ilustracion','Brillante','45X64',23,NULL,23,23,NULL,23,3),(7,1,1,'Definir','Ilustracion','Brillante','45X64',4,5,4,4,6,4,4),(7,1,2,'Definir','Ilustracion','Brillante','45X64',4,6,4,4,6,4,4),(8,1,1,'Definir','Ilustracion','Brillante','45X64',2,2,2,2,3,2,2),(8,1,2,'Definir','Ilustracion','Brillante','45X64',2,2,2,2,6,2,2),(9,1,1,'Definir','Ilustracion','Brillante','45X64',5,5,5,5,5,5,5);
/*!40000 ALTER TABLE `materiaprimadelaot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `idMateriales` int(11) NOT NULL AUTO_INCREMENT,
  `OrdenTrabajo` int(11) DEFAULT NULL,
  `idPapel` int(11) DEFAULT NULL,
  `poseXpliego` int(11) DEFAULT NULL,
  `plegosNetos` int(11) DEFAULT NULL,
  `pliegosDemasia` int(11) DEFAULT NULL,
  `pliegosXhoja` int(11) DEFAULT NULL,
  `cantHojas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMateriales`),
  KEY `fk_ot` (`OrdenTrabajo`),
  CONSTRAINT `fk_ot` FOREIGN KEY (`OrdenTrabajo`) REFERENCES `ordentrabajo` (`NroOrden`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variante`
--

DROP TABLE IF EXISTS `variante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variante` (
  `idvariante` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idvariante`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variante`
--

LOCK TABLES `variante` WRITE;
/*!40000 ALTER TABLE `variante` DISABLE KEYS */;
INSERT INTO `variante` VALUES (4,'Brillante'),(5,'Transparente'),(6,'Mate'),(7,'SemiMate'),(8,'Blanco'),(9,'Amarillo'),(10,'Rosa'),(11,'Verde'),(12,'Celeste'),(13,'Blanca/Blanca'),(14,'Blanca/Kraft');
/*!40000 ALTER TABLE `variante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea_has_proveedor`
--

DROP TABLE IF EXISTS `tarea_has_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarea_has_proveedor` (
  `idProveedor` int(11) NOT NULL DEFAULT '0',
  `idTarea` int(11) NOT NULL DEFAULT '0',
  `precioDeLaTarea` double DEFAULT NULL,
  PRIMARY KEY (`idProveedor`,`idTarea`),
  KEY `fk_Tarea_has_Proveedor_Proveedor1` (`idProveedor`),
  KEY `tarea` (`idTarea`),
  KEY `proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea_has_proveedor`
--

LOCK TABLES `tarea_has_proveedor` WRITE;
/*!40000 ALTER TABLE `tarea_has_proveedor` DISABLE KEYS */;
INSERT INTO `tarea_has_proveedor` VALUES (1,3,200),(2,1,23.4);
/*!40000 ALTER TABLE `tarea_has_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calidad`
--

DROP TABLE IF EXISTS `calidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calidad` (
  `idCalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calidad`
--

LOCK TABLES `calidad` WRITE;
/*!40000 ALTER TABLE `calidad` DISABLE KEYS */;
INSERT INTO `calidad` VALUES (2,'Ilustracion'),(3,'Obra'),(4,'Autoadhesivo'),(5,'Autoadhesivo Obra'),(6,'Autoadhesivo PVC'),(7,'Autoadhesivo OPP'),(8,'Cartulina'),(9,'Encapada'),(10,'Cartón'),(11,'Pvc'),(12,'Opp'),(13,'Especial'),(14,'Comercial color'),(15,'Quimico CB 1era'),(16,'Quimico CFB 2da'),(17,'Quimico CF 3ra'),(18,'Opalina'),(1000,'prueba');
/*!40000 ALTER TABLE `calidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidencias`
--

DROP TABLE IF EXISTS `incidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidencias` (
  `idIncidencias` int(11) NOT NULL AUTO_INCREMENT,
  `idSolicitudCompra` int(11) DEFAULT NULL,
  `IdPapel` int(11) DEFAULT NULL,
  `Descripcion` varchar(3) DEFAULT 'ARI',
  PRIMARY KEY (`idIncidencias`),
  KEY `idSolicitudCompra` (`idSolicitudCompra`),
  CONSTRAINT `idSolicitudCompra` FOREIGN KEY (`idSolicitudCompra`) REFERENCES `solicitudcompra` (`idsolicitudCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencias`
--

LOCK TABLES `incidencias` WRITE;
/*!40000 ALTER TABLE `incidencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarea` (
  `idTarea` int(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) DEFAULT NULL,
  `tiempoEstimado` time DEFAULT NULL,
  PRIMARY KEY (`idTarea`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` VALUES (1,'Barnizado','01:00:00'),(2,'Plegadito','00:11:00'),(3,'plegadon','00:20:30');
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcapapel`
--

DROP TABLE IF EXISTS `marcapapel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcapapel` (
  `idMarcaPapel` int(11) NOT NULL AUTO_INCREMENT,
  `Marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMarcaPapel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcapapel`
--

LOCK TABLES `marcapapel` WRITE;
/*!40000 ALTER TABLE `marcapapel` DISABLE KEYS */;
INSERT INTO `marcapapel` VALUES (2,'papelucho');
/*!40000 ALTER TABLE `marcapapel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementosproducto`
--

DROP TABLE IF EXISTS `elementosproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementosproducto` (
  `idTipoProducto` int(11) NOT NULL COMMENT 'Es la relacion que hay entre un producto y esta tabla, por ejemplo una revista tiene hojas.',
  `descripcion` varchar(45) NOT NULL,
  `cantidadXunidad` int(11) DEFAULT NULL,
  `unidadDeMedida` varchar(45) DEFAULT NULL,
  `idElementoDelProducto` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Es el identificador único, de éste tipo de producto, no hay dos elementos páginas.',
  PRIMARY KEY (`idTipoProducto`,`descripcion`),
  UNIQUE KEY `idElementoDelProducto_UNIQUE` (`idElementoDelProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementosproducto`
--

LOCK TABLES `elementosproducto` WRITE;
/*!40000 ALTER TABLE `elementosproducto` DISABLE KEYS */;
INSERT INTO `elementosproducto` VALUES (1,'Paginas',950,'KG',1),(1,'Tapa',1000,'KG',2),(2,'Duplicado',3,'UNIDAD',3),(2,'Original',800,'KG',4),(2,'Triplicado',4,'RESMA',5);
/*!40000 ALTER TABLE `elementosproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insumosutilizados`
--

DROP TABLE IF EXISTS `insumosutilizados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumosutilizados` (
  `idinsumosutilizados` int(11) NOT NULL,
  `idOrdTrabajo` int(11) DEFAULT NULL,
  `idPapel` int(11) DEFAULT NULL,
  `idPartida` int(11) DEFAULT NULL,
  `cantidadUtilizada` int(11) DEFAULT NULL,
  `idSolicitudCompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinsumosutilizados`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumosutilizados`
--

LOCK TABLES `insumosutilizados` WRITE;
/*!40000 ALTER TABLE `insumosutilizados` DISABLE KEYS */;
/*!40000 ALTER TABLE `insumosutilizados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordentrabajo`
--

DROP TABLE IF EXISTS `ordentrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordentrabajo` (
  `NroOrden` int(11) NOT NULL AUTO_INCREMENT,
  `Cliente` varchar(45) DEFAULT NULL,
  `FechaEntrPautada` date DEFAULT NULL,
  `Descripcion` varchar(800) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT 'ABIERTO',
  `EsApaisado` varchar(45) DEFAULT NULL,
  `Producto` varchar(45) DEFAULT NULL,
  `FechaConfeccion` date DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Ancho` int(11) DEFAULT NULL,
  `Alto` int(11) DEFAULT NULL,
  `CantidadAEntregar` int(11) DEFAULT NULL,
  `CantPlanchas` int(11) DEFAULT NULL,
  PRIMARY KEY (`NroOrden`),
  KEY `Fk_Cliente` (`Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordentrabajo`
--

LOCK TABLES `ordentrabajo` WRITE;
/*!40000 ALTER TABLE `ordentrabajo` DISABLE KEYS */;
INSERT INTO `ordentrabajo` VALUES (1,'Juan Perez','2012-10-22','Es una revista con muchas páginas.','ACTIVO','Es apaisado','Revista','2012-10-02','Nombre Corto',12,12,12221,1212),(2,'Juan Perez','2012-10-09','12121','ACTIVO','Es apaisado','Revista','2012-10-01','',12,12,12,12),(3,'Rodrigo Gomez','2012-10-08','qwertyuio','ACTIVO','Es apaisado','Revista','2012-10-02','mimimimim',23,23,23,23),(4,'Juan Perez','2012-10-09','22','ACTIVO','Es apaisado','Revista','2012-10-02','ww',23,2,2,22),(5,'Juan Perez','2012-10-10','111','ACTIVO','Es apaisado','Block factura','2012-10-02','1',11,11,1,11),(6,'Juan Perez','2012-10-09','23','ACTIVO','Es apaisado','Revista','2012-10-03','23',23,3,23,3),(7,'Juan Perez','2012-10-15','444','ACTIVO','Es apaisado','Revista','2012-10-01','54',54,4,4,4),(8,'Juan Perez','2012-10-01','22','ACTIVO','Es apaisado','Revista','2012-10-02','tre',2,1,22,22),(9,'Juan Perez','2012-10-01','555555555555','ACTIVO','Es apaisado','Revista','2012-10-02','rt',5,5,5,55);
/*!40000 ALTER TABLE `ordentrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreproducto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Revista'),(2,'Block factura');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formatopapel`
--

DROP TABLE IF EXISTS `formatopapel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formatopapel` (
  `idFormatoPapel` int(11) NOT NULL AUTO_INCREMENT,
  `Ancho` int(11) DEFAULT NULL,
  `Alto` int(11) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFormatoPapel`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formatopapel`
--

LOCK TABLES `formatopapel` WRITE;
/*!40000 ALTER TABLE `formatopapel` DISABLE KEYS */;
INSERT INTO `formatopapel` VALUES (2,45,64,'45X64'),(3,48,65,'48X65'),(4,50,65,'50X65'),(5,50,70,'50X70'),(6,58,92,'58X92'),(7,61,86,'61X86'),(8,63,88,'63X88'),(9,65,95,'65X95'),(10,66,96,'66X96'),(11,70,100,'70X100'),(12,72,102,'72X102'),(13,76,102,'76X102'),(14,74,110,'74X110'),(15,82,118,'82X118'),(16,89,117,'89X117');
/*!40000 ALTER TABLE `formatopapel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudcompra`
--

DROP TABLE IF EXISTS `solicitudcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudcompra` (
  `idsolicitudCompra` int(11) NOT NULL AUTO_INCREMENT,
  `idOrdTrabajo` int(11) DEFAULT NULL,
  `Observacion` varchar(150) DEFAULT NULL,
  `FechaPedido` date DEFAULT NULL,
  `FechaEntrega` date DEFAULT NULL,
  PRIMARY KEY (`idsolicitudCompra`),
  KEY `fk_OrdenTrabajo` (`idOrdTrabajo`),
  CONSTRAINT `fk_OrdenTrabajo` FOREIGN KEY (`idOrdTrabajo`) REFERENCES `ordentrabajo` (`NroOrden`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudcompra`
--

LOCK TABLES `solicitudcompra` WRITE;
/*!40000 ALTER TABLE `solicitudcompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudcompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedorinsumos_has_papel`
--

DROP TABLE IF EXISTS `proveedorinsumos_has_papel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedorinsumos_has_papel` (
  `idproveedor` int(11) NOT NULL DEFAULT '0',
  `papel_idPapel` int(11) NOT NULL DEFAULT '0',
  `precio` decimal(11,0) DEFAULT NULL,
  PRIMARY KEY (`idproveedor`,`papel_idPapel`),
  KEY `fk_proveedorinsumos_has_papel_papel1` (`papel_idPapel`),
  KEY `fk_proveedorinsumos_has_papel_proveedorinsumos1` (`idproveedor`),
  KEY `fk_proveedor` (`idproveedor`),
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedorinsumos_has_papel`
--

LOCK TABLES `proveedorinsumos_has_papel` WRITE;
/*!40000 ALTER TABLE `proveedorinsumos_has_papel` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedorinsumos_has_papel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `cuit` varchar(13) DEFAULT '99-99999999-9',
  `idIva` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `nombreContacto` varchar(45) DEFAULT NULL,
  `telefonoContacto` varchar(45) DEFAULT NULL,
  `mailContacto` varchar(45) DEFAULT NULL,
  `direccionDeEntrega` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `idIva2` (`idIva`),
  CONSTRAINT `idIva2` FOREIGN KEY (`idIva`) REFERENCES `iva` (`idiva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,' b','yyyyyyñ',1,'dirb','telb','mailb','Juan Perez','telefotactob','maactob','dtragab'),(5,'d','D',2,'J','J','J','Rodrigo Gomez','J','J','K');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareaordtrabajo`
--

DROP TABLE IF EXISTS `tareaordtrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tareaordtrabajo` (
  `idOrdTrabajo` int(11) NOT NULL,
  `idTarea` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `Estado` varchar(100) DEFAULT 'editar',
  PRIMARY KEY (`idOrdTrabajo`,`idTarea`,`idProveedor`),
  KEY `IdordTbjo` (`idOrdTrabajo`),
  KEY `idTarea4` (`idTarea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareaordtrabajo`
--

LOCK TABLES `tareaordtrabajo` WRITE;
/*!40000 ALTER TABLE `tareaordtrabajo` DISABLE KEYS */;
INSERT INTO `tareaordtrabajo` VALUES (1,1,2,'ACTIVA'),(1,1,1000,'ACTIVA'),(2,1,1,'ACTIVA'),(2,3,1,'ACTIVA'),(3,1,1,'ACTIVA'),(3,2,1,'ACTIVA'),(3,3,1,'ACTIVA'),(3,3,2,'ACTIVA'),(3,3,1000,'ACTIVA'),(5,1,1,'ACTIVA'),(5,1,1000,'ACTIVA'),(6,2,1,'ACTIVA'),(6,2,2,'ACTIVA'),(7,1,1,'ACTIVA'),(7,1,2,'ACTIVA'),(8,1,1,'ACTIVA'),(8,1,2,'ACTIVA'),(9,2,2,'ACTIVA');
/*!40000 ALTER TABLE `tareaordtrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `idStock` int(11) NOT NULL,
  `idPapel` int(11) DEFAULT NULL,
  `cantHojas` int(11) DEFAULT NULL,
  `nroSolicitudCompra` int(11) DEFAULT NULL,
  `fechaRecepcion` date DEFAULT NULL,
  `hora` varchar(45) DEFAULT 'Mañana o Tarde',
  `partida` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idStock`),
  UNIQUE KEY `partida_UNIQUE` (`partida`),
  KEY `idPapel` (`idPapel`),
  KEY `nroOrdTrabajo` (`nroSolicitudCompra`),
  KEY `nroSolicitudCompra` (`nroSolicitudCompra`),
  CONSTRAINT `nroSolicitudCompra` FOREIGN KEY (`nroSolicitudCompra`) REFERENCES `solicitudcompra` (`idsolicitudCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-12  4:13:22
