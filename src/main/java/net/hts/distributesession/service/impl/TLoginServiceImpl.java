package net.hts.distributesession.service.impl;

import common.MD5Util;
import common.UUIDUtil;
import net.hts.distributesession.mapper.TLoginMapper;
import net.hts.distributesession.model.TLogin;
import net.hts.distributesession.service.TLoginService;
import net.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/7/12.
 */
@Service
public class TLoginServiceImpl implements TLoginService {

    private static final String COOKIE_TOKEN_PREFIX = "token_";

    @Autowired
    private TLoginMapper tLoginMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public TLogin findByUserName(HttpServletResponse response,TLogin tLogin) {

        TLogin userInfo = tLoginMapper.findByUserName(tLogin.getUserName());

        if(null == userInfo){
            return null;
        }

        String pswd = userInfo.getPassword();
        String salt = userInfo.getSalt();//此盐值在注册时随机生成
        String inputPswd = MD5Util.clientPassToDbPass(pswd,salt);

        String dbPass = userInfo.getPassword();
        String handlerPass = MD5Util.clientPassToDbPass(dbPass, salt);

        if(!inputPswd.equals(handlerPass)){
//            throw new Exception("密码错误!"); TODO 此处需要定义自定义异常，然后在返回时统一处理,比如转成友好的信息返回用户-json
            return null;
        }

        //模拟会话
        String token = UUIDUtil.uuid();//生成唯一标识

        addCookie(response,token,tLogin);

        return userInfo;
    }

    @Override
    public TLogin findTLoginBytoken(String token){
        TLogin tLogin = redisService.get(token,TLogin.class);
        return tLogin;
    }

    private void addCookie(HttpServletResponse response,String token,TLogin tLogin){

        //存储到redis
        redisService.set(COOKIE_TOKEN_PREFIX,token,tLogin,TimeUnit.SECONDS,60*10);

        Cookie cookie = new Cookie(COOKIE_TOKEN_PREFIX,COOKIE_TOKEN_PREFIX+token);
        cookie.setMaxAge(60*10);
        cookie.setPath("/");

        response.addCookie(cookie);

    }

    @Override
    public boolean removeByToken(String token) {
        return redisService.removeByKey(token);
    }
}
