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
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password", columnDefinition = "VARCHAR(500)")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "intro", columnDefinition = "TEXT")
	private String intro;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "createAt")
	private Date createAt;
	
	@Column(name = "avatar")
	private String avatar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id")
	private FacultyEntity faculty;
	
	@Column(name = "studentnumber")
	private String student_number;
	
	@OneToMany(mappedBy = "user")
	private List<PostEntity> post = new ArrayList<PostEntity>();
	
	@OneToMany(mappedBy = "source")
	private List<FriendEntity> source = new ArrayList<FriendEntity>();
	
	@OneToMany(mappedBy = "target")
	private List<FriendEntity> target = new ArrayList<FriendEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<Like_PostEntity> likeuser = new ArrayList<Like_PostEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<Comment_PostEntity> commentuser = new ArrayList<Comment_PostEntity>();
	
	@OneToMany(mappedBy = "source")
	private List<ChatEntity> commentsource  = new ArrayList<ChatEntity>();
	
	@OneToMany(mappedBy = "target")
	private List<ChatEntity> commentarget = new ArrayList<ChatEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<VideoCallEntity> videocalluser = new ArrayList<VideoCallEntity>();
	
//	@OneToMany(mappedBy = "user")
//	private List<ProductEntity> product_user = new ArrayList<ProductEntity>();
//	
	@OneToMany(mappedBy = "owner")
	private List<InvoiceEntity> owner = new ArrayList<InvoiceEntity>();
	
	@OneToMany(mappedBy = "buyer")
	private List<InvoiceEntity> buyer= new ArrayList<InvoiceEntity>();
	
	
	
	
	public List<ChatEntity> getCommentsource() {
		return commentsource;
	}

	public void setCommentsource(List<ChatEntity> commentsource) {
		this.commentsource = commentsource;
	}

	public List<ChatEntity> getCommentarget() {
		return commentarget;
	}

	public void setCommentarget(List<ChatEntity> commentarget) {
		this.commentarget = commentarget;
	}

	public List<VideoCallEntity> getVideocalluser() {
		return videocalluser;
	}

	public void setVideocalluser(List<VideoCallEntity> videocalluser) {
		this.videocalluser = videocalluser;
	}

	public List<Comment_PostEntity> getCommentuser() {
		return commentuser;
	}

	public void setCommentuser(List<Comment_PostEntity> commentuser) {
		this.commentuser = commentuser;
	}

	public List<FriendEntity> getSource() {
		return source;
	}

	public void setSource(List<FriendEntity> source) {
		this.source = source;
	}

	public List<FriendEntity> getTarget() {
		return target;
	}

	public void setTarget(List<FriendEntity> target) {
		this.target = target;
	}

	public List<Like_PostEntity> getLikeuser() {
		return likeuser;
	}

	public void setLikeuser(List<Like_PostEntity> likeuser) {
		this.likeuser = likeuser;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<PostEntity> getPost() {
		return post;
	}

	public void setPost(List<PostEntity> post) {
		this.post = post;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public FacultyEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyEntity faculty) {
		this.faculty = faculty;
	}

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	
	
}
