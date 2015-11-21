import java.util.Scanner;

public class MainProgram
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        HiLow randomDice = new HiLow(); //object of class type HiLow we create, this will call the methods we choose to call in class HiLow
        int userGuess; //used to compare with the random number generated and the values in the hi and low range
 
        System.out.println();
        System.out.println("How many dice do you want to play with?: ");
        int numberofDices = input.nextInt();
        
        randomDice.Throw(numberofDices); //passes the argument numberofDices to the Throw() method which does most of our calcuations.
        randomDice.Value(); //returns value
        randomDice.setLowRange();
        randomDice.setHiRange();
        randomDice.getLowBound1();
        randomDice.getLowBound2();
        randomDice.getHiBound1();
        randomDice.getHiBound2();
        
        //ask player to guess a number from the minimum and maximum value of the dice
        System.out.printf("Please guess a number from %d to %d: %n", randomDice.getLowBound1(), randomDice.getHiBound2());
        userGuess = input.nextInt();
        randomDice.game(userGuess); 
        
        System.out.println("Do you want to play again? If so type yes or no type no: ");
        String playAgain = input.next();
        // if the player inputs yes, the game loops until the player inputs no
        while (playAgain.equals ("yes") )
        {
            System.out.printf("Please guess a number from %d to %d: %n", randomDice.getLowBound1(), randomDice.getHiBound2());
            userGuess = input.nextInt();
            randomDice.throwAgain();
            randomDice.Value();
            randomDice.game(userGuess); 
            System.out.println("Do you want to play again? If so type yes or no type no: ");
            playAgain = input.next();
            System.out.println();
        }
        randomDice.showFinalScore();
        
    }
}