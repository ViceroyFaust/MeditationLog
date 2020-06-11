import java.time.LocalDate;

public class JournalEntry implements Comparable<JournalEntry> {
	private LocalDate date;
	private String length;

	public JournalEntry(CharSequence date, CharSequence length) {
		this.date = LocalDate.parse(date);
		this.length = length.toString();
	}
	
	public LocalDate getDate() {
		return date;
	}

	public String getLength() {
		return length;
	}

	@Override
	public String toString() {
		return date.toString() + "," + length;
	}

	@Override
	public boolean equals(Object o) {
		JournalEntry j = (JournalEntry) o;
		return this.date.equals(j.getDate()) && this.length.equals(j.getLength());
	}

	@Override
	public int compareTo(JournalEntry j) {
		return this.date.compareTo(j.getDate());
	}

	public static JournalEntry parse(CharSequence text) {
		return new JournalEntry(text.subSequence(0, 10), text.subSequence(11, 19));
	}
}
