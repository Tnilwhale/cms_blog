package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleTag;
import top.skx1.cms_blog.service.ArticleTagService;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/articleTag")
public class ArticleTagController {

    @Autowired
    private ArticleTagService articleTagService;

    @PostMapping("/create")
    public Result create(@RequestBody ArticleTag articleTag){
        articleTagService.create(articleTag);
        return Result.ok(articleTag);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        articleTagService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ArticleTag articleTag){
        articleTagService.update(articleTag);
        return Result.ok(articleTag);
    }

    @PostMapping("/query")
    public Map query(@RequestBody ArticleTag articleTag){
        PageInfo<ArticleTag> pageInfo = articleTagService.query(articleTag);
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        ArticleTag articleTag = articleTagService.detail(id);
        return Result.ok(articleTag);
    }

    @PostMapping("/count")
    public Result count(@RequestBody ArticleTag articleTag){
        Integer count = articleTagService.count(articleTag);
        return Result.ok(count);
    }

}
