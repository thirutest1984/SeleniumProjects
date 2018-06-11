/**
 * 
 */
package assignments;

import java.util.Scanner;

/**
 * @author M1035775 Kotra Thirumala
 *
 */
public class PrintName {

	// method does not return
	public void displayName(String name) {
		System.out.println("You have entered your name as " + name);
	}

	// method with string return type
	public String printName(String name) {
		return name;
	}

	public static void main(String[] args) {

		// class object reference
		PrintName pn = new PrintName();

		// scanner for get input
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter a name: ");
		String name = scanner.nextLine();

		// calling void return type method
		pn.displayName(name);

		// calling String return type method
		String tName = pn.printName(name);
		System.out.println("You have entered your name as " + tName);

		scanner.close();
	}

}
