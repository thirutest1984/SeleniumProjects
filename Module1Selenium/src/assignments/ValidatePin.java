/**
 * 
 */
package assignments;

import java.util.Scanner;

/**
 * @author M1035775
 *
 */
public class ValidatePin {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int temp =1;
		for(int i=1;i<=3;i++) {
			System.out.println("Please enter the pin number: ");
			int pin = scanner.nextInt();
			// validate the pin is correct or not
			if(pin==1234) {
				System.out.println("Your ATM card has been enabled.");
				break;
			}
			else {
				// check for the wrong attempts
				if(temp==3) {
					System.out.println("3 wrong attempts.Your ATM card has been blocked.");
				}
				temp++;
			}
		}
		scanner.close();
	}

}
