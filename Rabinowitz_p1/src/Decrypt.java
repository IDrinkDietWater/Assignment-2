//Scott Rabinowitz
//9/12/19
//COP 3330 - Assignment 2 Pt 1

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		// Variables
		Scanner scan = new Scanner(System.in);
		int input, n1, n2, n3, n4, swap;
		
		//number input
		System.out.println("Input a 4 digit number");
		input = scan.nextInt();

		if(Integer.toString(input).length() < 4 || Integer.toString(input).length() > 4) {
			System.out.println("ERROR: not a 4 digit number. You entered: "+ input);
		}	
		else {System.out.println("Decrypted.");
		}
		
		//decryption method
		
		n1 = input/1000;
		n2 = input/100;
		n3 = input/10;
		n4 = input/1;
		
		swap = n1;
		n1 = n3;
		n3 = swap;
		
		swap = n2;
		n2 = n4;
		n4 = swap;
		
		n1 = Math.abs(n1 + 3) %10;
		n2 = Math.abs(n2 + 3) %10;
		n3 = Math.abs(n3 + 3) %10;
		n4 = Math.abs(n4 + 3) %10;
		
		System.out.printf("%d%d%d%d", n1,n2,n3,n4);
	}
}
