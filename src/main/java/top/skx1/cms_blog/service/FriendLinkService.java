package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.FriendLink;
import top.skx1.cms_blog.mapper.FriendLinkDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendLinkService {

    @Autowired
    private FriendLinkDao friendLinkDao;

    public int create(FriendLink friendLink){
        return friendLinkDao.create(friendLink);
    }

    public int delete(Integer id){
        return friendLinkDao.delete(Maps.build(id).getMap());
    }

    public int update(FriendLink friendLink){
        return friendLinkDao.update(Maps.build(friendLink.getId()).beanToMapForUpdate(friendLink));
    }

    public PageInfo<FriendLink> query(FriendLink friendLink){
        if(friendLink != null && friendLink.getPage() != null){
            PageHelper.startPage(friendLink.getPage(),friendLink.getLimit());
        }
        List<FriendLink> list = friendLinkDao.query(Maps.build().beanToMap(friendLink));
        return new PageInfo<FriendLink>(list);
    }

    public FriendLink detail(Integer id){
        return friendLinkDao.detail(Maps.build(id).getMap());
    }

    public int count(FriendLink friendLink){
        return friendLinkDao.count(Maps.build().beanToMap(friendLink));
    }




}
