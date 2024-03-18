// -------------------------------------------------------------------
// Assignment 4
// Written by: Noah Afriat 40276193 
// For COMP 248 Section H A – Fall 2023
// -------------------------------------------------------------------

/* The PoS (Point of Sale) class encapsulates essential functionalities for managing 
 * sales and prepaid card information within a system. It includes attributes such as 
 * a Sales object to track sales and an array of PrePaidCard objects for storing prepaid 
 * card details. The class provides methods for comparing total sales value and sales 
 * categories with another PoS object, accessing the total sales value and the number 
 * of prepaid cards, adding and removing prepaid cards, updating expiry dates, and adding 
 * meal sales. The equals method checks for equality based on total sales and prepaid card 
 * count, while toString offers a string representation of the PoS object, including sales 
 * breakdown and prepaid card details. Overall, the PoS class serves as a comprehensive tool 
 * for managing sales and prepaid card operations within a point of sale system. */

public class PoS {

	
	private Sales sales; // Object to track sales
	private PrePaidCard[] prePaidCards; // Array to store prepaid cards

    // Default constructor initializing sales to an empty Sales object and prePaidCards to null
	public PoS() {
		this.sales = new Sales(); 
		this.prePaidCards=null; }
	
    // Constructor to set sales and prePaidCards based on provided values
	public PoS(Sales sales, PrePaidCard[] prePaidCards) { //???
		this.sales = sales;
		if (prePaidCards != null) {
			this.prePaidCards=(PrePaidCard[]) prePaidCards.clone();
			}
			 else {
				 this.prePaidCards = null; } }
	
    // Method to compare total sales value with another PoS object
	public boolean compareTotalSalesValue(PoS otherPoS) {
		if(this.sales != null && otherPoS.sales != null) {
			return this.sales.salesTotal() == otherPoS.sales.salesTotal(); }
		else {
			return false; }
	}
	
    // Method to compare individual sales categories with another PoS object
	public boolean compareSalesCategories (PoS otherPoS) {
		if(this.sales != null && otherPoS.sales != null) {
			return this.sales.equals(otherPoS.sales); }
		else {
			return false; }
	}
	
    // Method to get the total sales value
	public int getTotalSales() {
		if (this.sales != null) {
			return this.sales.salesTotal();
		}
		else {
			return 0;
		}
	}
	
    // Method to get the number of prepaid cards
	public int numPrePaidCards() {
		if (this.prePaidCards != null) {
			return this.prePaidCards.length;
		}
		else {
			return 0;
		}
	}
	
    // Method to add a new prepaid card to the array
	public int addPrePaidCard (PrePaidCard newCard) {
		if (this.prePaidCards == null) {
			this.prePaidCards = new PrePaidCard[1];
			this.prePaidCards[0]=newCard;
		}
		else {
			PrePaidCard[] updatedCards = new PrePaidCard[this.prePaidCards.length + 1];
            // Copy existing cards into the updated array
			for (int i = 0; i < this.prePaidCards.length; i++) {
		            updatedCards[i] = this.prePaidCards[i];
		        }
			updatedCards[this.prePaidCards.length] = newCard;
			this.prePaidCards = updatedCards; 
		}
		return this.prePaidCards.length;	
	}
	
	public boolean removePrePaidCard (int cardIndex) {
		if (this.prePaidCards == null || this.prePaidCards.length == 0 || cardIndex >= this.prePaidCards.length) {
			return false;
		}
		else {
			int newSize = this.prePaidCards.length-1;
			PrePaidCard[]updatedCards = new PrePaidCard[newSize];
			int newIndex=0;
			
			for (int i = 0; i < this.prePaidCards.length; i++) {
				if (i != cardIndex)  {
					updatedCards[newIndex] = this.prePaidCards[i];
					newIndex++;
				}
			}
			this.prePaidCards = updatedCards;
			return true;
		}
	}
	
    // Method to update the expiry date of a prepaid card
	public boolean updateExpiryDate (int cardIndex, int newExpiryDay, int newExpiryMonth) {
		if (this.prePaidCards == null || this.prePaidCards.length == 0 || cardIndex >= this.prePaidCards.length) {
			return false;
		}
		else {
			this.prePaidCards[cardIndex].setExpiryDay(newExpiryDay);
			this.prePaidCards[cardIndex].setExpiryMonth(newExpiryMonth);
			return true;
		}
	}
	
    // Method to add meal sales to the sales object
	public double addMealSales (int numJunior, int numTeen, int numMedium, int numBig, int numFamily) {
		if (this.sales == null) {
			this.sales = new Sales();
		}
		
		this.sales.addSales(numJunior, numTeen, numMedium, numBig, numFamily);
		
		return this.sales.salesTotal();
	}
	
    /* Method which checks if the total ($) amount sales value and the 
	number of prepaid card of two PoS objects are equal, and false otherwise. */
	public boolean equals(PoS otherPoS) {
		if (otherPoS == null) {
			return false;
		}
		else {
			double thisTotalSales = (this.sales != null) ? this.sales.salesTotal() : 0.0;
	        double otherTotalSales = (otherPoS.sales != null) ? otherPoS.sales.salesTotal() : 0.0;

	        int thisNumPrePaidCards = (this.prePaidCards != null) ? this.prePaidCards.length : 0;
	        int otherNumPrePaidCards = (otherPoS.prePaidCards != null) ? otherPoS.prePaidCards.length : 0;
	        
	        return thisTotalSales == otherTotalSales && thisNumPrePaidCards == otherNumPrePaidCards;
		}
	}
	
    // Method to represent the PoS object as a string
	 public String toString() {
		 String output = this.sales.toString();
			 
			 if (this.prePaidCards != null && this.prePaidCards.length > 0) {
				 for(int i =0; i< this.prePaidCards.length; i++)
					 output+= "\n" + this.prePaidCards[i].toString();}
			
			 else 
				 output+="\nNo PrePaidCards";
				
			 
			 return output;
		 }
	
	// Method to get sales breakdown as a string
	public String salesBreakdown() {
		return this.sales.toString();
	}
}
