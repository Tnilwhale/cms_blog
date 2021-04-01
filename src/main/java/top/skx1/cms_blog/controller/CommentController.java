package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Comment;
import top.skx1.cms_blog.service.CommentService;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Result create(@RequestBody Comment comment){
        commentService.create(comment);
        return Result.ok(comment);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        commentService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Comment comment){
        commentService.update(comment);
        return Result.ok(comment);
    }

    @PostMapping("/query")
    public Map query(@RequestBody Comment comment){
        PageInfo<Comment> pageInfo = commentService.query(comment);
        return Result.ok(pageInfo);
    }

    @PostMapping("/detail")
    public Result detail(Integer id){
        Comment comment = commentService.detail(id);
        return Result.ok(comment);
    }

    @PostMapping("/count")
    public Result count(@RequestBody Comment comment){
        Integer count = commentService.count(comment);
        return Result.ok(count);
    }

}
