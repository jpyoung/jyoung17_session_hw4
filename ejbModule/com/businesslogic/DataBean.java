package com.businesslogic;

import java.util.List;

import com.business.DataBeanRemote;
import com.entity.EmContact;
import com.entity.Student;

import javax.ejb.Stateless;

import com.entity.Criterion;

import java.util.ArrayList;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.jws.WebService;

/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645
 * 
 * Class Purpose: Session Bean implementation class DataBean.  This
 * is the EJB that the Web Application interacts with to gather the information
 * from the database.  
 * 
 */

@Stateless
@WebService
public class DataBean implements DataBeanRemote {

//    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
//    private static final String DB_CONNECTION = "jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g";
//    private static final String DB_USER = "jyoung17";
//    private static final String DB_PASSWORD = "Drpepper123";
//    private static final String DB_TABLE_NAME = "SURVEY_SWE645_HW2";
	
	
	
	
	
    /**
     * Default constructor. 
     */
    public DataBean() {
        // TODO Auto-generated constructor stub
    	
    }

	private static final String PERSISTENCE_UNIT_NAME = "studentss";
	private static EntityManagerFactory factory;

	
	
	
	
	  public List<String> retrieveAllSurveys() {
		  System.out.println("[INFO] - Method Called :=: retrieveAllSurveys");
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin(); 
		    Query q = em.createQuery("select t from Student t ORDER BY t.lastName");
		    q.setHint("eclipselink.refresh", "true");
		    @SuppressWarnings("unchecked")
			List<Student> s = q.getResultList();
		    
		    List<String> rt = new ArrayList<String>();
		    for (int i = 0; i < s.size(); i++) {
		    	System.out.println("" + s.get(i).toString());
				rt.add(s.get(i).toStringEncode());
			}
		    em.close();
		    return rt;
	  }

	  
	  public List<String> searchByParameters(String last, String first, String cityy, String statee) {
		  System.out.println("[INFO] - Method Called :=: searchByParameters : " + last + ":" + first +":" + cityy + ":" + statee);
		  String qq = createQueryString(last, first, cityy, statee);
		  System.out.println(qq);
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();
		    em.getTransaction().begin(); 
		    Query q = em.createNativeQuery(qq, Student.class);
		    //q.setParameter("firstname", "L");
		    q.setHint("eclipselink.refresh", "true");
		    @SuppressWarnings("unchecked")
			List<Student> s = q.getResultList();
		    
		    List<String> rt = new ArrayList<String>();
		    for (int i = 0; i < s.size(); i++) {
		    		System.out.println("" + s.get(i).toString());
				rt.add(s.get(i).toStringEncode());
			}
		    em.close();
		    return rt;
	  }
	  
	  
	  
//	  public boolean insertStudentSurveyRecord(Student newStudent) {
//		  	System.out.println("[INFO] - Method Called :=: insertStudentSurveyRecord");
//		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		    EntityManager em = factory.createEntityManager();
//		    em.getTransaction().begin(); 
//		    em.persist(newStudent);
//		    em.getTransaction().commit();
//		    em.close();
//		    return true;
//	  }
	  
//	  public boolean insertStudentSurveyRecord(Student newStudent,  EmContact emContact1, EmContact emContact2) {
//		  	System.out.println("[INFO] - Method Called :=: insertStudentSurveyRecord");
//		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		    EntityManager em = factory.createEntityManager();
//		    em.getTransaction().begin(); 
//		    
//		    Student tempStudent = newStudent;
//		    em.persist(tempStudent);
//		    
//
//		    
//		    if (emContact1 != null) {
//			   EmContact tempEM = emContact1;
//			   em.persist(tempEM);
//			   tempEM.setStudent(tempStudent);
//			   //tempStudent.getEmContacts().add(emContact);
//			   em.persist(tempEM);
//			   em.persist(tempStudent);
//		    }
//		    
//		    if (emContact2 != null) {
//			   EmContact tempEM = emContact2;
//			   em.persist(tempEM);
//			   tempEM.setStudent(tempStudent);
//			   //tempStudent.getEmContacts().add(emContact);
//			   em.persist(tempEM);
//			   em.persist(tempStudent);
//		    }
//		    
////		   EmContact tempEM = emContact;
////		   em.persist(tempEM);
////		   tempStudent.getEmContacts().add(emContact);
////		  
////		   em.persist(tempEM);
////		    em.persist(tempStudent);
//		    
//		
//		    em.getTransaction().commit();
//		    em.close();
//		    return true;
//	  }
	  
	  //this will remove the student from the database along with all of his or her emergency contacts
	  //if the id passed it find a match to delete it deletes it and returns true, else it returns false.
//	  public boolean removeStudentRecord(int s_id) {
//		  	System.out.println("[INFO] - Method Called :=: removeStudentRecord");
//		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//		    EntityManager em = factory.createEntityManager();
//		    em.getTransaction().begin(); 
//		    Query q = em.createQuery("select t from Student  t");
//		    @SuppressWarnings("unchecked")
//			List<Student> s = q.getResultList();
//		    boolean jobDone = false;
//		    for (int i = 0; i < s.size(); i++) {
//				if ( s.get(i).getS_id() == s_id) {
//					System.out.println("[Deleting This Record] :=: " + s.get(i));
//					em.remove(s.get(i));
//					em.getTransaction().commit();
//					jobDone = true;
//				}
//			}
//		    return jobDone;		    
//	  }
	  
	  

	  
		/**
	 * This method is used to build the query string based on the passed in inputs.
	 * 
	 * Example
	 * searchByParameters("", "Jack", "", "V*");
	 * Criterion [fieldName=firstname, rawSearchText=Jack, isValid=true, hasWildCard=false]firstname = 'Jack'
	 * Criterion [fieldName=state, rawSearchText=V*, isValid=true, hasWildCard=true]state like 'V%'
	 * Final Query:   =  select * from survey_swe645_hw2 where firstname = 'Jack' && state like 'V%'
	 * @param last
	 * @param first
	 * @param city
	 * @param state
	 * @return
	 */
	private String createQueryString(String last, String first, String city, String state) {
		Criterion c1 = new Criterion("lastname", last);
		Criterion c2 = new Criterion("firstname", first);
		Criterion c3 = new Criterion("city", city);
		Criterion c4 = new Criterion("state", state);
	
		ArrayList<Criterion> cr = new ArrayList<Criterion>();
		//only adding the valid params to the list for the query string
		if(c1.isValid()) cr.add(c1);
		if(c2.isValid()) cr.add(c2);
		if(c3.isValid()) cr.add(c3);
		if(c4.isValid()) cr.add(c4);
	
		char[] a = new char[]{(char)32, (char)42,(char)32}; String b = "";
		for (int i = 0; i < a.length; i++) { b += a[i]; }
		String query = "select" + b + "FROM Student";
		
		if (cr.size() > 0) {
			query += " where ";
		}
		for (int i = 0; i < cr.size(); i++) {
			query += cr.get(i).getQuerySyntax();
			if ((i+1) < cr.size()) {
				query += " and ";
			}
		}
		return query;
	}

//    /**
//     * This method is used for inserting a student survey record into the database.
//     * It accepts the student object as its param.  If the insert is successful it returns
//     * true, else it returns false.  
//     * 
//     * @param newStudent
//     * @return  bolean true for success and false for failure
//     */
//    public boolean insertStudentSurveyRecord(Student newStudent) {
//    		System.out.println("Inserting Student Survey as a Record into the DB.");
//    		String q = "INSERT INTO " + DB_TABLE_NAME + newStudent.queryInsertFormat();
//    		System.out.println(q);
//    		try {
//    			Connection con = establishConnection();
//    			Statement statement = con.createStatement();
//    			statement.executeUpdate(q);
//    			return true;
//    		} catch (SQLException e) {
//    			System.out.println("Error: InsertStudentSurveyRecord - Catch Statement.");
//    			return false;
//    		}
//    }
//	
//	
//    /**
//     * This method is used to establish a connection with the database.  If
//     * it is unable to create the connection it returns null, else it returns the
//     * connection.  
//     * 
//     * @return
//     */
////	private Connection establishConnection() {
////		InitialContext ic;
////		DataSource ds = null;
////		Connection con = null;
////		try {
////			ic = new InitialContext();
////			ds = (DataSource) ic.lookup("java:jboss/datasources/orSQL");
////			con = ds.getConnection("jyoung17", "Drpepper123");
////		} catch (Exception e) {
////			System.out.println("==EstablishConnection Failed==");
////			//e.printStackTrace();
////		}
////		if (con == null) {
////			System.out.println("Failed to make a connection");
////		} else {
////			System.out.println("Connection has been established");
////		}
////		return con;
////	}
//	
//	
//    /**
//     * This method is used to retrieve all the survey fields, it returns the results
//     * as a list of student objects.  
//     * 
//     * @return List of Students
//     * @throws SQLException
//     */
//    public List<Student> retrieveAllSurveys() {
//        	List<Student> allStudents = new ArrayList<Student>();
//        	String sqlQuery = "select * from survey_swe645_hw2 order by lastname";
//       
//        	try {
//        		
//        		Connection con = establishConnection();
//	    		Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sqlQuery);
//
//    	    	while (rs.next()) {
//    	    		@SuppressWarnings("unused")
//			String id = rs.getString("s_id");
//    	    		String firstName = rs.getString("firstName");
//    	    		String lastName = rs.getString("lastName");
//    	    		String streetAddress = rs.getString("streetAddress");
//    	    		String city = rs.getString("city");
//    	    		String state = rs.getString("state");
//    	    		String zip = rs.getString("zip");
//    	    		String telephoneNumber = rs.getString("telephoneNumber");
//    	    		String email = rs.getString("email");
//    	    		String dataOfSurvey = rs.getString("dataOfSurvey");
//    	    		String likedAboutCampus = rs.getString("likedAboutCampus");
//    	    		String originOfInterest = rs.getString("originOfInterest");
//    	    		String likelyhoodOfRecommendation = rs.getString("likelyhoodOfRecommendation");
//    	    		String raffle = rs.getString("raffle");
//    	    		String comments = rs.getString("comments");
//    	
//    	    		String tempLikes[] = splitCampusLikes(likedAboutCampus);
//    	    		Student s = new Student(firstName, lastName, streetAddress, city, state, zip, telephoneNumber, email, dataOfSurvey, tempLikes, originOfInterest, likelyhoodOfRecommendation, raffle, comments);
//    	    		allStudents.add(s);
//    	    	}
//    	    	con.close();
//        	} catch (Exception e) {
//        		System.out.println("Error in retrieve all search");
//        	}
//
//    	    	return allStudents;   	
//    }
//
//    
//    
//	/**
//	 *  Break up the string entry
//	 *  example: "location, common"
//	 *  if null return n/A
//	 *  if single item return the single item in array format
//	 *  else return the string broken down into an array 
//	 * 
//	 * @param a
//	 * @return
//	 */
//	private String[] splitCampusLikes(String a) {
//		if (a == null) {
//			return new String[]{"n/A"};
//		}
//		if (a.contains(",")) {
//			String[] b = a.split(",");
//			return b;
//		} else if (a.length() > 0) {
//			return new String[]{a};
//		}
//		return null;
//	}
//    
//    
//    /**
//     * If the size of the return list is 0, that means no search results were found
//     * 
//     * @return List of Students
//     * @throws SQLException
//     */
//    public List<Student> searchByParameters(String last, String first, String cityy, String statee) {
//		System.out.println("SearchByParameters called");
//		String q = createQueryString(last, first, cityy, statee);
//		System.out.println(q);
//		List<Student> allStudents = new ArrayList<Student>();
//		
//		
//		try {
//			Connection connection = establishConnection();
//    		Statement statement = connection.createStatement();
//		ResultSet rs = statement.executeQuery(q);
//			while (rs.next()) {
//				@SuppressWarnings("unused")
//				String id = rs.getString("s_id");
//				String firstName = rs.getString("firstName");
//				String lastName = rs.getString("lastName");
//				String streetAddress = rs.getString("streetAddress");
//				String city = rs.getString("city");
//				String state = rs.getString("state");
//				String zip = rs.getString("zip");
//				String telephoneNumber = rs.getString("telephoneNumber");
//				String email = rs.getString("email");
//				String dataOfSurvey = rs.getString("dataOfSurvey");
//				String likedAboutCampus = rs.getString("likedAboutCampus");
//				String originOfInterest = rs.getString("originOfInterest");
//				String likelyhoodOfRecommendation = rs
//						.getString("likelyhoodOfRecommendation");
//				String raffle = rs.getString("raffle");
//				String comments = rs.getString("comments");
//
//				String tempLikes[] = splitCampusLikes(likedAboutCampus);
//				Student s = new Student(firstName, lastName, streetAddress,
//						city, state, zip, telephoneNumber, email, dataOfSurvey,
//						tempLikes, originOfInterest,
//						likelyhoodOfRecommendation, raffle, comments);
//				allStudents.add(s);
//			}
//
//		} catch (Exception e) {
//			System.out.println("Error in param search");
//			//e.printStackTrace();
//		}
//		return allStudents;
//    }
//    
//    
//	/**
//	 * This method is used to build the query string based on the passed in inputs.
//	 * 
//	 * Example
//	 * searchByParameters("", "Jack", "", "V*");
//	 * Criterion [fieldName=firstname, rawSearchText=Jack, isValid=true, hasWildCard=false]firstname = 'Jack'
//	 * Criterion [fieldName=state, rawSearchText=V*, isValid=true, hasWildCard=true]state like 'V%'
//	 * Final Query:   =  select * from survey_swe645_hw2 where firstname = 'Jack' && state like 'V%'
//	 * @param last
//	 * @param first
//	 * @param city
//	 * @param state
//	 * @return
//	 */
//	private String createQueryString(String last, String first, String city, String state) {
//		Criterion c1 = new Criterion("lastname", last);
//		Criterion c2 = new Criterion("firstname", first);
//		Criterion c3 = new Criterion("city", city);
//		Criterion c4 = new Criterion("state", state);
//	
//		ArrayList<Criterion> cr = new ArrayList<Criterion>();
//		//only adding the valid params to the list for the query string
//		if(c1.isValid()) cr.add(c1);
//		if(c2.isValid()) cr.add(c2);
//		if(c3.isValid()) cr.add(c3);
//		if(c4.isValid()) cr.add(c4);
//	
//		//If no params are valid, this shall be the default q string
//		String query = "select * from survey_swe645_hw2";
//		
//		if (cr.size() > 0) {
//			query += " where ";
//		}
//		for (int i = 0; i < cr.size(); i++) {
//			query += cr.get(i).getQuerySyntax();
//			if ((i+1) < cr.size()) {
//				query += " and ";
//			}
//		}
//		return query;
//	}
//
//	
//    /**
//     * This method is used to establish a connection with the database.  If
//     * it is unable to create the connection it returns null, else it returns the
//     * connection.  
//     * 
//     * @return
//     */
//	private Connection establishConnection() {
//		try {
//			Class.forName(DB_DRIVER);
//		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your Oracle JDBC Driver?");
//			e.printStackTrace();
//			return null;
//		}
//
//		System.out.println("Oracle JDBC Driver Registered!");
//		Connection connection = null;
//
//		try {
//			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
//					DB_PASSWORD);
//		} catch (SQLException e) {
//			System.out.println("Connection Failed! Check output console");
//			e.printStackTrace();
//			return null;
//		}
//
//		if (connection != null) {
//			System.out.println("You made it, take control your database now!");
//			return connection;
//		} else {
//			System.out.println("Failed to make connection!");
//			return null;
//		}
//	}
	
	
}
