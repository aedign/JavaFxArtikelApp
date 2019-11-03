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
    public static String lineSearch;
    public static String wordToPrint;


void openFile(String fileName){

    try {
        fileScanner = new Scanner(new File(fileName));
        }

    catch(Exception e){
        System.out.println("File not found");
        }
    }

        
void readFile(String wordtoFind) {

    // split tasks into another two methods and call here
    int count = 0;
            
    try{
		while(fileScanner.hasNext()) {

		    lineSearch = fileScanner.next();
                    
		        if(lineSearch.endsWith(",")) {

                    if (lineSearch.substring(0, wordtoFind.length()).equalsIgnoreCase(wordtoFind)
                            &&
                            lineSearch.substring(0, wordtoFind.length()+1).endsWith(",")) {

                     //   wordToPrint = lineSearch.replace(",", "");

                        wordToPrint = lineSearch.substring(0, wordtoFind.length());

                        System.out.println(searchArticle(lineSearch) + " " + wordToPrint);
                        return;
                    }
                }
		        else{
		            while(!lineSearch.endsWith(","))
                        lineSearch += " " + fileScanner.next();

		            if (lineSearch.substring(0, wordtoFind.length()).equalsIgnoreCase(wordtoFind)
                            &&
                            lineSearch.substring(0, wordtoFind.length()+1).endsWith(",")) {

		               // wordToPrint = lineSearch.replace(",", "");

                        wordToPrint = lineSearch.substring(0, wordtoFind.length());

                        System.out.println(searchArticle(lineSearch) + " " + wordToPrint);
		                return;
		            }
                    }
		}
		System.out.println("Word was not found.");
    }
    catch(Exception e){
        System.out.println("Exception: Error while finding the word in file.");
    }

    fileScanner.close();
}


String searchArticle(String findWordArticle){

    if(findWordArticle.contains(",f,"))
        return "die";
    else if (findWordArticle.contains(",m,"))
        return "der";
    else if(findWordArticle.contains(",n,"))
        return "das";
    else
        return ("Invalid");
}

        
public static void main(String[] args){
            
    NounFinder theNounFinder = new NounFinder();
    theNounFinder.openFile("Nouns.txt");
    theNounFinder.readFile("zelt");

    // "viertelscheffel" cannot be found. error in file. WHY?

    // add commas to all lines that do not end with commas before releasing the app

        }

    }
    

