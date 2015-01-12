package bordan;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * A list of notices to manage personal informations.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-11-12
 *
 */
public class SSNoticeList {
	private TreeSet <SSNotice> ts; 
	private SSNotice[] arr;
	/**
	 * Initializes a TreeSet
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public SSNoticeList() {
		ts = new TreeSet<SSNotice> ();
	}
	/**
	 * Sorts the list based on the given comparator
	 * 
	 * @param c The comparator needed for sorting
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public void sort(Comparator<SSNotice> c) {
		TreeSet<SSNotice> ts2 = new TreeSet<SSNotice> (ts);
		ts = new TreeSet<SSNotice> (c);
		ts.addAll(ts2);
		this.arraying();
	}
	/**
	 * Loads the TreeSet into an array in order to go through it easier.
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public void arraying() {
		arr = ts.toArray(new SSNotice[ts.size()]);
	}
	/**
	 * Edits this notice
	 * 
	 * @param index The notice to edit
	 * @param subject The new subject
	 * @param text The new text
	 * @param priority The new priority
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public void edit(int index, String subject, String text, int priority) {
		if(index<0 || index==ts.size()) { // Reveals if the number exists
			return;
		}
		arr[index].setSubject(subject);
		arr[index].setText(text);
		arr[index].setPriority(priority);
	}
	/**
	 * Gets the date from the notice on the specified index.
	 * 
	 * @param index The notice to get the date from
	 * 
	 * @return The date from the notice
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public String getDate(int index) {
		if(index<0|| index==ts.size()) {
			return null;
		}
		return arr[index].getDate();
	}
	/**
	 * Gets the subject from the notice on the specified index.
	 * 
	 * @param index The notice to get the subject from
	 * 
	 * @return The subject from the notice
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public String getSubject(int index) {
		if(index<0|| index==ts.size()) {
			return null;
		}
		return arr[index].getSubject();
	}
	/**
	 * Gets the text from the notice on the specified index.
	 * 
	 * @param index The notice to get the text from
	 * 
	 * @return The text from the notice
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public String getText(int index) {
		if(index<0|| index==ts.size()) {
			return null;
		}
		return arr[index].getText();
	}
	/**
	 * Gets the priority from the notice on the specified index
	 * 
	 * @param index The notice to get the priority from
	 * 
	 * @return The priority from the notice
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public int getPriority(int index)  {
		if(index<0|| index==ts.size()) {
			return 0;
		}
		return arr[index].getPriority();
	}
	/**
	 * Gets the subjects from all notices.
	 * 
	 * @return All subjects 
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public String [] getSubjects() {
		String [] subjects = null;
			subjects = new String[ts.size()];
			for(int i = 0; i<subjects.length; ++i) {
				subjects[i] = getSubject(i);
			}
		return subjects;
	}
	/**
	 * Removes a notice from the specified index.
	 * 
	 * @param index The index to remove the notice from
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public void remove(int index) {
		if(index>=ts.size()) {
			return;
		}
		ts.remove(arr[index]);
	}
	/**
	 * Adds a notice.
	 * 
	 * @param n The notice to add
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public void add(SSNotice n) {
		if(n==null) {
			return;
		}
		ts.add(n);
	}
}