package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EssayPane extends JPanel {
	private GiftFormatter localFormatter;
	private int index = 0;

	/**
	 * Create the panel.
	 */
	public EssayPane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[][grow][][]", "[][71.00,grow][][40][10][79.00,grow][][]"));
		
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
		
		JButton btnClearText = new JButton("Clear Question Text");
		add(btnClearText, "cell 3 2,growx");
		
		JButton btnAppendQuestion = new JButton("Append Question ");
		add(btnAppendQuestion, "cell 3 3,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 4 3 1,grow");
		
		JLabel label = new JLabel("Questions:");
		add(label, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 3 1,grow");
		
		final JTextArea questionList = new JTextArea();
		questionList.setBackground(SystemColor.control);
		questionList.setEditable(false);
		scrollPane_2.setViewportView(questionList);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 3 6,growx");
		
		JButton button_3 = new JButton("Add Questions to File");
		add(button_3, "cell 3 7,growx");
		
		
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionTitle.setText("");
				questionBody.setText("");
			}
		});
		
		btnAppendQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				questionList.append("//Question " + index + "\n" + localFormatter.buildEssayGifty(questionTitle.getText(), questionBody.getText()) + "\n\n");
				questionTitle.setText("");
				questionBody.setText("");
			}
		});
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionList.setText("");
				index = 0;
			}
		});

	}

}
