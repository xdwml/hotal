package edu.xidian.dao;

import edu.xidian.entity.FoodType;

import java.util.List;

/**
 * 2.菜系模块，dao接口设计，用于解耦合
 
 
 */
public interface IFoodTypeDao {
    /**
     * 添加
     */
    void save(FoodType foodType);
    /**
     * 更新
     */
    void update(FoodType foodType);
    /**
     * 删除
     */
    void delete(int id);
    /**
     * 根据主键查询
     */
    FoodType findById(int id);
    /**
     * 查询全部
     */
    List<FoodType> getAll();
    /**
     * 根据菜系名称查询
     */
    List<FoodType> getAll(String typeName);



}
