package com.grape.yeah.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.grape.yeah.model.Good;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Good> {
}
