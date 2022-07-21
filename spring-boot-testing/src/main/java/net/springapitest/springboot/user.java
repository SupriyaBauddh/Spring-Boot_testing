package net.springapitest.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String patientname;
	private String doctorname;

	public static Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
