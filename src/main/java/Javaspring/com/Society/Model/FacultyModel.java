package Javaspring.com.Society.Model;

public class FacultyModel {
	private long id;
	private String facultyname;
	
	
	public FacultyModel() {
		super();
	}
	public FacultyModel(long id, String facultyname) {
		super();
		this.id = id;
		this.facultyname = facultyname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFacultyName() {
		return facultyname;
	}
	public void setFacultyName(String facultyname) {
		this.facultyname = facultyname;
	}
	
}
