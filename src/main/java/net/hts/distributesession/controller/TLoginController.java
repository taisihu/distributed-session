package net.hts.distributesession.controller;

import common.MD5Util;
import io.netty.handler.codec.http.HttpResponse;
import net.hts.distributesession.model.TLogin;
import net.hts.distributesession.service.TLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/12.
 */
@Controller
@RequestMapping("user")
public class TLoginController {

    @Autowired
    TLoginService tLoginService;

    @RequestMapping("/login")
//    @ResponseBody
    public ModelAndView login(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session,
                        TLogin tLogin){

        ModelAndView view = new ModelAndView("jsonView");

        TLogin userInfo = null;
        String token = null;

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("token_".equals(cookie.getName())){
                token = cookie.getValue();
            }
        }
        //先根据cookie中的token获取redis中的用户信息
        userInfo = tLoginService.findTLoginBytoken(token);
        if (null == userInfo) {
            userInfo = tLoginService.findByUserName(response,tLogin);
        }
        if(null != userInfo){
            session.setAttribute("user", userInfo);
            view.addObject("code",1);
            view.addObject("msg","登录成功");
        }else{
            view.addObject("code",0);
            view.addObject("msg", "登录失败");
        }
        return view;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session){

        ModelAndView view = new ModelAndView("jsonView");

        Cookie[] cookies = request.getCookies();
        String token = null;
        for(Cookie cookie : cookies){
            if("token_".equals(cookie.getName())){
                token = cookie.getValue();
            }
        }

        session.removeAttribute("user");
        boolean delSucc = true;
        if(StringUtils.isNotEmpty(token)){
            delSucc = tLoginService.removeByToken(token);
        }
        if(delSucc){
//            session.removeAttribute("user");
            view.addObject("code",1);
            view.addObject("msg","登出成功");
        }else{
            view.addObject("code",0);
            view.addObject("msg","登出失败");
        }

        return view;

    }

}
