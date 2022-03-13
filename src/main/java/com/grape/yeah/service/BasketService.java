package com.grape.yeah.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.grape.yeah.config.ErrorCode;
import com.grape.yeah.config.UserContext;
import com.grape.yeah.exception.BusinessException;
import com.grape.yeah.dao.BasketMapper;
import com.grape.yeah.model.Basket;
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

    public void saveBasket(Integer goodId, Integer quantity) {
        LambdaQueryWrapper<Basket> query = new LambdaQueryWrapper<>();
        query.eq(Basket::getUserId, UserContext.getOpenId());
        query.eq(Basket::getGoodId, goodId);
        Basket basket = basketMapper.selectOne(query);
        if (basket == null) {
            Basket newBasket = new Basket();
            newBasket.setGoodId(goodId);
            newBasket.setQuantity(quantity);
            newBasket.setUserId(UserContext.getOpenId());
            basketMapper.insert(newBasket);
        } else {
            int quantityResult = basket.getQuantity() + quantity;
            if (quantityResult < 1 || quantityResult > 999) {
                throw new BusinessException(ErrorCode.QUANTITY_OPERATE_ERROR);
            }
            updateBasketById(basket.getId(), basket.getQuantity() + quantity);
        }
    }
}
