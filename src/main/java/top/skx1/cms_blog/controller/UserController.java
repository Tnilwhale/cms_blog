package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.service.UserService;
import top.skx1.cms_blog.utils.RequestUtils;
import top.skx1.cms_blog.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
 * @Author shaokexiang
 * @Date 2021/1/29 13:19
 * @Description //TODO
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Result create(@RequestBody User user){
        userService.create(user);
        return Result.ok(user);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        userService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.ok(user);
    }

    //需要返回值
    @PostMapping("/query")
    public Map query(@RequestBody User user){
        PageInfo<User> pageInfo = userService.query(user);
//        System.out.println(1/0);  //需全局异常捕获
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        User user = userService.detail(id);
        return Result.ok(user);
    }

    @PostMapping("/count")
    public Result count(@RequestBody User user){
        Integer count = userService.count(user);
        return Result.ok(count);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        //获取文件名的后缀
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1,originalFilename.length());
        //
        String newFilenamePrefix = UUID.randomUUID().toString();
        String newFileName = newFilenamePrefix+"."+ext;
        multipartFile.transferTo(new File("D:\\WebstormProjects\\cms_blog_vue\\upload",newFileName));
        //返回的是一个可以访问的全路径
        return Result.ok(RequestUtils.getBasePath(request)+"upload/"+newFileName);
    }


}
