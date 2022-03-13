package com.grape.yeah.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.grape.yeah.config.UserContext;
import com.grape.yeah.dao.AddressMapper;
import com.grape.yeah.dto.AddressRequest;
import com.grape.yeah.model.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {
    final AddressMapper addressMapper;

    public AddressService(@Autowired AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public List<Address> getAddresses() {
        LambdaQueryWrapper<Address> query = new LambdaQueryWrapper<>();
        query.eq(Address::getUserId, UserContext.getOpenId());
        return addressMapper.selectList(query);
    }

    public int deleteAddress(Integer id) {
        LambdaQueryWrapper<Address> query = new LambdaQueryWrapper<>();
        query.eq(Address::getUserId, UserContext.getOpenId());
        query.eq(Address::getId, id);
        return addressMapper.delete(query);

    }

    private void clearPrefer() {
        LambdaUpdateWrapper<Address> query = new LambdaUpdateWrapper<>();
        query.eq(Address::getUserId, UserContext.getOpenId());
        query.set(Address::getPrefer, false);
        addressMapper.update(null, query);
    }

    public int updateAddressById(Integer id, AddressRequest addressRequest) {
        if (addressRequest.getPrefer()) {
            clearPrefer();
        }
        Address address = new Address();
        BeanUtils.copyProperties(addressRequest, address);
        LambdaUpdateWrapper<Address> query = new LambdaUpdateWrapper<>();
        query.eq(Address::getUserId, UserContext.getOpenId());
        query.eq(Address::getId, id);
        return addressMapper.update(address, query);
    }

    public void saveAddress(AddressRequest addressRequest) {
        if (addressRequest.getPrefer()) {
            clearPrefer();
        }
        Address newAddress = new Address();
        BeanUtils.copyProperties(addressRequest, newAddress);
        newAddress.setUserId(UserContext.getOpenId());
        addressMapper.insert(newAddress);
    }
}
