package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author Jack Young
 * @date February 07, 2014
 * SWE 645
 * 
 * Class Purpose: This class contains the fields/attributes that were
 * specified in the instructions.  These attributes match the fields on
 * the student survey form.  
 * 
 */

@Entity
public class Student implements Serializable  {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	private int s_id;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private String dataOfSurvey;
	private String likedAboutCampus;
	private String originOfInterest;
	private String likelyhoodOfRecommendation;
	private String raffle;
	private String comments;
	
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	private List<EmContact> emContacts = new ArrayList<EmContact>();
	
	
	/**
	 * @return the emContacts
	 */
	public List<EmContact> getEmContacts() {
		return emContacts;
	}


	/**
	 * @param emContacts the emContacts to set
	 */
	public void setEmContacts(List<EmContact> emContacts) {
		this.emContacts = emContacts;
	}


	/**
	 * No arg Constructor
	 */
	public Student() {
		this.s_id = 0;
		this.firstName = "";
		this.lastName = "";
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.telephoneNumber = "";
		this.email = "";
		this.dataOfSurvey = "";
		this.likedAboutCampus = "";
		this.originOfInterest = "";
		this.likelyhoodOfRecommendation = "";
		this.raffle = "";
		this.comments = "";
	}
	
	
	/**
	 * Arg Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param zip
	 * @param telephoneNumber
	 * @param email
	 * @param dataOfSurvey
	 * @param likedAboutCampus
	 * @param originOfInterest
	 * @param likelyhoodOfRecommendation
	 * @param raffle
	 * @param comments
	 */
	public Student(String firstName, String lastName, String streetAddress,
			String city, String state, String zip, String telephoneNumber,
			String email, String dataOfSurvey, String likedAboutCampus,
			String originOfInterest, String likelyhoodOfRecommendation,
			String raffle, String comments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.dataOfSurvey = dataOfSurvey;
		this.likedAboutCampus = likedAboutCampus;
		this.originOfInterest = originOfInterest;
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
		this.raffle = raffle;
		this.comments = comments;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dataOfSurvey
	 */
	public String getDataOfSurvey() {
		return dataOfSurvey;
	}
	/**
	 * @param dataOfSurvey the dataOfSurvey to set
	 */
	public void setDataOfSurvey(String dataOfSurvey) {
		this.dataOfSurvey = dataOfSurvey;
	}

	/**
	 * @return the originOfInterest
	 */
	public String getOriginOfInterest() {
		return originOfInterest;
	}
	/**
	 * @param originOfInterest the originOfInterest to set
	 */
	public void setOriginOfInterest(String originOfInterest) {
		this.originOfInterest = originOfInterest;
	}
	/**
	 * @return the likelyhoodOfRecommendation
	 */
	public String getLikelyhoodOfRecommendation() {
		return likelyhoodOfRecommendation;
	}
	/**
	 * @param likelyhoodOfRecommendation the likelyhoodOfRecommendation to set
	 */
	public void setLikelyhoodOfRecommendation(String likelyhoodOfRecommendation) {
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
	}
	/**
	 * @return the raffle
	 */
	public String getRaffle() {
		return raffle;
	}
	/**
	 * @param raffle the raffle to set
	 */
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the s_id
	 */
	public int getS_id() {
		return s_id;
	}

	/**
	 * @param s_id the s_id to set
	 */
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	
	

	/**
	 * @return the likedAboutCampus
	 */
	public String getLikedAboutCampus() {
		return likedAboutCampus;
	}


	/**
	 * @param likedAboutCampus the likedAboutCampus to set
	 */
	public void setLikedAboutCampus(String likedAboutCampus) {
		this.likedAboutCampus = likedAboutCampus;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", streetAddress=" + streetAddress
				+ ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", telephoneNumber=" + telephoneNumber + ", email=" + email
				+ ", dataOfSurvey=" + dataOfSurvey + ", likedAboutCampus="
				+ likedAboutCampus + ", originOfInterest=" + originOfInterest
				+ ", likelyhoodOfRecommendation=" + likelyhoodOfRecommendation
				+ ", raffle=" + raffle + ", comments=" + comments
				+ ", emContacts=" + emContacts + "]";
	}




}

