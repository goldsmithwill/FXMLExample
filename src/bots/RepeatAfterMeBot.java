package bots;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RepeatAfterMeBot {
	private boolean isSecondTime;
	private ArrayList<String> ramList = new ArrayList<String>();

	public String processInput(String input) {
		String output = "";
		if (input == null) {
			try (BufferedReader br = new BufferedReader(new FileReader(
					new File("Random Words.txt")))) {
				for (String line; (line = br.readLine()) != null;) {
					ramList.add(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			isSecondTime = true;
			String greeting = "Hello! My name is RamBot!"
					+ "\nWe're going to be playing Repeat After Me."
					+ "\nBasically, the rules are... repeat after me!"
					+ "\nHere, I'll go first!\n\nTest";
			return greeting;
		} else if (isSecondTime) {
			if (input.equals("Test")) {
				int random = (int) Math.round(Math.random() * 98);
				return ramList.get(random);
			} else {
				return "Wrong!\n\n/ ___| __ _ _ __ ___   ___   / _ \\__   _____ _ __           ___\n| |  _ / _` | '_ ` _ \\ / _ \\ | | | \\ \\ / / _ \\ '__|\n| |_| | (_| | | | | | |  __/ | |_| |\\ V /  __/ |   \n \\____|\\__,_|_| |_| |_|\\___|  \\___/  \\_/ \\___|_|";
			}
		} else {

		}
		return output;

	}
}
