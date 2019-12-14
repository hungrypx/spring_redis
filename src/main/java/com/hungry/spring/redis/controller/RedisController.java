package com.hungry.spring.redis.controller;

import com.hungry.spring.redis.service.IRedisOper;
import com.hungry.spring.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.HashSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisService redis ;
    public RedisController(IRedisOper redisOper)
    {
        redis = (RedisService) redisOper;
    }
    @RequestMapping("/Create")
    public  String  Create()
    {
        String key = "hgy";
        HashMap<String,String> kv = new HashMap<>();
        kv.put("age","30");
        kv.put("name","hungry");
        kv.put("gender","male");
        this.SaveHashMap(key,kv);
        return "Create Ok";
    }
    public   boolean SaveHashMap(String key , HashMap<String,String> kv)
    {
        boolean ret = true;
        for (String name : kv.keySet())
        {
            ret = redis.hSet(key,name,kv.get(name));
            if( ret == false)
            {
                return false;
            }
        }
        return true;
    }
    @RequestMapping("/Get")
    public  String Get()
    {
        String key = "hgy";
        HashSet<String> names = new HashSet<>();
        names.add("name");
        names.add("gender");
        names.add("address");
        names.add("age");
        return GetHashMap(key,names);
    }
    public  String GetHashMap(String key , HashSet<String> names)
    {
        StringBuilder sb = new StringBuilder();
        for (String name : names)
        {
            sb.append(name).append(":").append(redis.hGet(key,name)).append(" ");
        }
        return sb.toString();
    }
}
