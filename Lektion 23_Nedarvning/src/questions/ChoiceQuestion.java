package questions;

import java.util.ArrayList;

public class ChoiceQuestion extends Question {
	// This instance variable is added to the subclass
	private ArrayList<String> choices;

	public ChoiceQuestion() {
		super();
		choices = new ArrayList<String>();
	}

	// This method is added to the subclass
	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct) {
			// Convert choices.size() to string
			String choiceString = "" + choices.size();
			setAnswer(choiceString);
		}
	}

	// This method overrides a method from the superclass
	@Override
	public String displayText() {
		String result = super.displayText();
		for (int i = 0; i < choices.size(); i++) {
			int choiceNumber = i + 1;
			result += choiceNumber + ": " + choices.get(i);
		}
		return result;
	}
}
