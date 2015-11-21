public class HiLow
{
    private int roll;
    //a 6-sided dice has a maximum value of 6 and a minimum value of 1
    private int maxSide = 6; // intialize the max value to 6
    private int minSide = 1; // intialize the min value to 1
    //to find both our ranges we make variables for each range. 
    //Each range consist of two variables, a variable for the lowest bound
    //and a variable for the highest bound of the range.
    private int lowBound1; //stores smallest number in the low range
    private int lowBound2; //stores highest number in the low range
    private int hiBound1; //stores smallest number in the hi range
    private int hiBound2; //stores highest number in the hi range
    private int pointCount; //stores the points won/lose, starts at 0
    private int userGuess; //used to compare with the random number generated from variable roll and the 
    //low range and high range
    private int gamesPlayed; //stores the number of games played

    
    public void Throw(int dices) //the # of dice(s) a user choices to play with
    //gets pass to the parameter
    {   
        //the value of int dices than gets passed into an equation for both maxSide and minSide
        //to figure out what the max value and min value for the # of dice(s) played with
        maxSide = maxSide * dices;
        minSide = minSide * dices;
        roll = minSide + (int)(Math.random()* maxSide);
        //System.out.println("This is the roll: " + roll); //debugger, shows the number generated from roll
    }
    
    public void throwAgain() //We use this in the while statement to generate a new random number
    //within the low and high range everytime the game loops
    {
        roll = minSide + (int)(Math.random()* maxSide);
        //System.out.println("This is the roll: " + roll);
    } 
    
    public int Value() //method returns the value of roll variable in throw method
    {
        return roll; 
    }
    
    public void setLowRange() //method to set the values in our low range variables
    {
        lowBound1 = minSide;
        lowBound2 = maxSide / 2;
        //System.out.println("This is the lowest bound: " + lowBound1); //debugger
        //System.out.println("This is the highest low bound: " + lowBound2); //debugger
    }
    
    public void setHiRange() //method to set the values in our hi range variables
    {
        hiBound1 = lowBound2 + 1;
        hiBound2 = maxSide;
        //System.out.println("This is the lowest hi bound: " + hiBound1); //debugger
        //System.out.println("This is the hi bound: " + hiBound2); //debugger
    }
    
    public int getLowBound1() //self explainatory returns the value of lowBound1 when called on
    {
        return lowBound1;
    }
    
    public int getLowBound2()
    {
        return lowBound2;
    }
    
    public int getHiBound1()
    {
        return hiBound1;
    }
    
    public int getHiBound2()
    {
        return hiBound2;
    }
    
    public void winPoint() //Increment the points in the game and prompts the score so far
    {
        pointCount++;
        System.out.printf("You WON a point, your score is %d%n", pointCount);
    }
    
    public void losePoint() //Decrement the points in the game and prompts the score so far
    {
        pointCount--;
        System.out.printf("You LOSS a point, your score is %d%n", pointCount);
    }
    
    public void game(int userNumber) //Compares the userGuess variable with the userGuess variable
    //in the MainProgram which gets passed to userNumber in the parameter
    {
        userGuess = userNumber;
        if ( (userGuess < getLowBound1() ) || (userGuess > getHiBound2()) )
            {
                System.out.printf("You guessed %d! Sorry you have to guess a number from %d to %d.%n", userGuess, getLowBound1(), getHiBound2());
            }
        else
        {
        
        if ( (Value() >= getLowBound1() ) && (Value() <= getLowBound2() ) && (userGuess >= getLowBound1() ) && (userGuess <= getLowBound2() ) )
            {
                System.out.printf("You guessed %d! The computer generated %d!%n", userGuess, Value());
                System.out.printf("You guessed it correct in the low range (%d-%d)!%n", getLowBound1(), getLowBound2());
                winPoint();
                gamesPlayed++;
                System.out.printf("You played %d game(s).%n%n", gamesPlayed);
            }
        
        else if ( (Value() >= getHiBound1() ) && (Value() <= getHiBound2() ) && (userGuess >= getHiBound1() ) && (userGuess <= getHiBound2() ) )
            {
                System.out.printf("You guessed %d! The computer generated %d!%n", userGuess, Value());
                System.out.printf("You guessed it correct in the hi range (%d-%d)!%n", getHiBound1(), getHiBound2());
                winPoint();
                gamesPlayed++;
                System.out.printf("You played %d game(s).%n%n", gamesPlayed);
            }
            
        else if ( (Value() >= getLowBound1() ) && (Value() <= getLowBound2() ) && ( (userGuess >= getHiBound1() ) && (userGuess <= getHiBound2() ) ) ) 
            {
                System.out.printf("You guessed %d! The computer generated %d!%n", userGuess, Value());
                System.out.printf("You guessed it incorrect. You guessed it in the hi range (%d-%d), the computer guess was in the low range (%d-%d).%n", getHiBound1(), getHiBound2(), getLowBound1(), getLowBound2());
                losePoint();
                gamesPlayed++;
                System.out.printf("You played %d game(s).%n%n", gamesPlayed);
            }
        
        else 
            {
                System.out.printf("You guessed %d! The computer generated %d!%n", userGuess, Value());
                System.out.printf("You guessed it incorrect. You guessed it in the low range (%d-%d), the computer guess was in the high range (%d-%d).%n", getLowBound1(), getLowBound2(), getHiBound1(), getHiBound2());
                losePoint();
                gamesPlayed++;
                System.out.printf("You played %d game(s).%n%n", gamesPlayed);
            }
        }   
    }
    
    public void showFinalScore() //shows the final score and number of games played in total
    {
        System.out.printf("You ended the game. your FINAL SCORE is %d.%n", pointCount);
        System.out.printf("You played a TOTAL of %d GAME(S).%n", gamesPlayed);
    }
    }