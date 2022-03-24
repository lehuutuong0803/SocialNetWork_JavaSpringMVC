package Javaspring.com.Society.DTO;


public class OutputMessage {


	private String userid;
	private String friendid;
	private String boxid;
	private String content;
	private String useravatar;
	private String friendavatar;
    private String time;
    
    
	public OutputMessage() {
		super();
	}

	public OutputMessage(String userid, String friendid, String boxid, String content, String useravatar,
			String friendavatar, String time) {
		super();
		this.userid = userid;
		this.friendid = friendid;
		this.boxid = boxid;
		this.content = content;
		this.useravatar = useravatar;
		this.friendavatar = friendavatar;
		this.time = time;
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


	public String getUseravatar() {
		return useravatar;
	}


	public void setUseravatar(String useravatar) {
		this.useravatar = useravatar;
	}


	public String getFriendavatar() {
		return friendavatar;
	}


	public void setFriendavatar(String friendavatar) {
		this.friendavatar = friendavatar;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	
    
    
}
