import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // a.	Declare an array of type int named dataPoints.
        int[] randomNumbers = new int[100];

        Random random = new Random();

        // b. Initialize each element in the array with random values between 1 and 100
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(100) + 1;
        }

        // c. Display the array values separated by " | "
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]);
            if (i < randomNumbers.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        // d. Calculate the sum and average of the array values
        int sum = 0;
        for (int number : randomNumbers) {
            sum += number;
        }
        double average = (double) sum / randomNumbers.length;

        // Output the sum and average
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        //2.a Prompt and input an int value between 1 and 100 from the user
        int userInput = SafeInput.getRangedInt(scanner, "Enter an integer between 1 and 100", 1, 100);
        System.out.println("User input: " + userInput);

        //2.b Count how many times the user's value is found within the array
        int count = 0;
        for (int number : randomNumbers) {
            if (number == userInput) {
                count++;
            }
        }
        System.out.println("The user's value was found " + count + " times within the array.");

        //2.c Prompt the user again for a value between 1 and 100
        int searchValue = SafeInput.getRangedInt(scanner, "Enter another integer between 1 and 100 to search in the array", 1, 100);
        System.out.println("Searching for value: " + searchValue);

        // Search for the user's value in the array and display its position if found
        boolean found = false;
        for (int i = 0; i < randomNumbers.length; i++) {
            if (randomNumbers[i] == searchValue) {
                System.out.println("The value " + searchValue + " was found at array index " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The value " + searchValue + " was not found in the array.");
        }

        //2.d Find the minimum and maximum values in the dataPoints array
        int min = randomNumbers[0];
        int max = randomNumbers[0];
        for (int i = 1; i < randomNumbers.length; i++) {
            if (randomNumbers[i] < min) {
                min = randomNumbers[i];
            }
            if (randomNumbers[i] > max) {
                max = randomNumbers[i];
            }
        }
        System.out.println("Minimum value in the array: " + min);
        System.out.println("Maximum value in the array: " + max);

        //2.e Calculate the average of the dataPoints array using the getAverage method
        System.out.println("Average of dataPoints is: " + getAverage(randomNumbers));
    }

    /**
     * Calculates the average of an array of integers.
     *
     * @param values The array of integers
     * @return The average of the array
     */
    public static double getAverage(int[] values) {
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}