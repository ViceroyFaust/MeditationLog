import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateTimeValidator {

	public static boolean isDateValid(String date) { // valid format is YYYY-MM-DD
		try {
			LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

	public static boolean isTimeValid(String time) { // valid format is HH:MM:SS
		if (time.length() != 8) {
			return false;
		}
		try {
			String[] times = time.split(":");
			for (String s : times) {
				Integer.parseInt(s);
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
