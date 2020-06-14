import java.util.List;

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
			int highest = 1;
			int current = 1;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).compareTo(list.get(i - 1)) == 1) {
					current++;
				} else if (list.get(i).compareTo(list.get(i - 1)) != 0) {
					if (highest < current) {
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
	 * Calculates a minute average of the JournalEntry list.
	 * 
	 * @param list JournalEntry List representing.
	 * @return double representation of average minutes meditated per day.
	 */
	public static double getDailyAverage(List<JournalEntry> list) {
		if (list.size() != 0) {
			double sum = 0;
			for (JournalEntry journal : list) {
				sum += DateTimeHelper.medTimeToMin(journal.getMedTime());
			}
			return sum / list.size();
		} else {
			return 0;
		}
	}
}
