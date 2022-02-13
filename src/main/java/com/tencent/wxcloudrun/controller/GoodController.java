package com.tencent.wxcloudrun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.GoodRequest;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

/**
 * Good控制器
 */
@RestController
public class GoodController {

  final GoodService GoodService;
  final Logger logger;

  public GoodController(@Autowired GoodService GoodService) {
    this.GoodService = GoodService;
    this.logger = LoggerFactory.getLogger(GoodController.class);
  }

  /**
   * 获取商品列表
   * @return API response json
   */
  @GetMapping(value = "/api/goods")
  ApiResponse getGoods() {
    logger.info("/api/count get request");
    List<Good> Goods = GoodService.getGoods();
    return ApiResponse.ok(Goods);
  }

  /**
   * 获取商品
   * @return API response json
   */
  @GetMapping(value = "/api/goods/{id}")
  ApiResponse getGoodById(@PathVariable()Integer id) {
    logger.info("/api/count get request");
    Optional<Good> Good = GoodService.getGood(id);
    return ApiResponse.ok(Good);
  }
  
}
