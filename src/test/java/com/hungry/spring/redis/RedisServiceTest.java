package com.hungry.spring.redis;
import com.hungry.spring.redis.service.RedisService;
import com.hungry.spring.redis.starter.SpringBootApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
public class RedisServiceTest {
    @Autowired
    RedisService redis;
    @Test
    public void testHashSetGet()
    {
        redis.hSet("key1","name1","value1");
        assertEquals("value1",redis.hGet("key1","name1"));
    }

}
