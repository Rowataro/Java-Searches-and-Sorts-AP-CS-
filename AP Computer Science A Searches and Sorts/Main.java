
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*
 * About: Here is where the searches and sorts are called, and the integer arrays are made.
 * Feel free to change integer arrays to test a certain algorithm.
 */
import java.util.Arrays;

public class Main
{
   public static void testBinary()
   {
        Option.setAll(Algorithm.BINARY_SEARCH);
        
        int TOTAL_ELEMENTS = 10;
        int power = 2;
        int[] array = new int[TOTAL_ELEMENTS]; 
        for(int index = 0; index < TOTAL_ELEMENTS; ++index)
        {
            array[index] = (int)Math.pow(power, index);
        }
        
        for(int index = 0; index < array.length; ++index)
        {
            System.out.println("\n\n\n\nNew binary search--Array: " + Arrays.toString(array));
            Search.doBinarySearch(array, (int)Math.pow(power, index));
            assert Search.getIndexOfLastKey() == index : "\nBinary search did not work";
            assert Search.wasSuccessful() : "\nBinary search flag should have been set to true.";
        }   
        System.out.println("\nSuccessful binary searches!");
        
        if
        ( 
            Option.isEnabled(Algorithm.BINARY_SEARCH, Option.KEY_NOT_FOUND) 
        )
        {
            System.out.println("\n\n\nBinary search with keys not in array: ");
            Search.doBinarySearch(array, -1);
            assert Search.getIndexOfLastKey() == TOTAL_ELEMENTS - 1: "\nBinary search should have failed.";
            assert !Search.wasSuccessful() : "\nBinary search flag should have been set to false.";
            
            Search.doBinarySearch(array, (int)Math.pow(power, TOTAL_ELEMENTS));
            assert Search.getIndexOfLastKey() == TOTAL_ELEMENTS - 1: "\nBinary search should have failed.";
            assert !Search.wasSuccessful() : "\nBinary search flag should have been set to false.";
        }
    }   
   public static void testLinear()
   {
        Option.setAll(Algorithm.LINEAR_SEARCH); 
       
        int TOTAL_ELEMENTS = 10;
        int power = 2;
        int[] array = new int[TOTAL_ELEMENTS]; 
        for(int index = 0; index < TOTAL_ELEMENTS; ++index)
        {
            array[index] = (int)Math.pow(power, index);
        }
        
        for(int index = 0; index < array.length; ++index)
        {
            System.out.println("\n\n\n\nNew linear search--Array: " + Arrays.toString(array));
            Search.doLinearSearch( array, (int)Math.pow(power, index) );
            assert Search.getIndexOfLastKey() == index : "\nLinear search did not work";
            assert Search.wasSuccessful() : "\nLinear search flag should have been set to true.";
        }    
        
        if
        ( 
            Option.isEnabled(Algorithm.LINEAR_SEARCH, Option.KEY_NOT_FOUND) 
        )
        {
            System.out.println("\n\n\nLinear search with keys not in array: ");
            Search.doLinearSearch( array, -1);
            assert Search.getIndexOfLastKey() == TOTAL_ELEMENTS - 1: "\nLinear search should have failed.";
            assert !Search.wasSuccessful() : "\nLinear search flag should have been set to false.";
            
            Search.doLinearSearch( array, (int)Math.pow(power, TOTAL_ELEMENTS) );
            assert Search.getIndexOfLastKey() == TOTAL_ELEMENTS - 1: "\nLinear search should have failed.";
            assert !Search.wasSuccessful() : "\nLinear search flag should have been set to false.";
        }
    }
   
   
   public static void testSelection()
   {
       Option.setAll(Algorithm.SELECTION_SORT);
       int[] array = {22, 11, 0, 88, 9, 7, 42,1};
       System.out.println
       (
           "\n\n\nNew Selection Sort--Array: " + Arrays.toString(array)
       );
       array = Sort.doSelectionSort(array);
       int[] expectedArray = {0, 1, 7, 9, 11, 22, 42, 88};
       assert Arrays.equals(array, expectedArray) : "\nSelection sort didn't work.";
       System.out.println("\nSuccessful selection sort!");
   }
   public static void testInsertion()
   {
       Option.setAll(Algorithm.INSERTION_SORT);
       int[] array = {22, 11, 0, 88, 9, 7, 42,1};
       System.out.println
       (
           "\n\n\nNew Insertion Sort--Array: " + Arrays.toString(array)
       );
       array = Sort.doInsertionSort(array);
       int[] expectedArray = {0, 1, 7, 9, 11, 22, 42, 88};
       assert Arrays.equals(array, expectedArray) : "\nInsertion sort didn't work.";
       System.out.println("\nSuccessful insertion sort!");
   }
   /*
   public static void testQuick()
   {
       int[] array1 = {22, 11, 99, 88, 9, 7, 42};
       array1 = Sort.doQuickSort(array1);
       int[] expectedArray1 = {7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array1, expectedArray1) : "\nSelection sort didn't work.";
       
       int[] array2 = {22, 11, 99, 88, 9, 7, 42,1};
       array2 = Sort.doQuickSort(array2);
       int[] expectedArray2 = {1, 7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array2, expectedArray2) : "\nSelection sort didn't work.";
       
       int[] array3 = {22, 11, 0, 88, 9, 7, 42,1};
       array3 = Sort.doQuickSort(array3);
       int[] expectedArray3 = {0, 1, 7, 9, 11, 22, 42, 88};
       
       assert Arrays.equals(array3, expectedArray3) : "\nSelection sort didn't work.";
       
       System.out.println("\nSuccess!");
   }
   */
   /*
   public static void testMerge()
   {
       int[] array1 = {22, 11, 99, 88, 9, 7, 42};
       array1 = Sort.doMergeSort(array1);
       int[] expectedArray1 = {7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array1, expectedArray1) : "\nSelection sort didn't work.";
       
       int[] array2 = {22, 11, 99, 88, 9, 7, 42,1};
       array2 = Sort.doMergeSort(array2);
       int[] expectedArray2 = {1, 7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array2, expectedArray2) : "\nSelection sort didn't work.";
       
       int[] array3 = {22, 11, 0, 88, 9, 7, 42,1};
       array3 = Sort.doMergeSort(array3);
       int[] expectedArray3 = {0, 1, 7, 9, 11, 22, 42, 88};
       
       assert Arrays.equals(array3, expectedArray3) : "\nSelection sort didn't work.";
       
       System.out.println("\nSuccess!");
   }
   */
}
