-- ----------------------------
--  `short_url` 表
-- ----------------------------
DROP TABLE IF EXISTS `short_url`;
CREATE TABLE `short_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(2048) NOT NULL DEFAULT '',
  `create_time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `short_url` AUTO_INCREMENT=10000000;