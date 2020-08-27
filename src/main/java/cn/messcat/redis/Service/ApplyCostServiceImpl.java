package cn.messcat.redis.Service;

import cn.messcat.redis.Dao.ApplyCostDao;
import cn.messcat.redis.entity.ApplyCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyCostServiceImpl implements ApplyCostService{

    @Autowired
    private ApplyCostDao applyCostDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<ApplyCost> queryAll() {
        String key="list";
        ValueOperations<String, List> operations = redisTemplate.opsForValue();
        boolean hasKey=redisTemplate.hasKey(key);
        if(hasKey){
            long start = System.currentTimeMillis();
            List<ApplyCost> list=operations.get(key);
            System.out.println("==========从缓存中获得数据=========!!!!");
            long end = System.currentTimeMillis();
            System.out.println("查询redis花费的时间是:" + (end - start)+"s");
            return list;
        }else{
            long start = System.currentTimeMillis();
            List<ApplyCost> list=applyCostDao.queryAll();
            System.out.println("==========从数据库中获得数据=========!!!!");
            long end = System.currentTimeMillis();
            System.out.println("查询数据库花费的时间是:" + (end - start)+"s");
            operations.set(key,list);
            return list;
        }
    }

    @Override
    public ApplyCost findUserById(int id) {
        Integer key=id;
        ValueOperations<Integer,ApplyCost> operations=redisTemplate.opsForValue();
        boolean isKey=redisTemplate.hasKey(key);
        if(isKey){
            System.out.println("==========从缓存中获得数据=========");
            return operations.get(key);
        }else{
            operations.set(key,applyCostDao.findUserById(id));
            System.out.println("==========从数据库中获得数据=========");
            return applyCostDao.findUserById(id);
        }
    }
}
