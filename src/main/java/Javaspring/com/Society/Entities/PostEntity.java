package Javaspring.com.Society.Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "createAt")
	private Date createAt;
	
	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy = "post")
	private List<Image_PostEntity> image_post = new ArrayList<Image_PostEntity>();
	

	@OneToMany(mappedBy = "post")
	private List<Like_PostEntity> likepost = new ArrayList<Like_PostEntity>();
	
	@OneToMany(mappedBy = "post")
	private List<Comment_PostEntity> commentpost = new ArrayList<Comment_PostEntity>();
	

	public List<Like_PostEntity> getLikepost() {
		return likepost;
	}

	public void setLikepost(List<Like_PostEntity> likepost) {
		this.likepost = likepost;
	}

	public List<Image_PostEntity> getImage_post() {
		return image_post;
	}

	public void setImage_post(List<Image_PostEntity> image_post) {
		this.image_post = image_post;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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
	
}
