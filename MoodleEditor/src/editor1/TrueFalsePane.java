package editor1;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TrueFalsePane extends JPanel {
	
	private GiftFormatter localFormatter;
	private String tfAnswer;
	private final JTextArea questionsList;

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	public TrueFalsePane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[79.00][56.00][grow][]", "[][71.00,grow][][40.00][10][79.00,grow][]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 3 1,grow");
		
		final JTextArea questionTitle = new JTextArea();
		scrollPane.setViewportView(questionTitle);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 3 1,grow");
		
		final JTextArea questionBody = new JTextArea();
		scrollPane_1.setViewportView(questionBody);
		
		JLabel lblAnswer = new JLabel("Answer:");
		add(lblAnswer, "cell 0 2,alignx right");
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Select", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, "cell 1 2 1 2,growy");
		panel.setLayout(new MigLayout("", "[56.00][][][]", "[]"));
		
		final ButtonGroup radioGroup = new ButtonGroup();
		final JRadioButton rdbtnTrue = new JRadioButton("True");
		panel.add(rdbtnTrue, "cell 1 0");
		radioGroup.add(rdbtnTrue);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator, "cell 2 0,grow");
		
		final JRadioButton rdbtnFalse = new JRadioButton("False");
		panel.add(rdbtnFalse, "cell 3 0");
		radioGroup.add(rdbtnFalse);
		
		JButton btnClearText = new JButton("Clear Question Text");

		add(btnClearText, "cell 3 2,growx");
		
		JButton btnCreateGifty = new JButton("Create Gift Code");

		add(btnCreateGifty, "cell 3 3,growx,aligny top");
		
		JSeparator separator_3 = new JSeparator();
		add(separator_3, "cell 1 4 3 1,grow");
		
		JLabel lblOutput = new JLabel("Gift Output:");
		add(lblOutput, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 3 1,grow");
		
		questionsList = new JTextArea();
		questionsList.setBackground(SystemColor.control);
		questionsList.setEditable(false);
		scrollPane_2.setViewportView(questionsList);
		
		JButton btnClearQuestionsList = new JButton("Clear Output List");
		add(btnClearQuestionsList, "cell 3 6,growx");
		
		
		
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearInput(questionTitle, questionBody, radioGroup);		
			}
		});

		btnCreateGifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnTrue.isSelected() == true){
					tfAnswer = "T";
				}else{
					tfAnswer = "F";
				}
				questionsList.append(localFormatter.buildT_FGifty(questionTitle.getText(), questionBody.getText(), tfAnswer) + "\n\n");
				clearInput(questionTitle, questionBody, radioGroup);
			}
		});
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsList.setText("");
			}
		});

	}
	
	private void clearInput(final JTextArea questionTitle, final JTextArea questionBody, final ButtonGroup radioGroup) {
		questionTitle.setText("");
		questionBody.setText("");
		radioGroup.clearSelection();
	}
	
	public String getQuestionList() {
		String list = questionsList.getText();
		questionsList.setText("");
		return list;

	}

}
