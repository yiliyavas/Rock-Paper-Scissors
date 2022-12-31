import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String time1 = getTime();
		String[] t = time1.split(":", 3);
		
		String word;
		int arr[] = {0, 0, 0};
		String h = t[0];
		String m = t[1];
		String s = t[2];
		
		System.out.println(time1);
		String timeEnd = oneMinute(h, m, s);
		System.out.println(timeEnd);
		
		String[] t1 = timeEnd.split(":", 3);
		String m2 = t1[1] + t1[2];
		int minBeg = Integer.parseInt(m);
		int minEnd = Integer.parseInt(m2);
		
		boolean flag = true;
		while(flag == true) {
			
			time1 = getTime();
			String[] chas = time1.split(":", 3);
			m = chas[1] + chas[2];
			minBeg = Integer.parseInt(m);
			
			if (minBeg >= minEnd) {
				System.out.println(time1);
				flag = false;
			}
			else {
				word = gameStarts();
				if (word.equals("victory"))
					arr[0] = arr[0] + 1;
				else if(word.equals("loss"))
					arr[1] = arr[1] + 1;
				else
					arr[2] = arr[2] + 1;
			}
				
			
		}
		
		for (int i=0; i<3; i++)
			System.out.print(arr[i] + " - "); 

	}


	
	public static String gameStarts() {
		
		System.out.println("Paper Rock Scissor\n");
		
		ArrayList<String> items = new ArrayList<String>();
		items.add("rock");
		items.add("paper");
		items.add("scissor");
		
		int choice1 = randomChoice(); 
		int choice2 = userChoice();
		
		
		System.out.println("Computer choice: " + items.get(choice1));
		System.out.println("User choice: " + items.get(choice2));
		System.out.println(items.get(choice1) + " vs " + items.get(choice2));
		String winner = detWinner(items.get(choice1), items.get(choice2));
		System.out.println("------------------------\n" + winner);
		if (winner.contains("VICTORY")) {
			return "victory";
		}
		else if (winner.contains("LOSS")) {
			return "loss";
		}
		else
			return "draw";
	}
	
	public static int randomChoice() {
		Random rand = new Random();
		int intRandom = rand.nextInt(3);
		return intRandom;
	}
	
	public static String oneMinute (String h, String m, String s) {
		int hour = Integer.parseInt(h);
		int min = Integer.parseInt(m);
		int sec = Integer.parseInt(s);
		min = min + 1;
		
		if (min >= 60) {
			hour++;
			min = min - 60;
		}
		
		if(hour >= 24)
			hour = hour - 24;
		
		
		return hour + ":" + min + ":" + sec;
		
	}
	
	public static int userChoice() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose corresponding number:\n1. Rock \n2. Paper \n3. Scissor");
		int userChoice = input.nextInt();
		
		return userChoice - 1;
	}
	
	
	public static String detWinner(String n1, String n2) {
		if (n1 == n2)
			return "Draw";
		else if (n1 == "rock" && n2 == "paper")
			return "paper beats rock \nUSER'S VICTORY";
		else if (n1 == "rock" && n2 == "scissor")
			return "rock beats scisssor \nUSER'S LOSS";
		else if (n1 == "paper" && n2 == "rock")
			return "paper beats rock \nUSER'S LOSS";
		else if (n1 == "paper" && n1 == "scissor")
			return "scissor beats paper \nUSER'S VICTORY";
		else if (n1 == "scissor" && n2 == "rock")
			return "rock beats scissor \nUSER'S VICTORY";
		else if (n1 == "scissor" && n2 == "paper")
			return "scissors beats paper \nUSER'S LOSS";
		else
			return "error";
	
	}
	
	
	 private static String getTime() {
			//LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			String datetime = String.format("%d:%d:%d", time.getHour(), time.getMinute(), time.getSecond());

			return datetime;
		}
}
