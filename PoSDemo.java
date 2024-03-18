// -------------------------------------------------------------------
// Assignment 4
// Written by: Noah Afriat 40276193 
// For COMP 248 Section H A – Fall 2023
// -------------------------------------------------------------------

/* The PoSDemo class functions as a driver program, managing a catering sales 
 * counter application for Concordia CostLessBites. It facilitates interaction 
 * with multiple instances of the PoS (Point of Sale) class, allowing users to 
 * perform various operations. The program initializes multiple PoS instances, 
 * adds meal sales, and includes functionalities to manage prepaid cards within 
 * these instances. The user interacts with a menu-driven interface to perform 
 * operations such as viewing the content of all PoS instances, adding sales, 
 * updating prepaid card details, listing PoSs with similar sales amounts or 
 * sales categories, and adding or removing prepaid cards. The driver class 
 * enables users to simulate various scenarios and manage sales and prepaid 
 * card activities across different PoS instances within the system. */

import java.util.Scanner;

// Array to hold PoS instances
public class PoSDemo {
	static PoS[] myPoS;
	static Scanner scan;

    // Method to add meal sales to a PoS
	public static void addMealSales(PoS pos1, int numJunior, int numTeen, int numMedium, int numBig, int numFamily) {
		pos1.addMealSales(numJunior, numTeen, numMedium, numBig, numFamily);
	}
	
    // Method to add a prepaid card to a PoS
	public static void addPrePaidCard(PoS pos1, String cardType, String cardID, int expiryDay, int expiryMonth) {
		pos1.addPrePaidCard(new PrePaidCard(cardType, cardID, expiryDay, expiryMonth));
	}
	
    // Method to read and check validity of PoS index
	public static int readPoSFromUser() {
		int PoSIndex;
		
		while (true) {
			PoSIndex = scan.nextInt();
			scan.nextLine();
			if (PoSIndex>(myPoS.length-1) || PoSIndex<0) {
				System.out.println("Sorry but there is no PoS number " + PoSIndex);
				System.out.print("--> Try again: (Enter number 0 to " + (myPoS.length-1) + "): ");
			}
			else {
				return PoSIndex;
			}
		}
	}
	
    // Main method
	 public static void main(String[] args) {
	     
		// Printing a welcome message for the user
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
				         + "| Welcome to Concordia CostLessBites Catering Sales Counter Application         |\n"        
			           	 + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
	    // Creating instances of PoS
		PoS pos0 = new PoS ();
		PoS pos1 = new PoS ();
		PoS pos2 = new PoS ();
		PoS pos3 = new PoS ();
		PoS pos4 = new PoS ();

	    // Adding meal sales and prepaid cards to each PoS instance
		addMealSales(pos0, 2, 1, 0, 4, 1);
		addPrePaidCard(pos0, "Vegetarian", "40825164", 25, 12);
		addPrePaidCard(pos0, "Carnivore", "21703195", 3, 12);
		
		addMealSales(pos1, 2, 1, 0, 4, 1);
		addPrePaidCard(pos1, "Vegan", "40825164", 7, 12);
		addPrePaidCard(pos1, "Vegetarian", "21596387", 24, 8);
		
		addMealSales(pos2, 0, 1, 5, 2, 0);
		addPrePaidCard(pos2, "Pescatarian", "95432806", 1, 6 );
		addPrePaidCard(pos2, "Halal", "42087913", 18, 12);
		addPrePaidCard(pos2, "Kosher", "40735421", 5, 4);
		
		addMealSales(pos3, 3, 2, 4, 1, 2);
		
		addMealSales(pos4, 3, 2, 4, 1, 2);
	
		// Storing PoS instances in an array
		myPoS = new PoS[5];
		myPoS[0]=pos0;
		myPoS[1]=pos1;
		myPoS[2]=pos2;
		myPoS[3]=pos3;
		myPoS[4]=pos4;
		
	    // Creating a scanner object to take user input
		scan = new Scanner (System.in);
		
		int selection;
	   
		// Entering a loop to display a menu and perform actions based on user input
		do {
			 System.out.print(
			          
			            "| What would you like to do?                                                    |\n" +
			            "| 1 >> See the content of all PoSs                                              |\n" +
			            "| 2 >> See the content of one PoS                                               |\n" +
			            "| 3 >> List PoSs with same $ amount of sales                                    |\n" +
			            "| 4 >> List PoSs with same number of Sales categories                           |\n" +
			            "| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards   |\n" +
			            "| 6 >> Add a PrePaid Card to an existing PoS                                    |\n" +
			            "| 7 >> Remove an existing prepaid card from a PoS                               |\n" +
			            "| 8 >> Update the expiry date of an existing Prepaid card                       |\n" +
			            "| 9 >> Add Sales to a PoS                                                       |\n" +
			            "| 0 >> To quit                                                                  |\n" +
			            "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n" +
			            "Please enter your choice and press <Enter>: "
			        );
			 
			selection = scan.nextInt(); // Reading the user's choice

	        // Switch-case to perform actions based on the user's choice
			switch (selection) {
		
				// Adding sales to a PoS
				case 9:
			        // Prompting the user to choose a PoS to add sales to
					System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to " + (myPoS.length - 1) + "): ");
					int posIndex9 = readPoSFromUser(); // Reading the PoS index from user input
					
			        // Prompting for the number of different meal menus to add
					System.out.print("How many junior, teen, medium, big and family meal menu do you want to add?\n"
							+ "Enter 5 numbers seperated by a space): ");
					
			        // Reading the number of meals to add for each category
					int numJunior = scan.nextInt();
					int numTeen = scan.nextInt();
					int numMedium = scan.nextInt();
					int numBig = scan.nextInt();
					int numFamily = scan.nextInt();
					scan.nextLine(); // Consuming the newline character
				
			        // Adding meal sales to the selected PoS and displaying the updated total sales
					double result = myPoS[posIndex9].addMealSales(numJunior, numTeen, numMedium, numBig, numFamily);
					System.out.println("You now have $" + result +"\n");
					
					break;
					
				// Updating the expiry date of an existing Prepaid card		
				case 8:
			        // Prompting the user to choose a PoS to add sales to
					System.out.print("Which PoS do you want to update a PrePaidCard from? (Enter number 0 to " + (myPoS.length - 1) + "): ");
					int posIndex8 = readPoSFromUser(); // Reading the PoS index from user input
					
					int numCards = myPoS[posIndex8].numPrePaidCards(); // Getting the number of PrePaidCards in the selected PoS
						
					    // Checking if the selected PoS has no PrePaidCards
						if (numCards==0) {
						System.out.println("Sorry that PoS has no PrePaidCards");
						}
				       
						// Prompting the user to choose which PrePaidCard to update
						else {
							System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to " + (numCards-1) + "): ");
							
							int cardToUpdate = scan.nextInt();
							
					        // Validating if the input cardToUpdate is within a valid range of PrePaidCards
							if (cardToUpdate >= myPoS[posIndex8].numPrePaidCards() || cardToUpdate < 0) {
					            System.out.println("Sorry, but that is not a valid PrePaidCard");
					            System.out.print("--> Try again: (Enter number 0 to " + (myPoS[posIndex8].numPrePaidCards() - 1) + "). ");
					        } 
							
							else {
								// Prompting the user to input the new expiry day and month for the selected PrePaidCard
					            System.out.print("Enter the new expiry day and month (separated by a space): ");
					            int newExpiryDay = scan.nextInt();
					            int newExpiryMonth = scan.nextInt();
					            scan.nextLine(); // Consuming the newline character
					           
					            // Updating the expiry date of the selected PrePaidCard and displaying the result
					            boolean response = myPoS[posIndex8].updateExpiryDate(cardToUpdate, newExpiryDay, newExpiryMonth);
					            
					            if (response) {
					        	   System.out.println("Expiry date updated");
					            }
					            else {
					            	System.out.println("Expiry Date not updated.");
					            }
					        }
						}
						break;
						
				// Removing an existing Prepaid card from a PoS
				case 7:
				    // Prompting the user to select a PoS to remove a PrePaidCard from
					System.out.print("Which PoS do you want to remove a PrePaidCard from? (Enter number 0 to " + (myPoS.length - 1) + "): ");
					int posIndex7 = readPoSFromUser(); // Reading the PoS index from user input
					
							int numCard = myPoS[posIndex7].numPrePaidCards(); // Getting the number of PrePaidCards in the selected PoS
						
						    // Checking if the selected PoS has no PrePaidCards
							if (numCard==0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							}
							
							else {
						        // Prompting the user to choose which PrePaidCard to remove
								System.out.println("(Enter number 0 to " + (numCard-1) + "): ");
								int cardIndex = scan.nextInt();
								
						        // Attempting to remove the selected PrePaidCard from the PoS and displaying the result
								boolean response = myPoS[posIndex7].removePrePaidCard(cardIndex);
								
								if (response) {
									System.out.println("PrePaidCard was removed successfully");
								}
								else {
									System.out.println("PrePaid card failed to remove.");
								}
							}
							break;
			
				// Adding a Prepaid card to an existing PoS
				case 6:
			        // Prompting the user to choose a PoS to add sales to
					System.out.print("Which PoS do you want to add a PrePaidCard to? (Enter number 0 to " + (myPoS.length - 1) + "): ");
					int pos6Index = readPoSFromUser(); // Reading the PoS index from user input
					
					// Gathering information to create a new PrePaidCard	
					System.out.println("Please enter the following information so that we may complete the PrePaidCard-\n"
							+ "--> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan): ");
					String typeChoice = scan.nextLine();
					System.out.print("--> ID of the prepaid card owner: ");
					String idChoice = scan.nextLine();
					System.out.print("--> Expiry day number and month (seperate by a space): ");
					int expiryDayChoice = scan.nextInt();
					int expiryMonthChoice = scan.nextInt();
					
				    // Adding a new PrePaidCard to the selected PoS and displaying the updated number of PrePaidCards
					int numCard1 = myPoS[pos6Index].addPrePaidCard(new PrePaidCard(typeChoice, idChoice, expiryDayChoice, expiryMonthChoice));
					System.out.println("You now have " + numCard1 + " PrePaidCard(s)\n");
					break;	
					
				// Listing PoSs with same $ amount of Sales and same number of Prepaid cards
				case 5:
					System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards : :\n");
					// Create nested loop so that there's no repetitive displays
					for (int i=0; i<myPoS.length; i++) {
						for (int j=i+1; j<myPoS.length; j++) {
							// Checking if two PoS instances have equal sales and the same number of PrePaidCards
							if(myPoS[i].equals(myPoS[j])) {
								System.out.println("PoSs " + i + " and " + j);
							}
						}
					}
					System.out.println("");
					break;
					
				// Listing PoSs with same number of Sales categories
				case 4:
					System.out.println("List of PoSs with same Sales categories: :\n");
					// Create nested loop so that there's no repetitive displays
					for (int i=0; i<myPoS.length; i++) {
						for (int j=i+1; j<myPoS.length; j++) {
				            // Checking if two PoS instances have the same sales breakdown
							if(myPoS[i].salesBreakdown().equals(myPoS[j].salesBreakdown())) {
								System.out.println("PoSs " + i + " and " + j + " both have " + myPoS[i].salesBreakdown());
							}
						}
					}
				    // Display a newline for readability
					System.out.println("");
					break;
					
				// Listing PoSs with same $ amount of sales
				case 3:
					for (int i=0; i<myPoS.length; i++) {
						for (int j=i+1; j<myPoS.length; j++) {
							if(myPoS[i].getTotalSales() == myPoS[j].getTotalSales()) {
								System.out.println("PoSs " + i + " and " + j + " both have " + myPoS[i].getTotalSales());
							}
						}
					}
					System.out.println("");
					break;
				
				// Viewing the content of one PoS
				case 2:
			        // Prompting the user to choose a PoS to add sales to
					System.out.print("Which PoS do you want to see the content of? (Enter number 0 to " + (myPoS.length-1) + "): ");
					int posIndex2 = readPoSFromUser(); // Reading the PoS index from user input
				    
					// Displaying the content of the selected PoS by using its 'toString()' representation
					System.out.println(myPoS[posIndex2].toString() +"\n");
					break;	
				
				// Displaying the content of each PoS
				case 1:
					System.out.println("Content of each PoS:\n--------------------");
					for (int i=0; i<(myPoS.length);i++) {
						System.out.println("PoS #" + i + ":\n" + myPoS[i].toString() + "\n");
						}
					break;
				
				// To quit the program
				case 0:
					System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
					break;
				
				// If the user inputs an invalid option
				default:
					System.out.println("Sorry that is not a valid choice. Try again.");			
				}
		} 
		// While loop continues until input by user is 0
		while (selection != 0);
		
		// Close scanner
		scan.close();
	 } 
}
