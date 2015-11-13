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
```

## Console Output
```
Let's play an addition game!
There will be four rounds of increasing difficulty.
If a question is answered incorrectly the difficulty will decrease.

Round #1
What is 9 + 4?
13
The answer was correct.

2 points added and difficulty increased.
Score: 2

Round #2
What is 11 + 79?
90
The answer was correct.

2 points added and difficulty increased.
Score: 4

Round #3
What is 837 + 101?
255
.The answer was incorrect.
The correct answer was: 938

1 point removed and difficulty decreased.
Score: 3

Round #4
What is 33 + 39?
61
That's not a number! Please enter a number.
61
The answer was incorrect.
The correct answer was: 72

1 point removed and difficulty decreased.
Score: 2

Good game but sadly it has ended
Final score: 2
```

## Command Prompt
```
D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git init
Initialized empty Git repository in D:/Documents/School/Fall 2015/Computer Science 1/Workspace/COMSC_1033_Revised_Addition_Game/.git/

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git add .

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git commit -m "Initial commit"
[master (root-commit) e29e5d8] Initial commit
 5 files changed, 270 insertions(+)
 create mode 100644 .classpath
 create mode 100644 .project
 create mode 100644 Readme.md
 create mode 100644 bin/Revised_Addition_Game.class
 create mode 100644 src/Revised_Addition_Game.java

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git remote add origin https://github.com/DevinSmoot/COMSC_1033_Revised_Addition_Game.git

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git push -u origin master
Username for 'https://github.com': DevinSmoot
Password for 'https://DevinSmoot@github.com':
Counting objects: 9, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (9/9), done.
Writing objects: 100% (9/9), 5.02 KiB | 0 bytes/s, done.
Total 9 (delta 0), reused 0 (delta 0)
To https://github.com/DevinSmoot/COMSC_1033_Revised_Addition_Game.git
 * [new branch]      master -> master
Branch master set up to track remote branch master from origin.

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git checkout -b dev
Switched to a new branch 'dev'

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git add .

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git commit -m "Revised code by adding globals"
[dev 721caa8] Revised code by adding globals
 4 files changed, 17 insertions(+), 9 deletions(-)
 create mode 100644 bin/COMSC_1033_Revised_Addition_Game.class
 delete mode 100644 bin/Revised_Addition_Game.class
 create mode 100644 git
 
 D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git push --set-upstream origin dev
Username for 'https://github.com': DevinSmoot
Password for 'https://DevinSmoot@github.com':
Counting objects: 7, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (6/6), done.
Writing objects: 100% (7/7), 1.37 KiB | 0 bytes/s, done.
Total 7 (delta 1), reused 0 (delta 0)
To https://github.com/DevinSmoot/COMSC_1033_Revised_Addition_Game.git
 * [new branch]      dev -> dev
Branch dev set up to track remote branch dev from origin.

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git checkout -b dev2
Switched to a new branch 'dev2'

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git add .

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git commit -m "Removed global variables and passed arguments to methods"
[dev2 14ef7fe] Removed global variables and passed arguments to methods
 3 files changed, 56 insertions(+), 43 deletions(-)
 delete mode 100644 bin/COMSC_1033_Revised_Addition_Game.class
 create mode 100644 bin/Revised_Addition_Game.class
 
 D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git push --set-upstream origin dev2
Username for 'https://github.com': DevinSmoot
Password for 'https://DevinSmoot@github.com':
Counting objects: 6, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (6/6), done.
Writing objects: 100% (6/6), 2.38 KiB | 0 bytes/s, done.
Total 6 (delta 2), reused 0 (delta 0)
To https://github.com/DevinSmoot/COMSC_1033_Revised_Addition_Game.git
 * [new branch]      dev2 -> dev2
Branch dev2 set up to track remote branch dev2 from origin.

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git checkout master
Switched to branch 'master'
Your branch is up-to-date with 'origin/master'.

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git merge dev2
Updating e29e5d8..14ef7fe
Fast-forward
 bin/Revised_Addition_Game.class | Bin 2660 -> 2465 bytes
 git                             |   0
 src/Revised_Addition_Game.java  |  87 +++++++++++++++++++++++++---------------
 3 files changed, 54 insertions(+), 33 deletions(-)
 create mode 100644 git
 
 D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git add .

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git commit -m "Removed debug code and cleaned it up"
[master af0832f] Removed debug code and cleaned it up
 2 files changed, 2 insertions(+), 19 deletions(-)

D:\Documents\School\Fall 2015\Computer Science 1\Workspace\COMSC_1033_Revised_Addition_Game>git push
warning: push.default is unset; its implicit value has changed in
Git 2.0 from 'matching' to 'simple'. To squelch this message
and maintain the traditional behavior, use:

  git config --global push.default matching

To squelch this message and adopt the new behavior now, use:

  git config --global push.default simple

When push.default is set to 'matching', git will push local branches
to the remote branches that already exist with the same name.

Since Git 2.0, Git defaults to the more conservative 'simple'
behavior, which only pushes the current branch to the corresponding
remote branch that 'git pull' uses to update the current branch.

See 'git help config' and search for 'push.default' for further information.
(the 'simple' mode was introduced in Git 1.7.11. Use the similar mode
'current' instead of 'simple' if you sometimes use older versions of Git)

Username for 'https://github.com': DevinSmoot
Password for 'https://DevinSmoot@github.com':
Counting objects: 6, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (6/6), done.
Writing objects: 100% (6/6), 791 bytes | 0 bytes/s, done.
Total 6 (delta 3), reused 0 (delta 0)
To https://github.com/DevinSmoot/COMSC_1033_Revised_Addition_Game.git
   e29e5d8..af0832f  master -> master
```

## Summary
	Even though I had used a FOR loop in my first attempt at the addition
	game it was refreshing to learn how to do methods. This allows for 
	modularizing the code and breaking it up into workable chunks. It also
	makes it easier to debug when problems occur. The IDE also helps
	debug most times but some errors are in the code itself. Passing 
	variables between the methods makes it easier to keep track of what
	information is being handed out to what method rather than using
	global variables as I began using. Even though globals will work it
	tends to defeat the purpose of using methods in the first place and
	passing variable information to those methods. Which isn't done when
	using global variables.
	
	Using this new information on methods is going to make programming in
	java much easier. Whether working on a massive assignment or group
	project the code can easily be broken up into manageable pieces and
	distributed to the group members to work on.