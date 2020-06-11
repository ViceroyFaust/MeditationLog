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

	public static void addJournal(JournalEntry j) throws IOException {
		List<JournalEntry> list = readData();
		PrintWriter write = new PrintWriter(new FileWriter(file));
		list.add(j);
		Collections.sort(list);
		for (JournalEntry journal : list) {
			write.println(journal.toString());
		}
		write.close();
	}

	public static void removeJournal(JournalEntry j) throws IOException {
		List<JournalEntry> list = readData();
		PrintWriter write = new PrintWriter(new FileWriter(file));
		for (JournalEntry journal : list) {
			if (journal.equals(j)) {
				continue;
			}
			write.println(journal.toString());
		}
		write.close();
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
