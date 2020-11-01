import java.time.DayOfWeek;
import java.util.List;

/**
 * Class responsible for calculating streaks, daily, weekly, and monthly
 * averages of JournalEntry Lists.
 * 
 * @author dfowl
 *
 */
public class Calculator {
	/**
	 * Checks all of the JournalEntries within a List for continuity. It is assumed
	 * that the list is already ordered from the least to greatest. If the list is
	 * empty, the return will be 0; if the list contains dates but no continuity,
	 * the return will be 1. If there is continuity the number will always be
	 * greater than 1.
	 * 
	 * @param list a List with JournalEntry objects. They must be ordered from least
	 *             to greatest.
	 * @return an integer representation of continuity
	 */
	public static int getHighestStreak(List<JournalEntry> list) {
		if (list.size() != 0) {
			int highest = 1; // The lowest streak possible is 1
			int current = 1;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).compareTo(list.get(i - 1)) == 1) { ///
					current++;
				}
				// Check the streak size when streak ends or when the array ends
				if (list.get(i).compareTo(list.get(i - 1)) > 1 || i == list.size() - 1) {
					if (highest < current) { // update the highest streak and reset the current streak
						highest = current;
						current = 1;
					}
				}
			}
			return highest;
		} else {
			return 0;
		}
	}

	/**
	 * Calculates a minute average of the JournalEntry list per day.
	 * 
	 * @param list JournalEntry List representing a record of meditations.
	 * @return double representation of average minutes meditated per day. Returns 0
	 *         in the case that the List is empty.
	 */
	public static double getDailyAverage(List<JournalEntry> list) {
		if (list.size() != 0) {
			return (double) getMinuteSum(list) / getDays(list);
		} else {
			return 0;
		}
	}

	/**
	 * Calculates a minute average of JournalEntry List per week. Works best once
	 * the user has accumulated over 2 weeks worth of data.
	 * 
	 * @param list JournalEntry List representing a record of meditations.
	 * @return double representation of average minutes meditated per week. Returns
	 *         0 in the case that the List is empty.
	 */
	public static double getWeeklyAverage(List<JournalEntry> list) {
		if (list.size() != 0) {
			int week = 1;
			for (int i = 0; i < list.size(); i++) {
				if (i > 1 && list.get(i).getDate().getDayOfWeek() == DayOfWeek.SUNDAY) {
					week++;
				}
			}
			return getMinuteSum(list) / (double) week;

		} else {
			return 0;
		}

	}

	/**
	 * Calculates a minute average of JournalEntry List per month. Works best once
	 * the user has accumulated over 2 months worth of data.
	 * 
	 * @param list JournalEntry List representing a record of meditations.
	 * @return double representation of average minutes meditated per month. Returns
	 *         0 in the case that the list is empty.
	 */
	public static double getMonthlyAverage(List<JournalEntry> list) {
		if (list.size() != 0) {
			int month = 1;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i).getDate().getMonth() != list.get(i + 1).getDate().getMonth()) {
					month++;
				}
			}
			return getMinuteSum(list) / (double) month;
		} else {
			return 0;
		}
	}

	/**
	 * Calculates the minute total of all meditations in a List of JournalEntry
	 * objects. Returns 0 if the List is empty.
	 * 
	 * @param list JournalEntry List representing a record of meditations.
	 * @return int representation of total minutes meditated. Returns 0 in the case
	 *         that the List is empty. Never returns a number less than 0.
	 */
	public static int getMinuteSum(List<JournalEntry> list) {
		int sum = 0;
		for (JournalEntry journal : list) {
			sum += DateTimeHelper.medTimeToMin(journal.getMedTime());
		}
		return sum;
	}

	public static int getDays(List<JournalEntry> list) {
		if (list.size() == 0) {
			return 0;
		}
		int days = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).compareTo(list.get(i - 1)) >= 1) {
				days++;
			}
		}
		return days;
	}
}
