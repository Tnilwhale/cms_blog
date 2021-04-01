package top.skx1.cms_blog.mapper;

import java.util.List;
import java.util.Map;

import top.skx1.cms_blog.entity.Article;

public interface ArticleDao {
	public int create(Article pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<Article> query(Map<String, Object> paramMap);
	public List<Article> queryByChannelId(Integer channelId);
	public Article detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}