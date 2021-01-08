
-- DROP database IF EXISTS `less_db`;
-- create database `less_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- ----------------------------
--  table structure for `tb_book`
-- ----------------------------
CREATE TABLE `tb_book` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(64) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
);

-- ----------------------------
--  table structure for `tb_hero`
-- ----------------------------
CREATE TABLE `tb_hero` (
  `hero_id` int(11) NOT NULL,
  `hero_name` varchar(32) DEFAULT NULL,
  `skill` varchar(64) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`hero_id`)
);

-- ----------------------------
--  Table structure for `tb_book_hero`
-- ----------------------------
CREATE TABLE `tb_book_hero` (
  `book_id` int(11) NOT NULL,
  `hero_id` int(11) NOT NULL,
  `user_comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`, `hero_id`)
);