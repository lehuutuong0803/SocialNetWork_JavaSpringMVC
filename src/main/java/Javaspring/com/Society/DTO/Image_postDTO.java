package Javaspring.com.Society.DTO;

public class Image_postDTO {
	private long id;
	private long id_post;
	private String image;
	
	
	public Image_postDTO() {
		super();
	}
	public Image_postDTO(long id, long id_post, String image) {
		super();
		this.id = id;
		this.id_post = id_post;
		this.image = image;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_post() {
		return id_post;
	}
	public void setId_post(long id_post) {
		this.id_post = id_post;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
