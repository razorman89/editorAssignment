package editor1;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.sun.org.apache.bcel.internal.generic.BALOAD;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class BlanksPane extends JPanel {
	private GiftFormatter localFormatter;	
	private ArrayList<JTextField> blankFields = new ArrayList<JTextField>();
	private ArrayList<JRadioButton> correctFields = new ArrayList<JRadioButton>();
	private int rowCount = 0;
	private int index = 0;
	private Dimension radioDimension = new Dimension(0, 28);

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
		
		final JTextArea questionTitle = new JTextArea();
		scrollPane.setViewportView(questionTitle);
		
		JLabel lblQuestionStart = new JLabel("Question Start:");
		add(lblQuestionStart, "cell 0 1,alignx right,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "cell 1 1 3 1,grow");
		
		final JTextArea questionStart = new JTextArea();
		scrollPane_1.setViewportView(questionStart);
		
		JLabel lblBlanks = new JLabel("Blank(s):");
		add(lblBlanks, "cell 0 2,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 2 3 1,grow");
		
		final JPanel blanksPanel = new JPanel();
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
		
		JTextField questionBlank_1 = new JTextField();
		blanksPanel.add(questionBlank_1, "flowy,cell 1 1 2 1,growx");
		blankFields.add(questionBlank_1);
		
		final ButtonGroup radioGroup = new ButtonGroup();
		
		JRadioButton rdbtnCorrect_1 = new JRadioButton("Correct");
		rdbtnCorrect_1.setPreferredSize(radioDimension);
		blanksPanel.add(rdbtnCorrect_1, "flowy,cell 3 1,growx");
		correctFields.add(rdbtnCorrect_1);
		radioGroup.add(rdbtnCorrect_1);
		
		JButton btnRemoveBlank = new JButton("Remove Blank");
		add(btnRemoveBlank, "cell 2 3,growx,aligny top");
		
		JButton btnAddBlank = new JButton("Add Blank");
		add(btnAddBlank, "cell 3 3,growx,aligny top");
		
		JLabel lblQuestionEnd = new JLabel("Question End:");
		add(lblQuestionEnd, "cell 0 4,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		add(scrollPane_3, "cell 1 4 3 1,grow");
		
		final JTextArea questionEnd = new JTextArea();
		scrollPane_3.setViewportView(questionEnd);
		
		JButton btnClearQuestionText = new JButton("Clear Question Text");
		add(btnClearQuestionText, "cell 3 5,growx");
		
		JButton btnCreateGifty = new JButton("Create Gift Code");
		add(btnCreateGifty, "cell 3 6,growx,aligny top");
		
		JSeparator separator_2 = new JSeparator();
		add(separator_2, "cell 1 7 3 1,grow");
		
		JLabel lblQuestions = new JLabel("Questions:");
		add(lblQuestions, "cell 0 8,alignx right,aligny top");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		add(scrollPane_4, "cell 1 8 3 1,grow");
		
		final JTextArea questionsList = new JTextArea();
		questionsList.setBackground(SystemColor.control);
		questionsList.setEditable(false);
		scrollPane_4.setViewportView(questionsList);
		
		JButton btnClearQuestionsList = new JButton("Clear Questions List");
		add(btnClearQuestionsList, "cell 3 9,growx");
		
		JButton button_3 = new JButton("Add Questions to File");
		add(button_3, "cell 3 10,growx");
		
		
		btnAddBlank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JTextField questionBlank = new JTextField();
				blanksPanel.add(questionBlank, "flowy,cell 1 1 2 1,growx");
				blankFields.add(questionBlank);
				
				JRadioButton rdbtnCorrect = new JRadioButton("Correct");
				rdbtnCorrect.setPreferredSize(radioDimension);
				blanksPanel.add(rdbtnCorrect, "flowy,cell 3 1,growx");	
				correctFields.add(rdbtnCorrect);
				radioGroup.add(rdbtnCorrect);
				
				blanksPanel.updateUI();
				rowCount++;
			}
		});
		
		btnRemoveBlank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rowCount > 0){
					blanksPanel.remove(blankFields.get(rowCount));
					blanksPanel.remove(correctFields.get(rowCount));

					blankFields.remove(rowCount);
					correctFields.remove(rowCount);
					
					blanksPanel.updateUI();
					rowCount--;					
				}
			}
		});
		
		btnClearQuestionText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearInput(questionTitle, questionStart, questionEnd, blankFields, correctFields, radioGroup);
			}
		});
		
		btnCreateGifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				questionsList.append("//Question " + index + "\n" + localFormatter.buildBlanksQ(questionTitle.getText(), questionStart.getText(), questionEnd.getText(), blankFields, correctFields) + "\n\n");
				clearInput(questionTitle, questionStart, questionEnd, blankFields, correctFields, radioGroup);
			}
		});
		
		btnClearQuestionsList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsList.setText("");
			}
		});

	}
	
	private void clearInput(JTextArea questionTitle, JTextArea questionStart, JTextArea questionEnd, ArrayList<JTextField> blankFields, ArrayList<JRadioButton> correctFields, ButtonGroup radioGroup) {
		questionTitle.setText("");
		questionStart.setText("");
		questionEnd.setText("");
		radioGroup.clearSelection();
		for (int ii = 0; ii < blankFields.size(); ii++) {
			blankFields.get(ii).setText("");
		}
		// TODO Auto-generated method stub	
	}

}
