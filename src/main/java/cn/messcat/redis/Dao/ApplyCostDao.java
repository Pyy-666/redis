package cn.messcat.redis.Dao;

import cn.messcat.redis.entity.ApplyCost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ApplyCostDao {
    List<ApplyCost> queryAll();

    ApplyCost findUserById(int id);
//
//    int updateUser(@Param("applyCost") ApplyCost applyCost);
//
//    int deleteUserById(int id);
}
