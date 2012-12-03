package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class MultipleChoicePane extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public MultipleChoicePane() {
		setLayout(new MigLayout("", "[31.00][16.00][grow][][47.00][]", "[38][grow][][][][][][][][33.00][12.00][79.00,grow][26.00]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 5 1,grow");
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 5 3,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblAnswers = new JLabel("Answers:");
		add(lblAnswers, "cell 0 4,alignx right");
		
		JLabel lblNewLabel = new JLabel("A)");
		add(lblNewLabel, "cell 1 4,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 2 4 3 1,growx");
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		add(spinner, "cell 5 4,growx,aligny top");
		
		JLabel lblB = new JLabel("B)");
		add(lblB, "cell 1 5,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1, "cell 2 5 3 1,growx");
		
		JSpinner spinner_1 = new JSpinner();
		add(spinner_1, "cell 5 5,growx,aligny top");
		
		JLabel lblC = new JLabel("C)");
		add(lblC, "cell 1 6,alignx trailing");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		add(textField_2, "cell 2 6 3 1,growx");
		
		JSpinner spinner_2 = new JSpinner();
		add(spinner_2, "cell 5 6,growx,aligny top");
		
		JLabel lblD = new JLabel("D)");
		add(lblD, "cell 1 7,alignx trailing");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		add(textField_3, "cell 2 7 3 1,growx");
		
		JSpinner spinner_3 = new JSpinner();
		add(spinner_3, "cell 5 7,growx,aligny top");
		
		JButton btnClearAllFields = new JButton("Clear All Fields");
		add(btnClearAllFields, "cell 4 8 2 1,growx,aligny top");
		
		JButton button = new JButton("Save Question ");
		add(button, "cell 4 9 2 1,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 10 5 1,grow");
		
		JLabel label = new JLabel("Output:");
		add(label, "cell 0 11,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 11 5 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBackground(SystemColor.control);
		scrollPane_2.setViewportView(textArea_2);
		
		JButton button_1 = new JButton("Append to Output");
		add(button_1, "cell 4 12 2 1,growx");

	}

}
