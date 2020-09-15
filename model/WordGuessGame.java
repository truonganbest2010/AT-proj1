package model;

import java.util.ArrayList;
import java.util.Random;

public class WordGuessGame {
    
    ArrayList<String> wordPool = new ArrayList<>();
    private int indexOfWord;
    private char[] stringOfKey;
    private char[] stringOfGuess;
    private int size;
    private int countGuessKeys;
    private int countHealth;
    private boolean gameFinish;
    

    public WordGuessGame(){
        // initialize the pool       
        wordPool.add("communication"); // 1
        wordPool.add("science");
        wordPool.add("programming");
        wordPool.add("language");
        wordPool.add("difficulty"); // 5
        wordPool.add("artificial");
        wordPool.add("intelligence");
        wordPool.add("attempts");
        wordPool.add("screenshot");
        wordPool.add("baseball"); // 10
        wordPool.add("windows");
        wordPool.add("learning");
        wordPool.add("electronics");
        wordPool.add("beautiful");
        wordPool.add("internet"); // 15
        wordPool.add("database");
        wordPool.add("organization");
        wordPool.add("application");
        wordPool.add("network");
        wordPool.add("friendly");  // 20
        wordPool.add("validation");
        wordPool.add("attempts");
        wordPool.add("statistics");
        wordPool.add("physics");
        wordPool.add("chemistry"); // 25
        wordPool.add("engineering");
        wordPool.add("school");
        wordPool.add("industry");
        wordPool.add("revolution");
        wordPool.add("progress"); // 30
        wordPool.add("characters");
        wordPool.add("heavily");
        wordPool.add("graphics"); // 33

    }

    public void chooseNewWord(){
        Random r = new Random();
        indexOfWord = r.nextInt(wordPool.size()-1);

        countHealth = 5;
        
        gameFinish = false;
        String word = wordPool.get(indexOfWord);
        size = word.length();

        stringOfKey = new char[size];
        stringOfGuess = new char[size];

        for (int i = 0; i < size; i++){
            stringOfKey[i] = word.charAt(i);
            stringOfGuess[i] = '_';    
        }
    }

    public void guessKeyInsert(char guess){
        boolean appear = false;
        countGuessKeys = 0;
        
        for (int i = 0; i < size; i++){
            if (guess == stringOfKey[i]){
                stringOfGuess[i] = guess;
            }
        }
        for (int i = 0; i < size; i++){
            if (guess == stringOfKey[i]){
                appear = true;
                break;
            }
        }
        if (appear == false){
            countHealth--;
        }
        for (int i = 0; i < size; i++){
            if (stringOfGuess[i] != '_')
                countGuessKeys++;
        }
        if (countGuessKeys == size)
            gameFinish = true;
    }

    public String getStringOfKey(){
        String sok = "";
        for (int i = 0; i < size; i++){
            sok += stringOfKey[i] + " ";
        }
        return sok;
    }

    public String getStringOfGuess(){
        String sog = "";
        for (int i = 0; i < size; i++){
            sog += stringOfGuess[i] + " ";
        }
        return sog;
    }

    public int getCountHealth(){
        return countHealth;
    }

    public boolean getGameFinish(){
        return gameFinish;
    }


}