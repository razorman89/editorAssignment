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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MultipleChoicePaneAdv extends JPanel {
	
	private GiftFormatter localFormatter;
	private ArrayList<JTextField> answerFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> feedbackFields = new ArrayList<JTextField>();
	private ArrayList<JSpinner> answerSpinners = new ArrayList<JSpinner>();
	private int rowCount = 1;
	private int index = 0;
//	private SpinnerNumberModel rangeSpinnerModel = new SpinnerNumberModel(0, 0, 1000.0, 0.001);
//	private SpinnerNumberModel percentageSpinnerModel = new SpinnerNumberModel(0, 0, 100, 1);

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	public MultipleChoicePaneAdv(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[31.00][][16.00][grow][grow][47.00][]", "[][grow][][][170][][33.00][12.00][79.00,grow][][26.00]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 6 1,grow");
		
		final JTextArea questionTitle = new JTextArea();
		scrollPane.setViewportView(questionTitle);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 6 3,grow");
		
		final JTextArea questionBody = new JTextArea();
		scrollPane_1.setViewportView(questionBody);
		
		JLabel lblAnswers = new JLabel("Answer(s):");
		add(lblAnswers, "cell 0 4,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 2 4 5 1,grow");
		
		final JPanel answersPanel = new JPanel();
		scrollPane_3.setViewportView(answersPanel);
		answersPanel.setLayout(new MigLayout("", "[][130.00,grow][][130.00,grow][][68.00]", "[][][]"));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_3, "cell 0 0,grow");
		
		JLabel lblAnswer = new JLabel("Choice");
		answersPanel.add(lblAnswer, "cell 1 0");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_1, "cell 2 0,grow");
		
		JLabel lblFeedback = new JLabel("Feedback");
		answersPanel.add(lblFeedback, "cell 3 0");
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_2, "cell 4 0,grow");
		
		JLabel lblMark = new JLabel("Mark");
		answersPanel.add(lblMark, "cell 5 0");
		
		JTextField ansField1 = new JTextField();
		ansField1.setToolTipText("Answer");
		answersPanel.add(ansField1, "flowy,cell 1 1,growx");
		answerFields.add(ansField1);
		
		JTextField txtFeedback_1 = new JTextField();
		txtFeedback_1.setToolTipText("feedback");
		answersPanel.add(txtFeedback_1, "flowy,cell 3 1,growx");
		feedbackFields.add(txtFeedback_1);
		
		JSpinner ansSpinner = new JSpinner();
		answersPanel.add(ansSpinner, "flowy,cell 5 1,growx");
		answerSpinners.add(ansSpinner);
		
		JTextField ansField2 = new JTextField();
		ansField2.setToolTipText("Answer");
		answersPanel.add(ansField2, "flowy,cell 1 2,growx");
		answerFields.add(ansField2);
		
		JTextField txtFeedback_2 = new JTextField();
		txtFeedback_2.setToolTipText("Feedback");
		answersPanel.add(txtFeedback_2, "flowy,cell 3 2,growx");
		feedbackFields.add(txtFeedback_2);
		
		JSpinner ansSpinner1 = new JSpinner();
		answersPanel.add(ansSpinner1, "flowy,cell 5 2,growx");
		answerSpinners.add(ansSpinner1);
		
		JButton btnNewAnswer = new JButton("Add Answer");		
		JButton btnClearText = new JButton("Clear Question Text");
		add(btnClearText, "cell 5 5 2 1,growx,aligny top");

		JButton btnAppendQuestion = new JButton("Append Question");
		add(btnAppendQuestion, "cell 5 6 2 1,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 2 7 5 1,grow");
		
		JLabel lblGeneratedQuestions = new JLabel("Questions:");
		add(lblGeneratedQuestions, "cell 0 8,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 2 8 5 1,grow");
		
		final JTextArea questionsMultiAdvGiftyList = new JTextArea();
		questionsMultiAdvGiftyList.setEditable(false);
		questionsMultiAdvGiftyList.setBackground(SystemColor.control);
		scrollPane_2.setViewportView(questionsMultiAdvGiftyList);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 5 9 2 1,growx");
		
		JButton btnAddQuestions = new JButton("Add Questions to File");
		add(btnAddQuestions, "cell 5 10 2 1,growx");
		
		
		btnNewAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowCount++;
				JTextField ansField = new JTextField();
				answersPanel.add(ansField, "flowy, cell 1 2,growx");
				ansField.setColumns(10);
				answerFields.add(ansField);
				
				JTextField txtFeedback = new JTextField();
				txtFeedback.setToolTipText("Feedback");
				answersPanel.add(txtFeedback, "flowy, cell 3 2,growx");
				feedbackFields.add(txtFeedback);				
				
				JSpinner ansSpinner = new JSpinner();
				answersPanel.add(ansSpinner, "flowy, cell 5 2,growx");
				answerSpinners.add(ansSpinner);

				answersPanel.updateUI();
			}
		});
		add(btnNewAnswer, "cell 2 5,growx");
		
		JButton btnRemoveAnswer = new JButton("Remove Answer");
		btnRemoveAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rowCount > 1){
					answersPanel.remove(answerFields.get(rowCount));
					answersPanel.remove(feedbackFields.get(rowCount));
					answersPanel.remove(answerSpinners.get(rowCount));
					answerFields.remove(rowCount);
					feedbackFields.remove(rowCount);
					answerSpinners.remove(rowCount);
					answersPanel.updateUI();
					rowCount--;					
				}
			}
		});
		add(btnRemoveAnswer, "cell 2 6,growx,aligny top");
		
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionTitle.setText("");
				questionBody.setText("");
				for (int ii = 0; ii < answerFields.size(); ii++) {
					answerFields.get(ii).setText("");
					feedbackFields.get(ii).setText("");
					answerSpinners.get(ii).setValue(0);
					
				}
			}
		});
		
		btnAppendQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				questionsMultiAdvGiftyList.append("//Question " + index + "\n" + localFormatter.buildMultiChoiceAdv(questionTitle.getText(), questionBody.getText(), answerFields, feedbackFields, answerSpinners) + "\n\n");
				
			}
		});
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsMultiAdvGiftyList.setText("");
				index = 0;
			}
		});

	}

}
