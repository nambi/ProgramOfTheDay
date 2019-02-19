package org.nava.year19.feb;

import java.util.HashMap;
import java.util.Map;

/**
 * Output a total score for given word based on below formula Weight for letters
 * F = 3 J = 6 X = 12 A,I,E,O = 2 T = 5 Others = 0
 * 
 * Example Score for "Jabbt" => 6+2+0+0+5 => 13
 */

 public class WordScore {

   private static HashMap<Character, Integer> alphaWeight;

   /** Initialize the lookup */
   static{
    alphaWeight = getWeight();
   }

   public static void main(String[] args){

    System.out.println(" Welcome to Word score Program");

    String input = "jabbt";
    input = "1231231231";

    int totalScore = getScore(input);

    System.out.println("Total score for "+input+" is : "+totalScore);

   }

   /**
    * Computes the score for given word 
    * The simple solution complexity is O(n) - n being number of characters in the word 
    * Anyother ways to improve? 
    * @param input
    * @return
    */
   static int getScore(String input){
    
    if(input == null || input.equalsIgnoreCase("")){
        return 0;
    }

    input = input.toUpperCase();

    char[] inputChars = input.toCharArray();
    int totalScore = 0;

    for(int i=0; i<inputChars.length; i++){

        if(alphaWeight.containsKey(inputChars[i])) {
               totalScore += alphaWeight.get(inputChars[i]);
        }
    }

    return totalScore;
   }

   /**
    * Construct the lookup table 
    * @return
    */
   static HashMap<Character,Integer> getWeight(){
    
    HashMap<Character, Integer> alphaWeight = new HashMap<Character, Integer>();
    alphaWeight.put('F', 3);
    alphaWeight.put('J', 6);
    alphaWeight.put('X', 12);
    alphaWeight.put('T', 5);
    alphaWeight.put('A', 2);
    alphaWeight.put('I', 2);
    alphaWeight.put('E', 2);
    alphaWeight.put('O', 2);

    return alphaWeight;
   }


 }