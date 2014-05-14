CREATE DATABASE `schooldb` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `results` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result_score` decimal(12,4) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `schools_idx` (`school_id`),
  KEY `subjectsfk_idx` (`subject_id`),
  CONSTRAINT `schoolsfk` FOREIGN KEY (`school_id`) REFERENCES `schools` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subjectsfk` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
CREATE TABLE `schools` (
  `id` int(11) NOT NULL,
  `school_name` varchar(45) DEFAULT NULL,
  `district` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `subjects` (
  `id` int(11) NOT NULL,
  `subject_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
