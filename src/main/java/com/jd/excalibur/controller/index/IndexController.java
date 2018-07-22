package com.jd.excalibur.controller.index;

import com.google.common.cache.Cache;
import com.jd.excalibur.common.CateCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @Autowired
    private Environment environment;

    private String logoutUrl;

    private Cache<String, String> cateCache = CateCache.getSingleton().getCateCache();

    private final static String SESSION = "session";

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public void excalibur(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/index.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping(value = "/Logging" ,method = RequestMethod.POST)
    public void Logging(HttpServletRequest request, HttpServletResponse response) {
        try {
        String a = (String) request.getParameter("logname");
        String b = (String) request.getParameter("logpass");
        UUID uuid = UUID.randomUUID();
        cateCache.put(uuid.toString(),SESSION);
        Cookie cookie = new Cookie("sessionId", uuid.toString());
        cookie.setMaxAge(-1);
        response.addCookie(cookie);

            response.sendRedirect(request.getContextPath()+"/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @PostConstruct
    public void init(){
        logoutUrl = environment.getProperty("logout.address") + "" + environment.getProperty("webapp.domain.name");
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "redirect:" + logoutUrl;
    }



}
