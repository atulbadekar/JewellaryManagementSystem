package jewellery_shop;

import java.util.Scanner;

public class validation {


	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter your first name: ");
	        String name = scanner.nextLine().trim();

	        System.out.print("Enter your mobile number: ");
	        String mobile = scanner.nextLine().trim();

	        if (isValidName(name) && isValidMobile(mobile)) {
	            System.out.println("Validation successful!");
	        } else {
	            if (!isValidName(name)) {
	                System.out.println("Invalid first name! It must contain only alphabetic characters.");
	            }
	            if (!isValidMobile(mobile)) {
	                System.out.println("Invalid mobile number! It must contain exactly 10 digits.");
	            }
	        }

	        scanner.close();
	    }

	    static boolean isValidName(String name) {
	        return name.matches("^[a-zA-Z]+$"); // Only alphabetic characters
	    }

	    static boolean isValidMobile(String mobile) {
	        return mobile.matches("^\\d{10}$"); // Exactly 10 digits
	    }
	}


