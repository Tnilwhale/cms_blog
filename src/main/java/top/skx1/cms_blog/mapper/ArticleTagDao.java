package top.skx1.cms_blog.mapper;

import java.util.List;
import java.util.Map;

import top.skx1.cms_blog.entity.ArticleTag;

public interface ArticleTagDao {
	public int create(ArticleTag pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<ArticleTag> query(Map<String, Object> paramMap);
	public ArticleTag detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}