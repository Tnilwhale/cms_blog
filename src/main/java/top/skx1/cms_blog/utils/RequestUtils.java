package top.skx1.cms_blog.utils;

import javax.servlet.http.HttpServletRequest;

/*
 * @Author shaokexiang
 * @Date 2021/3/31 14:28
 * @Description //请求工具类
 * @Param 
 * @return 
 **/
public class RequestUtils {
    public static String getBasePath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return basePath;
    }
}
