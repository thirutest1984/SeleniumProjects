/**
 * 
 */
package assignments;

import java.util.Scanner;

/**
 * @author M1035775
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		
		// using string builder class
		StringBuilder sb = new StringBuilder();
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter a string: ");
		String str = scanner.nextLine();
		
		// add the string to string builder
		sb.append(str);
		
		// reverse the string using string builder
		StringBuilder rStr = sb.reverse();
		System.out.println("reversed string is: "+rStr);

	}

}
