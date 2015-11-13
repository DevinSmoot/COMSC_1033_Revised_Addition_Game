/* Project:		Methods and Loops
 * Author:		Devin Smoot
 * Date:		2015-11-09
 * Description:	Use globals to make data transfer easier between methods.
 * 				Call methods to complete multiple pieces of the code.
 */
import java.util.Scanner;

public class Revised_Addition_Game {
	public static void main(String[] args) {
		//Call the addition game
		additionGameMethod();
	}//End main

	public static void additionGameMethod() {
		//Define local variables
		int number1;
		int number2;
		int hardness = 10;
		int score = 0;
		int userAnswer;
		int problemAnswer;
		
		//State game name and rules
		System.out.println ("Let's play an addition game!");
		System.out.println ("There will be four rounds of increasing difficulty.");
		System.out.println ("If a question is answered incorrectly the difficulty will decrease.");
				
		for(int i=0;i<4;i=i+1){
			//Ask the user to add these two numbers together
			
			number1 = randomNumber(hardness);
			//System.out.println("Number 1: " + number1);
			number2 = randomNumber(hardness);
			//System.out.println("Number 2: " + number2);
			problemAnswer = number1 + number2; 
			//System.out.println ("Answer: " + problemAnswer); //Debug statement
			
			//Round information
			System.out.println("\nRound #" + (i + 1));
			//Ask user to answer problem
			System.out.println("What is " + number1 + " + " + number2 + "?");
			//Read in their response
			Scanner input = new Scanner(System.in);
			//Take input and validate that input is an integer
			 do {
				 while (!input.hasNextInt()) {
			           System.out.println("That's not a number! Please enter a number.");
			           input.next(); // this is important!
			        }
				 userAnswer = input.nextInt(); // this is important!
			} while (userAnswer <= 0);
			 //Check answer
			 if (isAnswerCorrect(userAnswer, problemAnswer) == true){
				 	System.out.println("The answer was correct.");
					System.out.println("\n2 points added and difficulty increased.");
					hardness *= 10;
					score += 2;
					System.out.println("Score: " + score);
			 }else{
				 	System.out.println("The answer was incorrect.");
					System.out.println("The correct answer was: " + problemAnswer); //Can be removed if you wish
					System.out.println("\n1 point removed and difficulty decreased.");
					if (hardness <= 10){
						hardness = 10;
					}else{
						hardness /= 10;
					}
					score -= 1;
					System.out.println("Score: "+ score);
			 }
		}//End FOR loop
		//Announce game over
		System.out.println ("\nGood game but sadly it has ended");
		System.out.println ("Final score: " + score);
	}//End additionGameMethod
	
	public static int randomNumber(int hardness){
		int generatedNumber = (int)(Math.random()*hardness);
		return generatedNumber;
	}//End randomNumber
	
	public static boolean isAnswerCorrect(int userAnswer, int problemAnswer){
		boolean answerCorrect;
				if (userAnswer == problemAnswer){
					return true;
				}else{
					return false;
				}//End IF statement
	}//End isAnswerCorrect
}//End main