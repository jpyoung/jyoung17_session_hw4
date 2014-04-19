package com.entity;



/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645
 * 
 * Class Purpose: 
 * 
 */
public class Criterion {

	private String fieldName;
	private String rawSearchText;
	private boolean isValid;
	private boolean hasWildCard;
	
	
	public Criterion() {
		isValid = false;
		hasWildCard = false;
	}
	
	public Criterion(String fieldName, String rawSearchText) {
		super();
		this.fieldName = fieldName;
		this.rawSearchText = rawSearchText;
		this.isValid = isValidParam(this.rawSearchText);
		checkForWild();
	}
	
	public void checkForWild() {
		if(isValid) {
			if (this.rawSearchText.contains("*")) {
				this.hasWildCard = true;
			}
		}
	}
	
	public String getQuerySyntax() {
		if(isValid) {
			String q = fieldName;
			if (hasWildCard) {
				String temp = rawSearchText.replace("*", "");
				q += " like '" + temp +"%'";
			} else {
				q += " = '" + rawSearchText + "'"; 
			}
			return q;
		}
		return null;
	}
	
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the rawSearchText
	 */
	public String getRawSearchText() {
		return rawSearchText;
	}

	/**
	 * @param rawSearchText the rawSearchText to set
	 */
	public void setRawSearchText(String rawSearchText) {
		this.rawSearchText = rawSearchText;
	}

	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the hasWildCard
	 */
	public boolean isHasWildCard() {
		return hasWildCard;
	}

	/**
	 * @param hasWildCard the hasWildCard to set
	 */
	public void setHasWildCard(boolean hasWildCard) {
		this.hasWildCard = hasWildCard;
	}

	/**
	 * This method is used to check if the passed in param is valid.
	 * Not null and length is greater or equal to one return true, else 
	 * return false.  
	 * 
	 * Example
	 * 
	 * 	System.out.println(isValidParam(" ")); //false
	 * System.out.println(isValidParam(""));  //false
	 *	System.out.println(isValidParam(null));  //false
	 *	System.out.println(isValidParam("G"));  //true
	 * 
	 * @param y
	 * @return
	 */
	private boolean isValidParam(String y) {
		if (y == null) {
			return false;
		} else {
			String x = y.trim();
			if (x.length() >= 1) {
				return true;
			} else {
				return false;
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Criterion [fieldName=" + fieldName + ", rawSearchText="
				+ rawSearchText + ", isValid=" + isValid + ", hasWildCard="
				+ hasWildCard + "]" + getQuerySyntax();
	}
	
	
	
	
}
