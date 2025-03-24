import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] examScores = new int[n];

        // Taking input for students' exam scores
        System.out.println("Enter the exam scores: ");
        for (int i = 0; i < n; i++) {
            examScores[i] = sc.nextInt();
        }

        // Performing Selection Sort on the array
        selectionSort(examScores, n);

        // Displaying the sorted exam scores
        System.out.println("Exam scores after performing selection sort");
        System.out.println(Arrays.toString(examScores));

        sc.close();
    }

    // Method to perform Selection Sort
    public static void selectionSort(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    // Method to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/*
Input:
    Enter the number of students: 5
    Enter the exam scores: 85 72 90 66 78
Output:
    Exam scores after performing selection sort
    [66, 72, 78, 85, 90]
*/
