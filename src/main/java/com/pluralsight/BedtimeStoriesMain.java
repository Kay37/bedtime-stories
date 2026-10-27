package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BedtimeStoriesMain {

    public static boolean goldiLocksBool = false;
    public static boolean hanselBool = false;
    public static boolean maryHadLittleLambBool = false;

    public static void main(String[] args) {


        //! Prompt the user for the name of the story/file to read
        //*Creating a scanner for user input
        Scanner sc = new Scanner(System.in);
        //*Prompting the user for the name of the story/file they want to read
        System.out.println("""
          ____________________
         /                   /|
        /___________________/ |
        |  _______________  | |
        | |               | | |
        | |  THE STORY    | | |
        | |     BOOK      | | |
        | |               | | |
        | | Which story   | | |
        | | would you     | | |
        | | like to read? | | /
        | |_______________| |/
        |___________________|
         ||||||||||||||||||||
        """);

        System.out.println("1. Goldilocks and the Three Bears");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary Had a Little Lamb");
        System.out.print("Choose a story (1-3): ");
        int storyChoice = sc.nextInt();
        sc.nextLine();
        if (storyChoice == 1) {
            goldiLocksBool = true;
        }
        else if (storyChoice == 2) {
            hanselBool = true;
        }
        else if (storyChoice == 3) {
            maryHadLittleLambBool = true;
        }
        else {
            System.out.println("Invalid choice.");
            return;
        }
        //! Use a new BufferedReader to load and read each line of the chosen story in the file.
        //! and Print the file to the screen, but add a line # to the start of each line.
        try {
            //*Read the file the user selected
            BufferedReader goldilocks = new BufferedReader( new FileReader("goldilocks.txt"));
            BufferedReader hanselAndGretel = new BufferedReader( new FileReader("hansel_and_gretel.txt"));
            BufferedReader maryHadALittleLamb = new BufferedReader( new FileReader("mary_had_a_little_lamb.txt"));

            //*Create a variable that represents each line
            String line;
            //*Loop over the file and assign each line to the variable until we run out of lines
            if (goldiLocksBool == true) {
                int lineCount = 1;
                System.out.println("You have selected the Goldilocks story!\n");
                while((line = goldilocks.readLine()) != null) {
                    System.out.println(lineCount + ": " + line);
                    lineCount++;
                }
                goldilocks.close();
            }
            else if  (hanselBool == true) {
                int lineCount = 1;
                System.out.println("You have selected the Hansel and Gretel story!\n");
                while((line = hanselAndGretel.readLine()) != null) {
                    System.out.println(lineCount + ": " + line);
                    lineCount++;
                }
                hanselAndGretel.close();
            }
            else if  (maryHadLittleLambBool == true) {
                int lineCount = 1;
                System.out.println("You have selected the Mary Had a Little Lamb story!\n");
                while((line = maryHadALittleLamb.readLine()) != null) {
                    System.out.println(lineCount + ": " + line);
                    lineCount++;
                }
                maryHadALittleLamb.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Something went wrong while attempting to read your story.");
        }

    }

}
