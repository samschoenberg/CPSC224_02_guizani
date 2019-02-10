/***************

Homework #2

Due Date: 2/11/2019

Names: Mason Dellutri & Sam Schoenberg

********************/



//A program that plays hangman



import java.util.Scanner;

import java.util.Random;



public class
hw2MasonDellutri

{
    
    public static
    void main(String[] args){
        
        System.out.println("Welcome to Hangman");
        
        int strikes = 0;
        
        String word ="";
        
        int playMode = menuFunction();
        
        while (playMode !=
               3)
            
        {
            
            if (playMode ==
                1)
                
            {
                
                System.out.println("Will go to random word");
                
                word = randomWord();
                
            }
            
            else
                
            {
                
                System.out.println("Will go to entered");
                
                word = userWord();
                
            }
            
            System.out.println("Word is: " + word);
            
            char[] wordToArray = wordToArray(word);
            
            outputGame(word.length(), wordToArray);
            
            playMode = menuFunction();
            
        }
        
        
    }
    
    public static
    int menuFunction()
    
    //this function returns the number which corresponds to the play mode
    
    {
        
        Scanner scnr =
        new Scanner(System.in);
        
        System.out.println(" MENU ");
        
        System.out.println("1. Random Word 2. Player Entered Word 3. Exit");
        
        System.out.print("Please Enter Your Gamemode (1, 2, or 3): ");
        
        int value =
        scnr.nextInt();
        
        while (value <
               1 || value > 3)
            
        {
            
            System.out.print("Please Enter Correct Gamemode (1, 2, or 3): ");
            
            value = scnr.nextInt();
            
        }
        
        return value;
        
    }
    
    
    
    public static
    String randomWord()
    
    //returns a word from a random list of 50 words
    
    {
        
        Random rand =
        new Random();
        
        int wordPosition =
        rand.nextInt(49);
        
        String[] wordList =
        new String[50];
        
        wordList[0] =
        "Awkward";
        
        wordList[1] =
        "Bagpipes";
        
        wordList[2] =
        "Banjo";
        
        wordList[3] =
        "Bungler";
        
        wordList[4] =
        "Croquet";
        
        wordList[5] =
        "Crypt";
        
        wordList[7] =
        "Dwarves";
        
        wordList[8] =
        "Fervid";
        
        wordList[9] =
        "Fishhook";
        
        wordList[10] =
        "Fjord";
        
        wordList[11] =
        "Gazebo";
        
        wordList[12] =
        "Gypsy";
        
        wordList[13] =
        "Haiku";
        
        wordList[14] =
        "Haphazard";
        
        wordList[15] =
        "Hyphen";
        
        wordList[16] =
        "Ivory";
        
        wordList[17] =
        "Jazzy";
        
        wordList[18] =
        "Jiffy";
        
        wordList[19] =
        "Jinx";
        
        wordList[20] =
        "Jukebox";
        
        wordList[21] =
        "Kayak";
        
        wordList[22] =
        "Kiosk";
        
        wordList[23] =
        "Klutz";
        
        wordList[24] =
        "Memento";
        
        wordList[25] =
        "Mystify";
        
        wordList[26] =
        "Numbskull";
        
        wordList[27] =
        "Ostracize";
        
        wordList[28] = 
        "Oxygen";
        
        wordList[29] = 
        "Pajama";
        
        wordList[30] = 
        "Phlegm";
        
        wordList[31] = 
        "Pixel";
        
        wordList[32] = 
        "Polka";
        
        wordList[33] = 
        "Quad";
        
        wordList[34] = 
        "Quip";
        
        wordList[35] = 
        "Rhythmic";
        
        wordList[36] = 
        "Rogue";
        
        wordList[37] = 
        "Sphinx";
        
        wordList[38] = 
        "Squawk";
        
        wordList[39] = 
        "Swivel";
        
        wordList[40] = 
        "Toady";
        
        wordList[41] = 
        "Twelfth";
        
        wordList[42] = 
        "Unzip";
        
        wordList[43] = 
        "Waxy";
        
        wordList[44] = 
        "Wildebeest";
        
        wordList[45] = 
        "Yacht";
        
        wordList[46] = 
        "Zealous";
        
        wordList[47] = 
        "Zigzag";
        
        wordList[48] = 
        "Zippy";
        
        wordList[49] = 
        "Zombie";
        
        return wordList[wordPosition];
        
    }
    
    
    
    public static
    String userWord()
    
    //returns a word from a user
    
    {
        
        Scanner scnr =
        new Scanner(System.in);
        
        String value =
        scnr.next();
        
        return value;
        
    }
    
    public static
    void outputGame(int
                    wordLength, char[]
                    arrayFromWord)
    
    //displays the game
    
    {
        
        System.out.println("**HANGMAN**");
        
        System.out.println("***********");
        
        System.out.println("-----------");
        
        for(int
            i = 0; i < wordLength; i++)
            
        {
            
            System.out.print("_ ");
            
        }
        
        System.out.println();
        
        for(int
            k = 0; k < wordLength; k++)
            
        {
            
            System.out.print(arrayFromWord[k] +
                             " ");
            
        }
        
        System.out.println();
        
        System.out.println("-----------");
        
        System.out.println("***********");
        
    }
    
    
    
    public static
    char[] wordToArray(String
                       word)
    
    //returns an array of characters from a given word
    
    {
        
        char[] arrayFromWord =
        new char[word.length()];
        
        for(int
            i = 0; i < 
            word.length(); i++ )
            
        {
            
            arrayFromWord[i] = word.charAt(i);
            
        }
        
        return arrayFromWord;
        
    }
    
    
    
    public static
    char[] enterGuess(String word)
    
    //returns an array of characters from a given word
    
    {
        
    }
    
    public static guessChecker(char[] characterArray, char[] unguessedWord, char entered) {
        for(int i = 0; i < characterArray.length(); i++) {
            if(entered == characterArray[i]) {
                unguessedWord[i] = entered;
            }
        }
    }
    
    
    
    
    
    

