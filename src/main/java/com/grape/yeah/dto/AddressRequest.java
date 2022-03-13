package com.grape.yeah.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressRequest {
    /**
     * 收货人
     */
    @NotNull
    @NotBlank
    @Length(max = 60)
    private String name;
    /**
     * 手机号
     */
    @NotNull
    @NotBlank
    @Length(min = 11, max = 14)
    private String phone;
    /**
     * 省份
     */
    @NotNull
    @NotBlank
    @Length(max = 60)
    private String province;
    /**
     * 城市
     */


    private String city = "";
    /**
     * 区县
     */
    private String county = "";
    /**
     * 乡镇
     */
    private String town = "";
    /**
     * 补充信息
     */
    @NotNull
    @NotBlank
    @Length(max = 200)
    private String detail;
    /**
     * 纬度
     */
    @NotNull
    private double latitude;
    /**
     * 精度
     */
    @NotNull
    private double longitude;
    /**
     * 偏好
     */
    @NotNull
    private Boolean prefer;
}
