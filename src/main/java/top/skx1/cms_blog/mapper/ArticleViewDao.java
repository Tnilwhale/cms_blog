package top.skx1.cms_blog.mapper;

import java.util.List;
import java.util.Map;

import top.skx1.cms_blog.entity.ArticleView;

public interface ArticleViewDao {
	public int create(ArticleView pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<ArticleView> query(Map<String, Object> paramMap);
	public ArticleView detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}