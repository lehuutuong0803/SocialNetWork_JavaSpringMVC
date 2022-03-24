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
@Table(name = "videocall")
public class VideoCallEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "roomcode")
	private String roomcode;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "createAt")
	private Date createAt;
	
	@Column(name = "status")
	private int status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;


	public VideoCallEntity() {
		super();
	}

	
	



	public VideoCallEntity(long id, String roomcode, int amount, Date createAt, int status, UserEntity user) {
		super();
		this.id = id;
		this.roomcode = roomcode;
		this.amount = amount;
		this.createAt = createAt;
		this.status = status;
		this.user = user;
	}






	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getRoomcode() {
		return roomcode;
	}




	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
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






	public UserEntity getUser() {
		return user;
	}






	public void setUser(UserEntity user) {
		this.user = user;
	}






	
	
	
}
