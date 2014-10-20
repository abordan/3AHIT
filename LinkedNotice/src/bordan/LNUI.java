package bordan;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The visible window and its containing components
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-10-14
 *
 */
@SuppressWarnings("serial")
public class LNUI extends JFrame {
	private JButton save, neu, delete;
	private JLabel lPriority, lDate, lSubject;
	private JTextField tDate, tSubject;
	private JComboBox<String> tPriority, notices;
	private JTextArea tText;
	private JPanel buttons, changing, priority, date, subject, text;
	private ActionListener aL;
	/**
	 * Creates a new window with its components for usage of a notice list.
	 * 
	 * @param title The window title
	 * @param aL The ActionListener for the buttons
	 * @param datum The date for the window
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public LNUI(String title, ActionListener aL, String datum) {
		super(title);
		this.setSize(1440, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.aL = aL;
		save = new JButton("Save");
		neu = new JButton("Add");
		delete = new JButton("Delete");
		save.setActionCommand("Save");
		//save.setMnemonic(KeyEvent.VK_S); does not work
		save.addActionListener(aL);
		neu.setActionCommand("New");
		//neu.setMnemonic(KeyEvent.VK_A); does not work
		neu.addActionListener(aL);
		delete.setActionCommand("Delete");
		//delete.setMnemonic(KeyEvent.VK_D); does not work
		delete.addActionListener(aL);
		notices = new JComboBox<String>();
		notices.removeAll();
		notices.setActionCommand("Notices");
		notices.addActionListener(aL);
		notices.setLayout(new FlowLayout());
		lPriority = new JLabel("Priority", SwingConstants.LEFT);
		lDate = new JLabel("Changedate", SwingConstants.LEFT);
		lSubject = new JLabel("Subject", SwingConstants.LEFT);
		tPriority = new JComboBox<String>();
		tPriority.addItem("Low");
		tPriority.addItem("Medium");
		tPriority.addItem("High");
		tPriority.addItem("Realtime");
		tDate = new JTextField(datum, 10);
		tSubject = new JTextField(" ", 10);
		tText = new JTextArea(10, 15);
		tPriority.setActionCommand("Priority");
		priority = new JPanel();
		date = new JPanel();
		subject = new JPanel();
		text = new JPanel();
		priority.add(lPriority);
		priority.add(tPriority);
		date.add(lDate);
		date.add(tDate);
		tDate.setEditable(false);
		subject.add(lSubject);
		subject.add(tSubject);
		text.add(tText);
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttons.add(save);
		buttons.add(neu);
		buttons.add(delete);
		this.add(buttons, BorderLayout.SOUTH);
		changing = new JPanel();
		changing.setLayout(new BoxLayout(changing, BoxLayout.PAGE_AXIS));
		changing.add(notices);
		changing.add(subject);
		changing.add(date);
		changing.add(priority);
		changing.add(text);
		this.add(changing, BorderLayout.CENTER);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * Sets the subject of the text field.
	 * 
	 * @param subject The new subject
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void setSubject(String subject) {
		tSubject.setText(subject);
	}
	/**
	 * Sets the text of the text area.
	 * 
	 * @param text The new text
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void setText(String text) {
		tText.setText(text);
	}
	/**
	 * Sets the date of the text field.
	 * 
	 * @param date The new date
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void setDate(String date) {
		tDate.setText(date);
	}
	/**
	 * Sets the priority of the combo box.
	 * 
	 * @param priority The new priority
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void setPriority(int priority) {
		switch(priority) {
		case LinkedNotice.LOW:
			tPriority.setSelectedItem("Low");
			break;
		case LinkedNotice.MEDIUM:
			tPriority.setSelectedItem("Medium");
			break;
		case LinkedNotice.HIGH:
			tPriority.setSelectedItem("High");
			break;
		case LinkedNotice.REALTIME:
			tPriority.setSelectedItem("Realtime");
			break;
		}
	}
	/**
	 * Initializes a window with empty values.
	 * 
	 * @param date The date to set
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void init(String date) {
		tSubject.setText(" ");
		tDate.setText(date);
		tText.setText("");
		tPriority.setSelectedItem("Low");
	}
	/**
	 * Gets the subject in the text field.
	 * 
	 * @return The subject of the text field
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public String getSubject() {
		return tSubject.getText();
	}
	/**
	 * Gets the priority of the combo box.
	 * 
	 * @return The priority of the text field
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public int getPriority() {
		switch(tPriority.getSelectedItem().toString()) {
		case "Low":
			return LinkedNotice.LOW;
		case "Medium":
			return LinkedNotice.MEDIUM;
		case "High":
			return LinkedNotice.HIGH;
		case "Realtime":
			return LinkedNotice.REALTIME;
		default:
			return 0;
		}
	}
	/**
	 * Gets the index of the currently selected button in the list.
	 *  
	 * @return The index of the selected button
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public int getListItem() {
		return notices.getSelectedIndex();
	}
	/**
	 * Gets the text in the text area.
	 * 
	 * @return The text of the text area
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public String getText() {
		return tText.getText();
	}
	/**
	 * Actualizes the JComboBox with all new items
	 * 
	 * @param subjects The subjects to set the item titles
	 * 
	 * @since 2014-10-14
	 * 
	 */
	public void actualizeList(String[] subjects) {
		if(subjects!=null) {
			notices.removeAll();
			notices.removeAllItems();
			for(int i = 0; i< subjects.length; ++i) {
				notices.addItem(subjects[i]);
			}
		}
	}
}
