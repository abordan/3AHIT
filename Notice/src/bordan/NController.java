package bordan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Performs all actions for the buttons and initializes the program.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-09-29
 *
 */
public class NController implements ActionListener {
	private NoticeList model;
	private NUI view;
	/**
	 * Initializes model and view.
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public NController() {
		model = new NoticeList();
		view = new NUI("Notizliste", this, model.getDate(-1));
	}
	/**
	 * The actions that are performed when a button is pressed.
	 * 
	 * @param e The button that is pressed
	 * 
	 * @since 2014-09-29
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Save")) { // Saves the current values in an existing notice
			model.edit(view.getListItem(), view.getSubject(), view.getText(), view.getPriority());
			view.actualizeList(model.getSubjects());
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("New")) { // Adds a new notice
			model.add(new Notice(view.getSubject(), view.getText(), view.getPriority()));
			view.actualizeList(model.getSubjects());
			view.init(model.getDate(-1));
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("Delete")) { // Deletes an existing notice or does nothing, if there is no notice
			model.remove(view.getListItem());
			view.actualizeList(model.getSubjects());
			view.init(model.getDate(-1));
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("Notices")) { // Loads the values from an existing notice
			view.setSubject(model.getSubject(view.getListItem()));
			view.setText(model.getText(view.getListItem()));
			view.setDate(model.getDate(view.getListItem()));
			view.setPriority(model.getPriority(view.getListItem()));
		}
	}
	/**
	 * Starts the program
	 * 
	 * @since 2014-09-29
	 * 
	 */
	public static void main(String[]args) {
		new NController();
	}
}
