package top.skx1.cms_blog.mapper;

import java.util.List;
import java.util.Map;

import top.skx1.cms_blog.entity.Channel;

public interface ChannelDao {
	public int create(Channel pi);
	public int delete(Map<String, Object> paramMap);
	public int update(Map<String, Object> paramMap);
	public List<Channel> query(Map<String, Object> paramMap);
	public Channel detail(Map<String, Object> paramMap);
	public int count(Map<String, Object> paramMap);
}