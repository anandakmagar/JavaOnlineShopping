package shoppingApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OnlineShoppingApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Connecting to SQL database
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authentication_database", "root",
				"rootroot");
		java.sql.Statement stmt = con.createStatement();

		Scanner scnr1 = new Scanner(System.in);

		System.out.println("Welcome to Online Shopping!");
		System.out.println(" ");

		System.out.print("Enter the username: ");
		String username = scnr1.next();
		System.out.print("Enter the password: ");
		String password = scnr1.next();

		ResultSet rs = stmt.executeQuery(
				"select * from authentication_table where username='" + username + "' and password='" + password + "'");
		if (rs.next()) {
			System.out.println("Login Successfull!\n");
		} else {
			System.out.println("\nWrong username/password!\nPlease enter your correct username/password\n");

			System.out.print("Enter the username: ");
			username = scnr1.next();
			System.out.print("Enter the password: ");
			password = scnr1.next();
			rs = stmt.executeQuery("select * from authentication_table where username='" + username + "' and password='"
					+ password + "'");
			if (rs.next()) {
				System.out.println("\nLogin Successfull!\n");
			} else {
				System.out.println("\nYour account is locked due to multiple failed login attempts!");

				System.exit(0);
			}
		}
		con.close();
		

		// Creating an object of BinaryClass
		BinarySearch obj = new BinarySearch();

		// Creating a sorted array
		int[] array = { 1, 2, 3, 4 };
		int n = array.length;

		// Get input from user for element to be searched
		Scanner scnr2 = new Scanner(System.in);

		System.out.println("Department number          Department");
		System.out.println("-------------------------------------");
		System.out.println("1                          Clothes");
		System.out.println("2                          Toys");
		System.out.println("3                          Electronics");
		System.out.println("4                          Foods");

		System.out.println(" ");
		System.out.println("Enter department number to choose the department");
		// Getting input from user for element to be searched
		int element = scnr2.nextInt();

		System.out.println(" ");
		// input.close();

		// Calling the binary search method and passing arguments: array, element, index
		// of first and last element
		int result = obj.binarySearch(array, element, 0, n - 1);

		// Printing "You are in Clothes department" if the result equals 0
		if (result == 0) {
			System.out.println("You are in Clothes department");
		}
		// Printing "You are in Toys department" if the result equals 1
		else if (result == 1) {
			System.out.println("You are in Toys department");
		}
		// Printing "You are in Electronics department" if the result equals 2
		else if (result == 2) {
			System.out.println("You are in Electronics department");
		}
		// Printing "You are in Foods department" if the result equals 3
		else if (result == 3) {
			System.out.println("You are in Foods department");
		}
		// Exiting the system if the result doesn't match the above specified numbers
		else {
			System.exit(0);
		}

		System.out.println(" ");

		// Getting user input for item name, item price, and item quantity
		Scanner scnr3 = new Scanner(System.in);

		String productName = "";
		int productPrice = 0;
		int productQuantity = 0;
		int cartTotal = 0;

		ItemToPurchase item1 = new ItemToPurchase();
		ItemToPurchase item2 = new ItemToPurchase();

		// Getting item 1 details from user, creating ItemPurchase object
		System.out.println("Item 1");
		System.out.println("---------------------");
		System.out.println("Enter the item name: ");
		productName = scnr3.nextLine();

		System.out.println("Enter the item price: ");
		productPrice = scnr3.nextInt();

		System.out.println("Enter the item quantity: ");
		productQuantity = scnr3.nextInt();

		// Setting name, price, and quantity for item1
		item1.setName(productName);
		item1.setPrice(productPrice);
		item1.setQuantity(productQuantity);

		// Calling scnr2.nextLine to allow user to input new String
		scnr3.nextLine();

		// Getting item 2 details from user, creating ItemPurchase object
		System.out.println("\nItem 2");
		System.out.println("---------------------");
		System.out.println("Enter the item name: ");
		productName = scnr3.nextLine();

		System.out.println("Enter the item price: ");
		productPrice = scnr3.nextInt();

		System.out.println("Enter the item quantity: ");
		productQuantity = scnr3.nextInt();

		// Setting name, price, and quantity for item2
		item2.setName(productName);
		item2.setPrice(productPrice);
		item2.setQuantity(productQuantity);

		// Calculating the sum of the cost of two items
		cartTotal = (item1.getPrice() * item1.getQuantity()) + (item2.getPrice() * item2.getQuantity());
		// Printing TOTAL COST
		System.out.println("\nTOTAL COST");
		System.out.println("****************************************");

		// Getting and printing item 1 information
		System.out.println(item1.getQuantity() + " " + item1.getName() + " " + " @ " + "$" + item1.getPrice() + " each "
				+ " = $" + (item1.getPrice() * item1.getQuantity()));

		// Getting and printing item two information
		System.out.println(item2.getQuantity() + " " + item2.getName() + " " + " @ " + "$" + item2.getPrice() + " each "
				+ " = $" + (item2.getPrice() * item2.getQuantity()));
		System.out.println("----------------------------------------");

		// Printing Total output
		System.out.println("Total: $" + cartTotal);

		return;
	}
}

class ItemToPurchase {
   //Creating private fields - itemName, itemPrice, and itemQuanity
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
   // Default Constructor
   // Initializing itemName to "none", itemPrice to 0, and itemQuantity to 0
	public ItemToPurchase() {
	itemName = "none";
	itemPrice = 0;
	itemQuantity = 0;
	return;
	}
    
   // Using public member methods (mutators & accessors)
	//setName() & getName() 
	public String getName(){
		return itemName;
	}
	public void setName(String itemName) {
		this.itemName = itemName;
	}
	
	//setPrice() & getPrice() 
	public int getPrice() {
		return itemPrice;
	}
	public void setPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	//setQuantity() & getQuantity() 
	public int getQuantity() {
		return itemQuantity;
	}
	public void setQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
   
   //Printing item to purchase
   public void printItemPurchase() {
      System.out.println(itemQuantity + " " + itemName + " $" + itemPrice +  
                         " = $" + (itemPrice * itemQuantity));
   }

}

class BinarySearch {
  int binarySearch(int array[], int element, int low, int high) {

    // Repeating until the pointers low and high meet each other
    while (low <= high) {

      // Getting the index of mid element
      int mid = low + (high - low) / 2;

      // If the element to be searched is the mid element
      if (array[mid] == element)
        return mid;

      // Searching only the left side of mid if the element is less than the mid element
      if (array[mid] < element)
        low = mid + 1;

      // Searching only the right side of mid if the element is greater than the mid element
      else
        high = mid - 1;
    }

    return -1;
  }
}