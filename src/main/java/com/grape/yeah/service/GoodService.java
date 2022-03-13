package com.grape.yeah.service;

import com.grape.yeah.dao.GoodsMapper;
import com.grape.yeah.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodService {

  final GoodsMapper goodsMapper;

  public GoodService(@Autowired GoodsMapper goodsMapper) {
    this.goodsMapper = goodsMapper;
  }

  public Optional<Good> getGood(Integer id) {
    return Optional.ofNullable(goodsMapper.selectById(id));
  }

  public List<Good> getGoods() {
    return goodsMapper.selectList(null);
  }
}
