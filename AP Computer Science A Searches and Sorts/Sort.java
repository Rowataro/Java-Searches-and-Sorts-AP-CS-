
/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.Scanner;

/*
 * Please note that text formatting is not standard. 
 * To help get to the meat of the algorithm, all extra text to explain steps are indented away from the actual program.
 */

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
                    boolean showNextMinimum = Option.isEnabled(Algorithm.SELECTION_SORT, Option.NEXT_MINIMUM);
                    boolean showSwapValues = Option.isEnabled(Algorithm.SELECTION_SORT, Option.SHOW_SWAP_VALUES);
        
        for(int unsortedIndex= 0;  unsortedIndex < array.length-1; ++unsortedIndex)
        {
                    System.out.println("\n\n\nBefore: " + Arrays.toString(array));
            
            int nextIndex = getMinIndexStartingFrom(unsortedIndex, array);
            if(nextIndex != unsortedIndex)
            {
                    if(showSwapValues)
                    {
                        System.out.println
                        (
                        "\n Values to be swapped: " + array[nextIndex] + " and " + array[unsortedIndex] 
                        );
                    }   
                swap(unsortedIndex, nextIndex, array);
            }
                    
                    else if(showSwapValues)
                    {
                        System.out.println
                        ("\n No swap of " + array[unsortedIndex] + " necessary.");
                        
                        if(showNextMinimum)
                        {
                            System.out.println("\n This is because " + array[unsortedIndex] +
                            " is already the next MINIMUM value in the unsorted array." +
                            "\n And thus no swapping is needed."
                            );
                        }
                    }
                    System.out.println("\nAfter: " + Arrays.toString(array));
        } 
                    //|| operator cannot be used b/c of lazy evaluation
                    if(showNextMinimum)
                    {
                        System.out.println("\nNo need for swapping " + array[array.length -1] +" because everything before it is already sorted.");
                    }
                    else if(showSwapValues)
                    {
                        System.out.println("\nNo need for swapping " + array[array.length -1] +" because everything before it is already sorted.");
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
        
            if
            (
               Option.isEnabled
               (Algorithm.SELECTION_SORT, Option.NEXT_MINIMUM) 
            )
            {
                System.out.println
                (
                "\n Next MINIMUM value ( from UNSORTED array: " 
                + printInRange(startIndex, array.length -1, array) + " ): " + minValue
                );
            }
       
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
        for(int unsortedIndex = 1; unsortedIndex < array.length; ++unsortedIndex)
        {
            int sortedIndex = unsortedIndex - 1;
                    
                System.out.println("\n\n\n\nBefore: " + Arrays.toString(array));
            
                if( Option.isEnabled(Algorithm.INSERTION_SORT, Option.INSERTION_GUIDELINES) )
                {
                    System.out.println("\nInsertion guidelines: ");

                    System.out.println("\n SORTED array: " + printInRange(0, sortedIndex, array) );
                    
                    System.out.println
                    (
                    "\n To be inserted (UNSORTED value outside of sorted array): " + array[unsortedIndex]
                    );
                }
            
            insertValueEndingAt(array[unsortedIndex], sortedIndex, array);
            
                System.out.println("\nAfter: " + Arrays.toString(array));
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
        int index;
            
                boolean showProcessOfInsertion = Option.isEnabled(Algorithm.INSERTION_SORT, Option.PROCESS_OF_INSERTION);
                boolean insertionFound = false;
                
                if(showProcessOfInsertion)
                {
                    System.out.println("\nProcess of INSERTION: ");
                    System.out.println("\n READY to insert?");
           
                    insertionFound = (array[endIndex] <= unsortedValue);
                    System.out.println
                    (
                    "\n   Next sorted array value (" + array[endIndex] + ") <= UNSORTED value (" 
                    + unsortedValue + ")?: " + insertionFound
                    );
                    
                    insertionFound = (endIndex == 0);
                    System.out.println("\n   Reached end of SORTED array?: " + insertionFound );
                }
        
        for(index = endIndex; index >= 0 && array[index] > unsortedValue; --index)
        {
            array[index + 1] = array[index];
            
                if(showProcessOfInsertion)
                {
                    System.out.println("\n Process of MOVING");
                    System.out.println
                    (
                    "\n   SORTED array value (" + array[index] + ")" + 
                    " shifted right to make space for UNSORTED value " + unsortedValue + ": " + printInRange(0, endIndex + 1, array) 
                    );
                    if(!insertionFound)
                    {
                        System.out.println("\n READY to insert?");
                        if(index > 0)
                        {
                            System.out.println
                            (
                            "\n   Next SORTED array value (" + array[index - 1] + ") <= UNSORTED value (" 
                            + unsortedValue + ")?: " + (array[index - 1] <= unsortedValue)
                            );
                        }
                        System.out.println("\n   Reached end of SORTED array?: " + (index == 0) );
                    }
                }
         }
        ++index;
           
        array[index] = unsortedValue;
        if(showProcessOfInsertion)
                {
                    if(index == endIndex + 1)
                    {
                        System.out.println
                        (
                        "\n UNSORTED value " + unsortedValue + 
                        " already in correct place in sorted array, so no inserting or moving needed."
                        );
                    }
                    else
                    {
                        System.out.println 
                        (
                        "\n Found correct insertion (in sorted array) of unsorted value " + unsortedValue + 
                        " at index " + index + ": "+ printInRange(0, endIndex + 1, array)
                        );
                    }
                }
    }
    private static String printInRange(int min, int max, int[] array)
    {
      if(min > max)
      {
          int temp = max;
          max = min;
          min = temp;
      }
      else if (min < 0 || max > array.length)
      {
          return "";
      }
      
      String stringArray; 
      
      stringArray = "[";
      if(min != 0)
      {
          stringArray += "...";
      }
      
      for(int index = min; index <= max; ++index)
      {
          stringArray += array[index];
          if(index != max)
          {
              stringArray += ", ";
          }
      }
      
      if(max != array.length - 1)
      {
          stringArray += "...";
      }
      stringArray += "]";

      return stringArray;
  }
    /*
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
    */
   private static Scanner input = new Scanner(System.in);
}
