import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateTimeHelper {

	public static String parseDate(String date) throws DateTimeParseException { // valid format is YYYY-MM-DD
			LocalDate.parse(date);
			return date;
			
	}

	public static int convertToMinutes(String humanReadable) throws NumberFormatException, ArrayIndexOutOfBoundsException { // valid format is HH:MM:SS
		String[] times = humanReadable.split(":");

		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]) + (int) (Integer.parseInt(times[2]) / 60.0 + 0.5);

	}

}
