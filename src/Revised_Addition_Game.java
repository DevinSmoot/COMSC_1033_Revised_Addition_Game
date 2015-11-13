/* Project:		Methods and Loops
 * Author:		Devin Smoot
 * Date:		2015-11-09
 * Description:	Use globals to make data transfer easier between methods.
 * 				Call methods to complete multiple pieces of the code.
 */
import java.util.Scanner;

public class Revised_Addition_Game {
	//Define globals
	//public static int number1;
	//public static int number2;
	//public static int hardness = 10;
	//public static int score;
	//public static int userAnswer;
	//public static int problemAnswer;
	//dummy comment
	
	public static void main(String[] args) {
		//System.out.println("Main method"); //Debug statement
		//Call the addition game
		additionGameMethod();
	}//End main

	public static void additionGameMethod() {
		//System.out.println("Addition Game Method"); //Debug statement
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
			//System.out.println ("FOR loop"); //Debug statement
			//Ask the user to add these two numbers together
			
			number1 = randomNumber(hardness);
			//System.out.println("Number 1: " + number1);
			number2 = randomNumber(hardness);
			//System.out.println("Number 2: " + number2);
			problemAnswer = number1 + number2; 
			//System.out.println ("Answer: " + problemAnswer); //Debug statement
			
			//Ask the user to add these two numbers together
			System.out.println("\nRound #" + (i + 1));
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
					//System.out.println("Hardness of question: " + hardness); //Debug statement
					hardness *= 10;
					score += 2;
					System.out.println("Score: " + score);
			 }else{
				 	System.out.println("The answer was incorrect.");
					System.out.println("The correct answer was: " + problemAnswer); //Can be removed if you wish
					System.out.println("\n1 point removed and difficulty decreased.");
					//System.out.println("Hardness of question: " + hardness); //Debug statement
					if (hardness <= 10){
						hardness = 10;
					}else{
						hardness /= 10;
					}
					//System.out.println("Hardness of question: " + hardness); //Debug statement
					score -= 1;
					System.out.println("Score: "+ score);
			 }
		}//End FOR loop
		//Announce game over
		System.out.println ("\nGood game but sadly it has ended");
		System.out.println ("Final score: " + score);
	}//End additionGameMethod
	
	public static int randomNumber(int hardness){
		//System.out.println ("Random number method"); //Debug statement
		int generatedNumber = (int)(Math.random()*hardness);
		//System.out.println ("Random number: " + generatedNumber); //Debug statement
		return generatedNumber;
	}//End randomNumber
	
	public static boolean isAnswerCorrect(int userAnswer, int problemAnswer){
		//System.out.println("Is Answer Correct method"); //Debug statement
		boolean answerCorrect;
				if (userAnswer == problemAnswer){
					return true;
				}else{
					return false;
				}//End IF statement
	}//End isAnswerCorrect
}//End main