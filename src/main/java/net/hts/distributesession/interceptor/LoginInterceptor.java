package net.hts.distributesession.interceptor;

import net.hts.distributesession.model.TLogin;
import net.redis.RedisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/17.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("login.do")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        TLogin user = (TLogin)session.getAttribute("user");

        if(user == null){
            String token = null;
            Cookie[] cookies = request.getCookies();
            if(ArrayUtils.isEmpty(cookies)){
                return false;
            }
            for(Cookie cookie : cookies){
                if("token_".equals(cookie.getName())){
                    token = cookie.getValue();
                }
            }
            if(StringUtils.isNotEmpty(token)){
                user = redisService.get(token, TLogin.class);
                session.setAttribute("user",user);
                return true;
            }
        }

        if(user != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/html/login.html").forward(request, response);
        return false;
    }
}
