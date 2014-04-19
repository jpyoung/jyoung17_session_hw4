package com.business;

import javax.ejb.Remote;

import com.entity.EmContact;
import com.entity.Student;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645  HW2
 * 
 * Class Purpose:  This is the Interface for the DataBean.  
 * 
 */

@Remote
@WebService
public interface DataBeanRemote {
	
//	public boolean insertStudentSurveyRecord(Student newStudent,  EmContact emContact1, EmContact emContact2);

	@WebMethod
	public List<Student> searchByParameters(String last, String first, String cityy, String statee);
//	
//	 public boolean removeStudentRecord(int s_id);
//	
	@WebMethod
	public List<Student> retrieveAllSurveys();
	
}
