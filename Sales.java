// -------------------------------------------------------------------
// Assignment 4
// Written by: Noah Afriat 40276193 
// For COMP 248 Section H A – Fall 2023
// -------------------------------------------------------------------

/* The Sales class in Java is designed to manage and represent different types of sales 
 * and their quantities within a sales system. It contains variables to store the quantities 
 * of various sales categories, including junior, teen, medium, big, and family sales. These 
 * quantities are maintained using getter and setter methods, allowing access and modification 
 * of individual sale counts. The class includes methods to initialize sales quantities, update 
 * them, calculate the total sales value based on predefined prices for each sale category, and 
 * represent the sales object as a string displaying the quantities and prices. Additionally, 
 * the class features a method to compare two Sales objects to determine if they have identical 
 * quantities of sales across all categories. Overall, the class encapsulates functionalities to 
 * manage, manipulate, and retrieve information related to different types of sales within a sales 
 * system. */

public class Sales {

	// Variables to store quantities of different types of sales
	private int numJunior, numTeen, numMedium, numBig, numFamily;
	
	// Constants representing prices for each type of sale
	final static int JPRICE=5, TPRICE=10, MPRICE=12, BPRICE=15, FPRICE=20;
	
	// Default constructor initializing all sales quantities to zero
	public Sales () 
	{
		this.numJunior=0;
		this.numTeen=0;
		this.numMedium=0;
		this.numBig=0;
		this.numFamily=0;
	}
	
	// Constructor to set sales quantities based on provided values
	public Sales (int numJunior, int numTeen, int numMedium, int numBig, int numFamily) 
	{
		this.numJunior=numJunior;
		this.numTeen=numTeen;
		this.numMedium=numMedium;
		this.numBig=numBig;
		this.numFamily=numFamily;
	}
	
	// Copy constructor to create a Sales object from another Sales object
	public Sales (Sales anotherSale)
	{
		this.numJunior=anotherSale.getNumJunior();
		this.numTeen=anotherSale.getNumTeen();
		this.numMedium=anotherSale.getNumMedium();
		this.numBig=anotherSale.getNumBig();
		this.numFamily=anotherSale.getNumFamily();
	}
	
	// Getter methods to retrieve quantities of different types of sales
	public int getNumJunior() {
		return this.numJunior;
	}
	public int getNumTeen() {
		return this.numTeen;
	}
	public int getNumMedium() {
		return this.numMedium;
	}
	public int getNumBig() {
		return this.numBig;
	}
	public int getNumFamily() {
		return this.numFamily;
	}
	
	// Setter methods to set quantities of different types of sales
	public void setNumJunior(int num) {
		this.numJunior=num;
	}
	public void setNumTeen(int num) {
		this.numTeen=num;
	}
	public void setNumMedium(int num) {
		this.numMedium=num;
	}
	public void setNumBig(int num) {
		this.numBig=num;
	}
	public void setNumFamily(int num) {
		this.numFamily=num;
	}
	
	// Method to increment sales quantities by specified amounts
	public void addSales(int addJunior, int addTeen, int addMedium, int addBig, int addFamily) {
		this.numJunior+=addJunior;
		this.numTeen+=addTeen;
		this.numMedium+=addMedium;
		this.numBig+=addBig;
		this.numFamily+=addFamily;
	}
	
	// Method to calculate the total sales value based on quantities and prices
	public int salesTotal() {
		return (this.numJunior*JPRICE)+(this.numTeen*TPRICE)+(this.numMedium*MPRICE)+(this.numBig*BPRICE)+(this.numFamily*FPRICE);
	}
	
	// Method to represent the Sales object as a string
	public String toString() {
		return this.numJunior + " x $" + JPRICE + " + " + this.numTeen + " x $" + TPRICE + " + " + this.numMedium + " x $" + MPRICE + " + " + this.numBig + " x $" + BPRICE + " + " + this.numFamily + " x $" + FPRICE;
	}
	
	// Method to check if two Sales objects have the same quantities of sales
	public boolean equals(Sales anotherSale2) {
		
		if (this.numJunior == anotherSale2.getNumJunior() && this.numTeen == anotherSale2.getNumTeen() && this.numMedium == anotherSale2.getNumMedium() && this.numBig == anotherSale2.getNumBig() && this.numFamily == anotherSale2.getNumFamily()) {
			return true;
		}
		else {
			return false;
		}	
	}	
}

