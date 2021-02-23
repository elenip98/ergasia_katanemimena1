Gia na trexi afth h ergasia prepei 

1.Na valete ta stoixia ths diakias vasis dedomenon kai sindesis sta arxia: 
	a. application.properties
	b. hibernate.cfg.xml



2.na exete tous parakato pinakes me ta dedomena tous sthn vash dedomenon sas:


DROP TABLE IF EXISTS `stathmoi_applications`;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS classes;
DROP TABLE IF EXISTS stathmoi;
DROP TABLE IF EXISTS myusers;




CREATE TABLE myusers (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(45) NOT NULL,
`password` varchar(100) NOT NULL,
`firstname` varchar(45) DEFAULT NULL,
`lastname` varchar(45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
`authority` varchar(50) NOT NULL,
`enabled` tinyint(1) NOT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `myusers` VALUES
(1,'dhmotis', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'David','Adams','david@hua.gr', 'ROLE_DIM', 1),
(2,'root', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'John','Doe','john@hua.gr', 'ROLE_ADMIN', 1),
(3,'dief', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Panos','Petrakis','panos@hua.gr', 'ROLE_DIEF', 1),
(4,'diax', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Aris','Kinos','aris@hua.gr', 'ROLE_DIAX', 1),
(5,'teacher', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Maria','Alexiou','maria@hua.gr', 'ROLE_TEACHER', 1);

INSERT INTO `myusers` VALUES
(6,'dief2', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Katerina','Kara','katerina@hua.gr', 'ROLE_DIEF', 1),
(7,'dief3', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Xristos','Panou','xristos@hua.gr', 'ROLE_DIEF', 1),
(8,'dief4', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Marilena','Xrisou','marilena@hua.gr', 'ROLE_DIEF', 1),
(9,'dief5', '$2a$04$DR/f..s1siWJc8Xg3eJgpeB28a4V6kYpnkMPeOuq4rLQ42mJUYFGC', 'Eleni','Koli','eleni@hua.gr', 'ROLE_DIEF', 1);


CREATE TABLE `stathmoi` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
`capacity` int(3) DEFAULT NULL,
`address` varchar(45) DEFAULT NULL,
`phone` int(10) DEFAULT NULL,
`info` varchar(45) DEFAULT NULL,
`enabled` tinyint(1) NOT NULL,
`diefthidis_id` int(11) DEFAULT NULL,
PRIMARY KEY (id),
CONSTRAINT `FK_DIEF` FOREIGN KEY (`diefthidis_id`)
REFERENCES `myusers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `stathmoi` VALUES
(1,'First Steps', 25, 'Georgiou 2, Marousi', 2101234567, 'Idiotikos Stathmos', 1, 3),
(2,'15os Stathmos Peristeriou', 15 ,'Arkadias 38, Peristeri', 2108763252, 'Idiotikos Stathmos', 1, 6),
(3,'1os Stathmos Xalandriou', 30 ,'Grigoriou 13, Xalandri', 2108765473, 'Dimosios Stathmos', 1, 7),
(4,'Leukes Kardoules', 50 ,'Filikhs Etairias 10, Glifada', 2108757322, 'Dimosios Stathmos', 1, 8),
(5,'Baby Smile', 35 ,'Bafioxwriou 69, Athina', 2108264732, 'Dimosios Stathmos', 1, 9);


CREATE TABLE `classes` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
`stathmos_id` int(11) DEFAULT NULL,
`teacher_id` int(11) DEFAULT NULL,
PRIMARY KEY (id),
CONSTRAINT `FK_STATHMOS` FOREIGN KEY (`stathmos_id`)
REFERENCES `stathmoi` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_TEACH` FOREIGN KEY (`teacher_id`)
REFERENCES `myusers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `classes` VALUES
(1,'Animals', 1, 5),
(2,'Numbers', 1, 5),
(3,'Colors', 2, 5),
(4,'Playtime', 2, 5),
(5,'Speech', 3, 5),
(6,'Drawing', 3, 5),
(7,'Sea', 4, 5),
(8,'Dolphins', 4, 5),
(9,'Arts', 5, 5),
(10,'Music', 5, 5);

CREATE TABLE `students` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`firstname` varchar(45) DEFAULT NULL,
`lastname` varchar(45) DEFAULT NULL,
`parent1` varchar(45) DEFAULT NULL,
`parent2` varchar(45) DEFAULT NULL,
`contactinfo` varchar(45) DEFAULT NULL,
`age` int(2) NOT NULL,
`class_id` int(11) DEFAULT NULL,
PRIMARY KEY (id),
CONSTRAINT `FK_CLASS` FOREIGN KEY (`class_id`)
REFERENCES `classes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


INSERT INTO `students` VALUES
(1,'Alex', 'Panou', 'Maria Panou', 'Panagiotis Panou', '6912374278', 5, 1),
(2,'Giorgos', 'Papadopoulou', 'Kuriakh Papadopoulou', 'Dimitrios Papadopoulou', '6912313634', 4, 1),
(3,'Basilis', 'Mosxopoulou', 'Maria Mosxopoulou', 'Nikos Mosxopoulou', '6912341637', 6, 1),
(4,'Maria', 'Thanou', 'Olga Thanou', 'Athanasios Thanou', '6912348342', 4, 1),
(5,'Ioanna', 'Tsopala', 'Zwh Tsopala', 'Mixail Tsopala', '6912346235', 5, 1),
(6,'Xristos', 'Karagiannh', 'Eustathia Karagiannh', 'Antonios Karagiannh', '6912346314', 6, 1),
(7,'Stella', 'Papageorgiou', 'Areth Papageorgiou', 'Apostolos Papageorgiou', '6912345678', 4, 1),
(8,'Eva', 'Tsonh', 'Agathi Tsonh', 'Petros Tsonh', '6912312516', 5, 1),
(9,'Anna', 'Bagiou', 'Danah Bagiou', 'Thomas Bagiou', '6912123567', 6, 1),
(10,'Marios', 'Mikrou', 'Kleonikh Mikrou', 'Aggelos Mikrou', '6912246436', 5, 1),
(11,'Xristina', 'Athineou', 'Nausika Athineou', 'Lampros Athineou', '6911252363', 6, 1),
(12,'Eugenia', 'Perpinia', 'Hrw Perpinia', 'Lazaros Perpinias', '6912347346', 5, 1),
(13,'Spiros', 'Tsoukala', 'Mirto Tsoukala', 'Marios Tsoukala', '6912734653', 5, 1);

CREATE TABLE `application` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`finace` varchar(45) DEFAULT NULL,
`socailinfo` varchar(45) DEFAULT NULL,
`extrainfo` varchar(45) DEFAULT NULL,
`status` varchar(45) DEFAULT NULL,
`student_id` int(11) DEFAULT NULL,
`dhmotis_id` int(11) DEFAULT NULL,
PRIMARY KEY (id),
CONSTRAINT `FK_STD` FOREIGN KEY (`student_id`)
REFERENCES `students` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_DHMOTIS` FOREIGN KEY (`dhmotis_id`)
REFERENCES `myusers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



INSERT INTO application VALUES
(1,'10000k per year', 'married', '3 children', 'Submitted',1, 1);

CREATE  TABLE `stathmoi_applications` (
`stathmos_id` int(11) NOT NULL,
`application_id` int(11) NOT NULL,

PRIMARY KEY (`stathmos_id`,`application_id`),

KEY `FK_JOIN_TB` (`stathmos_id`),

CONSTRAINT `FK_STATHMOI_2` FOREIGN KEY (`stathmos_id`)
REFERENCES `stathmoi` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION,

CONSTRAINT `FK_APP` FOREIGN KEY (`application_id`)
REFERENCES `application` (`id`)
ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO application VALUES
(2,'10000k per year', 'married', '3 children', 'Submitted',1, 1),
(3,'10000k per year', 'married', '3 children', 'Rejected',1, 1),
(4,'10000k per year', 'married', '3 children', 'Rejected',1, 1),
(5,'10000k per year', 'married', '3 children', 'Accepted',1, 1);



