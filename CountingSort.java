import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] studentAges = new int[n];

        // Taking input for student ages
        System.out.println("Enter the student ages (10 to 18): ");
        for (int i = 0; i < n; i++) {
            studentAges[i] = sc.nextInt();
        }

        // Performing Counting Sort on the array
        countingSort(studentAges, n);

        // Displaying the sorted student ages
        System.out.println("Student ages after performing counting sort");
        System.out.println(Arrays.toString(studentAges));

        sc.close();
    }

    // Method to perform Counting Sort
    public static void countingSort(int[] array, int n) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[n];

        // Count occurrences of each age
        for (int i = 0; i < n; i++) {
            count[array[i] - minAge]++;
        }

        // Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i] - minAge] - 1] = array[i];
            count[array[i] - minAge]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }
}

/*
Input:
    Enter the number of students: 6
    Enter the student ages (10 to 18): 15 12 18 10 14 16
Output:
    Student ages after performing counting sort
    [10, 12, 14, 15, 16, 18]
*/