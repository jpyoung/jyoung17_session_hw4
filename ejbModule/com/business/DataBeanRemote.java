package com.business;

import javax.ejb.Remote;

import com.entity.EmContact;
import com.entity.Student;

import java.util.List;

/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645  HW2
 * 
 * Class Purpose:  This is the Interface for the DataBean.  
 * 
 */

@Remote
public interface DataBeanRemote {
	
	public boolean insertStudentSurveyRecord(Student newStudent,  EmContact emContact1, EmContact emContact2);

	public List<Student> searchByParameters(String last, String first, String cityy, String statee);
	
	 public boolean removeStudentRecord(int s_id);
	
	public List<Student> retrieveAllSurveys();
	
}