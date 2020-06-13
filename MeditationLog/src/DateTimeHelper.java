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

	public static boolean isMedLengthValid(String medLength) { // valid length is HH:MM:SS
		if (medLength.length() != 8 || medLength.charAt(2) != ':' || medLength.charAt(5) != ':') {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			if (i == 2 || i == 5) { // characters at position 2 and 5 aren't in the alphabet
				continue;
			}
			if (medLength.charAt(i) < 48 || medLength.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}

	public static int medLengthToMin(String medLength) {
		String lengths[] = medLength.split(":");
		return Integer.parseInt(lengths[0]) * 60 + Integer.parseInt(lengths[1]) + (int) ((double) Integer.parseInt(lengths[2]) / 60 + .5);
	}
}
