package edu.xidian.service.Impl;

import edu.xidian.dao.IFoodTypeDao;
import edu.xidian.dao.Impl.FoodTypeDao;
import edu.xidian.entity.FoodType;
import edu.xidian.factory.BeanFactory;
import edu.xidian.service.IFoodTypeService;

import java.util.List;

/**
 * 业务逻辑层接口实现
 */
public class FoodTypeService implements IFoodTypeService {
    //调用dao
    //private IFoodTypeDao foodTypeDao=new FoodTypeDao();//对象的创建，不能写死
    //工厂创建对象
    private IFoodTypeDao foodTypeDao= BeanFactory.getInstance("foodtypeDao", IFoodTypeDao.class);

    @Override
    public void delete(int id) {
        try{
            foodTypeDao.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    @Override
    public FoodType findById(int id) {
        try{
            return foodTypeDao.findById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll() {
        try{
            return foodTypeDao.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll(String typeName) {
        try{
            return foodTypeDao.getAll(typeName);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(FoodType foodType) {
        try{
            foodTypeDao.save(foodType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FoodType foodType) {
        try{
            foodTypeDao.update(foodType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
