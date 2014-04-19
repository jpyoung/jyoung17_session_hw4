package com.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmContact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@SequenceGenerator(name = "EMC_SEQ_SWE3", sequenceName="emc_seq_swe3", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "EMC_SEQ_SWE3")
//	@Column(unique = true, nullable = false)
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	private int e_id;
	private String eName;
	private String ePhone;
	private String eEmail;
	
//	@ManyToOne
//	 @JoinColumn(name="S_ID")
	private Student student;

	
	/**
	 * @return the e_id
	 */
	public int getE_id() {
		return e_id;
	}
	/**
	 * @param e_id the e_id to set
	 */
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}
	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}
	/**
	 * @return the ePhone
	 */
	public String getePhone() {
		return ePhone;
	}
	/**
	 * @param ePhone the ePhone to set
	 */
	public void setePhone(String ePhone) {
		this.ePhone = ePhone;
	}
	/**
	 * @return the eEmail
	 */
	public String geteEmail() {
		return eEmail;
	}
	/**
	 * @param eEmail the eEmail to set
	 */
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	/**
	 * @return the student
	 */
	@ManyToOne
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{" + e_id + "}{" + eName + "}{"
				+ ePhone + "}{" + eEmail + "}{" + student.getS_id() + "}";
	}


}
