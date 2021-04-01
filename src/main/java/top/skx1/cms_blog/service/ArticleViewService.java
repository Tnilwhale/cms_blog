package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleView;
import top.skx1.cms_blog.mapper.ArticleViewDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleViewService {

    @Autowired
    private ArticleViewDao articleViewDao;

    public int create(ArticleView articleView){
        return articleViewDao.create(articleView);
    }

    public int delete(Integer id){
        return articleViewDao.delete(Maps.build(id).getMap());
    }

    public int update(ArticleView articleView){
        return articleViewDao.update(Maps.build(articleView.getId()).beanToMapForUpdate(articleView));
    }

    public PageInfo<ArticleView> query(ArticleView articleView){
        if(articleView != null && articleView.getPage() != null){
            PageHelper.startPage(articleView.getPage(),articleView.getLimit());
        }
        List<ArticleView> list = articleViewDao.query(Maps.build().beanToMap(articleView));
        return new PageInfo<ArticleView>(list);
    }

    public ArticleView detail(Integer id){
        return articleViewDao.detail(Maps.build(id).getMap());
    }

    public int count(ArticleView articleView){
        return articleViewDao.count(Maps.build().beanToMap(articleView));
    }




}
