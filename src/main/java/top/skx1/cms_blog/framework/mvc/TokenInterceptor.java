package top.skx1.cms_blog.framework.mvc;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.framework.exception.MyException;
import top.skx1.cms_blog.framework.jwt.JWTUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @Author shaokexiang
 * @Date 2021/2/3 21:14
 * @Description //token拦截器
 * @Param
 * @return
 **/
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTUtil.token);
        User user = JWTUtil.getUser(token);
        if (user == null){
            throw new MyException("超时或不合法token");
        }
        //token续期

        String newToken = JWTUtil.sign(user);
        response.setHeader(JWTUtil.token,newToken);
        response.setHeader("Access-Control-Expose-Headers", JWTUtil.token);
        request.setAttribute("user",user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

