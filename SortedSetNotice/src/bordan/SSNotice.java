package bordan;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * A changeable SSNotice for further usage in a list.
 * 
 * @author Andreas Bordan
 * @version 2014-11-12
 *
 */
public class SSNotice implements Comparable<SSNotice>, Comparator<SSNotice>{
	private String subject, text;
	private GregorianCalendar date;
	private int priority;
	public static final int LOW = 1, MEDIUM = 2, HIGH = 3, REALTIME = 4, SAME = 12;
	/**
	 * Creates a SSNotice of the specific values.
	 * 
	 * @param subject The subject for the SSNotice
	 * @param text The text for the SSNotice
	 * @param priority The priority for the SSNotice
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public SSNotice(String subject, String text, int priority) {
		this.subject = subject;
		this.text = text;
		this.date = new GregorianCalendar();
		this.priority = priority;
	}
	/**
	 * For easier usage as Comparator
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public SSNotice() {
		this.subject = "";
		this.text = "";
		this.date = new GregorianCalendar();
		this.priority = -1;
	}
	/**
	 * Gets the subject of the SSNotice.
	 * 
	 * @return The subject
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public String getSubject() {
		return this.subject;
	}
	/**
	 * Gets the date of the SSNotice.
	 * 
	 * @return The date
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public String getDate() {
		return ""+this.date.get(Calendar.DATE)+"."+(this.date.get(Calendar.MONTH)+1)+"."+this.date.get(Calendar.YEAR);
	}
	/**
	 * Gets the text of the SSNotice.
	 * 
	 * @return The text
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public String getText() {
		return this.text;
	}
	/**
	 * Gets the priority of the SSNotice.
	 * 
	 * @return The priority
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public int getPriority() {
		return this.priority;
	}
	/**
	 * Sets the subject of the SSNotice.
	 * 
	 * @param subject The new subject
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * Sets the text of the SSNotice.
	 * 
	 * @param text The new text
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * Sets the priority of the SSNotice.
	 * 
	 * @param priority The new priority
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * Compares this notice object with the specified notice.
	 * 
	 * @param o The other notice for comparison
	 * 
	 * @return True if the compareTo method says 0
	 * 
	 * @since 2014-11-12
	 * 
	 */
	@Override
	public boolean equals(Object o) {
		if(o!=null) {
			if(o instanceof SSNotice) {
				if(this.compareTo((SSNotice) o)==0) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Compares this date with the date from the specified notice.
	 * 
	 * @param n The notice needed for the date comparison
	 * 
	 * @return SAME if the two dates are equal in year and day, 
	 * 		   otherwise compareTo from GregorianCalendar
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public int compareDate(SSNotice n) {
		if(this.date.get(Calendar.YEAR)==n.date.get(Calendar.YEAR)) {
			if(this.date.get(Calendar.DAY_OF_YEAR)==n.date.get(Calendar.DAY_OF_YEAR)) {
				return SAME;
			}
		}
		return this.date.compareTo(n.date);
	}
	/**
	 * Compares this notice with the specified one based on date and subject
	 * 
	 * @param The notice needed for comparison
	 * 
	 * @return 0 if the two notices are equal in subject and date, 
	 *         otherwise compareTo from String(only same date) or
	 *         compareTo from date(nothing equal)
	 * 
	 * @since 2014-11-12
	 * 
	 */
	@Override
	public int compareTo(SSNotice n) {
		if(n!=null) {
			if((this.subject.equals(n.getSubject()))&&(this.compareDate(n)==SAME)) {
				return 0;
			}
			if(this.compareDate(n)==SAME) {
				return this.subject.compareTo(n.subject);
			}
		}
		return this.date.compareTo(n.date);
	}
	/**
	 * Compares two notices based on priority and date
	 * 
	 * @param n1 The first notice to compare
	 * @param n2 The second notice to compare
	 * 
	 * @return Indicates if the notice is higher or lower
	 * 
	 * @since 2014-11-12
	 * 
	 */
	@Override
	public int compare(SSNotice n1, SSNotice n2) {
		if(n1.priority==n2.priority) {
			return n1.date.compareTo(n2.date);
		}else{
			if(n1.priority<n2.priority) {
				return 1; // First lower
			}
		}
		return -1; // First higher
	}
}