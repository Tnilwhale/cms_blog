package top.skx1.cms_blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import top.skx1.cms_blog.utils.Entity;

import java.util.Date;
/*
 * @Author shaokexiang
 * @Date 2021/1/29 11:28
 * @Description //TODO
 * @Param
 * @return 
 **/    
public class User extends Entity {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private String avatar;
    private String email;
    private Date createDate;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public String getPassWord() {
//        return password;
//    }
//
//    public void setPassWord(String password) {
//        this.password = password;
//    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore
    public Date getCreateDate() {
        return createDate;
    }
    @JsonProperty
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

