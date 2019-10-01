import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {

		// Variables
				Scanner scan = new Scanner(System.in);
				int input, n1, n2, n3, n4, swap;
				
				//number input
				System.out.println("Input a 4 digit number");
				input = scan.nextInt();

				System.out.println("Encrypted.");
				
				//encryption method
				n1 = input/1000;
				n2 = input/100;
				n3 = input/10;
				n4 = input/1;
				
				n1 = (n1 + 7) %10;
				n2 = (n2 + 7) %10;
				n3 = (n3 + 7) %10;
				n4 = (n4 + 7) %10;
				
				swap = n1;
				n1 = n3;
				n3 = swap;
				
				swap = n2;
				n2 = n4;
				n4 = swap;
				
				System.out.printf("%d%d%d%d", n1,n2,n3,n4);
			}
}
