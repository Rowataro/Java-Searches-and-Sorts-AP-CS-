
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
   public static void testMerge() throws InterruptedException
   {
       ShowAlgorithm.runSort(Algorithm.MERGE_SORT);
   }
   public static void testQuick() throws InterruptedException
   {
       ShowAlgorithm.runSort(Algorithm.QUICK_SORT);
   }
}
