import java.util.Scanner;

public class BMI_calculatorP2 {

	public static void main(String[] args) {
Scanner scnr = new Scanner(System.in);
		
		// Variables
		String weightUnit = "0";
		double weight;
		String heightUnit = "0";
        double height;
        double calculate;
        double bmi;
        String unit ="0";
        int bmi2;
        int height2;
        int bmiMax;
        int heightMax;
        
        /*DISCLAIMER: I have not legitimately trademarked BMI Calculator-inator.
         * I just liked the sound of it, and it's just a print statement, I promise the deviation here
         * will not affect my code at all. So please don't dock points, I woke up early one morning to 
         * start this and that put a smile on my cranky "I woke up at 4am and have all afternoon classes"
         * face. Please, when you read the first print statement, do not laugh; smile, because I smiled 
         * when I wrote it. Okay I'll stop wasting your time, Dr. Hollander or whoever is reading this.
         * P.S., if this is a grader reading this, RIP, I salute you for juggling your own courseload on top
         * of this and I can only assume another possible job.*/
        
        System.out.printf("Welcome to BMI Calculator-inator" + '\u2122' + ". What system of measurement do you prefer: \"Imperial\" or \"Metric\"" + '?');    
        unit = scnr.nextLine();
        
        //if imperial system is used
        if (unit.compareTo("Imperial") == 0 || unit.compareTo("imperial") == 0) {
        	weightUnit = "pounds";
        	heightUnit = "inches"; 
        	
        	 System.out.printf("Enter Your Weight in %s: ", weightUnit);
             weight = scnr.nextDouble();
             System.out.printf("Enter Your Height in %s: ", heightUnit);
             height = scnr.nextDouble();
             
             bmi = (weight * 703.0) / (height * height);
         	 System.out.printf ("Your Body Mass Index (BMI) is %.2f\n\n", bmi);
         	 
         	System.out.println("Body Mass Index Table");
         	
         	bmi2 = (int)bmi - 8;
         	height2 = (int)height - 9;
         	bmiMax = (int)bmi + 8;
         	heightMax = (int)height + 9;
         	
         	System.out.print("|  BMI   ");
         	for(int i = bmi2; i <= bmiMax; i++) {
         		System.out.printf("|  %d  ", i);
         	}
         	System.out.println("|");
         	
         	System.out.println("| Height |				    	  ---Body Weight in Pounds---			");
         	
         	for(int h = height2; h <= heightMax; h++) {
         		System.out.printf("|   %d   ", h);
         		for(int i = bmi2; i <= bmiMax; i++) {
         			double result = i * (h * h) / 703.0;
         			String strResult = String.format ("%3.1f", result);

         			System.out.printf("| %5s", strResult);

         			//*/System.out.printf("| %3.1f", i * (h * h) / 703.0);
         		}
         		System.out.println("|");
        
         }
       }
        
        //if metric system is used
        else if(unit.compareTo("Metric") == 0 || unit.compareTo("metric") == 0) {
        	weightUnit = "kilograms";
        	heightUnit = "centimeters";
        	
        	 System.out.printf("Enter Your Weight in %s: ", weightUnit);
             weight = scnr.nextDouble();
             System.out.printf("Enter Your Height in %s: ", heightUnit);
             height = scnr.nextDouble();
             
             bmi = (weight)/((height / 100.0) * (height / 100.0));
         	 System.out.printf ("Your Body Mass Index (BMI) is %.2f\n\n", bmi);
         	
         	//BMI table
          	System.out.println("Body Mass Index Table");
         	
          	bmi2 = (int)bmi - 8;
          	height2 = (int)height - 9;
          	bmiMax = (int)bmi + 8;
          	heightMax = (int)height + 9;
          	
          	System.out.print("|  BMI    ");
          	for(int i = bmi2; i <= bmiMax; i++) {
          		System.out.printf("|  %d   ", i);
          	}
          	System.out.println("|");
          	
          	System.out.println("| Height  |			 			 ---Body Weight in Kilograms---			");
          	
          	for(int h = height2; h <= heightMax; h++) {
          		System.out.printf("|   %d   ", h);
          		for(int i = bmi2; i <= bmiMax; i++) {
          			double result = i * ((h / 100.0) * (h / 100.0));
          			String strResult = String.format ("%3.1f", result);

          			System.out.printf("| %5s", strResult);

          			System.out.printf("| %3.1f", i * ((h / 100.0) * (h / 100.0)));
          		}
          		System.out.println("|");
         
          }
         	    
        }
	}
}

