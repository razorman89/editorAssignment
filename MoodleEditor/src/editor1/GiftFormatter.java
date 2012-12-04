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
	
	private String stringConverter(String string){
		
		System.out.println("BEFORE REPLACE: " + string);
		
		string = string.replace("~", "\\~");
		string = string.replace("::", "\\::");
		string = string.replace("{", "\\{");
		string = string.replace("}", "\\}");
		string = string.replace("=", "\\=");
		string = string.replace("#", "\\#");
		
		System.out.println("AFTER REPLACE: " + string);
		
		return string;
		
	}	

}
