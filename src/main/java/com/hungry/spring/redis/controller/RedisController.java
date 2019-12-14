package com.hungry.spring.redis.controller;

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
    private  void SaveHashMap(String key , HashMap<String,String> kv)
    {
        for (String name : kv.keySet())
        {
            redis.hmSet(key,name,kv.get(name));
        }
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
    private  String GetHashMap(String key , HashSet<String> names)
    {
        StringBuilder sb = new StringBuilder();
        for (String name : names)
        {
            sb.append(name).append(":").append(redis.hmGet(key,name)).append(" ");
        }
        return sb.toString();
    }
}
