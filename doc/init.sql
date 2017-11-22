CREATE TABLE `sys_user` (
  `uid` varchar(64) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8