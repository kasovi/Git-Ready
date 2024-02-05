/*
// AUTHOR: Cooper Nathan
// FILENAME: Collection.java
// SPECIFICATION: java class called Collection that has an array and count, capable
// of performing operations to add, remove, and count positive numbers in that array,
// changing size to accommodate new additions, and displaying the contents.
// FOR: CS 1400 - ASSIGNMENT #6
// TIME SPENT: 1 hr
//*/

public class Collection {
    private int count;
    private int[] numArray;

    //constructor
    public Collection(int arraySize){
        numArray = new int[arraySize];
        count = 0;
    }

    /**
     *
     */
    private void doubleArray() {

        int[] newArray = new int[numArray.length * 2]; //new array with double the length
        for (int i = 0; i < numArray.length; i++) { //copy old into new
            newArray[i] = numArray[i];
        }
        numArray = newArray; //replace old with new
    }

    //returns the index of the number specified by the
    //parameter. If the number is not found, it returns -1

    /**
     *
     * @param searchingNum
     * @return
     */
    private int search (int searchingNum) {
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == searchingNum) {
                return 3;
            }
        }
        return -1;
    }

    public boolean add(int numberToAdd) {
            int search = search(numberToAdd); //sees if number already in

            if (search == -1 && count < numArray.length) { //if not in, and not full
                numArray[count] = numberToAdd;
                count++; //add into array and increase count
                return true;

//          If the array reached its capacity, double size by calling
//          the method doubleArray() and add the number.
            } else if (count == numArray.length) {
                doubleArray();
                numArray[count] = numberToAdd;
                count++;
                return true;
            } else {
                return false;
            }
    }

    public boolean remove(int numberToRemove) {
        int search = search(numberToRemove); //see if in array
        if (search != -1) { //if in array
            for (int i = search; i < count; i++) {
                numArray[i] = numArray[i + 1]; //shift all values starting from index of number
            }
            count--; //decrease count because number got removed
            return true;
        } else {
            return false;
        }

    }

    public int findLargest() {
        if (count == 0) {
            return 0;
        }

        int max = numArray[0];
        for (int i = 0; i < count; i++) {
            if (numArray[i] > max) {
                max = numArray[i];
            }
        }
        return max;
    }

    public double computeAverage() {
        if (count == 0) {
            return 0;
        }
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += numArray[i]; //add all numbers up into total
        }
        return (double) total / count; //divide total by number of items
    }

    public int countPositives() {
        int positives = 0;
        for (int i = 0; i < count; i++) {
            if (numArray[i] > 0) { //if greater than 0, positive count goes up
                positives++;
            }
        }
        return positives;
    }

    public String toString() {
        String returnString = "{";

        for (int i = 0; i < count-1; i++) {
            returnString += numArray[i];
            returnString += ", "; //display all but last with comma and space
        }

        return returnString + numArray[count-1] + "}"; //last item with closing semicolon

    }


}
