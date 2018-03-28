
/**
 * Write a description of class Searches here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
      success = false;
      int lowerBound = 0;
      int upperBound = array.length -1;
      
      while(lowerBound <= upperBound)
      {
          int middle = (lowerBound + upperBound)/2;
          if(array[middle] == key)
          {
              keyIndex = middle;
              success = true; 
              break;
          }
          else if (array[middle] > key)
          {
              upperBound = middle - 1;
          }
          else
          {
              lowerBound = middle + 1;
          }
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
