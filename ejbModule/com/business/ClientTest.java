package com.business;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClientTest {

	public static void main(String args[]) throws Exception {
		  //String endpointURI ="http://localhost:8080/Simple/MathWs?wsdl";
		String endpointURI = "http://localhost:8080/jyoung17_session_hw4/DataBean?wsdl";
		  
//		  Object retObj = getPort(endpointURI).add(25, 7);
//		  System.out.println(retObj);
//		  Object retObj2 = getPort(endpointURI).subtract(25, 7);
//		  System.out.println(retObj2);
//		  Object retObj3 = getPort(endpointURI).sayHello("John Young");
//		  System.out.println(retObj3);
		  
		  
//		  Math r = getPort(endpointURI);
//		  
//		  System.out.println(r.add(25,7));
//		  System.out.println(r.subtract(25, 7));
//		  System.out.println(r.sayHello("John Young"));
//		  
//		  List<String> n = r.createName("Ryan", "Young");
//		  System.out.println(n);
		  
			Object retObj = getPort(endpointURI);
			
			
			List<String> allResults = ((DataBeanRemote) retObj).retrieveAllSurveys();
			
			for (int i = 0; i < allResults.size(); i++) {
				System.out.println(allResults.get(i));
			}
		
		
		}  
	
	
	 private static DataBeanRemote getPort(String endpointURI) throws MalformedURLException   {
		   QName serviceName = new QName("http://businesslogic.com/", "DataBeanService");
		   URL wsdlURL = new URL(endpointURI);

		   Service service = Service.create(wsdlURL, serviceName);
		   return service.getPort(DataBeanRemote.class);
		 }
}
