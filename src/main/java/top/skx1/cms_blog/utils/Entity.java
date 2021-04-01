package top.skx1.cms_blog.utils;

/*
 * @Author shaokexiang
 * @Date 2021/2/2 11:28
 * @Description //TODO
 * @Param 
 * @return 
 **/
public class Entity {

    private Integer page;
    private Integer limit = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
