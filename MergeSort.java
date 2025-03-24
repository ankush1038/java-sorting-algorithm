import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of books
        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();

        int[] bookPrices = new int[n];

        // Taking input for book prices
        System.out.println("Enter the book prices: ");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = sc.nextInt();
        }

        // Performing Merge Sort on the array
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        // Displaying the sorted book prices
        System.out.println("Book prices after performing merge sort");
        System.out.println(Arrays.toString(bookPrices));

        sc.close();
    }

    // Method to perform Merge Sort recursively
    public static void mergeSort(int[] bookPrices, int left, int right) {
        if (left < right) {
            // Finding the middle index of the array
            int mid = left + (right - left) / 2;

            // Sorting the first half of the array
            mergeSort(bookPrices, left, mid);

            // Sorting the second half of the array
            mergeSort(bookPrices, mid + 1, right);

            // Merging the sorted halves
            merge(bookPrices, left, mid, right);
        }
    }

    // Method to merge two sorted subarrays
    private static void merge(int[] array, int left, int mid, int right) {
        // Determining the sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Creating temporary arrays to store left and right halves
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copying data into the temporary arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        // Merging the two sorted subarrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copying any remaining elements of leftArray
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copying any remaining elements of rightArray
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}