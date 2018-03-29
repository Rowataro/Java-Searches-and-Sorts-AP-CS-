
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
                      "\n  (Index calculated as the ROUNDED DOWN average. Middle value is effectively a GUESS to find the key.)"
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
                      " The condition guarantees the key is not in the UPPER half." +
                      "\n Therefore the binary search narrows by eliminating the UPPER half."
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
                      " The condition guarantees the key is not in the LOWER half." + 
                      "\n Therefore the binary search narrows by eliminating the LOWER half."
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
      
              System.out.println("\nKey (value): " + key);
      for(int index = 0; index < array.length; ++index)
      {
              if
              ( 
                Option.isEnabled(Algorithm.LINEAR_SEARCH, Option.SEARCH_RANGE) 
              )
              {
                  System.out.println("\nSearch range: " + printInRange(index, array.length -1, array));
              }
              if
              (
                Option.isEnabled(Algorithm.LINEAR_SEARCH, Option.CHECKING_EQUALITY)
              )
              {
                  System.out.println
                  ("\n Is first range value (" + array[index] + ") == key (" + key + ")?: " + 
                   (array[index] == key)
                  );
              }
          if(array[index] == key)
          {
                  System.out.println("\nKey found at index: " + index);
              keyIndex = index;
              success = true;
              break;
          }
      }
      
              if(!success)
              {
                  System.out.println("\nKey not in array. Linear search narrowed down the whole array.");
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
  
  private static String printInRange(int min, int max, int[] array)
  {
      if (min < 0 || max > array.length)
      {
        return "";
      } 
      else if(min > max)
      {
          int temp = max;
          max = min;
          min = temp;
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
