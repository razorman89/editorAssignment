package editor1;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class NumericalPane extends JPanel {
	
	private GiftFormatter localFormatter;
	private JTextField answerFields;
	private JTextField feedbackFields;
	private final JTextArea questionsList;
	private String[] options = {"-- Select Type --", "Answer (+/-) Set Range", "Answer Within Set Range", "Muliple Answers Within Range & Partial Credit"};
	///HERE
	private int index = 0;
	private SpinnerNumberModel rangeStartModel = new SpinnerNumberModel(0, 0, 1000.0, 0.001);
	private SpinnerNumberModel rangeEndModel = new SpinnerNumberModel(0, 0, 1000.0, 0.001);
	private SpinnerNumberModel normalModel = new SpinnerNumberModel(0, 0, 100, 1);

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NumericalPane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[31.00][83.00][400,grow][][84.00]", "[][][grow][][][][10][79.00,grow][][26.00]"));
		
		JLabel lblQuestionType = new JLabel("Question Type:");
		add(lblQuestionType, "cell 0 0,alignx right,aligny top");
		
		final JComboBox questionTypes = new JComboBox(options);
		add(questionTypes, "cell 1 0,grow");
		questionTypes.setSelectedIndex(0);
		
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
		
		JLabel lblAnswers = new JLabel("Answer:");
		add(lblAnswers, "cell 0 3,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 1 3 4 1,grow");
		
		final JPanel answersPanel = new JPanel();
		answersPanel.setVisible(false); //##
		
		scrollPane_3.setViewportView(answersPanel);
		answersPanel.setLayout(new MigLayout("", "[][130.00,grow][][130.00,grow]", "[][]"));
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_3, "cell 0 0,grow");
		
		JLabel lblAnswer = new JLabel("Answer");
		answersPanel.add(lblAnswer, "cell 1 0");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_1, "cell 2 0,grow");
		
		JLabel lblFeedback = new JLabel("Feedback");
		answersPanel.add(lblFeedback, "cell 3 0");
		
		answerFields = new JTextField();
		answerFields.setToolTipText("Answer");
		answersPanel.add(answerFields, "flowy,cell 1 1,growx");
		
		feedbackFields = new JTextField();
		feedbackFields.setToolTipText("feedback");
		answersPanel.add(feedbackFields, "flowy,cell 3 1,growx");
		
		final JPanel rangePanel = new JPanel();
		rangePanel.setVisible(false); //##
		rangePanel.setBorder(new TitledBorder(null, "Range Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(rangePanel, "cell 1 4 2 2,grow");
		rangePanel.setLayout(new MigLayout("", "[][100,grow][][][100,grow]", "[]"));
		
		final JLabel lblRangeStart = new JLabel("Range Start:");
		rangePanel.add(lblRangeStart, "cell 0 0,alignx right");
		
		final JSpinner rangeStart = new JSpinner();
		rangeStart.setModel(rangeStartModel);
		rangePanel.add(rangeStart, "cell 1 0,growx");
		
		JSeparator separator_4 = new JSeparator();
		rangePanel.add(separator_4, "cell 2 0,grow");
		separator_4.setOrientation(SwingConstants.VERTICAL);
		
		final JLabel lblRangeEnd = new JLabel("Range End:");
		rangePanel.add(lblRangeEnd, "cell 3 0");
		
		final JSpinner rangeEnd = new JSpinner();
		rangeEnd.setModel(rangeEndModel);
		rangePanel.add(rangeEnd, "cell 4 0,growx");

		final JButton btnClearText = new JButton("Clear Question Text");
		btnClearText.setEnabled(false); //##
		add(btnClearText, "cell 4 4,growx,aligny top");
		
		final JButton btnCreateGifty = new JButton("Create Gift Code");
		btnCreateGifty.setEnabled(false); //##
		add(btnCreateGifty, "cell 4 5,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 6 4 1,grow");
		
		JLabel lblGeneratedQuestions = new JLabel("Questions:");
		add(lblGeneratedQuestions, "cell 0 7,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 7 4 1,grow");
		
		questionsList = new JTextArea();
		questionsList.setEditable(false);
		questionsList.setBackground(SystemColor.control);
		scrollPane_2.setViewportView(questionsList);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 4 8,growx");
		
		JButton btnAddQuestions = new JButton("Add Questions to File");
		add(btnAddQuestions, "cell 4 9,growx");

		
		questionTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (questionTypes.getSelectedIndex()) {
				case 0:
					autoClear(rangeStart, rangeEnd);
					answersPanel.setVisible(false);
					rangePanel.setVisible(false);
					btnClearText.setEnabled(false);
					btnCreateGifty.setEnabled(false);
					lblRangeStart.setText("Range Start:");
					rangeEnd.setEnabled(true);
					rangeEnd.setBackground(Color.WHITE);
	
					break;
					
				case 1:
					autoClear(rangeStart, rangeEnd);
					feedbackFields.setEnabled(false);
					feedbackFields.setBackground(Color.LIGHT_GRAY);
					answersPanel.setVisible(true);
					rangePanel.setVisible(true);
					lblRangeStart.setText("Range (+/-) :");
					rangeEnd.setEnabled(false);
					rangeEnd.setBackground(Color.LIGHT_GRAY);
					btnClearText.setEnabled(true);
					btnCreateGifty.setEnabled(true);
					
					break;
					
				case 2:
					autoClear(rangeStart, rangeEnd);
					answersPanel.setVisible(false);
					rangePanel.setVisible(true);
					btnClearText.setEnabled(true);
					btnCreateGifty.setEnabled(true);
					lblRangeEnd.setText("Range End: ");
					SpinnerNumberModel rangeEndModel = new SpinnerNumberModel(0, 0, 1000.0, 0.001);
					rangeEnd.setModel(rangeEndModel);
					
					break;
					
				case 3:
					autoClear(rangeStart, rangeEnd);
					feedbackFields.setEnabled(true);
					feedbackFields.setBackground(Color.WHITE);
					answersPanel.setVisible(true);
					rangePanel.setVisible(true);
					btnClearText.setEnabled(true);
					btnCreateGifty.setEnabled(true);
					lblRangeStart.setText("Range (+/-) :");
					rangeEnd.setEnabled(true);
					rangeEnd.setBackground(Color.WHITE);
					lblRangeEnd.setText("Mark: ");
					rangeEnd.setModel(normalModel);

					break;

				default:
					
					break;
				}


				answersPanel.updateUI();
			}
		});

		btnClearText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearInput(questionTitle, questionBody, rangeStart, rangeEnd);
			}
		});
					
		btnCreateGifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				switch (questionTypes.getSelectedIndex()) {
					
				case 1:
					questionsList.append("//Question " + index + ", Type '" + options[1] + "'\n" + localFormatter.buildNumRange_1(questionTitle.getText(), questionBody.getText(), answerFields, feedbackFields, (Double) rangeStart.getValue()) + "\n\n");
					break;
					
				case 2:
					questionsList.append("//Question " + index + ", Type '" + options[2] + "'\n" + localFormatter.buildNumRange_2(questionTitle.getText(), questionBody.getText(), (Double) rangeStart.getValue(), (Double) rangeEnd.getValue()) + "\n\n");
					break;
					
				case 3:
					questionsList.append("//Question " + index + ", Type '" + options[3] + "'\n" + localFormatter.buildNumRange_3(questionTitle.getText(), questionBody.getText(), answerFields, feedbackFields, (Double) rangeStart.getValue(), (Integer) rangeEnd.getValue()) + "\n\n");
					break;

				default:
					break;
				}
				clearInput(questionTitle, questionBody, rangeStart, rangeEnd);
			}
		});
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsList.setText("");
				index = 0;
			}
		});
	}
	
	private void clearInput(final JTextArea questionTitle, final JTextArea questionBody, JSpinner rangeStart, JSpinner rangeEnd) {
		questionTitle.setText("");
		questionBody.setText("");
		rangeStart.setValue(0);
		rangeEnd.setValue(0);
		answerFields.setText("");
		feedbackFields.setText("");
	
	}
	
	private void autoClear(JSpinner rangeStart, JSpinner rangeEnd) {
		rangeStart.setValue(0);
		rangeEnd.setValue(0);
	}

	public String getQuestionList() {
		String list = questionsList.getText();
		questionsList.setText("");
		return list;

	}
}
