package com.company;
/**
 @author   Volodymyr Lakusta
 @project   lb1
 @class  Harry
 @version  1.0.0
 @since 15.03.2021 - 18.02
 **/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;



public class Harry {

    public  static String[] getDistinctWordsFromText(String text){

        // clear from punctuation signs
        text = text.replaceAll("[^A-Za-z ']", "");

        // split text by space
        String[] words = text.split(" ");

        String distinctWords = "";

        for (String word : words) {
            if (!distinctWords.contains(word)) {
                distinctWords += word + " ";
            }
        }

        return distinctWords.split(" ");
    }

    public static String getLongestWord(String []words){

        String longestWord = "";

        for (String word:words) {
            if(longestWord.length()<word.length()){
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static int getNumberOfLines(String text){

        String[] lines = text.split("\r\n|\r|\n");

        int harryCounter = 0;

        for (String line:lines) {
            if(line.contains("Harry")){
                harryCounter++;
            }
        }

        return harryCounter;
    }

    public static int getNumbWordsWithC(String[] distWords){

        int numbOfWords = 0;

        for (String word:distWords) {
            if(word.charAt(0)=='C'){
                numbOfWords++;
            }
        }
        return numbOfWords;
    }

    public static int getNumberOfHashIntersection(String[] distinctWords){

        int [] hashes = new int[distinctWords.length];

        for (int i = 0; i < distinctWords.length; i++) {
            hashes[i] = distinctWords[i].hashCode();
        }

        Arrays.sort(hashes);

        int countHashes = 0;

        for (int i = 0; i < hashes.length-1; i++) {
            if (hashes[i]==hashes[i+1]){
                countHashes++;
            }
        }

        return countHashes;
    }

    public static void main(String[] args) throws IOException {
        String harryText = new String(Files.readAllBytes(Paths.get("src/com/company/harry.txt")));

        // get array of distinct words
        String[] distinctWords = getDistinctWordsFromText(harryText);

        // get longest word
        System.out.println(getLongestWord(distinctWords));
        // Output: interestinglooking

        System.out.println(getNumberOfLines(harryText));
        // Output: 1084

        System.out.println(getNumbWordsWithC(distinctWords));
        // Output: 80

        System.out.println(getNumberOfHashIntersection(distinctWords));
        // Output: 0
    }
}
