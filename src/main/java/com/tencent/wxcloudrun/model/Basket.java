package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "basket", resultMap = "BaseResultMap")
public class Basket extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer goodId;

    @TableField(exist = false)
    private Good good;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 数量
     */
    private Integer quantity;
}
