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
    
    private static Scanner fileScanner;
    private static String parsedLine;
    public static String articleToPrint;
    private static HashMap<String, String> wordMap = new HashMap<>();

    protected static void loadHashMap(){

        openFile();
        while (fileScanner.hasNext()) {
            parsedLine = fileScanner.nextLine();
            wordMap.put(findWordInLine(parsedLine), parsedLine);
        }
        fileScanner.close();
    }

    protected static String findWordInLine(String line){

        String comma = "";
        int i = 0;

        while(!comma.equalsIgnoreCase(",")) {
            comma = line.substring(i, i + 1);
            i++;
        }
        return line.substring(0,i-1);
    }

   private static void openFile(){

      try {
         fileScanner = new Scanner(new File("Nouns.txt"));
         }

     catch(Exception e){
           System.out.println("File not found");
           }
     }

    private static String searchArticle(String findWordArticle) {

        if (findWordArticle.contains(",f,"))
            return "die";
        else if (findWordArticle.contains(",m,"))
            return "der";
        else if (findWordArticle.contains(",n,"))
            return "das";
        else
            return ("N/A");
    }

    protected String getArticle(String unformattedInput){

        if(!unformattedInput.equalsIgnoreCase("")) {
            String formattedInput = unformattedInput.substring(0, 1).toUpperCase() +
                    unformattedInput.substring(1).toLowerCase();

            return (wordMap.get(formattedInput) != null) ?
                    searchArticle(wordMap.get(formattedInput)): "N/A";
        }
        else
            return "N/A";
    }

    public static void main(String[] args){

        loadHashMap();
        String unformattedInput = "paul smith";

        String formattedInput = unformattedInput.substring(0,1).toUpperCase() +
                unformattedInput.substring(1).toLowerCase();

        String upperCaseInput = unformattedInput.toUpperCase();

        String lowerCaseInput = unformattedInput.toLowerCase();

        if(wordMap.get(unformattedInput) != null)
            System.out.println(wordMap.get(unformattedInput));

        System.out.println(searchArticle(wordMap.get(unformattedInput)));

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
    

