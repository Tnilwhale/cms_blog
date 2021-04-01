package top.skx1.cms_blog.controller;

import top.skx1.cms_blog.utils.RequestUtils;
import top.skx1.cms_blog.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
public class UploadController {


    @PostMapping("/uploadFile")
    public Result upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String originalFilename = multipartFile.getOriginalFilename();
        //获取文件名后缀
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".")+1,originalFilename.length());
        //
        String newFileNamePrefix = UUID.randomUUID().toString();
        String newFileName = newFileNamePrefix+"."+ext;
        multipartFile.transferTo(new File("F:\\upload",newFileName));
        //返回的是可以访问的一个全路径
        return Result.ok(RequestUtils.getBasePath(request)+"upload/"+newFileName);
    }

}
