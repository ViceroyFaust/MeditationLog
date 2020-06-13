import java.time.LocalDate;
import java.util.Comparator;

/**
 * A representation of a single entry in a meditation journal. It stores the
 * date and the length in time of a given meditation.
 * 
 * @author dfowl
 *
 */
public class JournalEntry implements Comparable<JournalEntry>, Comparator<JournalEntry> {
	private LocalDate date;
	private String medTime;

	/**
	 * Constructs the JournalEntry class based on CharSequence inputs.
	 * 
	 * @param date   a CharSequence representing an ISO-8601 date "yyyy-MM-dd"
	 * @param length a CharSequence representing a length in time "HH:MM:SS"
	 */
	public JournalEntry(CharSequence date, CharSequence length) {
		this.date = LocalDate.parse(date);
		this.medTime = length.toString();
	}

	public LocalDate getDate() {
		return date;
	}

	public String getMedTime() {
		return medTime;
	}

	/**
	 * Returns a String representation of a JournalEntry. The String is formatted as
	 * an ISO-8601 date and a String of time separated by a comma:
	 * "yyyy-MM-dd,HH:MM:SS"
	 */
	@Override
	public String toString() {
		return date.toString() + "," + medTime;
	}

	/**
	 * Returns a boolean based on whether this JournalEntry is equal to a given one.
	 * Two JournalEntry objects are equal if and only if both their date and length
	 * in time are equal.
	 */
	@Override
	public boolean equals(Object o) {
		JournalEntry j = (JournalEntry) o;
		return this.date.equals(j.getDate()) && this.medTime.equals(j.getMedTime());
	}

	/**
	 * Returns an integer signifying whether the date of the JournalEntry is lesser,
	 * equal, or greater than of this JournalEntry.
	 */
	@Override
	public int compareTo(JournalEntry j) {
		return this.date.compareTo(j.getDate());
	}

	/**
	 * Returns an integer signifying whether the date of the JournalEntry is less,
	 * equal, or greater than of a given JournalEntry.
	 */
	@Override
	public int compare(JournalEntry o1, JournalEntry o2) {
		return o1.compareTo(o2);
	}

	/**
	 * Parses a CharSequence representing an ISO-8601 date and a length in time separated by a comma: "yyyy-MM-dd,HH:MM:SS"
	 * @param text A CharSequence representing the JournalEntry object.
	 * @return an instantiated JournalEntry object.
	 */
	public static JournalEntry parse(CharSequence text) {
		return new JournalEntry(text.subSequence(0, 10), text.subSequence(11, 19));
	}
}
