import java.time.LocalDate;
import java.util.Comparator;

public class JournalEntry implements Comparable<JournalEntry>, Comparator<JournalEntry> {
	private LocalDate date;
	private String medTime;

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

	@Override
	public String toString() {
		return date.toString() + "," + medTime;
	}

	@Override
	public boolean equals(Object o) {
		JournalEntry j = (JournalEntry) o;
		return this.date.equals(j.getDate()) && this.medTime.equals(j.getMedTime());
	}

	@Override
	public int compareTo(JournalEntry j) {
		return this.date.compareTo(j.getDate());
	}
	
	@Override
	public int compare(JournalEntry o1, JournalEntry o2) {
		return o1.compareTo(o2);
	}

	public static JournalEntry parse(CharSequence text) {
		return new JournalEntry(text.subSequence(0, 10), text.subSequence(11, 19));
	}
}
