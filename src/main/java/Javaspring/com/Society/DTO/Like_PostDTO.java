package Javaspring.com.Society.DTO;

public class Like_PostDTO {
		private long id;
		private long idpost;
		private long likeiduser;
		
		private long amount;
		private int status;
		
		
		
		public Like_PostDTO() {
			super();
		}
		public Like_PostDTO(long id, long idpost, long likeiduser) {
			super();
			this.id = id;
			this.idpost = idpost;
			this.likeiduser = likeiduser;
		}
		
		public long getAmount() {
			return amount;
		}
		public void setAmount(long amount) {
			this.amount = amount;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getIdpost() {
			return idpost;
		}
		public void setIdpost(long idpost) {
			this.idpost = idpost;
		}
		public long getLikeiduser() {
			return likeiduser;
		}
		public void setLikeiduser(long likeiduser) {
			this.likeiduser = likeiduser;
		}
		
		
}
