//-------------------Task-1:Number Game----------------

import java.util.*;
public class NumberGame
{
	public static void main(String[] args) {
	    Scanner sc =new Scanner(System.in);
	    
	    //int guess;
	    
	    int maxAttempts=5;
	    int attempts=0;
	    int score =0;
	    boolean playAgain = true;
	    int games=0;
	    
	    
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("The number is from 1 to 100. You have " + maxAttempts + " attempts to guess it.");
		
		while(playAgain){
		    games++;
		    int secretNumber = (int)(Math.random()*100)+1;
		    boolean guess = false;
		    for(int i=1;i<=maxAttempts;i++){
		        System.out.println("Attempt "+i+ ": Enter your guess: ");
		        int num = sc.nextInt();
		        if(num == secretNumber){
		            guess = true;
		            score++;
		            System.out.println("your guess is correct");
		            break;
		        }
		        else if (num>secretNumber){
		            System.out.println("Too High");
		            
		        }
		        else {
		            System.out.println("Too Low");
		        }
		        }
		    if (guess ==false){
		        System.out.println("Sorry Buddy you left with no attempts.The secret number is " +secretNumber);
		        
		    }
		    System.out.println("Do you want to play again?(Response with Yes or No)");
		    String yourResponse = sc.next();
		    playAgain = yourResponse.equalsIgnoreCase("yes");
		    
		    
		}
		System.out.println("That's it buddy.Hope  you enjoyed the game");
		if(games==0 || games == 1){
		System.out.println("you have played " +games + " game and ");
		}
		else{
		    System.out.println("you have played " +games + " games and ");
		}
		System.out.println("your score is "+score);

	}
}
