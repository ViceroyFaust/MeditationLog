import java.time.LocalDate;

public class JournalEntry implements Comparable<JournalEntry> {
	private LocalDate date;
	private String length;

	public JournalEntry(String date, String length) {
		this.date = LocalDate.parse(date);
		this.length = length;
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

}
