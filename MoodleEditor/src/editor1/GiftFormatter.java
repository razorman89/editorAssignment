package editor1;

public class GiftFormatter {
	
	public GiftFormatter(){
		
	}
	
	public String buildT_FGifty(String qTitle, String qBody, String qAnswer){
		System.out.println("TITLE: " + qTitle + "\nBODY: " + qBody + "\nANSWER: " + qAnswer);
		
		String tfQuestion = "";
		tfQuestion = ("::" + qTitle + "::");
		tfQuestion += (qBody + "{" + qAnswer + "}");
		return tfQuestion;
	}
	
	public String multiChoiceAdv(){
		
		return "";
	}
	

}
