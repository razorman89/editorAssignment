package editor1;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class NumericalPane extends JPanel {
	
	private GiftFormatter localFormatter;
	private ArrayList<JTextField> answerFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> feedbackFields = new ArrayList<JTextField>();
	private ArrayList<JSpinner> answerSpinners = new ArrayList<JSpinner>();
	private String[] options = {"-- Select Type --", "One Answer With Range", "Muliple Correct", "Within Range"};
	private int rowCount = 1;
	private int index = 0;
//	private SpinnerNumberModel rangeSpinnerModel = new SpinnerNumberModel(0, 0, 1000.0, 0.001);
//	private SpinnerNumberModel percentageSpinnerModel = new SpinnerNumberModel(0, 0, 100, 1);

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	public NumericalPane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[31.00][83.00][400,grow][][84.00]", "[][][grow][170][][][10][79.00,grow][][26.00]"));
		
		JLabel lblQuestionType = new JLabel("Question Type:");
		add(lblQuestionType, "cell 0 0,alignx right,aligny top");
		
		final JComboBox questionTypes = new JComboBox(options);
		add(questionTypes, "cell 1 0,grow");
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 1 4 1,grow");
		
		final JTextArea questionTitle = new JTextArea();
		scrollPane.setViewportView(questionTitle);
		
		JLabel lblQuestion = new JLabel("Question:");
		add(lblQuestion, "cell 0 2,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 2 4 1,grow");
		
		final JTextArea questionBody = new JTextArea();
		scrollPane_1.setViewportView(questionBody);
		
		JLabel lblAnswers = new JLabel("Answer(s):");
		add(lblAnswers, "cell 0 3,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 1 3 4 1,grow");
		
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Range Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, "cell 1 4 2 2,grow");
		panel.setLayout(new MigLayout("", "[][100,grow][][][100,grow]", "[]"));
		
		JLabel lblRangeStart = new JLabel("Range Start:");
		panel.add(lblRangeStart, "cell 0 0,alignx right");
		
		JTextField rangeStart = new JTextField();
		panel.add(rangeStart, "cell 1 0,growx");
		
		JSeparator separator_4 = new JSeparator();
		panel.add(separator_4, "cell 2 0,grow");
		separator_4.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblRangeEnd = new JLabel("Range End:");
		panel.add(lblRangeEnd, "cell 3 0");
		
		JTextField rangeEnd = new JTextField();
		panel.add(rangeEnd, "cell 4 0,growx");
		
		JButton btnNewAnswer = new JButton("Add Answer");		
		
		questionTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (questionTypes.getSelectedIndex()) {
				case 0:
					
					break;
					
				case 1:
					
					break;
					
				case 2:
					
					break;
					
				case 3:
					
					break;

				default:
					
					break;
				}


				answersPanel.updateUI();
			}
		});

		
		
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
		add(btnNewAnswer, "cell 3 4,growx");

		JButton btnClearText = new JButton("Clear Question Text");
		add(btnClearText, "cell 4 4,growx,aligny top");
		
		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearInput(questionTitle, questionBody);
			}
		});
				
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
				add(btnRemoveAnswer, "cell 3 5,growx,aligny top");
		
				JButton btnCreateGifty = new JButton("Create Gift Code");
				add(btnCreateGifty, "cell 4 5,growx,aligny top");
				
				btnCreateGifty.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						index++;
//						questionsMultiAdvGiftyList.append("//Question " + index + "\n" + localFormatter.buildMultiChoiceAdv(questionTitle.getText(), questionBody.getText(), answerFields, feedbackFields, answerSpinners) + "\n\n");
						clearInput(questionTitle, questionBody);
					}
				});
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 6 4 1,grow");
		
		JLabel lblGeneratedQuestions = new JLabel("Questions:");
		add(lblGeneratedQuestions, "cell 0 7,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 7 4 1,grow");
		
		final JTextArea questionsList = new JTextArea();
		questionsList.setEditable(false);
		questionsList.setBackground(SystemColor.control);
		scrollPane_2.setViewportView(questionsList);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 4 8,growx");
		
		JButton btnAddQuestions = new JButton("Add Questions to File");
		add(btnAddQuestions, "cell 4 9,growx");
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsList.setText("");
				index = 0;
			}
		});

	}
	
	private void clearInput(final JTextArea questionTitle, final JTextArea questionBody) {
		questionTitle.setText("");
		questionBody.setText("");
		for (int ii = 0; ii < answerFields.size(); ii++) {
			answerFields.get(ii).setText("");
			feedbackFields.get(ii).setText("");
			answerSpinners.get(ii).setValue(0);
			
		}
	}

}
