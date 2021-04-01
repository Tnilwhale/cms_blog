package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.Tag;
import top.skx1.cms_blog.mapper.TagDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * @Author shaokexiang
 * @Date 2021/4/1 11:41
 * @Description //TODO
 * @Param 
 * @return 
 **/
@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public int create(Tag tag){
        return tagDao.create(tag);
    }

    public int delete(Integer id){
        return tagDao.delete(Maps.build(id).getMap());
    }

    public int update(Tag tag){
        return tagDao.update(Maps.build(tag.getId()).beanToMapForUpdate(tag));
    }

    public PageInfo<Tag> query(Tag tag){
        if(tag != null && tag.getPage() != null){
            PageHelper.startPage(tag.getPage(),tag.getLimit());
        }
        List<Tag> list = tagDao.query(Maps.build().beanToMap(tag));
        return new PageInfo<Tag>(list);
    }

    public List<Tag> all(){
        List<Tag> list = tagDao.query(null);
        return list;
    }

    public Tag detail(Integer id){
        return tagDao.detail(Maps.build(id).getMap());
    }

    public int count(Tag tag){
        return tagDao.count(Maps.build().beanToMap(tag));
    }




}
