package com.cookie.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cookie.reggie.common.CustomException;
import com.cookie.reggie.entity.Category;
import com.cookie.reggie.entity.Dish;
import com.cookie.reggie.entity.Setmeal;
import com.cookie.reggie.mapper.CategoryMapper;
import com.cookie.reggie.service.CategoryService;
import com.cookie.reggie.service.DishService;
import com.cookie.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;


    /**
     * 根据id删除分类，删除之前需要进行判断
     *
     * @param id
     * @return
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishQueryWrapper);
        //查询当前分类是否关联了菜品，如果已经关联，抛出业务异常
        if (count1 > 0) {
            //已关联菜品，抛出一个业务异常
            throw new CustomException("当前分类下关联菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果已经关联，抛出业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count();
        if (count2>0){
            //已关联套餐，抛出一个业务异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //正常删除分类
        super.removeById(id);
    }


}
