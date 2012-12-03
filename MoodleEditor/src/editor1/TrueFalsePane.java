package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Button;

public class TrueFalsePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrueFalsePane() {
		setLayout(new MigLayout("", "[79.00][56.00][grow][][][]", "[38.00][71.00,grow][][40.00][12.00][79.00,grow][]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 5 1,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 5 1,grow");
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblCorrectAnswer = new JLabel("Select Answer:");
		add(lblCorrectAnswer, "cell 1 2");
		
		JButton btnNewButton = new JButton("Clear All Fields");
		add(btnNewButton, "cell 4 2 2 1,growx");
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		add(rdbtnTrue, "cell 1 3");
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		add(rdbtnFalse, "cell 2 3");
		
		ButtonGroup radioGroup = new ButtonGroup();
	    radioGroup.add(rdbtnTrue);
	    radioGroup.add(rdbtnFalse);
		
		JButton btnSaveQuestion = new JButton("Save Question ");
		add(btnSaveQuestion, "cell 4 3 2 1,growx,aligny top");
		
		JSeparator separator_3 = new JSeparator();
		add(separator_3, "cell 1 4 5 1,grow");
		
		JLabel lblOutput = new JLabel("Output:");
		add(lblOutput, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 5 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(SystemColor.control);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnSaveToFile = new JButton("Append to Output");
		add(btnSaveToFile, "cell 4 6 2 1,growx");

	}

}
