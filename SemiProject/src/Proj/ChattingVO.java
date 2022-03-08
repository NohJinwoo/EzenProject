package Proj;

public class ChattingVO {
	private String word;
	private String answer;
	
	public ChattingVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ChattingVO(String word) {
		this.word =word;
	}
	
	public ChattingVO(String word, String answer) {
		this.word = word;
		this.answer = answer;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
