import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * A helper class designed to handle most of the date/time format verification
 * and parsing within the MeditationLog program.
 * 
 * @author dfowl
 *
 */
public class DateTimeHelper {

	/**
	 * Checks whether a given date is valid based on the ISO-8601 format
	 * "yyyy-MM-dd". Uses the LocalDate parse method in order to check validity.
	 * 
	 * @param date a String to be checked.
	 * @return True if the date is valid; False if the date is invalid.
	 */
	public static boolean isDateValid(String date) { // valid date is YYYY-MM-DD
		// The format is always 10 characters long with '-' at indexes 4 and 7
		// A preliminary check so logic flow does not wholly rely on exceptions
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

	/**
	 * Checks whether a given String representing a certain length in time is valid.
	 * The length is represented in the HH:MM:SS format.
	 * 
	 * @param medTime a String in the HH:MM:SS format
	 * @return True if the input is properly formatted; False if the input is
	 *         incorrectly formatted
	 */
	public static boolean isMedTimeValid(String medTime) { // valid length is HH:MM:SS
		// The format's length is always 8 characters long and ':' are always present at
		// indexes 2 and 5
		if (medTime.length() != 8 || medTime.charAt(2) != ':' || medTime.charAt(5) != ':') {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			if (i == 2 || i == 5) { // Characters at positions 2 and 5 are not in the alphabet.
				continue;
			}
			if (medTime.charAt(i) < 48 || medTime.charAt(i) > 57) { // The format cannot include alphabetical characters
				return false;
			}
		}
		return true;
	}

	/**
	 * Converts the String representation of a certain length in time into an
	 * integer form of minutes.
	 * 
	 * @param medTime String length in time formatted HH:MM:SS
	 * @return an integer representing the time in minutes
	 */
	public static int medTimeToMin(String medTime) {
		String times[] = medTime.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]) + (int) ((double) Integer.parseInt(times[2]) / 60 + .5);
	}
}
