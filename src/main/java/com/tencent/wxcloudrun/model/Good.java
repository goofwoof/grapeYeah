package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tencent.wxcloudrun.config.mybatis.typeHandler.ListStringTypeHandler;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("goods")
public class Good extends BaseEntity {
  private static final long serialVersionUID = 1L;
  /**
   * 商品价钱
   */
  private Double goodPrice;
  /**
   * 开始时间
   */
  private LocalDateTime startTime;
  /**
   * 结束时间
   */
  private LocalDateTime endTime;
  /**
   * 商品图片
   */
  @TableField(typeHandler = ListStringTypeHandler.class)
  private List<String> goodUrls;

  @TableField(typeHandler = ListStringTypeHandler.class)
  private List<String> flowUrls;
  /**
   * 商品code
   */
  private String goodCode;
  /**
   * 商品描述
   */
  private String goodDesc;
  /**
   * 规格描述
   */
  private String specs;
}
