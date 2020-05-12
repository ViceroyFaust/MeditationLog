import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeParseException;

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
			try {
			Logger.addLog(DateTimeHelper.parseDate(date), DateTimeHelper.convertToMinutes(length));
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("NOTICE: Please enter a valid HH:MM:SS time.");
			} catch (DateTimeParseException e) {
				System.out.println("NOTICE: Please enter a valid YYYY:MM:DD date.");
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
