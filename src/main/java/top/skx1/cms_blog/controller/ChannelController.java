package top.skx1.cms_blog.controller;

import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Channel;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.service.ChannelService;
import top.skx1.cms_blog.utils.RequestUtils;
import top.skx1.cms_blog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/create")
    public Result create(@RequestBody Channel channel,HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        channel.setCreateUser(user.getId());
        if(channel.getParentId() == null){
            channel.setParentId(0);
        }
        channelService.create(channel);
        return Result.ok(channel);
    }

    @PostMapping("/delete")
    public Result delete(Integer id){
        channelService.delete(id);
        return Result.ok();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Channel channel){
        channelService.update(channel);
        return Result.ok(channel);
    }

    @PostMapping("/query")
    public Map query(@RequestBody Channel channel){
        PageInfo<Channel> pageInfo = channelService.query(channel);
        //遍历，将所有栏目的父栏目传到前端，然后在前端显示父栏目信息
        for (Channel entity : pageInfo.getList()) {
            if(entity.getParentId() != null && entity.getParentId()>0){
                //获取parent栏目
                Channel parent = channelService.detail(entity.getParentId());
                entity.setParent(parent);
            }
        }
        return Result.ok(pageInfo);
    }

    @PostMapping("/tree")
    public Result tree(){
        List<Channel> list = channelService.all();
        List<Map<String,Object>> mapList = new ArrayList<>();
        for (Channel channel : list) {
            //首先获取顶级栏目（递归）
            if(channel.getParentId() == 0){
                Map<String,Object> map = new HashMap<>();
                map.put("id",channel.getId());
                map.put("label",channel.getName());
                List<Map<String,Object>> children = new ArrayList<>();
                for (Channel entity : list) {
                    if(entity.getParentId() == channel.getId()){
                        Map<String,Object> subMap = new HashMap<>();
                        subMap.put("id",entity.getId());
                        subMap.put("label",entity.getName());
                        children.add(subMap);
                    }
                }
                map.put("children",children);
                mapList.add(map);
            }
        }
        return Result.ok(mapList);
    }






    @PostMapping("/detail")
    public Result detail(Integer id){
        Channel channel = channelService.detail(id);
        return Result.ok(channel);
    }

    @PostMapping("/count")
    public Result count(@RequestBody Channel channel){
        Integer count = channelService.count(channel);
        return Result.ok(count);
    }
}
