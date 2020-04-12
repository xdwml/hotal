package edu.xidian.dao.Impl;
import edu.xidian.dao.IFoodTypeDao;
import edu.xidian.entity.FoodType;
import edu.xidian.utils.JdbcUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.List;
/**
 * 2.菜系模块dao实现
 */
public class FoodTypeDao implements IFoodTypeDao {
    @Override
    public void delete(int id) {
        String sql="delete from foodType where id=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public FoodType findById(int id) {
        String sql="select * from foodType where id=?";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanHandler<FoodType>(FoodType.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll() {
        String sql="select * from foodType";
        try{
            return JdbcUtils.getQueryRunner().query(sql,new BeanListHandler<FoodType>(FoodType.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll(String typeName) {
        String sql="select * from foodType where typeName like ?";
        try{
            return JdbcUtils.getQueryRunner()
                    .query(sql,new BeanListHandler<FoodType>(FoodType.class),"%"+typeName+"%");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void save(FoodType foodType) {
        String sql="INSERT INTO foodType(typeName) VALUES(?);";
        try{
            JdbcUtils.getQueryRunner().update(sql,foodType.getTypeName());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FoodType foodType) {
        String sql="update foodType set typeName=? where id=?";
        try{
            JdbcUtils.getQueryRunner().update(sql,foodType.getTypeName(),foodType.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
