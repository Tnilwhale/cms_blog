package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.skx1.cms_blog.entity.ArticleAttachment;
import top.skx1.cms_blog.mapper.ArticleAttachmentDao;
import top.skx1.cms_blog.utils.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleAttachmentService {

    @Autowired
    private ArticleAttachmentDao articleAttachmentDao;

    public int create(ArticleAttachment articleAttachment){
        return articleAttachmentDao.create(articleAttachment);
    }

    public int delete(Integer id){
        return articleAttachmentDao.delete(Maps.build(id).getMap());
    }

    public int update(ArticleAttachment articleAttachment){
        return articleAttachmentDao.update(Maps.build(articleAttachment.getId()).beanToMapForUpdate(articleAttachment));
    }

    public PageInfo<ArticleAttachment> query(ArticleAttachment articleAttachment){
        if(articleAttachment != null && articleAttachment.getPage() != null){
            PageHelper.startPage(articleAttachment.getPage(),articleAttachment.getLimit());
        }
        List<ArticleAttachment> list = articleAttachmentDao.query(Maps.build().beanToMap(articleAttachment));
        return new PageInfo<ArticleAttachment>(list);
    }

    public ArticleAttachment detail(Integer id){
        return articleAttachmentDao.detail(Maps.build(id).getMap());
    }

    public int count(ArticleAttachment articleAttachment){
        return articleAttachmentDao.count(Maps.build().beanToMap(articleAttachment));
    }




}
