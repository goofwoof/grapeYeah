package com.grape.yeah.controller;

import com.grape.yeah.config.ApiResponse;
import com.grape.yeah.model.Address;
import com.grape.yeah.service.AddressService;
import com.grape.yeah.dto.AddressRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Basket控制器
 */
@RestController
public class AddressController {

  final AddressService addressService;
  final Logger logger;

  public AddressController(@Autowired AddressService addressesService) {
    this.addressService = addressesService;
    this.logger = LoggerFactory.getLogger(AddressController.class);
  }

  /**
   * 获取地址列表
   *
   * @return API response json
   */
  @GetMapping(value = "/api/addresses")
  ApiResponse getAddresses() {
    List<Address> addresses = addressService.getAddresses();
    return ApiResponse.ok(addresses);
  }

  /**
   * 新增
   *
   * @return API response json
   */
  @PostMapping(value = "/api/addresses")
  ApiResponse createAddress(@Validated AddressRequest addressRequest) {
    addressService.saveAddress(addressRequest);
    return ApiResponse.ok();
  }

  /**
   * 更新
   *
   * @return API response json
   */
  @PutMapping(value = "/api/addresses/{id}")
  ApiResponse updateBasketById(@PathVariable() Integer id,
      @Validated AddressRequest addressRequest) {
    addressService.updateAddressById(id, addressRequest);
    return ApiResponse.ok();
  }

  /**
   * 删除
   *
   * @return API response json
   */
  @DeleteMapping(value = "/api/addresses/{id}")
  ApiResponse deleteBasketById(@PathVariable() Integer id) {
    addressService.deleteAddress(id);
    return ApiResponse.ok();
  }
}
