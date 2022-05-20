package com.cookie.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cookie.reggie.entity.ShoppingCart;
import com.cookie.reggie.mapper.ShoppingCartMapper;
import com.cookie.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
