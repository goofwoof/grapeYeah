DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`                int(11) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
    `good_code`         varchar(15) NOT NULL COMMENT '商品code',
    `good_desc`         varchar(100) NOT NULL COMMENT '商品描述',
    `good_urls`         varchar(2048) NOT NULL COMMENT '商品图片',
    `good_price`        double NOT NULL COMMENT '商品零售价',
    `start_time`        datetime    NOT NULL COMMENT '开始时间',
    `end_time`          datetime    NOT NULL COMMENT '结束时间',
    `create_time`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';
