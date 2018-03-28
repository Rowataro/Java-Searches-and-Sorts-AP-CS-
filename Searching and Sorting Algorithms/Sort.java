
/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Sort
{
    /*
     * precondition: 
     *  Array is unsorted and is of n-length
     * postcondition: 
     *  Array sorted in ASCENDING order
     */
    public static int[] doSelectionSort(int[] array)
    {
        System.out.println("\n\n\n  New Selection Sort");
        for(int unsortedIndex= 0;  unsortedIndex < array.length-1; ++unsortedIndex)
        {
            System.out.println("\n\nBefore swap: " + Arrays.toString(array));
            int nextIndex = getMinIndexStartingFrom(unsortedIndex, array);
            
            if(nextIndex != unsortedIndex)
            {
                swap(unsortedIndex, nextIndex, array);
            }
            System.out.println("\nSwap: " + Arrays.toString(array));
        } 
        return array;
    }
    /*
     * Use Case:
     *  precondition:
     *      int[] array = {18, 6, 66, 44, 9, 22, 14};
     *      getMinIndexStartingFrom(2, array);
     *  postcondition: 
     *      returns 4. 
     *      The minimum is 9 starting from {...66, 44, 9, 22, 14}. 9 has 
     *      index 4 in the original array. 
     */
    private static int getMinIndexStartingFrom(int startIndex, int[] array)
    {
        int minIndex = startIndex;
        int minValue = array[startIndex];
        
        for(int index = startIndex + 1; index < array.length; ++index)
        {
            if(array[index] < minValue)
            {
               minIndex = index;
               minValue = array[index];
            }
        }
        System.out.println("\nNext minimum at index: " + minIndex);
        return minIndex;
    }
     /*
      * precondition:
      *     index1 and index2 are indices of array
      * postcondition:
      *     element at index1 will be at index2 and 
      *     element at index2 will be at index1
     */
    private static void swap(int index1, int index2, int[] array)
    {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }
   
    /*
     * precondition: 
     *  Array is unsorted and is of n-length
     * postcondition: 
     *  Array sorted in ASCENDING order
     */
    public static int[] doInsertionSort(int[] array)
    {
        System.out.println("\n\n\n\n  New Insertion Sort");
        for(int unsortedIndex = 1; unsortedIndex < array.length; ++unsortedIndex)
        {
            System.out.println("\n\n\nBefore insertion: " + Arrays.toString(array));
            int sortedIndex = unsortedIndex - 1;
            insertValueEndingAt(array[unsortedIndex], sortedIndex, array);
            System.out.println("\n\n\nAfter insertion: " + Arrays.toString(array));
        }
        return array;
    }
    /* precondition:
     *      array from 0 to endIndex is sorted in ASCENDING order
     * Use Case:
     *  precondition:
     *      array = {3, 6, 7, 4, 8, 5};
     *      
     *      unsortedValue = 4 
     *      sorted/endIndex = 2
     *      
     *      insertValueEndingAt(4, 2, array);
     *  postcondition: 
     *      array = {3, 4, 6, 7, 8, 5};
     */ 
    private static void insertValueEndingAt(int unsortedValue, int endIndex, int[] array)
    {
        System.out.println("\n\nNew insertion");
        int index;
        for(index = endIndex; index >= 0 && array[index] > unsortedValue; --index)
        {
            array[index + 1] = array[index];
            System.out.println("\nArray values copying forward: " + Arrays.toString(array));
        }
        ++index;
        array[index] = unsortedValue;
        System.out.println("\nCorrect insertion: " + Arrays.toString(array));
    }
    public static void doMergeSort(ArrayList<LibraryBook> library)
    {
        if(library == null)
        {
            System.out.println("\nLibrary is null.");
            return;
        }
        else if (library.isEmpty())
        {
            System.out.println("\nLibrary is empty.");
            return;
        }
       
        int left = 0;
        int right = library.size() - 1;
        mergeSortHelper(library, left, right);
    }
    private static void mergeSortHelper(ArrayList<LibraryBook> library, int left, int right)
    {
         if (left < right)
         {
            int middle = (left + right)/2;
            
            mergeSortHelper(library, left, middle);
            mergeSortHelper(library , middle+1, right);
        
            // Merge the sorted halves
            merge(library, left, middle, right);
        }
    }
    private static void merge(ArrayList<LibraryBook> library, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;
 
        ArrayList<LibraryBook> L = new ArrayList();
        ArrayList<LibraryBook> R = new ArrayList();
        
        for (int i=0; i<n1; ++i)
        {
            L.add( new LibraryBook( library.get(left + i).getBook(), library.get(left + i).getCopies() ) );
        }
        for (int j=0; j<n2; ++j)
        {
            R.add( new LibraryBook( library.get(middle + 1 + j).getBook(), library.get(middle + 1 + j).getCopies() ));
        }
 
        int i = 0, j = 0;
 
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L.get(i).getNumPages() <= R.get(j).getNumPages())
            {
                
                library.set(k, L.get(i));
                i++;
            }
            else
            {
                library.set(k, R.get(j));
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            library.set(k, L.get(i));
            i++;
            k++;
        }
 
        while (j < n2)
        {
            library.set(k, R.get(j));
            j++;
            k++;
        }
    }
    
    public static int[] doQuickSort(int array[])
    {
        assert array!= null : "Array is null";
        assert array.length >= 0 : "Array is empty";
        int low = 0;
        int high = array.length - 1;
        int[] sorted = quickSortHelper(array, low, high);
        return sorted;
    }
    private static int[] quickSortHelper(int[] array, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(array, low, high);
            quickSortHelper(array, low, pi-1);
            quickSortHelper(array, pi+1, high);
        }
        return array;
    }
    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
}
