CREATE DATABASE IF NOT EXISTS `chance`;
USE `chance`;

DROP FUNCTION IF EXISTS `rand_string`;

CREATE FUNCTION `rand_string`(n INT)
RETURNS varchar(255) CHARSET utf8
 BEGIN
  DECLARE chars_str varchar(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
  DECLARE return_str varchar(255) DEFAULT '';
  DECLARE i INT DEFAULT 0;
  WHILE i < n DO
   SET return_str = concat(return_str,substring(chars_str , FLOOR(1 + RAND()*62 ),1));
   SET i = i +1;
  END WHILE;
  RETURN return_str;
 END;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
 `id` varchar(32) NOT NULL,
 `name` varchar(50) DEFAULT NULL,
 `password` varchar(50) DEFAULT NULL,
 PRIMARY KEY (`id`)
);

INSERT INTO user VALUES(rand_string(22),'chance',md5('x'))