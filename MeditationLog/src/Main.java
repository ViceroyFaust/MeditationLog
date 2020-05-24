import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please present a choice:");
		System.out.printf("1. (A)dd Entry%n2. (M)odify Entry%n3. (R)emove Entry%n4. Print (S)tatistics%n5. (H)elp%n");
		String date, length;
		switch (reader.readLine().toUpperCase()) {
		case "1":
		case "A":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			System.out.print("Please Enter the Length: ");
			length = reader.readLine();
			if (DateTimeHelper.isDateValid(date) || DateTimeHelper.isLengthValid(length)) {
				Logger.addLog(date, DateTimeHelper.lengthToMin(length));
			} else {
				System.out.print("ERROR: Incorrect Format Input");
			}
			break;
		case "2":
		case "M":
			break;
		case "3":
		case "R":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			System.out.print("Please Enter the Length: ");
			length = reader.readLine();
			Logger.removeLog(date, DateTimeHelper.lengthToMin(length));
			break;
		case "4":
		case "S":
			break;
		default:
			System.out.println("Error: bad input");
		}
	}

}
