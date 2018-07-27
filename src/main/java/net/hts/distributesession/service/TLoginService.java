package net.hts.distributesession.service;

import net.hts.distributesession.model.TLogin;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/7/12.
 */
public interface TLoginService {

    TLogin findByUserName(HttpServletResponse response,TLogin tLogin);

    TLogin findTLoginBytoken(String token);

    boolean removeByToken(String token);

}
