import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of products
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        int[] productPrices = new int[n];

        // Taking input for product prices
        System.out.println("Enter the product prices: ");
        for (int i = 0; i < n; i++) {
            productPrices[i] = sc.nextInt();
        }

        // Performing Quick Sort on the array
        quickSort(productPrices, 0, n - 1);

        // Displaying the sorted product prices
        System.out.println("Product prices after performing quick sort");
        System.out.println(Arrays.toString(productPrices));

        sc.close();
    }

    // Method to perform Quick Sort recursively
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Finding the partition index
            int partitionIndex = partition(array, low, high);

            // Sorting elements before and after partition
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Method to partition the array
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
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
    Enter the number of products: 5
    Enter the product prices: 500 200 700 400 100
Output:
    Product prices after performing quick sort
    [100, 200, 400, 500, 700]
*/
