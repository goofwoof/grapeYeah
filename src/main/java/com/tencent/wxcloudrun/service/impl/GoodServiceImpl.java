package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.GoodsMapper;
import com.tencent.wxcloudrun.model.Good;
import com.tencent.wxcloudrun.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

  final GoodsMapper GoodsMapper;

  public GoodServiceImpl(@Autowired GoodsMapper GoodsMapper) {
    this.GoodsMapper = GoodsMapper;
  }

  @Override
  public Optional<Good> getGood(Integer id) {
    return Optional.ofNullable(GoodsMapper.selectById(id));
  }

  @Override
  public List<Good> getGoods() {
    return GoodsMapper.selectList(null);
  }
}
