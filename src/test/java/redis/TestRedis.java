package redis;

import common.BaseJunit4Test;
import net.redis.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/7/16.
 */
public class TestRedis extends BaseJunit4Test {


    @Autowired
    private RedisService redisService;


    @Test
    public void testRedisSet(){

//        redisService.set("key_001","value_001");

    }

}
