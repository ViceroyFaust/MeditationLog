import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateTimeHelper {
	public static boolean isDateValid(String date) { // valid date is YYYY-MM-DD
		if (date.length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-') {
			return false;
		}
		try {
			LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return false;
		}

		return true;
	}

	public static boolean isLengthValid(String length) { // valid length is HH:MM:SS
		if (length.length() != 8 || length.charAt(2) != ':' || length.charAt(5) != ':') {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			if (i == 2 || i == 5) {
				continue;
			}
			if (length.charAt(i) < 48 || length.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}

	public static int lengthToMin(String length) {
		String lengths[] = length.split(":");
		return Integer.parseInt(lengths[0]) * 60 + Integer.parseInt(lengths[1]) + (int) ((double) Integer.parseInt(lengths[2]) / 60 + .5);
	}
}
