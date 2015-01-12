package bordan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Performs all actions for the buttons and initializes the program.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-11-12
 *
 */
public class SSNController implements ActionListener {
	private SSNoticeList model;
	private SSNUI view;
	/**
	 * Initializes model and view.
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public SSNController() {
		model = new SSNoticeList();
		view = new SSNUI("Notice me Senpai", this, model.getDate(-1));
	}
	/**
	 * The actions that are performed when a button is pressed.
	 * 
	 * @param e The button that is pressed
	 * 
	 * @since 2014-11-12
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Save")) { // Saves the current values in an existing notice
			model.edit(view.getNotice(), view.getSubject(), view.getText(), view.getPriority());
			view.actualizeList(model.getSubjects());
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("New")) { // Adds a new notice or does nothing, if the notice already exists
			model.add(new SSNotice(view.getSubject(), view.getText(), view.getPriority()));
			model.arraying();
			view.actualizeList(model.getSubjects());
			view.init(model.getDate(-1));
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("Delete")) { // Deletes an existing notice or does nothing, if there is no notice
			model.remove(view.getNotice());
			model.arraying();
			view.actualizeList(model.getSubjects());
			view.init(model.getDate(-1));
			view.revalidate();
			view.repaint();
			view.pack();
		}
		if(e.getActionCommand().equals("Notices")) { // Loads the values from an existing notice
			view.setSubject(model.getSubject(view.getNotice()));
			view.setText(model.getText(view.getNotice()));
			view.setDate(model.getDate(view.getNotice()));
			view.setPriority(model.getPriority(view.getNotice()));
		}
		if(e.getActionCommand().equals("Sorting")) { // Sort based on given mechanism and list again.
			if(view.getSort().equals("Prioritize")) {
				model.sort(new SSNotice());
			}else{
				model.sort(null);
			}
			view.actualizeList(model.getSubjects());
		}
	}
	/**
	 * Starts the program
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public static void main(String[]args) {
		new SSNController();
	}
}