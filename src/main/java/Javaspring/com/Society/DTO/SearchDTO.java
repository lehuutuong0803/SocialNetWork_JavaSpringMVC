package Javaspring.com.Society.DTO;

public class SearchDTO {
		public String Value;
		public long id_user;

		
		public SearchDTO() {
			super();
		}

		public SearchDTO(String value) {
			super();
			Value = value;
		}

		public String getValue() {
			return Value;
		}

		public void setValue(String value) {
			Value = value;
		}

		public long getId_user() {
			return id_user;
		}

		public void setId_user(long id_user) {
			this.id_user = id_user;
		}

	
		
}
