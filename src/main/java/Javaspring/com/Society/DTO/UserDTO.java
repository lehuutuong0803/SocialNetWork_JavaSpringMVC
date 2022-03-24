package Javaspring.com.Society.DTO;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	private long id;
	
	private String username;

	private String password;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private Date birthday;
	
	private String intro;
	
	private int gender;
	
	private Date createAt;
	
	private String avatar;
	
	private long id_Faculty;
	
	private String student_number;
	
	private String faculty_name;
	
	private String birthday_string;
	
	private int age;
	
	private int status;
	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	private MultipartFile[] file;

	
	
	
	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

	public UserDTO() {
		super();
	}



	public UserDTO(long id, String username, String password, String name, String phone, String email, Date birthday,
			String intro, int gender, Date createAt, String avatar, long id_Faculty, String student_number) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.intro = intro;
		this.gender = gender;
		this.createAt = createAt;
		this.avatar = avatar;
		this.id_Faculty = id_Faculty;
		this.student_number = student_number;
	}

	
	
	public String getBirthday_string() {
		return birthday_string;
	}

	public void setBirthday_string(String birthday_string) {
		this.birthday_string = birthday_string;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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



	public long getId_Faculty() {
		return id_Faculty;
	}

	public void setId_Faculty(long id_Faculty) {
		this.id_Faculty = id_Faculty;
	}

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	
	
}
