package com.wumengjun.redis.redisfirst.controller;

import com.wumengjun.redis.redisfirst.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRedis {

    @Autowired
    RedisDao redisDao;

    @RequestMapping("/helloredis")
    @ResponseBody
    public String hello(){//(String name, String age) {
        redisDao.setKey("name", "junjun");
        redisDao.setKey("age", "23");

        System.out.println("my name is=" + "junjun" + " * " + "and my age is=" + "23");

        String retName = redisDao.getValue("name");
        String retAge = redisDao.getValue("age");
        return "my name is="+retName  + " and my age is=" +retAge;
    }
}
