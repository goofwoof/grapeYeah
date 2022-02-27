package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("basket")
public class Basket extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 数量
     */
    private Integer quantity;
}
