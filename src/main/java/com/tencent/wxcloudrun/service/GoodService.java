package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Good;

import java.util.List;
import java.util.Optional;

public interface GoodService {

  Optional<Good> getGood(Integer id);

  List<Good> getGoods();
}
