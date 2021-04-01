package top.skx1.cms_blog.entity;


import top.skx1.cms_blog.utils.Entity;

/*
 * @Author shaokexiang
 * @Date 2021/4/1 10:22
 * @Description //TODO
 * @Param 
 * @return 
 **/
public class Tag extends Entity {

    private Integer id;
    private String tagName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
