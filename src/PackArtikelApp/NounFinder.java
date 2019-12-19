/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andres Di Gregorio
 */

package PackArtikelApp;

import java.io.*;
import java.util.*;

public class NounFinder {
    
    protected static Scanner fileScanner;
    public static String parsedLine;
    public static String wordToPrint;
    public static HashMap<String, String> wordMap = new HashMap<>();


    public static void loadHashMap(){

        openFile("Nouns.txt");

            while (fileScanner.hasNext()) {
                parsedLine = fileScanner.nextLine();
                wordMap.put(findWordInLine(fileScanner.nextLine()), fileScanner.nextLine());
            }
        fileScanner.close();
    }

    public static String findWordInLine(String line){

        String comma = "";
        int i = 0;

        while(!comma.equalsIgnoreCase(",")) {
            comma = line.substring(i, i + 1);
            i++;
        }
        return line.substring(0,i-1);
    }

    static void openFile(String fileName){

      try {
         fileScanner = new Scanner(new File(fileName));
         }

     catch(Exception e){
           System.out.println("File not found");
           }
     }
    /*
     static void readFile(String wordtoFind) {

      // split tasks into another two methods and call here
     int count = 0;

        long time1 = System.currentTimeMillis();

            
        try{
		    while(fileScanner.hasNext()) {

            parsedLine = fileScanner.next();

            if (parsedLine.endsWith(",")) {

                if (parsedLine.substring(0, wordtoFind.length()).equalsIgnoreCase(wordtoFind)
                        &&
                        parsedLine.substring(0, wordtoFind.length() + 1).endsWith(",")) {

                    //   wordToPrint = lineSearch.replace(",", "");

                    wordToPrint = parsedLine.substring(0, wordtoFind.length());

                    System.out.println(searchArticle(parsedLine) + " " + wordToPrint);
                    return;
                }
            } else {
                while (!parsedLine.endsWith(","))
                    parsedLine += " " + fileScanner.next();

                if (parsedLine.substring(0, wordtoFind.length()).equalsIgnoreCase(wordtoFind)
                        &&
                        parsedLine.substring(0, wordtoFind.length() + 1).endsWith(",")) {

                    // wordToPrint = lineSearch.replace(",", "");

                    wordToPrint = parsedLine.substring(0, wordtoFind.length());

                    System.out.println(searchArticle(parsedLine) + " " + wordToPrint);
                    return;
                }
            }
        }
		System.out.println("Word not found.");
    }
    catch(Exception e){
        System.out.println("Exception: Word not in file or entered incorrectly.");
    }
    fileScanner.close();
}
*/

    static String searchArticle(String findWordArticle){

        if(findWordArticle.contains(",f,"))
            return "die";
        else if (findWordArticle.contains(",m,"))
            return "der";
        else if(findWordArticle.contains(",n,"))
            return "das";
        else
            return ("Word has no article");
    }

        
    public static void main(String[] args){

        loadHashMap();
        String unformattedInput = "1. Johannesbrief";

        String formattedInput = unformattedInput.substring(0,1).toUpperCase() +
                unformattedInput.substring(1).toLowerCase();

        String upperCaseInput = unformattedInput.toUpperCase();

        String lowerCaseInput = unformattedInput.toLowerCase();





    if(wordMap.get(unformattedInput) != null)
        System.out.println(wordMap.get(unformattedInput));

        if(wordMap.get(formattedInput) != null)
            System.out.println(wordMap.get(formattedInput));

    if(wordMap.get(upperCaseInput) != null)
        System.out.println(wordMap.get(upperCaseInput));

    if(wordMap.get(lowerCaseInput) != null)
        System.out.println(wordMap.get(lowerCaseInput));

    // "viertelscheffel" cannot be found. error in file. WHY?

    // add commas to all lines that do not end with commas before releasing the app

        }

    }
    

