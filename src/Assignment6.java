/*   
// AUTHOR: YOUR NAME
// FILENAME: TITLE OF THIS SOURCE FILE
// SPECIFICATION: DESCRIPTION OF THIS PROGRAM
// FOR: CS 1400 - ASSIGNMENT #6
// TIME SPENT: HOW LONG IT TOOK YOU TO FINISH THIS ASSIGNMENT
//*/

import java.util.Scanner;
import java.text.*;
public class Assignment6 {
    public static void main(String[] args)
    {   //declare variables
        int number, size;
        String choice;
        char command;

        Scanner keyboard = new Scanner(System.in);
        // ask a user for a array size
        System.out.println("Please enter a size for the array: ");
        size = keyboard.nextInt();

        // instantiate an IntCollection object
        Collection collection = new Collection(size);

        // print the menu
        printMenu();

        do
        {
            // ask a user to choose a command
            System.out.println("\nPlease enter a command or type: ");
            choice = keyboard.next().toLowerCase();
            command = choice.charAt(0);

            switch (command)
            {
                case 'a': // add a number
                    System.out.println("Please enter an integer to add: ");
                    number = keyboard.nextInt();
                    if(collection.add(number))
                        System.out.println(number + " successfully added.");
                    else
                        System.out.println(number + " is already in the array. " + number + " was not added.");
                    break;
                case 'b': //remove from collection
                    System.out.println("Please enter an integer to remove: ");
                    number = keyboard.nextInt();
                    if(collection.remove(number))
                        System.out.println(number + " successfully removed.");
                    else
                        System.out.println(number + " is not in the array. " + number + " was not removed.");
                    break;
                case 'c': //display
                    System.out.println("The content of the array: " + collection.toString());
                    break;
                case 'd': //find largest
                    System.out.println("The largest number is: " + collection.findLargest());
                    break;

                case 'e': // count of positive
                    System.out.println("\nThe count of positive numbers is: " + collection.countPositives());
                    break;
                case 'f': // count of even numbers
                    // Round the output to three decimal places
                    DecimalFormat fmt = new DecimalFormat ("0.###");
                    System.out.println("The average is: " + fmt.format(collection.computeAverage()));
                    break;

                case '?':
                    printMenu();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid input!");
            }

        } while (command != 'q');

        keyboard.close();

    }  //end of the main method


    // this method prints out the menu to a user
    public static void printMenu()
    {
        System.out.println("\nCommand Options\n"
                + "a: add an integer in the array\n"
                + "b: remove an integer from the array\n"
                + "c: display the array\n"
                + "d: find largest\n"
                + "e: count positive numbers\n"
                + "f: compute average\n"
                + "?: display the menu again\n"
                + "q: quit this program");

    } // end of the printMenu method

} // end of the Assignment6 class