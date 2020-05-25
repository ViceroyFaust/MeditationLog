import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	public static void addLog(String date, String length) throws IOException {
		PrintWriter write = new PrintWriter(new FileWriter(new File("data.csv"), true));
		write.printf("%s,%s%n", date, length);
		write.close();
	}
	
	public static void removeLog(String date, String length) throws IOException {
			File file = new File("data.csv");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder builder = new StringBuilder();
			String line;
			int delete = 1;
			while((line = reader.readLine()) != null) {
				if (line.equals(date + "," + length) && delete != 0) {
					delete--;
					continue;
				}
				builder.append(line + "\n");
			}
			System.out.println(builder.toString());
			reader.close();
			FileWriter write = new FileWriter(file);
			write.write(builder.toString());
			write.close();
	}
}
