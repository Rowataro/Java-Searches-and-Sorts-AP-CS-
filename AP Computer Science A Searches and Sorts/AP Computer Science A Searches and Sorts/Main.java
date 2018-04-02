
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/*
 * About: Main is for the convience of not having to do runSearch from class ShowAlgorithm
 * manually.
 */
import java.util.Arrays;

public class Main
{
   public static void testBinary() throws InterruptedException
   {
      ShowAlgorithm.runSearch(Algorithm.BINARY_SEARCH);
   }   
   public static void testLinear() throws InterruptedException
   {
       ShowAlgorithm.runSearch(Algorithm.LINEAR_SEARCH);
   }
   
   
   public static void testSelection() throws InterruptedException
   {
       ShowAlgorithm.runSort(Algorithm.SELECTION_SORT);
   }
   public static void testInsertion() throws InterruptedException
   {
     ShowAlgorithm.runSort(Algorithm.INSERTION_SORT);
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
  
  private static boolean showAllAtOnce = false;
  private static boolean moveOnToNextSearch = false;
  
  private static int TOTAL_ELEMENTS = 10;
  private static int power = 2;
}
