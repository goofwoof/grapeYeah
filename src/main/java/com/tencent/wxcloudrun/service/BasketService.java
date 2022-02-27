package com.tencent.wxcloudrun.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.tencent.wxcloudrun.config.UserContext;
import com.tencent.wxcloudrun.dao.BasketMapper;
import com.tencent.wxcloudrun.model.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    final BasketMapper basketMapper;

    public BasketService(@Autowired BasketMapper basketMapper) {
        this.basketMapper = basketMapper;
    }

    public List<Basket> getBaskets() {
        LambdaQueryWrapper<Basket> query = new LambdaQueryWrapper<>();
        query.eq(Basket::getUserId, UserContext.getOpenId());
        return basketMapper.selectList(query);
    }

    public int deleteBasket(Integer id) {
        LambdaQueryWrapper<Basket> query = new LambdaQueryWrapper<>();
        query.eq(Basket::getUserId, UserContext.getOpenId());
        query.eq(Basket::getId, id);
        return basketMapper.delete(query);

    }

    public int deleteBaskets() {
        LambdaQueryWrapper<Basket> query = new LambdaQueryWrapper<>();
        query.eq(Basket::getUserId, UserContext.getOpenId());
        return basketMapper.delete(query);
    }

    public int updateBasketById(Integer id, Integer quantity) {
        LambdaUpdateWrapper<Basket> query = new LambdaUpdateWrapper<>();
        query.eq(Basket::getUserId, UserContext.getOpenId());
        query.eq(Basket::getId, id);
        query.set(Basket::getQuantity, quantity);
        return basketMapper.update(null, query);

    }
}
