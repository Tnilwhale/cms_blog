package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Tag;
import top.skx1.cms_blog.service.TagService;
import top.skx1.cms_blog.utils.RequestUtils;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/*
 * @Author shaokexiang
 * @Date 2021/4/1 11:17
 * @Description //TODO
 * @Param 
 * @return 
 **/

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/create")
    public Result create(@RequestBody Tag tag){
        tagService.create(tag);
        return Result.ok(tag);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        tagService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Tag tag){
        tagService.update(tag);
        return Result.ok(tag);
    }

    @PostMapping("/query")
    public Map query(@RequestBody Tag tag){
        PageInfo<Tag> pageInfo = tagService.query(tag);
        return Result.ok(pageInfo);
    }

    @PostMapping("/all")
    public Result all(){
        return Result.ok(tagService.all());
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        Tag tag = tagService.detail(id);
        return Result.ok(tag);
    }

    @PostMapping("/count")
    public Result count(@RequestBody Tag tag){
        Integer count = tagService.count(tag);
        return Result.ok(count);
    }

}
