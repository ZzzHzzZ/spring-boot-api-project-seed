CREATE TABLE `t_user` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(64) NOT NULL COMMENT '登录用户名' ,
`password`  varchar(255) NOT NULL COMMENT '密码' ,
`name`  varchar(64) NULL COMMENT '用户姓名' ,
`mobile`  varchar(11) NULL COMMENT '手机号' ,
`email`  varchar(64) NULL ,
`ctime`  timestamp NOT NULL COMMENT '用户创建时间' ,
`deleted`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否被删除' ,
`admin`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否为管理员' ,
PRIMARY KEY (`id`)
)
;

