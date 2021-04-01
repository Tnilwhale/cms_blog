package top.skx1.cms_blog.entity;

import com.sun.xml.internal.ws.api.message.Attachment;
import top.skx1.cms_blog.utils.Entity;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 
 * @author 596183363@qq.com
 * @time 2020-10-27 16:01:24
 */
public class Article extends Entity{

	//待审批
	public static Integer status_0 = 0;
	//已审批
	public static Integer status_1 = 1;
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer channelId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String titleImg;
	/**
	 * 
	 */
	private String summary;
	/**
	 * 
	 */
	private String author;
	/**
	 * 
	 */
	private String url;
	/**
	 * 
	 */
	private String content;
	/**
	 * 0待发布|1已发布
	 */
	private Integer status;
	/**
	 * 0/NULL允许评论|1不允许评论
	 */
	private Integer commentStatus;
	/**
	 * 0/NULL非轮播|1轮播
	 */
	private Integer rotation;
	/**
	 * 0/NULL不置顶 | 1 置顶
	 */
	private Integer top;
	/**
	 * 
	 */
	private Integer orderby;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Integer createUser;
	/**
	 * 
	 */
	private Date updateDate;

	private List<Map<String,Object>> attachmentList;

	private List<Integer> selectTagList;

	//关联栏目对象
	private Channel channel;

	//关联标签对象列表
	private List<Tag> tags;

	//关联附件对象列表
	private List<Attachment> attachments;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public Integer getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(Integer commentStatus) {
		this.commentStatus = commentStatus;
	}
	public Integer getRotation() {
		return rotation;
	}
	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<Integer> getSelectTagList() {
		return selectTagList;
	}

	public void setSelectTagList(List<Integer> selectTagList) {
		this.selectTagList = selectTagList;
	}

	public List<Map<String,Object>> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Map<String,Object>> attachmentList) {
		this.attachmentList = attachmentList;
	}


	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
}