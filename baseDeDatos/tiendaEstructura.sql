-- MariaDB dump 10.19  Distrib 10.11.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: Tienda
-- ------------------------------------------------------
-- Server version	10.11.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Categoria_Cliente`
--

DROP TABLE IF EXISTS `Categoria_Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Categoria_Cliente` (
  `idCategoria_Cliente` int(11) NOT NULL,
  `Nombre_Categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria_Cliente`
--

LOCK TABLES `Categoria_Cliente` WRITE;
/*!40000 ALTER TABLE `Categoria_Cliente` DISABLE KEYS */;
INSERT INTO `Categoria_Cliente` VALUES
(1,'Ocacional'),
(2,'Frecuente (actualizado)');
/*!40000 ALTER TABLE `Categoria_Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `idCategoria_Cliente` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`idCategoria_Cliente`),
  KEY `fk_Cliente_Categoria_Cliente_idx` (`idCategoria_Cliente`),
  CONSTRAINT `fk_Cliente_Categoria_Cliente` FOREIGN KEY (`idCategoria_Cliente`) REFERENCES `Categoria_Cliente` (`idCategoria_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES
(1,'Juan Vanegas','3101234567',1),
(2,'Romulo Caicedo','3108609553',2),
(3,'Stik Melano','3124421751',2),
(4,'Orlando Tisquesuza','31423533735',2),
(5,'Miguel Castillo','3238166058',1);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalle de compra`
--

DROP TABLE IF EXISTS `Detalle de compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Detalle de compra` (
  `idFactura-de-Compra` int(11) NOT NULL,
  `Producto_idProducto` int(11) NOT NULL,
  `Cantidad-producto` int(11) DEFAULT NULL,
  `Total-por-cada-Producto` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idFactura-de-Compra`,`Producto_idProducto`),
  KEY `fk_Factura-de-Compra_has_Producto_Producto1_idx` (`Producto_idProducto`),
  KEY `fk_Factura-de-Compra_has_Producto_Factura-de-Compra1_idx` (`idFactura-de-Compra`),
  CONSTRAINT `fk_Factura-de-Compra_has_Producto_Factura-de-Compra1` FOREIGN KEY (`idFactura-de-Compra`) REFERENCES `Factura-de-Compra` (`idFactura-de-Compra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura-de-Compra_has_Producto_Producto1` FOREIGN KEY (`Producto_idProducto`) REFERENCES `Producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalle de compra`
--

LOCK TABLES `Detalle de compra` WRITE;
/*!40000 ALTER TABLE `Detalle de compra` DISABLE KEYS */;
INSERT INTO `Detalle de compra` VALUES
(1,1,15,168000),
(2,2,24,240000),
(3,3,13,520000),
(4,4,27,216000),
(5,5,11,66000);
/*!40000 ALTER TABLE `Detalle de compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalle_Facturacion`
--

DROP TABLE IF EXISTS `Detalle_Facturacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Detalle_Facturacion` (
  `idFactura_de_Venta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idCategoria_Cliente` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `Cantidad-Pedido` int(11) DEFAULT NULL,
  `Total-Pedido` double DEFAULT NULL,
  PRIMARY KEY (`idFactura_de_Venta`,`idCliente`,`idCategoria_Cliente`,`idProducto`),
  KEY `fk_Factura_de_Venta_has_Producto_Producto1_idx` (`idProducto`),
  KEY `fk_Factura_de_Venta_has_Producto_Factura_de_Venta1_idx` (`idFactura_de_Venta`,`idCliente`,`idCategoria_Cliente`),
  CONSTRAINT `fk_Factura_de_Venta_has_Producto_Factura_de_Venta1` FOREIGN KEY (`idFactura_de_Venta`, `idCliente`, `idCategoria_Cliente`) REFERENCES `Factura_de_Venta` (`idFactura_de_Venta`, `idCliente`, `idCategoria_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_de_Venta_has_Producto_Producto1` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalle_Facturacion`
--

LOCK TABLES `Detalle_Facturacion` WRITE;
/*!40000 ALTER TABLE `Detalle_Facturacion` DISABLE KEYS */;
INSERT INTO `Detalle_Facturacion` VALUES
(1,1,1,1,1,20000),
(2,2,2,2,2,40000),
(3,3,2,3,5,250000),
(4,4,2,4,7,112000),
(5,5,1,5,2,20000);
/*!40000 ALTER TABLE `Detalle_Facturacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalles de servicio`
--

DROP TABLE IF EXISTS `Detalles de servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Detalles de servicio` (
  `idServicio` int(11) NOT NULL,
  `idComprobante-de-servicio` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idServicio`,`idComprobante-de-servicio`),
  KEY `fk_Servicio_has_Comprobante de servicio_Comprobante de serv_idx` (`idComprobante-de-servicio`),
  KEY `fk_Servicio_has_Comprobante de servicio_Servicio1_idx` (`idServicio`),
  CONSTRAINT `fk_Servicio_has_Comprobante de servicio_Comprobante de servic1` FOREIGN KEY (`idComprobante-de-servicio`) REFERENCES `Factura de servicio` (`idComprobante de servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Servicio_has_Comprobante de servicio_Servicio1` FOREIGN KEY (`idServicio`) REFERENCES `Servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalles de servicio`
--

LOCK TABLES `Detalles de servicio` WRITE;
/*!40000 ALTER TABLE `Detalles de servicio` DISABLE KEYS */;
INSERT INTO `Detalles de servicio` VALUES
(1,1,'Cambio display Samsug'),
(1,5,'Cambio puerto de carga iphone '),
(2,2,'Mantenimiento general pc Hp'),
(2,3,'Limpieza celular xiaomi'),
(2,4,'Cambio pasta termica lenovo');
/*!40000 ALTER TABLE `Detalles de servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura de servicio`
--

DROP TABLE IF EXISTS `Factura de servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Factura de servicio` (
  `idComprobante de servicio` int(11) NOT NULL,
  `Costo` varchar(45) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idCategoria_Cliente` int(11) NOT NULL,
  PRIMARY KEY (`idComprobante de servicio`),
  KEY `fk_Factura de servicio_Cliente1_idx` (`idCliente`,`idCategoria_Cliente`),
  CONSTRAINT `fk_Factura de servicio_Cliente1` FOREIGN KEY (`idCliente`, `idCategoria_Cliente`) REFERENCES `Cliente` (`idCliente`, `idCategoria_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura de servicio`
--

LOCK TABLES `Factura de servicio` WRITE;
/*!40000 ALTER TABLE `Factura de servicio` DISABLE KEYS */;
INSERT INTO `Factura de servicio` VALUES
(1,'40000',1,1),
(2,'23500',2,2),
(3,'72900',3,2),
(4,'50000',4,2),
(5,'86750',5,1);
/*!40000 ALTER TABLE `Factura de servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura-de-Compra`
--

DROP TABLE IF EXISTS `Factura-de-Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Factura-de-Compra` (
  `idFactura-de-Compra` int(11) NOT NULL,
  `Fecha-compra` date DEFAULT NULL,
  `Total_a_Pagar` double DEFAULT NULL,
  `Proveedor_idProveedor` int(11) NOT NULL,
  PRIMARY KEY (`idFactura-de-Compra`,`Proveedor_idProveedor`),
  KEY `fk_Factura-de-Compra_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Factura-de-Compra_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `Proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura-de-Compra`
--

LOCK TABLES `Factura-de-Compra` WRITE;
/*!40000 ALTER TABLE `Factura-de-Compra` DISABLE KEYS */;
INSERT INTO `Factura-de-Compra` VALUES
(1,'2001-02-23',500000,1),
(2,'2015-06-22',450000,2),
(3,'2025-11-22',210000,3),
(4,'2012-12-19',1000000,4),
(5,'2026-04-23',700530,5);
/*!40000 ALTER TABLE `Factura-de-Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura_de_Venta`
--

DROP TABLE IF EXISTS `Factura_de_Venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Factura_de_Venta` (
  `idFactura_de_Venta` int(11) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Total_a_Pagar` int(11) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idCategoria_Cliente` int(11) NOT NULL,
  PRIMARY KEY (`idFactura_de_Venta`,`idCliente`,`idCategoria_Cliente`),
  KEY `fk_Factura_de_Venta_Cliente1_idx` (`idCliente`,`idCategoria_Cliente`),
  CONSTRAINT `fk_Factura_de_Venta_Cliente1` FOREIGN KEY (`idCliente`, `idCategoria_Cliente`) REFERENCES `Cliente` (`idCliente`, `idCategoria_Cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura_de_Venta`
--

LOCK TABLES `Factura_de_Venta` WRITE;
/*!40000 ALTER TABLE `Factura_de_Venta` DISABLE KEYS */;
INSERT INTO `Factura_de_Venta` VALUES
(1,'2023-05-17',15000,1,1),
(2,'2023-05-16',25000,2,2),
(3,'2023-05-15',18000,3,2),
(4,'2023-05-14',30000,4,2),
(5,'2023-05-13',50000,5,1);
/*!40000 ALTER TABLE `Factura_de_Venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Producto` (
  `idProducto` int(11) NOT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  `Cantidad-especifica` varchar(45) DEFAULT NULL,
  `Precio-venta` varchar(45) DEFAULT NULL,
  `Precio-compra` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES
(1,'Audifonos','50','29.99','14000'),
(2,'Protectores celular','78','20000','10000'),
(3,'PowerBank','20','50000','40000'),
(4,'Aro de luz','10','16000','8000'),
(5,'Cable USB','15','10000','6000');
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedor` (
  `idProveedor` int(11) NOT NULL,
  `NIT` bigint(20) DEFAULT NULL,
  `Nombre-Proveedor` varchar(45) DEFAULT NULL,
  `Telefono-Proveedor` varchar(20) DEFAULT NULL,
  `Direccion-Proveedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
INSERT INTO `Proveedor` VALUES
(1,1234567899,'JBL','3259872654','calle-25-sur'),
(2,1234567888,'Ysmartphone','3284571215','calle-21-norte'),
(3,1234569877,'Hometly','3134568524','calle-22-occidente'),
(4,9874561233,'Teknopolis','3148759642','calle-23-oriente'),
(5,5467891235,'ArticulosAltagama','3125896471','calle-69-centro');
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Servicio`
--

DROP TABLE IF EXISTS `Servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Servicio` (
  `idServicio` int(11) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Servicio`
--

LOCK TABLES `Servicio` WRITE;
/*!40000 ALTER TABLE `Servicio` DISABLE KEYS */;
INSERT INTO `Servicio` VALUES
(1,'Reparacion'),
(2,'Mantenimiento');
/*!40000 ALTER TABLE `Servicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-21 18:33:02
