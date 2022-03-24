package Javaspring.com.Society.DTO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class ChatDTO {

	private long id;
	private long source_id;
	private long target_id;
	private String content;
	private Date createAt;
	private long box_id;
	private String user_avatar;
	private String friend_avatar;
	private String date;
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	public String getFriend_avatar() {
		return friend_avatar;
	}
	public void setFriend_avatar(String friend_avatar) {
		this.friend_avatar = friend_avatar;
	}
	
	public long getBox_id() {
		return box_id;
	}
	public void setBox_id(long box_id) {
		this.box_id = box_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSource_id() {
		return source_id;
	}
	public void setSource_id(long source_id) {
		this.source_id = source_id;
	}
	public long getTarget_id() {
		return target_id;
	}
	public void setTarget_id(long target_id) {
		this.target_id = target_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
}
