import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please present a choice:");
		System.out.printf("1. (A)dd Entry%n2. (M)odify Entry%n3. (R)emove Entry%n4. Print (S)tatistics%n5. (H)elp%n");
		String date, medTime;
		switch (reader.readLine().toUpperCase()) {
		case "1":
		case "A":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			System.out.print("Please Enter the Length: ");
			medTime = reader.readLine();
			if (DateTimeHelper.isDateValid(date) && DateTimeHelper.isMedLengthValid(medTime)) {
				Journal.addJournal(new JournalEntry(date, medTime));
			} else {
				System.out.print("ERROR: Incorrectly Formatted Input");
			}
			break;
		case "2":
		case "M":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			if (DateTimeHelper.isDateValid(date)) {
				List<JournalEntry> list = Journal.dateSearch(date);
				if (list.size() > 0) {
					System.out.println(list.size() + " Dates Found:");
					for (JournalEntry journal : list) {
						System.out.println(journal.getMedLength());
					}
					System.out.print("Select Time to Modify: ");
					medTime = reader.readLine();
					System.out.print("Enter New Time: ");
					Journal.modifyJournal(new JournalEntry(date, medTime), new JournalEntry(date, reader.readLine()));
				}
			}
			break;
		case "3":
		case "R":
			System.out.print("Please Enter the Date: ");
			date = reader.readLine();
			if (DateTimeHelper.isDateValid(date)) {
				List<JournalEntry> list = Journal.dateSearch(date);
				if (list.size() > 0) {
					System.out.println(list.size() + " Dates Found:");
					for (JournalEntry journal : list) {
						System.out.println(journal.getMedLength());
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
		case "4":
		case "S":
			break;
		default:
			System.out.println("Error: bad input");
		}
	}

}
