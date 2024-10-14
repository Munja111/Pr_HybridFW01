package Experiment;

import java.util.Date;
import com.github.javafaker.Faker;

public class Demo {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString().replace(" ","_").replace(":", "_").replace("_", "").replace("IST", ""));
	


	        // Create a Faker instance
	        Faker faker = new Faker();
	        
	        // Generate random data
	        String name = faker.name().fullName();
	        String address = faker.address().fullAddress();
	        String email = faker.internet().emailAddress();
	        
	        // Print the generated data
	        System.out.println("Name: " + name);
	        System.out.println("Address: " + address);
	        System.out.println("Email: " + email);
	    }
	}
	


