
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author arghhjayy
 */

public class PropertiesTest {
	
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
	
		prop.load(new FileInputStream("Database.properties"));
		
		System.out.println("Enter your username: ");
		
		Scanner scanner = new Scanner(System.in);
		
		String username = scanner.next();
		
		System.out.println("Enter your password: ");
		
		String password = scanner.next();
		
		if(prop.get(username) != null)
			if(prop.get(username).equals(password))
				System.out.println("Logged in!");
			else
				System.out.println("Login denied.");
		else
			System.out.println("No such user.");
	}
	
}
