package com.grape.yeah.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.grape.yeah.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
