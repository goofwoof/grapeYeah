DROP TABLE IF EXISTS `basket`;
CREATE TABLE `basket`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '篮子ID',
    `user_id`     varchar(64) NOT NULL COMMENT 'open id',
    `good_id`     int(11) NOT NULL COMMENT '商品id',
    `quantity`    int(11) NOT NULL COMMENT '数量',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    INDEX         `idx_basket_user_id` (user_id),
    INDEX         `idx_basket_good_id` (good_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='篮子表';

ALTER TABLE `goods`
    ADD COLUMN `specs` varchar(100) NOT NULL COMMENT '规格描述';
ALTER TABLE `goods`
    ADD COLUMN `flow_urls` varchar(1024) NOT NULL COMMENT '商品流图片urls';


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id`     varchar(64)   NOT NULL COMMENT 'open id',
    `nick_name`   varchar(64)   NOT NULL COMMENT '昵称',
    `avatar`      varchar(1024) NOT NULL COMMENT '头像',
    `create_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    INDEX         `idx_basket_user_id` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';


DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id`     varchar(64)  NOT NULL COMMENT 'open id',
    `name`        varchar(15)  NOT NULL COMMENT '收件人姓名',
    `phone`       varchar(15)  NOT NULL COMMENT '手机',
    `latitude`    double       NOT NULL COMMENT '纬度',
    `longitude`   double       NOT NULL COMMENT '精度',
    `province`    varchar(64)  NOT NULL COMMENT '省份',
    `city`        varchar(64)  NOT NULL COMMENT '城市',
    `county`      varchar(64)  NOT NULL COMMENT '区县',
    `town`        varchar(64)  NOT NULL COMMENT '乡镇',
    `detail`      varchar(256) NOT NULL COMMENT '详细地址',
    `prefer`      int(1) NOT NULL COMMENT '偏好',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    INDEX         `idx_basket_user_id` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';
