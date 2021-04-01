package top.skx1.cms_blog.mapper;

import top.skx1.cms_blog.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public int create(User user);
    public int delete(Map<String, Object> paramMap);
    public int update(Map<String, Object> paramMap);
    public List<User> query(Map<String, Object> paramMap);
    public User detail(Map<String, Object> paramMap);
    public int count(Map<String, Object> paramMap);




}
