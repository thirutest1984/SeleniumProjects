/**
 * 
 */
package demo2;

import demo1.MethodsStatic; // import primary package

/**
 * @author M1035775 Kotra Thirumala
 *
 */
// test class
public class TestMainStatic {

	public static void main(String[] args) {
		// calling the methods directly since they are static
		MethodsStatic.day();
		MethodsStatic.month();
		MethodsStatic.year();
	}

}
