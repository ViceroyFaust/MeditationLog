import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A static Journal class is responsible for the IO operations of the
 * MeditationLog program. The class writes and reads from the "data.csv" file
 * located in the directory of the program.
 * <p>
 * Since the program is not designed to be used by any outside users other than
 * the meditationLog program, it assumes that all input is correct and will run
 * successfully.
 * 
 * @author D. F. Owl
 *
 */
public class Journal {

	/**
	 * The variable is used to store the filename of the "database".
	 */
	private static final File file = new File("data.csv");

	/**
	 * Writes a JournalEntry object to the CSV file in "yyyy-MM-dd,HH:MM:SS" format.
	 * All entries are separated by a newline.
	 * 
	 * @param j JournalEntry which is to be written to the CSV file
	 * @throws IOException
	 */
	public static void addJournal(JournalEntry j) throws IOException {
		List<JournalEntry> list = readData();
		PrintWriter write = new PrintWriter(new FileWriter(file));
		list.add(j);
		Collections.sort(list); // Sorts the List by date
		for (JournalEntry journal : list) {
			write.println(journal.toString());
		}
		write.close();
	}

	/**
	 * Removes a specified record from the CSV file.
	 * 
	 * @param j JournalEntry which is to be removed from the CSV file
	 * @throws IOException
	 */
	public static void removeJournal(JournalEntry j) throws IOException {
		List<JournalEntry> list = readData();
		PrintWriter write = new PrintWriter(new FileWriter(file));
		for (JournalEntry journal : list) {
			if (!journal.equals(j)) {
				write.println(journal.toString());
			}
		}
		write.close();
	}

	/**
	 * Changes a particular existing JournalEntry with the JournalEntry provided.
	 * 
	 * @param j1 The target JournalEntry to be replaced
	 * @param j2 The JournalEntry which replaces the former
	 * @throws IOException
	 */
	public static void modifyJournal(JournalEntry j1, JournalEntry j2) throws IOException {
		List<JournalEntry> list = readData();
		list.set(list.indexOf(j1), j2); // Overwrites the existing JournalEntry with the new one
		PrintWriter write = new PrintWriter(new FileWriter(file));
		for (JournalEntry journal : list) {
			write.println(journal.toString());
		}
		write.close();
	}

	/**
	 * Searches the entire CSV file for records with a particular date and returns
	 * it to the user.
	 * 
	 * @param date A String in ISO-8601 "yyyy-MM-dd" format.
	 * @return A List of JournalEntry objects with the corresponding date. If none
	 *         found, returns an empty List.
	 * @throws IOException
	 */
	public static List<JournalEntry> dateSearch(String date) throws IOException {
		List<JournalEntry> list = readData();
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getDate().toString().equals(date)) { // Removes all objects with non-matching date
				list.remove(i);
				i--; // keeps the loop in sync after removal of an object
			}
		}
		return list;
	}

	/**
	 * Reads the entire CSV file, inserting the written entries into a List.
	 * 
	 * @return A List of all JournalEntry objects written in the CSV file. If the
	 *         file is empty, it will return an empty List.
	 * @throws IOException
	 */
	public static List<JournalEntry> readData() throws IOException {
		List<JournalEntry> list = new ArrayList<JournalEntry>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			list.add(JournalEntry.parse(line));
		}
		Collections.sort(list); // Sorts the List based on date. It is done here so that if the user enters data
								// manually into the CSV, the output of the method would always be correct.
		reader.close();
		return list;
	}
}
