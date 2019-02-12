/***************
Homework #2
Due Date: 2/11/2019
Names: Mason Dellutri, Sam Schoenberg
********************/

//A program that plays hangman

import java.util.Scanner;
import java.util.Random;

public class hw2MasonDellutri
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Hangman");
        int strikes = 6;
        String word;
        int playMode = menuFunction();
        while (playMode != 3)
        {
            if (playMode == 1)
            {
                word = randomWord();
            }
            else
            {
                word = userWord();
            }
            char[] wordToArray = wordToArray(word);
            char[] unguessedWord = new char[wordToArray.length];
            for (int i = 0; i < unguessedWord.length; i++)
            {
                unguessedWord[i] = '_';
            }
            outputGame(word.length(), wordToArray, unguessedWord, strikes);
            playMode = menuFunction();
        }
        
    }
    public static int menuFunction()
    //this function returns the number which corresponds to the play mode
    {
       Scanner scnr = new Scanner(System.in);
       System.out.println("                     MENU                      ");
       System.out.println("1. Random Word  2. Player Entered Word  3. Exit");
       System.out.print("Please Enter Your Gamemode (1, 2, or 3): ");
       int value = scnr.nextInt();
       while (value < 1 || value > 3)
       {
        System.out.print("Please Enter Correct Gamemode (1, 2, or 3): ");  
        value = scnr.nextInt();
       }
       return value;
    }

    public static String randomWord()
    //returns a word from a random list of 50 words
    {
        Random rand = new Random();
        int wordPosition = rand.nextInt(49);
        String[] wordList = new String[50];
        wordList[0] = "awkward";
        wordList[1] = "bagpipes";
        wordList[2] = "banjo";
        wordList[3] = "bungler";
        wordList[4] = "croquet";
        wordList[5] = "crypt";
        wordList[7] = "dwarves";
        wordList[8] = "fervid";
        wordList[9] = "fishhook";
        wordList[10] = "fjord";
        wordList[11] = "gazebo";
        wordList[12] = "gypsy";
        wordList[13] = "haiku";
        wordList[14] = "haphazard";
        wordList[15] = "hyphen";
        wordList[16] = "ivory";
        wordList[17] = "jazzy";
        wordList[18] = "jiffy";
        wordList[19] = "jinx";
        wordList[20] = "jukebox";
        wordList[21] = "kayak";
        wordList[22] = "kiosk";
        wordList[23] = "klutz";
        wordList[24] = "memento";
        wordList[25] = "mystify";
        wordList[26] = "numbskull";
        wordList[27] = "ostracize";
        wordList[28] = "oxygen";
        wordList[29] = "pajama";
        wordList[30] = "phlegm";
        wordList[31] = "pixel";
        wordList[32] = "polka";
        wordList[33] = "quad";
        wordList[34] = "quip";
        wordList[35] = "rhythmic";
        wordList[36] = "rogue";
        wordList[37] = "sphinx";
        wordList[38] = "squawk";
        wordList[39] = "swivel";
        wordList[40] = "toady";
        wordList[41] = "twelfth";
        wordList[42] = "unzip";
        wordList[43] = "waxy";
        wordList[44] = "wildebeest";
        wordList[45] = "yacht";
        wordList[46] = "zealous";
        wordList[47] = "zigzag";
        wordList[48] = "zippy";
        wordList[49] = "zombie";
        return wordList[wordPosition];
    }

    public static String userWord()
    //returns a word from a user
    {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a word to play with (lowercase): ");
        String value = scnr.next();
        return value;
    }
    public static void outputGame(int wordLength, char[] arrayFromWord, char[] unguessedWord, int strikes)
    //displays the game
    {
        int currentStrikes = 0;
        //checks if the word has been fully guessed or if all strikes have been met
        while((compareArray(unguessedWord, arrayFromWord) == false) && (currentStrikes < strikes))
        {
            //displays top of gameboard
            System.out.println("**HANGMAN**");
            System.out.println("***********");
            System.out.println("-----------");
            for(int i = 0; i < wordLength; i++)
            {
                System.out.print(unguessedWord[i]);
                System.out.print(" ");
            }
            System.out.println();
            System.out.print("Enter letter: ");
            char enterGuess = enterGuess();
            char [] tempArray = fillArray(unguessedWord); 
            unguessedWord = guessChecker(arrayFromWord, unguessedWord, enterGuess);
            //will check if word has been guessed correctly
            if ((compareArray(unguessedWord, arrayFromWord)))
            {
                System.out.print("YOUR WORD IS: ");
                for(int k = 0; k < wordLength; k++)
                {
                    System.out.print(arrayFromWord[k]);
                }
                System.out.println();
                System.out.println("YOU WIN!!!");
            }
            //checks if array has not changed after guess
            else if ((compareArray(tempArray, unguessedWord)))
            {
                currentStrikes++;
                if (currentStrikes == 1)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("|");
                    System.out.println("|");
                }
                else if (currentStrikes == 2)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("|  |");
                    System.out.println("|");
                }
                else if (currentStrikes == 3)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("| \\|");
                    System.out.println("|");
                }
                else if (currentStrikes == 4)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("| \\|/");
                    System.out.println("|");
                }
                else if (currentStrikes == 5)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("| \\|/");
                    System.out.println("| /");
                }
                else if (currentStrikes == 6)
                {
                    System.out.println("____");
                    System.out.println("|  O");
                    System.out.println("| \\|/");
                    System.out.println("| / \\");
                    System.out.print("THE WORD WAS: ");
                    for(int i = 0; i < wordLength; i++)
                    {
                        System.out.print(arrayFromWord[i]);
                    }
                    System.out.println();
                }
            }
            System.out.println("-----------");
            System.out.println("***********");
        }

    }

    public static char[] wordToArray(String word)
    //returns an array of characters from a given word
    {
        char[] arrayFromWord = new char[word.length()];
        for(int i = 0; i < word.length(); i++ )
        {
            arrayFromWord[i] = word.charAt(i);
        }
        return arrayFromWord;
    }

    public static char enterGuess()
    //returns an array of characters from a given word
    {
        Scanner scnr = new Scanner(System.in);
        char value = scnr.next().charAt(0);
        return value;
    }

    public static char[] fillArray( char[] arrayToEnter)
    //returns an array of characters from a given word
    {
        char[] tempArray = new char[arrayToEnter.length];
        for(int i = 0; i < arrayToEnter.length; i++) {
            tempArray[i] = arrayToEnter[i];
        }
        return tempArray;
    }

    public static boolean compareArray( char[] arrayOne, char[] arrayTwo)
    //returns an array of characters from a given word
    {
        for(int i = 0; i < arrayOne.length; i++) {
           if( arrayOne[i] != arrayTwo[i])
           {
               return false;
           }
        }
        return true;
    }
    

    public static char[] guessChecker(char[] characterArray, char[] unguessedWord, char entered) {

        for(int i = 0; i < characterArray.length; i++) {

            if(entered == characterArray[i]) {

                unguessedWord[i] = entered;
            }
        }
        return unguessedWord;
    }
}
