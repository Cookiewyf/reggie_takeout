package com.cookie.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cookie.reggie.entity.AddressBook;
import com.cookie.reggie.mapper.AddressBookMapper;
import com.cookie.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;


@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
