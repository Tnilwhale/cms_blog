package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Article;
import top.skx1.cms_blog.entity.Channel;
import top.skx1.cms_blog.service.ArticleService;
import top.skx1.cms_blog.service.ChannelService;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ChannelService channelService;

    @PostMapping("/create")
    public Result create(@RequestBody Article article){
        article.setStatus(Article.status_1);
        articleService.create(article);
        return Result.ok(article);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        articleService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article){
        articleService.update(article);
        return Result.ok(article);
    }

    @PostMapping("/query")
    public Map query(@RequestBody Article article){
        PageInfo<Article> pageInfo = articleService.query(article);
        //查询文章的时候，关联查询栏目
        pageInfo.getList().forEach(entity -> {
            if(entity.getChannelId() != null){
                Channel detail = channelService.detail(entity.getChannelId());
                entity.setChannel(detail);
            }
        });
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        Article article = articleService.detail(id);
        return Result.ok(article);
    }

    @PostMapping("/count")
    public Result count(@RequestBody Article article){
        Integer count = articleService.count(article);
        return Result.ok(count);
    }

}
