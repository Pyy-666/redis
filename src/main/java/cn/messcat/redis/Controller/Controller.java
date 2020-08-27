package cn.messcat.redis.Controller;

import cn.messcat.redis.Service.ApplyCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ApplyCostService applyCostService;

    @RequestMapping("/test")
    public Object test(){
       return applyCostService.queryAll();
    }

    @RequestMapping("/test2/{id}")
    public Object test2(@PathVariable int id){
        return applyCostService.findUserById(id);
    }
}
