package net.hk.mvcc.controller;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by Administrator on 2017/1/17.
 */
public abstract class BaseController implements ServletContextAware{

    protected static final String JSON_VIEW = "jsonView";

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
