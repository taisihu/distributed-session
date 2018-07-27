package net.redis;

import com.alibaba.fastjson.JSON;
import net.hts.distributesession.model.TLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/16.
 */
@Component
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    private Jedis getJedis(){
        return jedisPool.getResource();
    }

    public <T> boolean set(String prefix,String token,T value,TimeUnit unit,int time){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            String str = beanToString(value);
            if(str == null){
                return false;
            }
            String realKey = prefix+token;
            int seconds = time;
            if(seconds <= 0){
                jedis.set(realKey,str);
            }else{
                jedis.setex(realKey,seconds,str);
            }
            return true;
        }catch (Exception e){

        }finally {
            returnToPool(jedis);
        }
        return false;
    }

    public <T> T get(String token,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            Object obj = jedis.get(token);
            return stringToBean(obj.toString(),clazz);
        }catch (Exception e){

        }
        return null;
    }

    private <T> String beanToString(T value){

        if(null == value){
            return  null;
        }

        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return "" + value;
        }else if(clazz == String.class){
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class){
            return "" + value;
        }else{
            return JSON.toJSONString(value);
        }
    }

    private <T> T stringToBean(String str,Class<T> clazz){
        if(null == str || str.length()<=0 || null == clazz){
            return null;
        }

        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }

    }

    private void returnToPool(Jedis jedis){
        if(null != jedis){
            jedis.close();
        }
    }

    public boolean removeByKey(String key){
        Jedis jedis = getJedis();
        long deleted = jedis.del(key);
        if(deleted>0){
            return true;
        }
        return false;
    }
}
