CREATE SCHEMA `demo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
CREATE TABLE `demo`.`t_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `demo`.`t_user` (`id`, `user_name`, `user_password`) VALUES ('1', 'admin', 'admin');


CREATE TABLE `demo`.`t_book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NOT NULL,
  `book_author` VARCHAR(45) NOT NULL,
  `book_press` VARCHAR(45) NOT NULL,
  `book_price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `demo`.`t_book` (`id`, `book_name`, `book_author`, `book_press`, `book_price`) VALUES ('1', '《深入浅出Mybatis技术原理与实战》', '杨开振', '电子工业出版社', '69.00');
INSERT INTO `demo`.`t_book` (`id`, `book_name`, `book_author`, `book_press`, `book_price`) VALUES ('2', '《Spring+Mybatis企业应用实战》', '疯狂软件', '电子工业出版社', '58.00');
