package com.cookie.reggie.dto;

import com.cookie.reggie.entity.Setmeal;
import com.cookie.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
