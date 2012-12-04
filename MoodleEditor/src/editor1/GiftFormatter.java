package editor1;

import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTextField;

public class GiftFormatter {
	
	public GiftFormatter(){
		
	}
	
	public String buildT_FGifty(String qTitle, String qBody, String qAnswer){
		System.out.println("TITLE: " + qTitle + "\nBODY: " + qBody + "\nANSWER: " + qAnswer);
		
		String tfQuestion = "";
		tfQuestion = ("::" + qTitle + "::" + qBody + "{" + qAnswer + "}");
		return tfQuestion;
	}
	
	public String buildMultiChoiceAdv(String qTitle, String qBody, ArrayList<JTextField> answerFields, ArrayList<JTextField> feedbackFields, ArrayList<JSpinner> answerSpinners){
		
		String multiAdvQuestion = "";
		multiAdvQuestion = ("::" + qTitle + "::" + qBody + "{#");
		
		for (int ii = 0; ii < answerFields.size(); ii++) {
			multiAdvQuestion += ("\n=%" + answerSpinners.get(ii).getValue().toString() + "%" + answerFields.get(ii).getText() + "\t#" + feedbackFields.get(ii).getText());
		}
		
		multiAdvQuestion += ("}");
		
		return multiAdvQuestion;
	}
	

}
