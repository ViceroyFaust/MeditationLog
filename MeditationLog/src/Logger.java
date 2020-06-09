import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	private static final File file = new File("data.csv");
	
	public static void addLog(String date, String length) throws IOException {
		PrintWriter write = new PrintWriter(new FileWriter(file, true));
		write.printf("%s,%s%n", date, length);
		write.close();
	}
	
	public static void removeLog(String date, String length) throws IOException {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder builder = new StringBuilder();
			String line;
			int delete = 1;
			while((line = reader.readLine()) != null) { // Put file contents into builder
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
		while((line = reader.readLine()) != null) {
			if (line.contains(date)) {
				builder.append(line);
				builder.append("\n");
			}
		}
		reader.close();
		return builder.toString();
	}
}
