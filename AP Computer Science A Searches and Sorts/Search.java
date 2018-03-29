
/**
 * Write a description of class Searches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;
 /*
  * Please note that text formatting is not standard. 
  * To help get to the meat of the algorithm, all extra text to explain steps are indented away from the actual program.
 */
public class Search
{
  /*
   * precondition:
   *    Array is sorted in ASCENDING order.
   * postcondition: 
   *    Success flag and keyIndex set appropriately.
   */
  public static void doBinarySearch(int[] array, int key)
  {
      assert isIntArrayInAscendingOrder(array) : "\nArray parameter is not in ASCENDING order";
      
          System.out.println("\n\n\n\nNew binary search--Array: " + Arrays.toString(array));
          System.out.println("\nKey (value): " + key);
      
      success = false;
      
      int lowerBound = 0;
      int upperBound = array.length -1;
      while(lowerBound <= upperBound)
      {
          int middle = (lowerBound + upperBound)/2;
             
              if
              (
                lowerBound <= upperBound &&
                Option.isEnabled(Algorithm.BINARY_SEARCH, Option.SEARCH_RANGE_VALUES)
              )
              {
                  System.out.println("\n\nSearch range: " + printInRange(lowerBound, upperBound, array));
                  System.out.println
                  (
                  "\n Lower bound index: " + lowerBound + " (value " + array[lowerBound] + ") " +
                  "\n Upper bound index: " + upperBound + " (value " + array[upperBound] + ") " + 
                  "\n Middle index: " + middle + " (value " + array[middle] + ") " +
                  "\n  (Calculated as the rounded down average. Middle value is effectively a guess to find the key.)"
                 );   
              }
              boolean showNarrowingTheSearch = Option.isEnabled(Algorithm.BINARY_SEARCH, Option.NARROWING_THE_SEARCH);
              if(showNarrowingTheSearch)
              {
                  System.out.println("\nNarrowing the search: ");
              }
          
          if(array[middle] == key)
          {
                  if(showNarrowingTheSearch)
                  {
                      System.out.println("\n guess (" + array[middle] + ") == key (" + key + ")?: true");
                      System.out.println("\n Binary search can stop.");
                  }
              System.out.println("\nKey found at index: " + middle);
              
              keyIndex = middle;
              success = true; 
              break;
          }
          else if (array[middle] > key)
          {
                  if(showNarrowingTheSearch)
                  {
                      System.out.println("\n guess (" + array[middle] + ") > key (" + key + ")?: true");
                      System.out.println
                      (
                      " Binary search narrows by eliminating upper half." +
                      "\n The previous condition guarantees the key is not in the upper half."
                      );
                  }
             
              upperBound = middle - 1;
          }
          else
          {
                  if(showNarrowingTheSearch)
                  {
                      System.out.println("\n guess (" + array[middle] + ") < key (" + key + ")?: true");
                      System.out.println
                      (
                      " Binary search narrows by eliminating lower half." + 
                      "\n The previous condition guarantees the key is not in the lower half."
                      );
                  }
       
              lowerBound = middle + 1;
          }
      }
      
      if(!success)
      {
          System.out.println("\nKey not in array. Binary search narrowed down the whole array.");
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
   * precondition:
   *    Array is sorted in ASCENDING order.
   * postcondition: 
   *    Success flag and keyIndex set appropriately.
   */
  public static void doLinearSearch(int[] array, int key)
  {
      assert isIntArrayInAscendingOrder(array) : "\nArray parameter is not in ASCENDING order";
      success = false;
      
      for(int index = 0; index < array.length; ++index)
      {
          if(array[index] == key)
          {
              keyIndex = index;
              success = true;
              break;
          }
      }
  }
  
  private static boolean isIntArrayInAscendingOrder(int[] array)
  {
      for(int index = 0; index < array.length - 1; ++index)
      {
          if(array[index] > array[index + 1])
          {
              return false;
          }
      }
      return true;
  }
  
  /*
   * Indicate of the LAST search
   */
  public static int getIndexOfLastKey()
  {
      return keyIndex;
  }
  /*
   * Indicative of the LAST search
   */
  public static boolean wasSuccessful()
  {
      return success;
  }
  
  private static int keyIndex = -1;
  private static boolean success = false;
}
