package top.skx1.cms_blog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.framework.jwt.JWTUtil;
import top.skx1.cms_blog.service.UserService;
import top.skx1.cms_blog.utils.Maps;
import top.skx1.cms_blog.utils.Result;
import java.util.Map;

/*
 * @Author shaokexiang
 * @Date 2021/2/3 23:52
 * @Description //TODO
 * @Param
 * @return
 **/
@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){
        String userName = map.get("userName");
        String password = map.get("password");
        User user = userService.login(userName, password);
        if (user!=null){
            String token = JWTUtil.sign(user);
            return Result.ok(Maps.build().put("token",token).put("user",user).getMap());
        }else {
            return Result.fail("用户名或密码错误");
        }
    }
}
