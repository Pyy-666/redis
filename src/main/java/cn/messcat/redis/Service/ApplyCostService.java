package cn.messcat.redis.Service;

import cn.messcat.redis.entity.ApplyCost;

import java.util.List;

public interface ApplyCostService {
    List<ApplyCost> queryAll();

    ApplyCost findUserById(int id);
}
