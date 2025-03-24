import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        // Taking input for student marks
        inputMarks(sc, marks, n);

        // Performing Bubble Sort
        bubbleSort(marks, n);

        // Displaying sorted marks
        displaySortedMarks(marks);

        sc.close();
    }

    public static void inputMarks(Scanner sc, int[] marks, int n) {
        System.out.println("Enter the marks of students: ");
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }
    }

    public static void bubbleSort(int[] marks, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swapping adjacent elements if they are in the wrong order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void displaySortedMarks(int[] marks) {
        System.out.println("Sorted marks in ascending order: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}

/*
Input:
    int[] studentMarks = {75, 43, 56, 89, 92};
Output:
    Marks after performing bubble sort:
    [43, 56, 75, 89, 92]
 */
