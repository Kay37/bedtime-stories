
package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BedtimeStoriesMain {

    public static void main(String[] args) {

        // Creating a scanner for user input
        Scanner sc = new Scanner(System.in);

        // Prompting the user to choose a story
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
        String storyFile = "";

        if (storyChoice == 1) {

            System.out.println("\nYou have selected the Goldilocks story!\n");
            storyFile = "goldilocks.txt";
        } else if (storyChoice == 2) {

            System.out.println("\nYou have selected the Hansel and Gretel story!\n");
            storyFile = "hansel_and_gretel.txt";
        } else if (storyChoice == 3) {

            System.out.println("\nYou have selected the Mary Had a Little Lamb story!\n");
            storyFile = "mary_had_a_little_lamb.txt";

        } else {
            System.out.println("Invalid choice.");
            return;
        }

        try {
            BufferedReader storyReader = new BufferedReader(new FileReader(storyFile));
            String line;
            int lineCount = 1;

            while ((line = storyReader.readLine()) != null) {
                System.out.println(lineCount + ": " + line);
                lineCount++;
            }
            storyReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong while attempting to read your story.");
        }

        sc.close();
    }
}
