package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleAttachment;
import top.skx1.cms_blog.service.ArticleAttachmentService;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/articleAttachment")
public class ArticleAttachmentController {

    @Autowired
    private ArticleAttachmentService articleAttachmentService;

    @PostMapping("/create")
    public Result create(@RequestBody ArticleAttachment articleAttachment){
        articleAttachmentService.create(articleAttachment);
        return Result.ok(articleAttachment);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        articleAttachmentService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ArticleAttachment articleAttachment){
        articleAttachmentService.update(articleAttachment);
        return Result.ok(articleAttachment);
    }

    @PostMapping("/query")
    public Map query(@RequestBody ArticleAttachment articleAttachment){
        PageInfo<ArticleAttachment> pageInfo = articleAttachmentService.query(articleAttachment);
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        ArticleAttachment articleAttachment = articleAttachmentService.detail(id);
        return Result.ok(articleAttachment);
    }

    @PostMapping("/count")
    public Result count(@RequestBody ArticleAttachment articleAttachment){
        Integer count = articleAttachmentService.count(articleAttachment);
        return Result.ok(count);
    }

}
