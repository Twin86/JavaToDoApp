-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE DATABASE "sibi_to_do_db" -------------------------
CREATE DATABASE IF NOT EXISTS `sibi_to_do_db` CHARACTER SET utf8 COLLATE utf8_polish_ci;
USE `sibi_to_do_db`;
-- ---------------------------------------------------------


-- CREATE TABLE "status" -----------------------------------
DROP TABLE IF EXISTS `status` CASCADE;

CREATE TABLE `status` ( 
	`title` VarChar( 255 ) NOT NULL,
	`is_delete` TinyInt( 1 ) NOT NULL DEFAULT '0',
	CONSTRAINT `unique_title` UNIQUE( `title` ) )
ENGINE = InnoDB;
-- ---------------------------------------------------------


-- CREATE TABLE "tasks" ------------------------------------
DROP TABLE IF EXISTS `tasks` CASCADE;

CREATE TABLE `tasks` ( 
	`id` Int( 255 ) AUTO_INCREMENT NOT NULL,
	`title` VarChar( 255 ) NOT NULL,
	`description` Text NULL,
	`id_user` Int( 11 ) NOT NULL,
	`day_start` Date NOT NULL,
	`day_end` Date NOT NULL,
	`all_day` TinyInt( 1 ) NOT NULL DEFAULT '0',
	`time_start` Time NOT NULL,
	`time_end` Time NOT NULL,
	`status` VarChar( 255 ) NOT NULL,
	`is_delete` TinyInt( 1 ) NOT NULL DEFAULT '0',
	CONSTRAINT `unique_id` UNIQUE( `id` ) )
ENGINE = InnoDB
AUTO_INCREMENT = 2;
-- ---------------------------------------------------------


-- CREATE TABLE "users" ------------------------------------
DROP TABLE IF EXISTS `users` CASCADE;

CREATE TABLE `users` ( 
	`id` Int( 11 ) AUTO_INCREMENT NOT NULL,
	`email` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
	`is_delete` TinyInt( 1 ) NOT NULL DEFAULT '0',
	`pass` VarChar( 40 ) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
	CONSTRAINT `unique_email` UNIQUE( `email` ),
	CONSTRAINT `unique_id` UNIQUE( `id` ) )
CHARACTER SET = latin2
COLLATE = latin2_general_ci
ENGINE = InnoDB
AUTO_INCREMENT = 2;
-- ---------------------------------------------------------


-- Dump data of "status" -----------------------------------
INSERT INTO `status`(`title`,`is_delete`) VALUES ( 'nowe', '0' );
INSERT INTO `status`(`title`,`is_delete`) VALUES ( 'usunięte', '0' );
INSERT INTO `status`(`title`,`is_delete`) VALUES ( 'wykonane', '0' );
-- ---------------------------------------------------------


-- Dump data of "tasks" ------------------------------------
INSERT INTO `tasks`(`id`,`title`,`description`,`id_user`,`day_start`,`day_end`,`all_day`,`time_start`,`time_end`,`status`,`is_delete`) VALUES ( '1', 'Napisać pracę inżynierską', NULL, '1', '2016-11-08', '2016-11-08', '0', '13:00:00', '14:00:00', 'nowe', '0' );
-- ---------------------------------------------------------


-- Dump data of "users" ------------------------------------
INSERT INTO `users`(`id`,`email`,`is_delete`,`pass`) VALUES ( '1', 'twin86@gmail.com', '0', '1' );
-- ---------------------------------------------------------


-- CREATE INDEX "lnk_status_tasks" -------------------------
CREATE INDEX `lnk_status_tasks` USING BTREE ON `tasks`( `status` );
-- ---------------------------------------------------------


-- CREATE INDEX "lnk_users_tasks" --------------------------
CREATE INDEX `lnk_users_tasks` USING BTREE ON `tasks`( `id_user` );
-- ---------------------------------------------------------


-- CREATE LINK "lnk_status_tasks" --------------------------
ALTER TABLE `tasks` DROP FOREIGN KEY `lnk_status_tasks`;


ALTER TABLE `tasks`
	ADD CONSTRAINT `lnk_status_tasks` FOREIGN KEY ( `status` )
	REFERENCES `status`( `title` )
	ON DELETE No Action
	ON UPDATE Cascade;
-- ---------------------------------------------------------


-- CREATE LINK "lnk_users_tasks" ---------------------------
ALTER TABLE `tasks` DROP FOREIGN KEY `lnk_users_tasks`;


ALTER TABLE `tasks`
	ADD CONSTRAINT `lnk_users_tasks` FOREIGN KEY ( `id_user` )
	REFERENCES `users`( `id` )
	ON DELETE No Action
	ON UPDATE Cascade;
-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


