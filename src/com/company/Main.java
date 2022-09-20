package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        String currentString, tempString;
        List<String> numbersStr;

	    try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                currentString = scanner.nextLine();

                tempString = currentString.replaceAll("[^0-9]+", " "); //Replace all characters that are not numbers
                                                                                       // with spaces

                numbersStr = Arrays.asList(tempString.trim().split(" ")); //Splits the string to an array of strings that contain
                                                                                // numbers which were in the string.

                for(String num : numbersStr){
                    if(Integer.parseInt(num) >= 10){
                        System.out.println(currentString);
                        break; //Since there can be multiple values that are greater than 10
                               // in one string, we need to break the loop after it finds the first one.
                    }
                }

            }
        }catch (FileNotFoundException e){
	        e.printStackTrace();
        }
    }
}
