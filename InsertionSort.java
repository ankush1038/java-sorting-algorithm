import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of employees
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        int[] employeeIDs = new int[n];

        // Taking input for employee IDs
        inputEmployeeIDs(sc, employeeIDs, n);

        // Performing Insertion Sort
        insertionSort(employeeIDs, n);

        // Displaying sorted employee IDs
        displaySortedEmployeeIDs(employeeIDs);

        sc.close();
    }

    public static void inputEmployeeIDs(Scanner sc, int[] employeeIDs, int n) {
        System.out.println("Enter the Employee IDs: ");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = sc.nextInt();
        }
    }

    public static void insertionSort(int[] employeeIDs, int n) {
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            // Moving elements that are greater than key one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void displaySortedEmployeeIDs(int[] employeeIDs) {
        System.out.println("Sorted Employee IDs in ascending order: ");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}

/*
Input:
    int[] employeeIDs = {101, 104, 102, 105, 107, 106, 103};
Output:
    Employee IDs after performing insertion sort:
    [101, 102, 103, 104, 105, 106, 107]
 */