package top.skx1.cms_blog.entity;

import top.skx1.cms_blog.utils.Entity;
import java.util.Date;



public class Comment extends Entity{

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String author;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String ip;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private String content;
	/**
	 * 0待批|1通过|2未通过
	 */
	private Integer status;
	/**
	 * 
	 */
	private Integer articleId;
	/**
	 * 
	 */
	private Integer parentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}