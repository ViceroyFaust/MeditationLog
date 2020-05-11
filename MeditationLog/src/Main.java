import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please present a choice:");
		System.out.printf("1. (A)dd Entry%n2. (M)odify Entry%n3. (R)emove Entry%n4. Print (S)tatistics%n5. (H)elp%n");
		switch (reader.readLine().toUpperCase()) {
		case "1":
		case "A":
			System.out.println("Please Enter the Date: ");
			String date = reader.readLine();
			System.out.println("Please Enter the Length: ");
			String length = reader.readLine();
			if (!DateTimeValidator.isDateValid(date)) {
				System.out.println("Wrong date");
				break;
			} else {
				Logger.addLog(date, length);
			}
			break;
		case "2":
		case "M":
			break;
		case "3":
		case "R":
			break;
		case "4":
		case "S":
			break;
		default:
			System.out.println("Error: bad input");
		}
	}

}
