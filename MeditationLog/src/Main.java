import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// The user is presented with five options in the CLI menu
		System.out.println("Please present a choice:");
		System.out.printf("1. (A)dd Entry%n2. (M)odify Entry%n3. (R)emove Entry%n4. Print (S)tatistics%n5. (H)elp%n");
		String date, medTime; // Used for input commonly nearly across all cases

		switch (reader.readLine().toUpperCase()) {
		case "1": // Add entry
		case "A":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			System.out.print("Please Enter the Length: ");
			medTime = reader.readLine();
			if (DateTimeHelper.isDateValid(date) && DateTimeHelper.isMedTimeValid(medTime)) {
				Journal.addJournal(new JournalEntry(date, medTime));
			} else {
				System.out.print("ERROR: Incorrectly Formatted Input");
			}
			break;
		case "2": // Modify Entry
		case "M":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			if (DateTimeHelper.isDateValid(date)) {
				List<JournalEntry> list = Journal.dateSearch(date);
				if (list.size() > 0) {
					System.out.println(list.size() + " Dates Found:");
					for (JournalEntry journal : list) { // Prints out the times of every Journal of a needed date
						System.out.println(journal.getMedTime());
					}
					System.out.print("Select Time to Modify: ");
					medTime = reader.readLine();
					System.out.print("Enter New Time: ");
					Journal.modifyJournal(new JournalEntry(date, medTime), new JournalEntry(date, reader.readLine()));
				} else {
					System.out.println("No Date Found");
				}
			} else {
				System.out.println("ERROR: Incorrectly Formatted Date");
			}
			break;
		case "3": // Remove Entry
		case "R":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			if (DateTimeHelper.isDateValid(date)) {
				List<JournalEntry> list = Journal.dateSearch(date);
				if (list.size() > 0) {
					System.out.println(list.size() + " Dates Found:");
					for (JournalEntry journal : list) { // Prints out the times of every Journal of a needed date
						System.out.println(journal.getMedTime());
					}
					System.out.print("Select Time to Remove: ");
					Journal.removeJournal(new JournalEntry(date, reader.readLine()));
				} else {
					System.out.println("No Date Found");
				}
			} else {
				System.out.println("ERROR: Incorrectly Formatted Date");
			}
			break;
		case "4": // Print statistics
		case "S":
			System.out.println("...:::Statistics:::...");
			System.out.println("Time meditated per day: " + Calculator.getDailyAverage(Journal.readData()));
			System.out.println("Time meditated per week: " + Calculator.getWeeklyAverage(Journal.readData()));
			System.out.println("Time meditated per month: " + Calculator.getMonthlyAverage(Journal.readData()));
			System.out.println("\nLongest streak: " + Calculator.getHighestStreak(Journal.readData()));
			System.out.println("Total minutes of meditation " + Calculator.getMinuteSum(Journal.readData()));
			break;
		default:
			System.out.println("Error: bad input");
		}
	}

}
