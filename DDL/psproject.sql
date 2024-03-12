/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - prosoft_projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoft_projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `prosoft_projekat`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `employment_date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `administrator` */

insert  into `administrator`(`id`,`username`,`password`,`employment_date`) values 
(1,'admin','admin','2023-09-11'),
(2,'admin123','admin123','2023-09-11');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `administrator_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `administrator_id` (`administrator_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `employee` */

insert  into `employee`(`id`,`firstname`,`lastname`,`birth_date`,`creation_date`,`administrator_id`) values 
(1,'Marija','Milic','2004-04-16','2024-01-06',1),
(14,'Petar','Peric','2000-04-04','2024-02-16',1),
(15,'Milica','Ivic','2000-07-12','2024-02-16',1),
(16,'Marija','Bogicevic','1998-08-30','2024-02-16',1),
(18,'Ivana','Ivanovic','2000-05-10','2024-02-16',1),
(19,'Milica','Milojevic','2000-11-14','2024-02-16',1),
(20,'Marko','Markovic','1995-05-20','2024-02-16',1),
(21,'Milovan','Peric','2000-07-04','2024-02-16',1),
(22,'Pavle','Pavlovic','1999-07-13','2024-02-16',1),
(24,'Pera','Perovic','2000-09-13','2024-02-16',1),
(28,'Anja','Pejovic','2024-02-07','2024-02-18',1);

/*Table structure for table `membership` */

DROP TABLE IF EXISTS `membership`;

CREATE TABLE `membership` (
  `employee_id` bigint(20) unsigned NOT NULL,
  `team_id` bigint(20) unsigned NOT NULL,
  `joining_date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`,`team_id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `membership_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `membership_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `membership` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `administrator_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `administrator_id` (`administrator_id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `ch_startdate` CHECK (`start_date` <= `end_date`),
  CONSTRAINT `ch_enddate` CHECK (`end_date` >= `start_date`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `project` */

insert  into `project`(`id`,`name`,`start_date`,`end_date`,`administrator_id`) values 
(2,'StellarSync','2021-03-01','2021-04-16',1),
(5,'RoboRevolution','2024-02-07','2024-02-12',1),
(6,'SkyNetConnection','2023-03-17','2024-02-12',1),
(16,'SpaceExplora','2021-02-12','2022-09-08',1),
(17,'SpaceSky','2023-06-06','2024-01-11',1),
(18,'GreenTechScape','2021-08-03','2022-01-14',1);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `project_id` bigint(20) unsigned NOT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `due_date` date NOT NULL,
  `team_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`project_id`,`id`),
  KEY `id` (`id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `task` */

insert  into `task`(`project_id`,`id`,`name`,`status`,`due_date`,`team_id`) values 
(5,5,'Task4','ASSIGNED','2024-03-27',5),
(5,18,'Task 2','ON_HOLD','2024-02-18',1),
(5,19,'Task 3','CLOSED','2024-02-18',1),
(5,20,'Task 4','NEW','2024-02-18',1),
(6,2,'Task2','COMPLETED','2024-07-04',1);

/*Table structure for table `team` */

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `number_of_members` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `team` */

insert  into `team`(`id`,`name`,`number_of_members`) values 
(1,'Tim 1',5),
(2,'Tim 2',4),
(3,'Tim 3',2),
(4,'Tim 4',3),
(5,'Tim 5',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
