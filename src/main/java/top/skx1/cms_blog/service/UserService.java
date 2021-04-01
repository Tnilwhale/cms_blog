package top.skx1.cms_blog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.skx1.cms_blog.entity.User;
import top.skx1.cms_blog.mapper.UserDao;
import top.skx1.cms_blog.utils.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author shaokexiang
 * @Date 2021/1/29 12:26
 * @Description //TODO
 * @Param 
 * @return 
 **/
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    public int create(User user){
        return userDao.create(user);
    }

    public int delete(Integer id){
        //支持链式调用
        return userDao.delete(Maps.build(id).getMap());
    }

    public int update(User user){
//        //对象转map过程较繁琐，转工具类
//        Map<String,Object> map =new HashMap<>();
//        map.put("id",user.getId());
//        map.put("userName",user.getUserName());
        return userDao.update(Maps.build(user.getId()).beanToMapForUpdate(user));
    }

    public PageInfo<User> query(User user){
        if(user != null&& user.getPage() != null){
            PageHelper.startPage(user.getPage(),user.getLimit());
        }
        List<User> list = userDao.query(Maps.build().beanToMap(user));
        return new PageInfo<User>(list);
    }

    public User login(String userName,String password){
        return userDao.detail(Maps.build().put("userName",userName).put("password",password).getMap());
    }

    public User detail(Integer id){
        return userDao.detail(Maps.build(id).getMap());
    }

    public int count(User user){
        return userDao.count(Maps.build().beanToMap(user));
    }

}
