package net.hts.distributesession.controller;

import common.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/7/24.
 */
@RequestMapping("accesslog")
@Controller
public class AccessLogController {

    private static final Logger logger = LoggerFactory.getLogger(AccessLogController.class);

    @RequestMapping("logip")
//    @ResponseBody
    public ModelAndView logAccess(HttpServletRequest request){

        ModelAndView view = new ModelAndView("jsonView");

        String ip = IpUtils.getIpAddr(request);

        logger.info("访问ip:" + ip);

        view.addObject("msg","访问成功");

        return view;

    }



}
