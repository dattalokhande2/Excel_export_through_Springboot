package in.ashokit.Entity;

import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

import lombok.Data;
	@Data
	@ Entity
	@Table(name="COURSE_DTLS")
	public class Course {
	    @Id
		private Integer cid;
		private String cname;
		private Double price;

	}



