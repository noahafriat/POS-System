// -------------------------------------------------------------------
// Assignment 4
// Written by: Noah Afriat 40276193 
// For COMP 248 Section H A – Fall 2023
// -------------------------------------------------------------------

/* The PrePaidCard class in Java serves to manage and represent prepaid card 
 * information within a system. It contains attributes to store details associated 
 * with a prepaid card, including its type, identification number, expiry day, and 
 * expiry month. The class provides constructors to initialize these attributes 
 * either with default values or by using provided input values while ensuring 
 * valid input for the expiry day and month. Getter and setter methods are available 
 * to access and modify the card's attributes while validating the values for expiry 
 * day and month. The class includes a method to represent the prepaid card object as 
 * a formatted string displaying the card type, card ID, and expiry date. Additionally, 
 * it features a method to compare two PrePaidCard objects to determine if they share 
 * identical attributes across card type, card ID, expiry day, and expiry month. Overall, 
 * the PrePaidCard class encapsulates functionalities to handle, manipulate, and retrieve 
 * information related to prepaid card instances within a system. */

public class PrePaidCard {

    // Attributes to store card information
	private String cardType;
	private String cardID;
	private int expiryDay;
	private int expiryMonth;
	
    // Default constructor initializing card attributes to default values
	public PrePaidCard() {
		this.cardType= "";
		this.cardID= "";
		this.expiryDay=0;
		this.expiryMonth=0;
	}	
	
	// Constructor to set card attributes based on provided values
	public PrePaidCard(String cardType, String cardID, int expiryDay, int expiryMonth) {
		this.cardType=cardType;
		this.cardID=cardID;
		
	    // Ensures valid values for expiry day and month
		if (expiryDay<1 || expiryDay>31) {
			this.expiryDay=0;
		}
		else {
			this.expiryDay=expiryDay;
		}
		
		if (expiryMonth<1 || expiryMonth>12) {
			this.expiryMonth=0;
		}
		else {
			this.expiryMonth=expiryMonth;
		}
	}
	
    // Copy constructor to create a PrePaidCard object from another PrePaidCard object
	public PrePaidCard(PrePaidCard anotherCard) {
		this.cardType=anotherCard.getCardType();
		this.cardID=anotherCard.getCardID();
		this.expiryDay=anotherCard.getExpiryDay();
		this.expiryMonth=anotherCard.getExpiryMonth();
	}
	
    // Getter methods to retrieve card information
	public String getCardType() {
		return this.cardType;
	}
	public String getCardID() {
		return this.cardID;
	}
	public int getExpiryDay() {
		return this.expiryDay;
	}
	public int getExpiryMonth() {
		return this.expiryMonth;
	}

    // Setter methods to set expiry day and month with validity checks
	public void setExpiryDay(int day) {
		if (day<1 || day>31) {
			this.expiryDay=0;
		}
		else {
			this.expiryDay=day;
		}	
	}
	public void setExpiryMonth(int month) {
		if (month<1 || month>12) {
			this.expiryMonth=0;
		}
		else {
			this.expiryMonth=month;
		}
	}
	
    // Method to represent the PrePaidCard object as a string
	public String toString() {
		String formattedDay = String.format("%02d", this.expiryDay);
		String formattedMonth = String.format("%02d", this.expiryMonth);
		
		return this.cardType + " - " + this.cardID + " - " + formattedDay + "/" + formattedMonth;
	}
	
    // Method to check if two PrePaidCard objects have the same attributes
	public boolean equals(PrePaidCard anotherCard2) {
		if (this.cardType.equals(anotherCard2.getCardType()) && this.cardID.equals(anotherCard2.getCardID()) && this.expiryDay==anotherCard2.getExpiryDay() && this.expiryMonth==anotherCard2.getExpiryMonth()) {
			return true;
		}
		else {
			return false;
		}
	}
}
