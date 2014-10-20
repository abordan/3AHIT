package bordan;
import java.util.ArrayList;

/**
 * A list of notices to manage personal informations.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-10-14
 *
 */
@SuppressWarnings("serial")
public class NoticeList extends ArrayList <Notice> {
	/**
	 * Edits a notice
	 * 
	 * @param index The notice to edit
	 * @param subject The new subject
	 * @param text The new text
	 * @param priority The new priority
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void edit(int index, String subject, String text, int priority) {
		if(index<0 || index==this.size()) { // Reveals if the number exists
			return;
		}
		boolean a;
		for(int i = 0; i<this.size(); ++i) { // Makes the subject unique
			a = true;
			for(int j = 0; j<this.size(); ++j) {
				if(subject.equals(get(j).getSubject())) {
					subject += " ";
					a = false;
				}
			}
			if(a) { // If the subject is unique, continue with program
				get(index).setSubject(subject);
				get(index).setText(text);
				get(index).setPriority(priority);
				get(index).changeDate();
				return;
			}
		}
	}
	/**
	 * Gets the date from the notice on the specific index.
	 * 
	 * @param index The notice to get the date from
	 * 
	 * @return The date from the notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getDate(int index) {
		if(index<0|| index==this.size()) {
			return null;
		}
		return get(index).getDate();
	}
	/**
	 * Gets the subject from the notice on the specific index.
	 * 
	 * @param index The notice to get the subject from
	 * 
	 * @return The subject from the notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getSubject(int index) {
		if(index<0|| index==this.size()) {
			return null;
		}
		return get(index).getSubject();
	}
	/**
	 * Gets the text from the notice on the specific index.
	 * 
	 * @param index The notice to get the text from
	 * 
	 * @return The text from the notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String getText(int index) {
		if(index<0|| index==this.size()) {
			return null;
		}
		return get(index).getText();
	}
	/**
	 * Gets the priority from the notice on the specific index
	 * 
	 * @param index The notice to get the priority from
	 * 
	 * @return The priority from the notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public int getPriority(int index)  {
		if(index<0|| index==this.size()) {
			return 0;
		}
		return get(index).getPriority();
	}
	/**
	 * Gets the subjects from all notices.
	 * 
	 * @return All subjects 
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public String [] getSubjects() {
		String [] subjects = new String[this.size()];
		for(int i = 0; i<subjects.length; ++i) {
			subjects[i] = getSubject(i);
		}
		return subjects;
	}
	/**
	 * Removes the notice from the specific index.
	 * 
	 * @return The removed notice
	 * 
	 * @since 2014-09-29
	 * 
	 */
	@Override
	public Notice remove(int index) {
		if(index<0|| index==this.size()) {
			return null;
		}else{
		 	return super.remove(index);
		}
	}
	/**
	 * Adds a notice to the list.
	 * 
	 * @param n The notice to add to the list
	 * 
	 * @return Indicates if the notice got added or not
	 * 
	 * @since 2014-10-14
	 * 
	 */
	@Override
	public boolean add (Notice n) {
		if(n==null) {
			return false;
		}
		boolean a = true;
		for(int i = 0; i<this.size(); ++i) {
			a = true;
			for(int j = 0; j<this.size(); ++j) {
				if(n.getSubject().equals(get(j).getSubject())) {
					n.setSubject(n.getSubject()+" ");
					a = false;
				}
			}
		}
		if(a) {
			return super.add(n);
		}
		return false;
	}
}
