import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String name = Validator.getString(scan, "Please enter a valid name: ");
		System.out.println(validateName(name));
		
		String email = Validator.getString(scan, "Please enter a valid email: ");
		System.out.println(validateEmail(email));
		
		String phone = Validator.getString(scan, "Please enter a valid phone number (with dashes): ");
		System.out.println(validatePhone(phone));
		
		String date = Validator.getString(scan, "Please enter a valid date: (dd/mm/yyyy) ");
		System.out.println(validateDate(date));
		
		scan.close();
	}
	
	public static String validateName (String name) {
		
		String regex = "^[A-Z][a-z]{1,30}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if (m.matches()) {
			return "Name is valid!";			
		}
		return "Sorry, name is not valid!";
	}
	
	public static String validateEmail (String email) {
		email = email.toLowerCase();
		String regex = "[a-z,\\d]{5,30}@[a-z,\\d]{5,10}\\.[a-z,\\d]{2,3}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if (m.matches()) {
			return "Email is valid!";
		} 
		return "Sorry, email is not valid!";
		
	}
	
	public static String validatePhone (String phone) {
		String regex = "\\d{3}-\\d{3}-\\d{4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phone);
		if (m.matches()) {
			return "Phone number is valid!";
		}
		return "Sorry, phone is not valid!";
	}
	
	public static String validateDate (String date) {
		String regex = "^[0-3]{1}[0-9]{1}\\/[0-1]{1}[0-9]{1}\\/\\d{4}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(date);
		if (m.matches()) {
			return "Date is valid!";
		}
		return "Sorry, date is not valid!";
	}
}
