import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	public static void addLog(String date, int length) throws IOException {
		PrintWriter write = new PrintWriter(new FileWriter(new File("data.csv"), true));
		write.printf("%s, %d%n", date, length);
		write.close();
	}

}
