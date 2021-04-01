package top.skx1.cms_blog.entity;

import top.skx1.cms_blog.utils.Entity;
import java.util.Date;


/**
 * @author 596183363@qq.com
 * @time 2020-10-27 16:01:24
 */
public class ArticleView extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer articleId;
	/**
	 * 
	 */
	private Date viewDate;
	/**
	 * 
	 */
	private String ip;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Date getViewDate() {
		return viewDate;
	}
	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}