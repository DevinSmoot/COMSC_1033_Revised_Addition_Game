# FOR loops and METHOD calls

## Introduction
	This week we are taking our previous addition game and using FOR loops and 
	METHOD calls to streamline the code and make it more efficient.
	
## Outline
```java
//Import java scanner

public class Revised_Addition_Game {
	public static void main(String[] args) {
		//Call the addition game method
	}//End main

	public static void additionGameMethod() {
		//Define local variables
		
		//State game name and rules
		
		//FOR loop for the 4 rounds of the game
			//Call randomNumber method with a hardness arguement for number1
			//Call randomNumber method with a hardness arguement for number2
			//Set up the problem with problemAnswer integer to hold answer and number1 + number2
			
			//Print round information
			//State the problem to the user to answer
			
			//Read in their response
			//Initiate scanner
			//Take input and validate that input is an integer
			
			//A DO loop with a nested while to validate an integer was entered
			//DO loop breaks on an answer being entered
				//Check answer by calling isAnswerCorrect method and passing the correct answer with the users answer
				//An IF statement for answer being correct or incorrect
				//A correct answer states that it is correct to the console
				//and that 2 points were added and the difficulty was increased by increasing hardness variable
				//The score is printed
				//An incorrect answer states that is was incorrect to the console
				//and that 1 point was taken away and the difficult was decreased by decrasing hardness variable
				//Hardness can never drop below 10
				//The score is printed
			 
		}//End FOR loop
		//Announce game over
	}//End additionGameMethod
	
	public static int randomNumber(int hardness){
		//Generate a random number
		//Return that number
	}//End randomNumber
	
	public static boolean isAnswerCorrect(int userAnswer, int problemAnswer){
		//Declare a boolean to check the answer in an IF statement and return true or false accordingly
	}//End isAnswerCorrect
}//End main
```

## References and Literature
	*	Liang - Introduction to Java 10th Edition
		Pg 204-205 Section 6.2 & Figure 6.1 Define a Method
	*	Liang - Introduction to Java 10th Edition
		Pg 206 Section 6.3 Calling a Method
	*	Liang - Introduction to Java 10th Edition
		Pg 209 Section 6.4 Void Method Example
	*	Liang - Introduction to Java 10th Edition
		Pg 174 Section 5.5 Which Loop to Use?
	*	Liang - Introduction to Java 10th Edition
		Pg 215 Section 6.6 Modularizing Code
	*	Liang - Introduction to Java 10th Edition
		Pg 87 Section 3.7 Generating Random Numbers
	*	Liang - Introduction to Java 10th Edition
		Pg 78-79 Section 3.3 if Statements

## Code
```java
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
			number1 = randomNumber(hardness);
			//System.out.println("Number 1: " + number1);
			number2 = randomNumber(hardness);
			//System.out.println("Number 2: " + number2);
			problemAnswer = number1 + number2; 
			
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
```