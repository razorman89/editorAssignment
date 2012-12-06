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
	private ArrayList<JTextField> questionFields = new ArrayList<JTextField>();
	private ArrayList<JCheckBox> checkBoxs = new ArrayList<JCheckBox>();
	private int index = 0;
	private final JTextArea questionsList;

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
		
		final JTextArea questionTitle = new JTextArea();
		scrollPane.setViewportView(questionTitle);
		
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
		questionFields.add(questionTextField_1);
		
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
		questionFields.add(questionTextField_2);
		
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
		
		JButton btnCreateGifty = new JButton("Create Gift Code");
		add(btnCreateGifty, "cell 3 3,growx,aligny top");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 1 4 3 1,grow");
		
		JLabel lblQuestions = new JLabel("Questions:");
		add(lblQuestions, "cell 0 5,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 1 5 3 1,grow");
		
		questionsList = new JTextArea();
		questionsList.setBackground(SystemColor.control);
		questionsList.setEditable(false);
		scrollPane_2.setViewportView(questionsList);
		
		JButton button_2 = new JButton("Clear Questions List");
		add(button_2, "cell 3 6,growx");
		
		JButton button_3 = new JButton("Add Questions to File");
		add(button_3, "cell 3 7,growx");
		
		
		btnAddQa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField questionTextField = new JTextField();
				questionTextField.setToolTipText("Question");
				answersPanel.add(questionTextField, "flowy,cell 2 2,growx");
				questionFields.add(questionTextField);
				
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
				ArrayList<Integer> removes = new ArrayList<Integer>();
				
				/*
				 * Find which checkboxes are selected
				 */
				for (int ii = 0; ii < checkBoxs.size(); ii++) {
					if(checkBoxs.get(ii).isSelected() == true){
						removes.add(ii);
					}
				}
				
				System.out.println("ITEMS PENDING REMOVAL: " + removes);
				System.out.println("\nBEFORE REMOVES\n-----------------------##\n" + "ANSWERS :" + answerFields.size() + "\nQUESTIONS :" + 
						questionFields.size() + "\nREMOVES :" + removes.size()+"\n-------------------------\n");
				/*
				 * Loop backwards through all gui components removing selected components
				 */
				int temp = removes.size();
				for (int jj = temp-1; jj >= 0; jj--) {
					answersPanel.remove(answerFields.get(removes.get(jj)));
					answersPanel.remove(questionFields.get(removes.get(jj)));
					answersPanel.remove(checkBoxs.get(removes.get(jj)));
					removes.remove(jj);
				}
				answersPanel.updateUI();
				
				/*
				 * Loop backwards through all data fields removing selected fields
				 */
				temp = answerFields.size();
				ArrayList<JCheckBox> temp2 = checkBoxs;
				for (int i = temp-1; i >= 0; i--) {
					System.out.println("RUN");
					if (temp2.get(i).isSelected() == true){
						System.out.println("REMOVING: " + i);
						answerFields.remove(i);
						questionFields.remove(i);
						checkBoxs.remove(i);
					}
					
				}
				System.out.println("\nAFTER REMOVES\n-----------------------##\n" + "ANSWERS :" + answerFields.size() + "\nQUESTIONS :" + 
						questionFields.size() + "\nREMOVES :" + removes.size()+"\n-------------------------\n");
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearInputs(questionTitle);
			}
		});
		
		btnCreateGifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				questionsList.append("//Question " + index + "\n" + localFormatter.buildMatchQAs(questionTitle.getText(),questionFields, answerFields) + "\n\n");
				clearInputs(questionTitle);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsList.setText("");
			}
		});

	}
	
	private void clearInputs(final JTextArea questionTitle) {
		questionTitle.setText("");
		for (int ii = 0; ii < answerFields.size(); ii++) {
			answerFields.get(ii).setText("");
			questionFields.get(ii).setText("");
			checkBoxs.get(ii).setSelected(false);
		}
	}
	
	public String getQuestionList() {
		String list = questionsList.getText();
		questionsList.setText("");
		return list;

	}

}
