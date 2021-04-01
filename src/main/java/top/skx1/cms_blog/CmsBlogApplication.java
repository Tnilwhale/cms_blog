package top.skx1.cms_blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.skx1.cms_blog.mapper")
public class CmsBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsBlogApplication.class, args);
    }

}
