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
    private static HashMap<String, String> wordMap = new HashMap<>();

    private static void openFile(){
        try {
            fileScanner = new Scanner(new File("Nouns.txt"));
        }

        catch(Exception e){
            System.out.println("File not found");
        }
    }

    protected static void loadHashMap(){

        openFile();
        while (fileScanner.hasNext()) {
            parsedLine = fileScanner.nextLine();
            String key = findWordInLine(parsedLine);
            if(wordMap.get(key) == null) // proper fix to avoid replacing a word ? EX: repeated words but without gender (Nachnamen)
                wordMap.put(key, parsedLine);
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
        String formattedInput = unformattedInput.substring(0, 1).toUpperCase() +
                unformattedInput.substring(1).toLowerCase();

        return (wordMap.get(formattedInput) != null) ? searchArticle(wordMap.get(formattedInput)): "N/A";
    }

    // "viertelscheffel" cannot be found

    // eigennamen und nachnamen löschen? sie haben kein artikel

}
    

