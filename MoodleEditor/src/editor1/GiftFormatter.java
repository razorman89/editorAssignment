package editor1;

import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class GiftFormatter {

	public GiftFormatter(){
		
	}
	
	public String buildT_FGifty(String qTitle, String qBody, String qAnswer){
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		qAnswer = stringConverter(qAnswer);
		
		System.out.println("TITLE: " + qTitle + "\nBODY: " + qBody + "\nANSWER: " + qAnswer);
		String tfQuestion = "";
		tfQuestion = ("::" + qTitle + "::" + qBody + "{" + qAnswer + "}");
		
		return tfQuestion;
	}
	
	public String buildMultiChoiceAdv(String qTitle, String qBody, ArrayList<JTextField> answerFields, ArrayList<JTextField> feedbackFields, ArrayList<JSpinner> answerSpinners){
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		for (int jj = 0; jj < answerFields.size(); jj++) {
			String answerHolder = stringConverter(answerFields.get(jj).getText());
			answerFields.get(jj).setText(answerHolder);
			
			String feedbackHolder = stringConverter(feedbackFields.get(jj).getText());
			feedbackFields.get(jj).setText(feedbackHolder);
		}

		String multiAdvQuestion = "";
		multiAdvQuestion = ("::" + qTitle + "::" + qBody + "{");
		
		for (int ii = 0; ii < answerFields.size(); ii++) {
			multiAdvQuestion += ("\n~%" + answerSpinners.get(ii).getValue().toString() + "%" + answerFields.get(ii).getText() + "\n#" + feedbackFields.get(ii).getText());
		}
		
		multiAdvQuestion += ("\n}");
		return multiAdvQuestion;
	}
	
	public String buildMultiChoiceBas(String qTitle, String qBody, ArrayList<JTextField> answerFields, ArrayList<JTextField> feedbackFields, ArrayList<JRadioButton> radioSelectors) {
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		for (int jj = 0; jj < answerFields.size(); jj++) {
			String answerHolder = stringConverter(answerFields.get(jj).getText());
			answerFields.get(jj).setText(answerHolder);
			
			String feedbackHolder = stringConverter(feedbackFields.get(jj).getText());
			feedbackFields.get(jj).setText(feedbackHolder);
			
		}
		
		String multiBasQuestion = "";
		multiBasQuestion = ("::" + qTitle + "::" + qBody + "{");
		
		for (int ii = 0; ii < answerFields.size(); ii++) {
			if(radioSelectors.get(ii).isSelected()){
				multiBasQuestion += ("\n=" + answerFields.get(ii).getText() + "\n#" + feedbackFields.get(ii).getText());
			}else{
				multiBasQuestion += ("\n~" + answerFields.get(ii).getText() + "\n#" + feedbackFields.get(ii).getText());
			}
		}
		
		multiBasQuestion += ("\n}");
		return multiBasQuestion;
	}
	
	public String buildMatchQAs(String qTitle, ArrayList<JTextField> questionFields, ArrayList<JTextField> answerFields) {
		qTitle = stringConverter(qTitle);
		
		for (int jj = 0; jj < answerFields.size(); jj++) {
			
			String questionHolder = stringConverter(questionFields.get(jj).getText());
			questionFields.get(jj).setText(questionHolder);
			
			String answerHolder = stringConverter(answerFields.get(jj).getText());
			answerFields.get(jj).setText(answerHolder);
		}
		
		String matchQAsQuestion = "";
		matchQAsQuestion = ("::" + qTitle + "{");
		
		for (int ii = 0; ii < answerFields.size(); ii++) {
			matchQAsQuestion += ("\n=" + questionFields.get(ii).getText() + " -> " + answerFields.get(ii).getText());
		}
		
		matchQAsQuestion += ("\n}");
		return matchQAsQuestion;
	}	
	
	public String buildEssayGifty(String qTitle, String qBody) {
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		String essayQuestion = ("::" + qTitle + "::" + qBody + "{}");;
		return essayQuestion;
	}
	
	public String buildBlanksQ(String qTitle, String qStart, String qEnd, ArrayList<JTextField> blankFields, ArrayList<JRadioButton> correctFields) {
		qTitle = stringConverter(qTitle);
		qStart = stringConverter(qStart);
		qEnd = stringConverter(qEnd);
		
		for (int jj = 0; jj < blankFields.size(); jj++) {
			String blankHolder = stringConverter(blankFields.get(jj).getText());
			blankFields.get(jj).setText(blankHolder);			
		}
		
		String blanksQuestion = ("::" + qTitle + "::" + qStart + " {");
		for (int ii = 0; ii < blankFields.size(); ii++) {
			if(correctFields.get(ii).isSelected()){
				blanksQuestion += (" =" + blankFields.get(ii).getText());
			}else{
				blanksQuestion += (" ~" + blankFields.get(ii).getText());
			}
		}
		blanksQuestion += ("} " + qEnd);
		return blanksQuestion;
	}
	
	public String buildNumRange_1(String qTitle, String qBody, JTextField answerFields, JTextField feedbackFields, Object rangeStart) {
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		String answerHolder = stringConverter(answerFields.getText());
		answerFields.setText(answerHolder);		
		
		String feedbackHolder = stringConverter(feedbackFields.getText());
		feedbackFields.setText(feedbackHolder);
		
		String numRange_1Question = ("::" + qTitle + "::" + qBody + " {");
		numRange_1Question += ("#" + answerFields.getText() + ":" + rangeStart); 
		numRange_1Question += ("}");
		
		return numRange_1Question;
	}

	public String buildNumRange_2(String qTitle, String qBody, Object rangeStart, Object rangeEnd) {
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		String numRange_2Question = ("::" + qTitle + "::" + qBody + " {#" + rangeStart + ".." + rangeEnd + "}");
		return numRange_2Question;
	}
	
	public String buildNumRange_3(String qTitle, String qBody, JTextField answerFields, JTextField feedbackFields, Object qRange, Object rangeMark) {
		qTitle = stringConverter(qTitle);
		qBody = stringConverter(qBody);
		
		String answerHolder = stringConverter(answerFields.getText());
		answerFields.setText(answerHolder);		
			
		String feedbackHolder = stringConverter(feedbackFields.getText());
		feedbackFields.setText(feedbackHolder);
		
		String numRange_3Question = ("::" + qTitle + "::" + qBody + " {#");
		
		numRange_3Question += ("\n=" + answerFields.getText() + ":0 #" + feedbackFields.getText()); 
		numRange_3Question += ("\n=%" + rangeMark + "%" + answerFields.getText() + ":" + qRange); 
		
		numRange_3Question += ("\n}");
		return numRange_3Question;
	}
	
	private String stringConverter(String string){
		
		string = string.replace("~", "\\~");
		string = string.replace("::", "\\::");
		string = string.replace("{", "\\{");
		string = string.replace("}", "\\}");
		string = string.replace("=", "\\=");
		string = string.replace("#", "\\#");
		string = string.replace("%", "\\%");
		
		return string;
	}

}
