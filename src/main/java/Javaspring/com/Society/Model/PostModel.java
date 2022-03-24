package Javaspring.com.Society.Model;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PostModel {
	private long id;
	private long userID;
	private String content;
	private Date createAt;
	private int status;
	private List<MultipartFile> file;
	
	
	
	public PostModel() {
		super();
	}
	public PostModel(long id, long userID, String content, Date createAt, int status, List<MultipartFile> file) {
		super();
		this.id = id;
		this.userID = userID;
		this.content = content;
		this.createAt = createAt;
		this.status = status;
		this.file = file;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	
	
}
