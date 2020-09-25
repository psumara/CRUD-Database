CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES 
	(1,'Piotr','Sumara','ps@gmail.com'),
	(2,'Jan','Kowalski','jk@gmail.com'),
	(3,'Maria','Kowalska','mk@gmail.com'),
	(4,'Anna','Kowalska','ak@gmail.com');
	

