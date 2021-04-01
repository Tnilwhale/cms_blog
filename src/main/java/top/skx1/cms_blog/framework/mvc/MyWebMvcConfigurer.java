package top.skx1.cms_blog.framework.mvc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * @Author shaokexiang
 * @Date 2021/2/3 23:04
 * @Description //拦截器等
 * @Param
 * @return
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    //拦截器加入spring容器里
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //放行
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","static/**","/upload/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/WebstormProjects/cms_blog_vue/upload/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //上传文件可通过yml控制
    }

    //CorsFilter解决跨域请求问题
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许跨域请求的域名
        corsConfiguration.addAllowedOrigin("*");
        //设置允许的方法 get、post、put、delete
        corsConfiguration.addAllowedMethod("*");
        //允许任何头部
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addExposedHeader("token");

        //CorFilter依赖于urlBasedCorsConfigurationSource
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);

    }
}
