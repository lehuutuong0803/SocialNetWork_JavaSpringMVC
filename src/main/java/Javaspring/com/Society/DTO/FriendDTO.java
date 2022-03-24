package Javaspring.com.Society.DTO;

import java.sql.Date;

public class FriendDTO {
	
	private long id;
	private long sourceId;
	private long targetId;
	private Date createAt;
	private int status;
	
	
	public FriendDTO() {
		super();
	}
	public FriendDTO(long id, long sourceId, long targetId, Date createAt, int status) {
		super();
		this.id = id;
		this.sourceId = sourceId;
		this.targetId = targetId;
		this.createAt = createAt;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public long getTargetId() {
		return targetId;
	}
	public void setTargetId(long targetId) {
		this.targetId = targetId;
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
	
	
}
