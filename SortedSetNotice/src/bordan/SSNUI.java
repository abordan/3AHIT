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
 * The visible window and its containing components.
 * 
 * @author Andreas Bordan
 * 
 * @version 2014-11-12
 *
 */
@SuppressWarnings("serial")
public class SSNUI extends JFrame {
	private JButton save, neu, delete;
	private JLabel lPriority, lDate, lSubject, lSort, lAttributes, lOptions;
	private JTextField tDate, tSubject;
	private JComboBox<String> tPriority, notices, tSort;
	private JTextArea tText;
	private JPanel buttons, attributes, options, priority, date, subject, text, sort, sortC, subjectC, dateC, priorityC;
	@SuppressWarnings("unused")
	private ActionListener aL;
	/**
	 * Creates a new window with its components for usage of a notice list.
	 * 
	 * @param title The window title
	 * @param aL The ActionListener for the buttons
	 * @param datum The date for the window
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public SSNUI(String title, ActionListener aL, String datum) {
		super(title);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.aL = aL;
		// BUTTONS
		save = new JButton("Save");
		neu = new JButton("Add");
		delete = new JButton("Delete");
		save.setActionCommand("Save");
		save.addActionListener(aL);
		neu.setActionCommand("New");
		neu.addActionListener(aL);
		delete.setActionCommand("Delete");
		delete.addActionListener(aL);
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttons.add(save);
		buttons.add(neu);
		buttons.add(delete); 
		this.add(buttons, BorderLayout.SOUTH);
		// COMBOS
		notices = new JComboBox<String>();
		notices.removeAll();
		notices.setActionCommand("Notices");
		notices.addActionListener(aL);
		tSort = new JComboBox<String>();
		tSort.addItem("Natural");
		tSort.addItem("Prioritize");
		tSort.setActionCommand("Sorting");
		tSort.addActionListener(aL);
		tPriority = new JComboBox<String>();
		tPriority.addItem("Low");
		tPriority.addItem("Medium");
		tPriority.addItem("High");
		tPriority.addItem("Realtime");
		// LABELS
		lPriority = new JLabel("Priority", SwingConstants.LEFT);
		lDate = new JLabel("Date", SwingConstants.LEFT);
		lSubject = new JLabel("Subject", SwingConstants.LEFT);
		lSort = new JLabel("Sorting");
		lOptions = new JLabel("Options");
		lAttributes = new JLabel("Attributes");
		// TEXT
		tDate = new JTextField(datum, 10);
		tDate.setEditable(false);
		tSubject = new JTextField("", 10);
		tText = new JTextArea(35, 50);
		// PANELS
		sort = new JPanel();
		sort.add(lSort);
		sort.add(tSort);
		priority = new JPanel();
		priority.add(lPriority);
		priority.add(tPriority);
		date = new JPanel();
		date.add(lDate);
		date.add(tDate);
		subject = new JPanel();
		subject.add(lSubject);
		subject.add(tSubject);
		text = new JPanel();
		text.add(tText);
		// CONTAINERPANELS
		sortC = new JPanel(new BorderLayout());
		sortC.add(sort, BorderLayout.LINE_START);
		subjectC = new JPanel(new BorderLayout());
		subjectC.add(subject, BorderLayout.LINE_START);
		dateC = new JPanel(new BorderLayout());
		dateC.add(date, BorderLayout.LINE_START);
		priorityC = new JPanel(new BorderLayout());
		priorityC.add(priority, BorderLayout.LINE_START);
		// BOXES
		attributes = new JPanel();
		attributes.setLayout(new BoxLayout(attributes, BoxLayout.PAGE_AXIS));
		attributes.add(lAttributes);
		attributes.add(subjectC);
		attributes.add(dateC);
		attributes.add(priorityC);
		options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
		options.add(lOptions);
		options.add(sortC);
		// ADDING
		this.add(notices, BorderLayout.NORTH);
		this.add(text, BorderLayout.CENTER);
		this.add(options, BorderLayout.LINE_END);
		this.add(attributes, BorderLayout.LINE_START);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	/**
	 * Sets the subject of the text field.
	 * 
	 * @param subject The new subject
	 * 
	 * @since 2014-11-10
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
	 * @since 2014-11-10
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
	 * @since 2014-11-10
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
	 * @since 2014-11-10
	 * 
	 */
	public void setPriority(int priority) {
		switch(priority) {
		case SSNotice.LOW:
			tPriority.setSelectedItem("Low");
			break;
		case SSNotice.MEDIUM:
			tPriority.setSelectedItem("Medium");
			break;
		case SSNotice.HIGH:
			tPriority.setSelectedItem("High");
			break;
		case SSNotice.REALTIME:
			tPriority.setSelectedItem("Realtime");
			break;
		}
	}
	/**
	 * Initializes a window with empty values.
	 * 
	 * @param date The date to set
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public void init(String date) {
		tSubject.setText("");
		tDate.setText(date);
		tText.setText("");
		tPriority.setSelectedItem("Low");
	}
	/**
	 * Gets the subject in the text field.
	 * 
	 * @return The subject of the text field
	 * 
	 * @since 2014-11-10
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
	 * @since 2014-11-10
	 * 
	 */
	public int getPriority() {
		switch(tPriority.getSelectedItem().toString()) {
		case "Low":
			return SSNotice.LOW;
		case "Medium":
			return SSNotice.MEDIUM;
		case "High":
			return SSNotice.HIGH;
		case "Realtime":
			return SSNotice.REALTIME;
		default:
			return 0;
		}
	}
	/**
	 * Gets the index of the currently selected button in the list.
	 *  
	 * @return The index of the selected button
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public int getNotice() {
		return notices.getSelectedIndex();
	}
	/**
	 * Gets the sorting algorithm
	 * 
	 * @return The string of the sorting algorithm
	 * 
	 * @since 2014-11-12
	 * 
	 */
	public String getSort() {
		if(!(tSort.getSelectedItem() instanceof String)) {
			return "";
		}
		return (String) tSort.getSelectedItem();
	}
	/**
	 * Gets the text in the text area.
	 * 
	 * @return The text of the text area
	 * 
	 * @since 2014-11-10
	 * 
	 */
	public String getText() {
		return tText.getText();
	}
	/**
	 * Actualizes the notice JComboBox with all new items
	 * 
	 * @param subjects The subjects to set the item titles
	 * 
	 * @since 2014-11-12
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