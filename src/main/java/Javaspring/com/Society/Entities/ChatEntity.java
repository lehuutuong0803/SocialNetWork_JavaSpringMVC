package Javaspring.com.Society.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class ChatEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_id")
	private UserEntity source;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_id")
	private UserEntity target;
	
	@Column(name = "content")
	private String content;
	

	@Column(name = "createat")
	private Date createAt;
	
	@Column(name = "box_id")
	private long boxid;
	


	
	public ChatEntity() {
		super();
	}


	public ChatEntity(long id, UserEntity source, UserEntity target, String content, Date createAt) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.content = content;
		this.createAt = createAt;
	}


	




	public long getBoxid() {
		return boxid;
	}


	public void setBoxid(long boxid) {
		this.boxid = boxid;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public UserEntity getSource() {
		return source;
	}


	public void setSource(UserEntity source) {
		this.source = source;
	}


	public UserEntity getTarget() {
		return target;
	}


	public void setTarget(UserEntity target) {
		this.target = target;
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
