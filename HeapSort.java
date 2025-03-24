import java.util.Scanner;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of job applicants
        System.out.print("Enter the number of job applicants: ");
        int n = sc.nextInt();

        int[] salaryDemands = new int[n];

        // Taking input for salary demands
        System.out.println("Enter the salary demands: ");
        for (int i = 0; i < n; i++) {
            salaryDemands[i] = sc.nextInt();
        }

        // Performing Heap Sort on the array
        heapSort(salaryDemands, n);

        // Displaying the sorted salary demands
        System.out.println("Salary demands after performing heap sort");
        System.out.println(Arrays.toString(salaryDemands));

        sc.close();
    }

    // Method to perform Heap Sort
    public static void heapSort(int[] array, int n) {
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    // Method to heapify a subtree rooted at index i
    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
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
    Enter the number of job applicants: 5
    Enter the salary demands: 60000 75000 50000 90000 65000
Output:
    Salary demands after performing heap sort
    [50000, 60000, 65000, 75000, 90000]
*/
