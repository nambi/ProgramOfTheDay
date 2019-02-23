package org.nava.year19.feb;

/**
 * To calculate the distance, We start from the left most digit of the number
 * and calculate the difference between those 3 digits and 314. The total score
 * is average of each 3 digit score. For the number 3149, the distrane score is
 * calculated as follows (314-314 = 0)+(149-314 = -165)/2 = -82.5
 * 
 * For the number 357878, the distane is (357 - 314 = 43)+ (578 - 314 = 264) +
 * (787-314 = 473) +(878-314=564) / 4 = 336
 */

public class DistanceTo314 {

    public static void main(String[] args) {

        int input = 0;
        input = 3149;
        input = 357878;
        double distance = getDistance(input);
        System.out.println("The input is : " + input + " and distance is : " + distance);

    }
    /**
     * For easier tokenization, convert to string 
     * Complexity O(n/3) ==> O(n) - n digits in the input
     */
    static double getDistance(int input) {

        String inputStr = String.valueOf(input);
        int length = inputStr.length();
        int entry = 0;
        double total = 0;
        do{
            int endIndex = length >= entry + 3 ? entry + 3 : length;
            int value = Integer.valueOf(inputStr.substring(entry, endIndex));
            total += (value - 314);
            entry++;
        } while (length >= entry+3);

        return total / entry;
    }

}