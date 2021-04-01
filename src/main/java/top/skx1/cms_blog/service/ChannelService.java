package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Channel;
import top.skx1.cms_blog.mapper.ChannelDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelDao channelDao;

    public int create(Channel channel){
        return channelDao.create(channel);
    }

    public int delete(Integer id){
        return channelDao.delete(Maps.build(id).getMap());
    }

    public int update(Channel channel){
        return channelDao.update(Maps.build(channel.getId()).beanToMapForUpdate(channel));
    }

    public PageInfo<Channel> query(Channel channel){
        if(channel != null && channel.getPage() != null){
            PageHelper.startPage(channel.getPage(),channel.getLimit());
        }
        List<Channel> list = channelDao.query(Maps.build().beanToMap(channel));
        return new PageInfo<Channel>(list);
    }

    public List<Channel> getChannelByPos(String pos){
        List<Channel> list = channelDao.query(Maps.build().put("pos",pos).getMap());
        return list;
    }

    public List<Channel> all(){
        List<Channel> list = channelDao.query(Maps.build().getMap());
        return list;
    }

    public Channel detail(Integer id){
        return channelDao.detail(Maps.build(id).getMap());
    }

    public int count(Channel channel){
        return channelDao.count(Maps.build().beanToMap(channel));
    }




}
