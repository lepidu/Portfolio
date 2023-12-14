-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.27 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Volcando estructura para tabla slec_leislypino.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `surname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla slec_leislypino.admin: ~1 rows (aproximadamente)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`name`, `surname`, `email`, `password`, `phone`) VALUES
	('Leisly', 'Pino', 'CCT', 'Dublin', '+353 0833550594');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Volcando estructura para tabla slec_leislypino.equation_threev
CREATE TABLE IF NOT EXISTS `equation_threev` (
  `x1` int DEFAULT NULL,
  `y1` int DEFAULT NULL,
  `z1` int DEFAULT NULL,
  `r1` int DEFAULT NULL,
  `x2` int DEFAULT NULL,
  `y2` int DEFAULT NULL,
  `z2` int DEFAULT NULL,
  `r2` int DEFAULT NULL,
  `x3` int DEFAULT NULL,
  `y3` int DEFAULT NULL,
  `z3` int DEFAULT NULL,
  `r3` int DEFAULT NULL,
  `x` int DEFAULT NULL,
  `y` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `z` int DEFAULT NULL,
  KEY `emailv3` (`email`),
  CONSTRAINT `emailv3` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla slec_leislypino.equation_threev: ~0 rows (aproximadamente)
DELETE FROM `equation_threev`;
/*!40000 ALTER TABLE `equation_threev` DISABLE KEYS */;
/*!40000 ALTER TABLE `equation_threev` ENABLE KEYS */;

-- Volcando estructura para tabla slec_leislypino.equation_twov
CREATE TABLE IF NOT EXISTS `equation_twov` (
  `x1` int DEFAULT NULL,
  `y1` int DEFAULT NULL,
  `r1` int DEFAULT NULL,
  `x2` int DEFAULT NULL,
  `y2` int DEFAULT NULL,
  `r2` int DEFAULT NULL,
  `x` int DEFAULT NULL,
  `y` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  KEY `emailv2` (`email`),
  CONSTRAINT `emailv2` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla slec_leislypino.equation_twov: ~0 rows (aproximadamente)
DELETE FROM `equation_twov`;
/*!40000 ALTER TABLE `equation_twov` DISABLE KEYS */;
/*!40000 ALTER TABLE `equation_twov` ENABLE KEYS */;

-- Volcando estructura para tabla slec_leislypino.users
CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla slec_leislypino.users: ~6 rows (aproximadamente)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`name`, `surname`, `email`, `phone`, `address`, `city`, `password`) VALUES
	('Carol', 'Byrne', 'byrne@gmail.com', '098765', '97 Tyrconnell Rd', 'Donegal', '1234'),
	('Gerald', 'Cullen', 'gerry@gmail.com', '3 Queen St', '1098765', 'Meath', '1234'),
	('leisly', 'pino', 'lepidu', '988378', 'smjn', 'Item 1', 'pino'),
	('leisly', 'pino', 'lepidu@live.com', '8372', 'djnc', 'Item 1', '1234'),
	('Mauro', 'Bruno', 'mauro@gmail.com', '098765', '6 Loftus', 'Antrim', '12345'),
	('Mikey', 'Reddin', 'mikey@gmail.com', '098765', '54 Foxrock Manor', 'Cavan', '1234');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
