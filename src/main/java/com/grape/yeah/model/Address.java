package com.grape.yeah.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address")
public class Address extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 收货人
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区县
     */
    private String county;
    /**
     * 乡镇
     */
    private String town;
    /**
     * 补充信息
     */
    private String detail;
    /**
     * 纬度
     */
    private double latitude;
    /**
     * 精度
     */
    private double longitude;
    /**
     * 偏好
     */
    private Boolean prefer;
}
