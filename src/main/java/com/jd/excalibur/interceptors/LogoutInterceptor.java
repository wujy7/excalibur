package com.jd.excalibur.interceptors;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jd.excalibur.common.CateCache;
import com.jd.excalibur.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


public class LogoutInterceptor implements HandlerInterceptor {

    private final static String LoggingPath = "/logging/index.html";

    private Cache<String, String> cateCache = CateCache.getSingleton().getCateCache();

    private final static String BLANK = "blank";

    private final static String SESSION = "session";

    String SESSION_KEY = "sessionId";

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (loggingVerify(request)){
            return true;
        }else {
            response.sendRedirect(LoggingPath);
            return false;
        }
    }


    private boolean loggingVerify(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        boolean boo = false;
        if (cookies!=null){
            boo = Arrays.stream(cookies).
                anyMatch(cookie ->{
                    if (cookie.getName().equalsIgnoreCase(SESSION_KEY)){
                        try {
                            String val = cateCache.get(cookie.getValue().toString(),() -> BLANK);
                            if (val.equals(SESSION)){
                                return true;
                            }
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }else{
                        return false;
                    }
                });
        }
        return boo;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
