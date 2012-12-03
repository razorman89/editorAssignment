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
import javax.swing.border.TitledBorder;

public class TrueFalsePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public TrueFalsePane() {
		setLayout(new MigLayout("", "[79.00][56.00][grow][]", "[][71.00,grow][][40.00][12.00][79.00,grow][][]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 3 1,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 3 1,grow");
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblAnswer = new JLabel("Answer:");
		add(lblAnswer, "cell 0 2,alignx right");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, "cell 1 2 1 2,growy");
		panel.setLayout(new MigLayout("", "[56.00][][][]", "[]"));
		
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton rdbtnTrue = new JRadioButton("True");
		panel.add(rdbtnTrue, "cell 1 0");
		radioGroup.add(rdbtnTrue);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator, "cell 2 0,grow");
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		panel.add(rdbtnFalse, "cell 3 0");
		radioGroup.add(rdbtnFalse);
		
		JButton btnNewButton = new JButton("Clear Question Text");
		add(btnNewButton, "cell 3 2,growx");
		
		JButton btnSaveQuestion = new JButton("Append Question ");
		add(btnSaveQuestion, "cell 3 3,growx,aligny top");
		
		JSeparator separator_3 = new JSeparator();
		add(separator_3, "cell 1 4 3 1,grow");
		
		JLabel lblOutput = new JLabel("Questions:");
		add(lblOutput, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 3 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(SystemColor.control);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 3 6,growx");
		
		JButton btnAddQuestionsTo = new JButton("Add Questions to File");
		add(btnAddQuestionsTo, "cell 3 7,growx,aligny top");

	}

}
