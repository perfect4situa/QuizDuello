package model;

public class Quiz {
	
	private String question;
	private String true1;
	private String false1;
	private String false2;
	private String false3;
	
	public Quiz(String question, String true1, String false1, String false2, String false3) {
		this.question = question;
		this.true1 = true1;
		this.false1 = false1;
		this.false2 = false2;
		this.false3 = false3;
	}

	public String getQuestion() {
		return question;
	}

	public String getTrue1() {
		return true1;
	}

	public String getFalse1() {
		return false1;
	}

	public String getFalse2() {
		return false2;
	}

	public String getFalse3() {
		return false3;
	}
	
	public boolean equals(Quiz x) {
		return question.equals(x.question);
	}

	public String toString() {
		return question + ";" + true1 + ";" + false1 + ";" + false2+ ";" + false3;
	}
	
}
