package com.tencent.wxcloudrun.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tencent.wxcloudrun.config.mybatis.typeHandler.ListStringTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("goods")
public class Good implements Serializable {
  private static final long serialVersionUID = 1L;
  /**
   * 活动ID
   */
  @TableId(type = IdType.AUTO)
  private Integer id;
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
   * 车辆图片
   */
  @TableField(typeHandler = ListStringTypeHandler.class)
  private List<String> goodUrls;
  /**
   * 商品code
   */
  private String goodCode;
  /**
   * 商品描述
   */
  private String goodDesc;
  /**
   * 创建时间
   */
  private LocalDateTime createTime;
  /**
   * 更新时间
   */
  private LocalDateTime updateTime;
}
