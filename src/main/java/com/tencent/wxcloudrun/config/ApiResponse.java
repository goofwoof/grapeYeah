package com.tencent.wxcloudrun.config;

import lombok.Data;

import java.util.HashMap;

@Data
public final class ApiResponse {

  private String code;
  private String errorMsg;
  private Object data;

  private ApiResponse(String code, String errorMsg, Object data) {
    this.code = code;
    this.errorMsg = errorMsg;
    this.data = data;
  }
  
  public static ApiResponse ok() {
    return new ApiResponse("0", "", new HashMap<>());
  }

  public static ApiResponse ok(Object data) {
    return new ApiResponse("0", "", data);
  }

  public static ApiResponse error(String code, String errorMsg) {
    return new ApiResponse(code, errorMsg, new HashMap<>());
  }
}
