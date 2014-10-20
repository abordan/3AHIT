package bordan;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A changeable notice for further usage in a list.
 * 
 * @author Andreas Bordan
 * @version 2014-09-29
 *
 */
public class Notice {
	private String subject, text, date;
	private int priority;
	public static final int LOW = 1, MEDIUM = 2, HIGH = 3, REALTIME = 4;
	/**
	 * Creates a notice of the specific values.
	 * 
	 * @param subject The subject for the notice
	 * @param text The text for the notice
	 * @param priority The priority for the notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public Notice(String subject, String text, int priority) {
		this.subject = subject;
		this.text = text;
		this.date = new SimpleDateFormat().format(new Date());
		this.priority = priority;
	}
	/**
	 * Sets the date of the notice to now.
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public void changeDate() {
		this.date = new SimpleDateFormat().format(new Date());
	}
	/**
	 * Gets the subject of the notice.
	 * 
	 * @return The subject
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getSubject() {
		return this.subject;
	}
	/**
	 * Gets the date of the notice.
	 * 
	 * @return The date
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getDate() {
		return this.date;
	}
	/**
	 * Gets the text of the notice.
	 * 
	 * @return The text
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getText() {
		return this.text;
	}
	/**
	 * Gets the priority of the notice.
	 * 
	 * @return The priority
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public int getPriority() {
		return this.priority;
	}
	/**
	 * Sets the subject of the notice.
	 * 
	 * @param subject The new subject
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * Sets the text of the notice.
	 * 
	 * @param text The new text
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * Sets the priority of the notice.
	 * 
	 * @param priority The new priority
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
