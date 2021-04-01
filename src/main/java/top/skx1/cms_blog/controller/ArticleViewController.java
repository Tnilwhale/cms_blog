package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleView;
import top.skx1.cms_blog.service.ArticleViewService;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/articleView")
public class ArticleViewController {

    @Autowired
    private ArticleViewService articleViewService;

    @PostMapping("/create")
    public Result create(@RequestBody ArticleView articleView){
        articleViewService.create(articleView);
        return Result.ok(articleView);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        articleViewService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ArticleView articleView){
        articleViewService.update(articleView);
        return Result.ok(articleView);
    }

    @PostMapping("/query")
    public Map query(@RequestBody ArticleView articleView){
        PageInfo<ArticleView> pageInfo = articleViewService.query(articleView);
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        ArticleView articleView = articleViewService.detail(id);
        return Result.ok(articleView);
    }

    @PostMapping("/count")
    public Result count(@RequestBody ArticleView articleView){
        Integer count = articleViewService.count(articleView);
        return Result.ok(count);
    }

}
