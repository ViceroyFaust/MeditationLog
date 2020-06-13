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

	public static boolean isMedTimeValid(String medTime) { // valid length is HH:MM:SS
		if (medTime.length() != 8 || medTime.charAt(2) != ':' || medTime.charAt(5) != ':') {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			if (i == 2 || i == 5) { // characters at position 2 and 5 aren't in the alphabet
				continue;
			}
			if (medTime.charAt(i) < 48 || medTime.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}

	public static int medTimeToMin(String medTime) {
		String times[] = medTime.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]) + (int) ((double) Integer.parseInt(times[2]) / 60 + .5);
	}
}
