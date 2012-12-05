package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BlanksPane extends JPanel {
	private GiftFormatter localFormatter;	

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	public BlanksPane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[][grow][130][]", "[][30.00,grow][170][][30,grow][][40][10][79.00,grow][27.00][26.00]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 3 1,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblQuestionStart = new JLabel("Question Start:");
		add(lblQuestionStart, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 3 1,grow");
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblBlanks = new JLabel("Blank(s):");
		add(lblBlanks, "cell 0 2,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 2 3 1,grow");
		
		JPanel blanksPanel = new JPanel();
		scrollPane_2.setViewportView(blanksPanel);
		blanksPanel.setLayout(new MigLayout("", "[][grow][][]", "[][][]"));
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		blanksPanel.add(separator, "cell 0 0,grow");
		
		JLabel lblChoice = new JLabel("Choice");
		blanksPanel.add(lblChoice, "cell 1 0");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		blanksPanel.add(separator_1, "cell 2 0,grow");
		
		JLabel lblCorrect = new JLabel("Select");
		blanksPanel.add(lblCorrect, "cell 3 0");
		
		JTextField blank_1 = new JTextField();
		blanksPanel.add(blank_1, "cell 1 1 2 1,growx");
		blank_1.setColumns(10);
		
		JRadioButton rdbtnCorrect = new JRadioButton("Correct");
		blanksPanel.add(rdbtnCorrect, "cell 3 1,growx");
		
		JButton btnRemoveBlank = new JButton("Remove Blank");
		add(btnRemoveBlank, "cell 2 3,growx,aligny top");
		
		JButton btnAddAnswer = new JButton("Add Blank");
		add(btnAddAnswer, "cell 3 3,growx,aligny top");
		
		JLabel lblQuestionEnd = new JLabel("Question End:");
		add(lblQuestionEnd, "cell 0 4,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 1 4 3 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_3.setViewportView(textArea_2);
		
		JButton button = new JButton("Clear Question Text");
		add(button, "cell 3 5,growx");
		
		JButton button_1 = new JButton("Append Question");
		add(button_1, "cell 3 6,growx,aligny top");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 7 3 1,grow");
		
		JLabel lblQuestions = new JLabel("Questions:");
		add(lblQuestions, "cell 0 8,alignx right,aligny top");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		add(scrollPane_4, "cell 1 8 3 1,grow");
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_4.setViewportView(textArea_3);
		
		JButton button_2 = new JButton("Clear Questions List");
		add(button_2, "cell 3 9,growx");
		
		JButton button_3 = new JButton("Add Questions to File");
		add(button_3, "cell 3 10,growx");

	}

}
