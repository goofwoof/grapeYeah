package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.OneToOne;
import lombok.Data;

@Data
@TableName("basket")
public class Basket extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer goodId;

    @TableField(exist = false)
    @OneToOne
    @JoinColumn(name = "good", referencedColumnName = "good_id")
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
