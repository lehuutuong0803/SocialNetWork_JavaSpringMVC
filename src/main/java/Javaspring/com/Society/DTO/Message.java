package Javaspring.com.Society.DTO;


public class Message {

	private String userid;
	private String friendid;
	private String boxid;
	private String content;
	
	
	
	
	public Message() {
		super();
	}
	public Message(String userid, String friendid, String boxid, String content) {
		super();
		this.userid = userid;
		this.friendid = friendid;
		this.boxid = boxid;
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFriendid() {
		return friendid;
	}
	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}
	public String getBoxid() {
		return boxid;
	}
	public void setBoxid(String boxid) {
		this.boxid = boxid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

   
    
}
