import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Journal {

	private static final File file = new File("data.csv");

	public static void addJournal(String date, String length) throws IOException {
		PrintWriter write = new PrintWriter(new FileWriter(file, true));
		List<JournalEntry> list = readData();
		list.add(new JournalEntry(date, length));
		Collections.sort(list);
		for (JournalEntry j : list) {
			write.printf(j.toString());
		}
		write.close();
	}

	public static void removeLog(String date, String length) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String line;
		int delete = 1;
		while ((line = reader.readLine()) != null) { // Put file contents into builder
			if (line.equals(date + "," + length) && delete != 0) { // Omit the targeted line from builder
				delete--;
				continue;
			}
			builder.append(line);
			builder.append("\n");
		}
		reader.close();
		FileWriter writer = new FileWriter(file); // Write the builder to file
		writer.write(builder.toString());
		writer.close();
	}

	public static String dateSearch(String date) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			if (line.contains(date)) {
				builder.append(line);
				builder.append("\n");
			}
		}
		reader.close();
		return builder.toString();
	}

	public static List<JournalEntry> readData() throws IOException {
		List<JournalEntry> list = new ArrayList<JournalEntry>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			list.add(JournalEntry.parse(line));
		}
		Collections.sort(list);
		reader.close();
		return list;
	}
}
