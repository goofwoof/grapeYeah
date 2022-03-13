package com.grape.yeah.controller;

import com.grape.yeah.config.ApiResponse;
import com.grape.yeah.service.BasketService;
import com.grape.yeah.model.Basket;
import org.hibernate.validator.constraints.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Basket控制器
 */
@RestController
public class BasketController {

  final BasketService Basketservice;
  final Logger logger;

  public BasketController(@Autowired BasketService Basketservice) {
    this.Basketservice = Basketservice;
    this.logger = LoggerFactory.getLogger(BasketController.class);
  }

  /**
   * 获取篮子列表
   *
   * @return API response json
   */
  @GetMapping(value = "/api/baskets")
  ApiResponse getBaskets() {
    logger.info("/api/count get request");
    List<Basket> Baskets = Basketservice.getBaskets();
    return ApiResponse.ok(Baskets);
  }

  /**
   * 新增
   *
   * @return API response json
   */
  @PostMapping(value = "/api/baskets")
  ApiResponse createBasket(
      @RequestParam("good") @Validated @NotNull Integer goodId,
      @RequestParam("quantity") @Validated @NotNull @Range(min = 1, max = 999) Integer quantity) {
    logger.info("/api/count get request");
    Basketservice.saveBasket(goodId, quantity);
    return ApiResponse.ok();
  }

  /**
   * 更新
   *
   * @return API response json
   */
  @PutMapping(value = "/api/baskets/{id}")
  ApiResponse updateBasketById(@PathVariable() Integer id,
      @RequestParam("quantity") @Validated @NotNull @Range(min = 1, max = 999) Integer quantity) {
    logger.info("/api/count get request");
    Basketservice.updateBasketById(id, quantity);
    return ApiResponse.ok();
  }

  /**
   * 删除
   *
   * @return API response json
   */
  @DeleteMapping(value = "/api/baskets/{id}")
  ApiResponse deleteBasketById(@PathVariable() Integer id) {
    logger.info("/api/count get request");
    Basketservice.deleteBasket(id);
    return ApiResponse.ok();
  }

  /**
   * 清除
   *
   * @return API response json
   */
  @DeleteMapping(value = "/api/baskets")
  ApiResponse deleteBaskets() {
    logger.info("/api/count get request");
    Basketservice.deleteBaskets();
    return ApiResponse.ok();
  }

}
