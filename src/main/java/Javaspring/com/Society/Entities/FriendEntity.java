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
@Table(name = "friend")
public class FriendEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_id")
	private UserEntity source;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "target_id")
	private UserEntity target;
	
	@Column(name = "createAt")
	private Date createAt;
	
	@Column(name = "status")
	private int status;

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
