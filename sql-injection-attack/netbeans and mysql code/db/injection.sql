-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.62 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for injection
CREATE DATABASE IF NOT EXISTS `injection` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `injection`;

-- Dumping structure for table injection.creditcard
CREATE TABLE IF NOT EXISTS `creditcard` (
  `accountnumber` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.creditcard: ~2 rows (approximately)
DELETE FROM `creditcard`;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` (`accountnumber`, `password`, `amount`) VALUES
	('1010', 'aaa', '800'),
	('1000', 'bbb', '800');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;

-- Dumping structure for table injection.customerdetails
CREATE TABLE IF NOT EXISTS `customerdetails` (
  `name` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `acctype` varchar(50) DEFAULT NULL,
  `contactnumber` varchar(50) DEFAULT NULL,
  `accountnumber` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cpassword` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.customerdetails: ~0 rows (approximately)
DELETE FROM `customerdetails`;
/*!40000 ALTER TABLE `customerdetails` DISABLE KEYS */;
INSERT INTO `customerdetails` (`name`, `dob`, `age`, `gender`, `address`, `occupation`, `acctype`, `contactnumber`, `accountnumber`, `amount`, `password`, `cpassword`) VALUES
	('kaleem', '11/12/1983', '36', 'male', 'bangalore', 'be', 'saving', '1234567890', '2000', '8000.0', 'mcecse', 'mcecse');
/*!40000 ALTER TABLE `customerdetails` ENABLE KEYS */;

-- Dumping structure for table injection.details
CREATE TABLE IF NOT EXISTS `details` (
  `d` varchar(50) DEFAULT NULL,
  `e` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.details: ~0 rows (approximately)
DELETE FROM `details`;
/*!40000 ALTER TABLE `details` DISABLE KEYS */;
/*!40000 ALTER TABLE `details` ENABLE KEYS */;

-- Dumping structure for table injection.login
CREATE TABLE IF NOT EXISTS `login` (
  `accountnumber` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `accountdetails` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.login: ~1 rows (approximately)
DELETE FROM `login`;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` (`accountnumber`, `password`, `accountdetails`) VALUES
	('1000', 'eee', 'sss');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;

-- Dumping structure for table injection.query
CREATE TABLE IF NOT EXISTS `query` (
  `queryname` varchar(50) DEFAULT NULL,
  `query` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.query: ~0 rows (approximately)
DELETE FROM `query`;
/*!40000 ALTER TABLE `query` DISABLE KEYS */;
INSERT INTO `query` (`queryname`, `query`) VALUES
	('select', 'select * from where AND OR'),
	('insert', 'insert into values ( )'),
	('update', 'update set where');
/*!40000 ALTER TABLE `query` ENABLE KEYS */;

-- Dumping structure for table injection.sample
CREATE TABLE IF NOT EXISTS `sample` (
  `s` varchar(50) DEFAULT NULL,
  `d` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.sample: ~0 rows (approximately)
DELETE FROM `sample`;
/*!40000 ALTER TABLE `sample` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample` ENABLE KEYS */;

-- Dumping structure for table injection.transactiondetails
CREATE TABLE IF NOT EXISTS `transactiondetails` (
  `yourname` varchar(50) DEFAULT NULL,
  `accountnumber` varchar(50) DEFAULT NULL,
  `tranaccountnumber` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL,
  `dataofttansaction` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table injection.transactiondetails: ~0 rows (approximately)
DELETE FROM `transactiondetails`;
/*!40000 ALTER TABLE `transactiondetails` DISABLE KEYS */;
INSERT INTO `transactiondetails` (`yourname`, `accountnumber`, `tranaccountnumber`, `amount`, `dataofttansaction`) VALUES
	('kaleem', '2000', '3232', '1000', 'Tue Mar 29 18:07:42 IST 2022');
/*!40000 ALTER TABLE `transactiondetails` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
