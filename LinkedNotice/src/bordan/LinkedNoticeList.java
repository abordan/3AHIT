package bordan;
/**
 * A list of notices to manage personal informations.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-10-14
 *
 */
public class LinkedNoticeList {
	private LinkedNotice first;
	private LinkedNotice last;
	/**
	 * An empty List
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public LinkedNoticeList() {
		first = null;
		last = null;
	}
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
		for(int i = 0; i<this.size(); ++i) {
			a = true;
			for(int j = 0; j<this.size(); ++j) { // Makes the subject unique
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
	 * @since 2014-10-14
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
	 * @since 2014-10-14
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
	 * @since 2014-10-14
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
	 * @since 2014-10-14
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
	 * @since 2014-10-14
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
	 * Adds a notice to the list
	 * 
	 * @param n The notice to add
	 * 
	 * @param nr The index where to notice will be added
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void add(LinkedNotice n, int nr) {
		if(n==null) {
			return;
		}
		LinkedNotice show = first;
		for(int k = 0; k<nr; ++k) { // nr not higher than elements in the list
			if(show.getNext().equals(null)) {
				break;
			}else{
				show = show.getNext();
			}
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
			switch(nr) {
			case 0: // Case first
				if(first==null) {
					first = n;
					last = n;
				}else{
					n.setNext(first);
					first.setPre(n);
					n.setPre(null);
					first = n;
				}
				break;
			default :
				if(show.equals(last)) { // Case last 
					last.setNext(n);
					n.setPre(last);
					n.setNext(null);
					last = n;
				}else{ // Case between
					n.setNext(show);
					n.setPre(show.getPre());
					show.getPre().setNext(n);
					show.setPre(n);
				}
				break;
			}
			return;
		}
	}
	/**
	 * Gives the notice on the specified index.
	 * 
	 * @param index The index to get the notice 
	 * 
	 * @return The notice from the specified index
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public LinkedNotice get(int index) {
		LinkedNotice show = first;
		for(int i = 0; i<index; ++i) { // index not higher than elements in the list
			if(show==null) {
				return null;
			}else{
				show = show.getNext();
			}
		}
		return show;
	}
	/**
	 * Removes the notice from the specific index.
	 * 
	 * @return The removed notice
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void remove(int nr) {
		if(first==null) {
			return;
		}
		LinkedNotice show = first;
		for(int i = 0; i<nr; ++i) {
			if(show.getNext().equals(null)) {
				break;
			}else{
				show = show.getNext();
			}
		}
		switch(nr) {
		case 0:
			first = first.getNext();
			if(first!= null) {
				first.setPre(null);
			}
			break;
		default :
			if(show.equals(last)) {
				last = last.getPre();
				if(last!=null) {
					last.setNext(null);
				}
			}else{
				show.setPre(show.getPre().getPre());
				show.getPre().setNext(show);
			}
			break;
		}
	}
	/**
	 * Gives the size of the list.
	 * 
	 * @return The size of the list
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public int size() {
		int i = 0;
		for(LinkedNotice show = first; show!=null; show = show.getNext()) {
			++i;
		}
		return i;
	}
}
