package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleTag;
import top.skx1.cms_blog.mapper.ArticleTagDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagService {

    @Autowired
    private ArticleTagDao articleTagDao;

    public int create(ArticleTag tag){
        return articleTagDao.create(tag);
    }

    public int delete(Integer id){
        return articleTagDao.delete(Maps.build(id).getMap());
    }

    public int update(ArticleTag tag){
        return articleTagDao.update(Maps.build(tag.getId()).beanToMapForUpdate(tag));
    }

    public PageInfo<ArticleTag> query(ArticleTag tag){
        if(tag != null && tag.getPage() != null){
            PageHelper.startPage(tag.getPage(),tag.getLimit());
        }
        List<ArticleTag> list = articleTagDao.query(Maps.build().beanToMap(tag));
        return new PageInfo<ArticleTag>(list);
    }

    public ArticleTag detail(Integer id){
        return articleTagDao.detail(Maps.build(id).getMap());
    }

    public int count(ArticleTag tag){
        return articleTagDao.count(Maps.build().beanToMap(tag));
    }




}
