package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class MatchingPane extends JPanel {
	private GiftFormatter localFormatter;
	private Dimension checkDimension = new Dimension(0, 28);
	private ArrayList<JTextField> answerFields = new ArrayList<JTextField>();
	private ArrayList<JTextField> questionsFields = new ArrayList<JTextField>();
	private ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();

	/**
	 * Create the panel.
	 * @param editorFormatter 
	 */
	public MatchingPane(GiftFormatter editorFormatter) {
		
		this.localFormatter = editorFormatter;
		setLayout(new MigLayout("", "[][150.00][242.00,grow][119.00]", "[][170.00][][40][14.00][79.00,grow][][]"));
		
		JLabel lblQuestionTitle = new JLabel("Question Title:");
		add(lblQuestionTitle, "cell 0 0,alignx right,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 1 0 3 1,grow");
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 4 1,grow");
		
		final JPanel answersPanel = new JPanel();
		scrollPane_1.setViewportView(answersPanel);
		answersPanel.setLayout(new MigLayout("", "[][][grow][][grow][]", "[][][]"));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_1, "cell 1 0,grow");
		
		JLabel lblNewLabel = new JLabel("Question");
		answersPanel.add(lblNewLabel, "cell 2 0");
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		answersPanel.add(separator_2, "cell 3 0,grow");
		
		JLabel lblNewLabel_1 = new JLabel("Answer");
		answersPanel.add(lblNewLabel_1, "cell 4 0");
		
		JButton btnAddQa = new JButton("Add Q&A");
		answersPanel.add(btnAddQa, "cell 0 1 1 2,aligny top");
		
		JTextField questionTextField_1 = new JTextField();
		questionTextField_1.setToolTipText("Question");
		answersPanel.add(questionTextField_1, "flowy,cell 2 1,growx");
		questionsFields.add(questionTextField_1);
		
		JTextField answerTextField_1 = new JTextField();
		answerTextField_1.setToolTipText("Answer");
		answersPanel.add(answerTextField_1, "flowy,cell 4 1,growx");
		answerFields.add(answerTextField_1);
		
		JCheckBox chckbxDelete_1 = new JCheckBox("Delete");
		chckbxDelete_1.setEnabled(false);
		chckbxDelete_1.setPreferredSize(checkDimension);
		answersPanel.add(chckbxDelete_1, "flowy,cell 5 1");
		checkBoxs.add(chckbxDelete_1);
		
		JTextField questionTextField_2 = new JTextField();
		questionTextField_2.setToolTipText("Question");
		answersPanel.add(questionTextField_2, "flowy,cell 2 2,growx");
		questionsFields.add(questionTextField_2);
		
		JTextField answerTextField_2 = new JTextField();
		answerTextField_2.setToolTipText("Answer");
		answersPanel.add(answerTextField_2, "flowy,cell 4 2,growx");
		answerFields.add(answerTextField_2);
		
		JCheckBox chckbxDelete_2 = new JCheckBox("Delete");
		chckbxDelete_2.setEnabled(false);
		chckbxDelete_2.setPreferredSize(checkDimension);
		answersPanel.add(chckbxDelete_2, "flowy,cell 5 2");
		checkBoxs.add(chckbxDelete_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Remove Selected", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_1, "cell 1 2 1 2,alignx center,growy");
		panel_1.setLayout(new MigLayout("", "[242.00,grow]", "[]"));
		
		JButton btnDeleteSelected = new JButton("Remove");
		panel_1.add(btnDeleteSelected, "cell 0 0,aligny top");
		
		JButton button = new JButton("Clear Question Text");
		add(button, "cell 3 2,growx");
		
		JButton button_1 = new JButton("Append Question ");
		add(button_1, "cell 3 3,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 4 3 1,grow");
		
		JLabel lblQuestions = new JLabel("Questions:");
		add(lblQuestions, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 3 1,grow");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.control);
		textArea_1.setEditable(false);
		scrollPane_2.setViewportView(textArea_1);
		
		JButton button_2 = new JButton("Clear Questions List");
		add(button_2, "cell 3 6,growx");
		
		JButton button_3 = new JButton("Add Questions to File");
		add(button_3, "cell 3 7,growx");
		
		
		btnAddQa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField questionTextField = new JTextField();
				questionTextField.setToolTipText("Question");
				answersPanel.add(questionTextField, "flowy,cell 2 2,growx");
				questionsFields.add(questionTextField);
				
				JTextField answerTextField = new JTextField();
				answerTextField.setToolTipText("Answer");
				answersPanel.add(answerTextField, "flowy,cell 4 2,growx");
				answerFields.add(answerTextField);
				
				JCheckBox chckbxDelete = new JCheckBox("Delete");
				chckbxDelete.setPreferredSize(checkDimension);
				answersPanel.add(chckbxDelete, "flowy,cell 5 2");
				checkBoxs.add(chckbxDelete);
				
				answersPanel.updateUI();
			}
		});
		
		btnDeleteSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int ii = 0; ii < checkBoxs.size(); ii++) {
					if(checkBoxs.get(ii).isSelected()){
						answersPanel.remove(answerFields.get(ii));
						answersPanel.remove(questionsFields.get(ii));
						answersPanel.remove(checkBoxs.get(ii));
						answerFields.remove(ii);
						questionsFields.remove(ii);
						checkBoxs.remove(ii);
					}
				}
				answersPanel.updateUI();			
			}
		});

	}

}
