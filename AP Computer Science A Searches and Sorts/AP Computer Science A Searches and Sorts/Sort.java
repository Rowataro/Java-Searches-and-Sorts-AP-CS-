
/**
 * Write a description of class Sort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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
    public static int[] doSelectionSort(int[] array) throws InterruptedException
    {       
                    boolean showNextMinimum = Setting.isEnabled(Algorithm.SELECTION_SORT, Setting.NEXT_MINIMUM);
                    boolean showSwapValues = Setting.isEnabled(Algorithm.SELECTION_SORT, Setting.SHOW_SWAP_VALUES);

        for(int unsortedIndex= 0;  unsortedIndex < array.length-1; ++unsortedIndex)
        {
                    System.out.println("\n\n\nBefore: " + Arrays.toString(array));
                    TimeUnit.MILLISECONDS.sleep(1250);

            int nextIndex = getMinIndexStartingFrom(unsortedIndex, array);
            if(nextIndex != unsortedIndex)
            {
                    if(showSwapValues)
                    {
                        System.out.println
                        (
                            "\n Values to be swapped (to be sorted and unsorted): "  + array[nextIndex] + " and " + array[unsortedIndex] 
                        );
                        TimeUnit.MILLISECONDS.sleep(1998);
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
                            TimeUnit.MILLISECONDS.sleep(1998);
                        }
                    }
                    System.out.println("\nAfter: " + Arrays.toString(array));
                    TimeUnit.MILLISECONDS.sleep(2500);
        } 

                    if(showNextMinimum || showSwapValues)
                    {
                        System.out.println("\nNo need for swapping " + array[array.length -1] +" because everything before it is already sorted.");
                        TimeUnit.MILLISECONDS.sleep(1998);
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
    private static int getMinIndexStartingFrom(int startIndex, int[] array) throws InterruptedException
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
            Setting.isEnabled
            (Algorithm.SELECTION_SORT, Setting.NEXT_MINIMUM) 
            )
            {
                System.out.println
                (
                    "\n Next MINIMUM value ( from UNSORTED array: " 
                    + arrayInRange(startIndex, array.length -1, array) + " ): " + minValue
                );
                TimeUnit.MILLISECONDS.sleep(1998);
            }

        return minIndex;
    }
    
    /*
     * precondition: 
     *  Array is unsorted and is of n-length
     * postcondition: 
     *  Array sorted in ASCENDING order
     */
    public static int[] doInsertionSort(int[] array) throws InterruptedException
    {   
        for(int unsortedIndex = 1; unsortedIndex < array.length; ++unsortedIndex)
        {
            int sortedIndex = unsortedIndex - 1;

                System.out.println("\n\n\n\nBefore: " + Arrays.toString(array));
                TimeUnit.MILLISECONDS.sleep(1998);
                if( Setting.isEnabled(Algorithm.INSERTION_SORT, Setting.INSERTION_GUIDELINES) )
                {
                    System.out.println("\nInsertion guidelines: ");
    
                    System.out.println("\n SORTED array: " + arrayInRange(0, sortedIndex, array) );
    
                    System.out.println
                    (
                        "\n To be inserted (UNSORTED value outside of sorted array): " + array[unsortedIndex]
                    );
                    TimeUnit.MILLISECONDS.sleep(3000);
                }

            insertValueEndingAt(array[unsortedIndex], sortedIndex, array);

                System.out.println("\nAfter: " + Arrays.toString(array));
                TimeUnit.MILLISECONDS.sleep(2500);
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
     *      sortedIndex/endIndex = 2
     *      
     *      insertValueEndingAt(4, 2, array);
     *  postcondition: 
     *      array = {3, 4, 6, 7, 8, 5};
     */ 
    private static void insertValueEndingAt(int unsortedValue, int endIndex, int[] array) throws InterruptedException
    { 
        int index;

                boolean showProcessOfInsertion = Setting.isEnabled(Algorithm.INSERTION_SORT, Setting.PROCESS_OF_INSERTION);

        for(index = endIndex; index >= 0 && array[index] > unsortedValue; --index)
        {
            array[index + 1] = array[index];

                if(showProcessOfInsertion)
                {
                        System.out.print
                        (
                            "\n SORTED array value " + array[index] + 
                            " shifted RIGHT: " + arrayInRange(0, endIndex + 1, array) 
                        );
                        if(index == 0 || array[index - 1] <= unsortedValue)
                        {
                            TimeUnit.MILLISECONDS.sleep(2500);
                            System.out.println
                            (
                                " \n\n Insertion spot has been found." 
                            );
                        }
                        else
                        {
                            System.out.println
                            (
                                " \n Insertion spot has not been found."
                            );
                        }
                        TimeUnit.MILLISECONDS.sleep(2500);
                }
                
        }
        ++index;

                if(showProcessOfInsertion)
                {
                    if(index == endIndex + 1)
                    {
                        System.out.println
                        (
                            "\n UNSORTED value " + unsortedValue + 
                            " is already in the correct place in the sorted array, so no inserting or moving is needed."
                        );
                        TimeUnit.MILLISECONDS.sleep(2500);
                    }
                    else
                    {   
                        System.out.println("\n HOW?:" );
                        TimeUnit.MILLISECONDS.sleep(666);
                        if(index == 0)
                        {
                            System.out.println("\n   Reached end of SORTED array: true ");
                            System.out.println
                            (
                            "\n   Logically unsorted value (" + unsortedValue +
                            ") would be be valid at index 0 because it is the SMALLEST in the sorted array."
                            );
                            System.out.println("\n   (There would be no other values to move RIGHT.)");  
                            TimeUnit.MILLISECONDS.sleep(3200);
                        }
                        else if(array[index - 1] <= unsortedValue)
                        {
                            System.out.println
                            (
                                "\n   Next SORTED array value (" + array[index -1] + ") <= UNSORTED value (" 
                                + unsortedValue + "): true"
                            );
                            System.out.println("\n   Inserting at index " + index +  " would be valid because then the SORTED array would always be ASCENDING.");
                            TimeUnit.MILLISECONDS.sleep(3200);
                        }
                    }
                }
       
        array[index] = unsortedValue;
        
                if(showProcessOfInsertion && index != endIndex + 1)
                {
                        System.out.println 
                        (
                            "\n Correct insertion in sorted array: "+ arrayInRange(0, endIndex + 1, array)
                        );
                        TimeUnit.MILLISECONDS.sleep(1332);
                }
    }
    
    private static String arrayInRange(int min, int max, int[] array)
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
    
    public static int[] doMergeSort(int[] array) throws InterruptedException
    {
        int lowestIndex = 0;
        int highestIndex = array.length -1;
            if(Setting.isEnabled(Algorithm.MERGE_SORT, Setting.SHOW_RECURSIVE_CALLS))
            {
                System.out.println
                ("\n\nFunction signature -- " +
                "void mergeSortFromTo(int lowestIndex, int highestIndex...)"
                );
                TimeUnit.MILLISECONDS.sleep(1998);
                System.out.println
                (
                    "\n\nInitial call: " + 
                    "mergeSortFromTo(" + lowestIndex + ", " + highestIndex + ")" + 
                    "\nArray: " + Arrays.toString(array)
                );
                TimeUnit.MILLISECONDS.sleep(1998);
                
                if(lowestIndex != highestIndex)
                {
                    System.out.println
                    (
                    "\nORDER of calls " +
                    "\n  (Recursive calls to follow)" +
                    "\nExpect mergeSortToFrom() to: " +
                    "\n 1. DIVIDE (in half)" +
                    "\n 2. CONQUER" +
                    "\n 3. COMBINE until the method returns the initial call."
                    );
                    TimeUnit.MILLISECONDS.sleep(2500);
                }
            }
        mergeSortFromTo(lowestIndex, highestIndex, array);
        return array;
    }
    /*
     * preconditon: 
     *  lowestIndex < highestIndex. 
     *  Array is unsorted and of n-length.
     * postcondition:
     *  Array sorted in ASCENDING order.
     */
    private static void mergeSortFromTo(int lowestIndex, int highestIndex, int[] array) throws InterruptedException
    {
                boolean showRecursiveCalls = Setting.isEnabled(Algorithm.MERGE_SORT, Setting.SHOW_RECURSIVE_CALLS);
                boolean showDivide = Setting.isEnabled(Algorithm.MERGE_SORT, Setting.SHOW_DIVIDE);
                boolean isInitialCall = (lowestIndex == 0 && highestIndex == array.length - 1);
                boolean isBaseCase = (lowestIndex == highestIndex);
                
                if(!isInitialCall)
                {
                    System.out.println("\nWhole array: " + Arrays.toString(array) );
                    TimeUnit.MILLISECONDS.sleep(1998);
                }
                
                if(showRecursiveCalls)
                {
                    if(isBaseCase)
                    {
                        System.out.println
                        (
                            "\n Base case: " +
                            "\n   return array " + arrayInRangeNoElipsis(lowestIndex, highestIndex, array)
                        );
                        TimeUnit.MILLISECONDS.sleep(1998);
                        
                        System.out.println("   (DIVIDING not necessary with one element. It is automaticaly considered SORTED.)");
                        TimeUnit.MILLISECONDS.sleep(1998);
                    }
                    else if(!isInitialCall)
                    {
                        System.out.println
                        (   
                            "\n Recursive call: " + 
                            "mergeSortFromTo(" + lowestIndex + ", " + highestIndex + ")" 
                        );
                        TimeUnit.MILLISECONDS.sleep(2200);
                    }
                }
                if(showDivide && !isBaseCase)
                {
                    System.out.println(" DIVIDE Array: " + arrayInRangeNoElipsis(lowestIndex, highestIndex, array));
                    TimeUnit.MILLISECONDS.sleep(2200);
                }
        
        if(lowestIndex < highestIndex)
        {
            int middleIndex = (lowestIndex + highestIndex)/2;
            
            mergeSortFromTo(lowestIndex, middleIndex, array);
            
                if(showRecursiveCalls)
                {
                    System.out.print("\n Recursive call propogates up to the NEXT top call:");
                    System.out.println(" mergeSortFromTo(" + lowestIndex + ", " + highestIndex + ")");
                    TimeUnit.MILLISECONDS.sleep(2200);
                }
                if(showDivide)
                {
                    System.out.println
                    (
                        " DIVIDE UPPER half of: " +
                         arrayInRangeNoElipsis(lowestIndex, highestIndex, array)
                    );
                    TimeUnit.MILLISECONDS.sleep(2200);
                }
                
            mergeSortFromTo(middleIndex + 1, highestIndex, array);
            
                if(showDivide)
                {
                    System.out.println
                    (   
                    "\n DIVIDING: Done."
                    );
                    TimeUnit.MILLISECONDS.sleep(1998);
                }
                if( Setting.isEnabled(Algorithm.MERGE_SORT, Setting.SHOW_CONQUER_AND_COMBINE) )
                {
                    System.out.println
                    (   
                    "\n\n CONQUER: Sorted subarrays from " + 
                    " mergeSortFromTo(" + lowestIndex + ", " + highestIndex + ")" +
                    " to be merged together into one array."
                    );
                }
                
            mergeLowerAndUpperHalves(lowestIndex, middleIndex, highestIndex, array);
        }
                if(!isInitialCall)
                {
                    System.out.println("\nWhole array: " + Arrays.toString(array));
                    TimeUnit.MILLISECONDS.sleep(2200);
                }
    }
    
    /*
     * preconditon: 
     *  Takes in an array that has two sorted subarrays, lowerHalf and upperHalf.
     *  lowerHalf is from [lowestIndex...middleIndex] and 
     *  upperHalf is from [middleIndex+1...highestIndex]
     * postcondition: 
     *  Merges the array, making it ASCENDING through CONQUERING and COMBINING
     *
     *Examples:
     *Use case 1:
     *  array[0...1] = [87, 17]
     *  lowestIndex = 0;
     *  highestIndex = 1;
     *  middleIndex = (0 + 1)/2 = 0;
     *  
     * precondition:
     *  lowerHalf sorted: array[0...0] = [87] 
     *  upperHalf sorted: array[1...1] = [17]
     *   (by definition, arrays with single elements are sorted)
     *  
     * postcondition: 
     *  mergeLowerAndUpperHalves(...);
     *  array[0...1] = [17, 87]
     *  
     *  
     *Use case 2:
     *  array[0...4] = [17, 87, 88, 6, 22]
     *  lowestIndex = 0;
     *  highestIndex = 4;
     *  middleIndex = (0+4)/2 = 2;
     * precondition:
     *  lowerHalf sorted: array[0...2] = [17, 87, 88]
     *  upperHalf sorted: array[3...4] = [6, 22] 
     *  
     * postcondition: 
     *  mergeLowerAndUpperHalves(...);
     *  array[0...4] = [6, 17, 22, 87, 88]
     */
    private static void mergeLowerAndUpperHalves(int lowestIndex, int middleIndex, int highestIndex, int[] array) throws InterruptedException
    {  
                boolean showConquerAndCombine = Setting.isEnabled(Algorithm.MERGE_SORT, Setting.SHOW_CONQUER_AND_COMBINE); 

       int totalLowerHalfElements = middleIndex - lowestIndex + 1;
       int lowerHalf[] = new int[totalLowerHalfElements];
       int totalUpperHalfElements = highestIndex - (middleIndex +1) + 1;
       int upperHalf[] = new int[totalUpperHalfElements];
       
       int originalArrayIndex = lowestIndex;
       
       for(int index = 0; index < lowerHalf.length; ++index, ++originalArrayIndex) 
       {
           lowerHalf[index] = array[originalArrayIndex];
       }
       
                   if(showConquerAndCombine)
                   {
                       System.out.println("\n  Temporary lowerHalf array: " + Arrays.toString(lowerHalf));
                       TimeUnit.MILLISECONDS.sleep(1998);
                    }
       //originalArrayIndex makes sure upperHalf is filled with values from middleIndex + 1 to highestIndex 
       //array[middleIndex + 1...highestIndex]
       for(int index = 0; index < upperHalf.length; ++index, ++originalArrayIndex)
       {
           upperHalf[index] = array[originalArrayIndex];
       }
       
                   if(showConquerAndCombine)
                   {
                       System.out.println("\n  Temporary upperHalf array: " + Arrays.toString(upperHalf));
                       TimeUnit.MILLISECONDS.sleep(1998);
                   }
               
       originalArrayIndex = lowestIndex;
       int lowerHalfIndex = 0;
       int upperHalfIndex = 0;
       
       //puts appropriate lowerHalf or upperHalf elements in ASCENDING order into original
       //array (hence the updating of originalArrayIndex)
       while(lowerHalfIndex < lowerHalf.length && upperHalfIndex < upperHalf.length)
       {
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       ("\n  Sorting subarrays in array: " 
                       + arrayInRangeNoElipsis(lowestIndex, highestIndex, array)
                       );
                       TimeUnit.MILLISECONDS.sleep(1998);
                   }
           if(lowerHalf[lowerHalfIndex] <= upperHalf[upperHalfIndex])
           {
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       (
                        "\n    Inserting value (" + lowerHalf[lowerHalfIndex] + ")" +
                        " from temporary lower half array"
                       );
                       TimeUnit.MILLISECONDS.sleep(1998);
                   }
                   
               array[originalArrayIndex] = lowerHalf[lowerHalfIndex];  
               
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       ("\n    WHY?: " +
                       "\n        CURRENT lower half value (" + lowerHalf[lowerHalfIndex] + ")" +
                       " <= CURRENT upper half value (" + upperHalf[upperHalfIndex] + ")"
                       );
                       TimeUnit.MILLISECONDS.sleep(2200);
                   }
                   
               ++lowerHalfIndex;
           }
           else 
           {
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       (
                        "\n    Inserting value (" + upperHalf[upperHalfIndex] + ")" +
                        " from temporary upper half array"
                       );
                       TimeUnit.MILLISECONDS.sleep(1998);
                   }
                   
               array[originalArrayIndex] = upperHalf[upperHalfIndex];
               
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       ("\n    WHY?: " +
                       "\n        CURRENT upper half value (" + upperHalf[upperHalfIndex] + ")" +
                       " <= CURRENT lower half value (" + lowerHalf[lowerHalfIndex] + ")"
                       );
                       TimeUnit.MILLISECONDS.sleep(2200);
                    }
                    
               ++upperHalfIndex;
           }
           ++originalArrayIndex;
       }
       
                   if(showConquerAndCombine)
                   {
                       System.out.println("\n    Array fills up with remaining values.");
                       TimeUnit.MILLISECONDS.sleep(2200);
                   }   
       while(lowerHalfIndex < lowerHalf.length)
       {
           array[originalArrayIndex] = lowerHalf[lowerHalfIndex];
           ++lowerHalfIndex;
           ++originalArrayIndex;
       }
       while(upperHalfIndex < upperHalf.length)
       {
           array[originalArrayIndex] = upperHalf[upperHalfIndex];
           ++upperHalfIndex;
           ++originalArrayIndex;
       }
       
                   if(showConquerAndCombine)
                   {
                       System.out.println
                       (
                       "\n COMBINE results:" +
                       "\n   return array " + arrayInRangeNoElipsis(lowestIndex, highestIndex, array) 
                       );
                       TimeUnit.MILLISECONDS.sleep(2500);
                   }
    }
    private static String arrayInRangeNoElipsis(int min, int max, int[] array)
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

        for(int index = min; index <= max; ++index)
        {
            stringArray += array[index];
            if(index != max)
            {
                stringArray += ", ";
            }
        }

        stringArray += "]";

        return stringArray;
    }
    
    public static int[] doQuickSort(int[] array) throws InterruptedException
    {
       int lowestIndex = 0;
       int highestIndex = array.length -1;
       System.out.println
       ("\n\nFunction signature -- " +
       "void quickSortFromTo(int lowestIndex, int highestIndex...)"
       );
       TimeUnit.MILLISECONDS.sleep(1998);
       System.out.println
       (
           "\n\nInitial call: " + 
            "quickSortFromTo(" + lowestIndex + ", " + highestIndex + ")" + 
            "\nArray: " + Arrays.toString(array)
       );
       TimeUnit.MILLISECONDS.sleep(1998);
                
       if(lowestIndex != highestIndex)
       {
           System.out.println
           (
           "\nORDER of calls " +
           "\n  (Recursive calls to follow)" +
           "\nExpect quickSortFromTo() to: " +
           "\n 1. DIVIDE (partitioning subarrays)" +
           "\n 2. CONQUER (partitioning and sorting values)"
           );
           TimeUnit.MILLISECONDS.sleep(2500);
       }
       
       quickSortFromTo(lowestIndex, highestIndex, array);
       return array; 
    }
    /*
     * preconditon: 
     *  lowestIndex < highestIndex. 
     *  Array is unsorted and of n-length.
     * postcondition:
     *  Array sorted in ASCENDING order.
     */
    private static void quickSortFromTo(int lowestIndex, int highestIndex, int[] array)
    {   
        if(lowestIndex < highestIndex)
        {
            int partitionIndex = getIndexFromPartition(lowestIndex, highestIndex, array);
            quickSortFromTo(lowestIndex, partitionIndex - 1, array);
            quickSortFromTo(partitionIndex + 1, highestIndex, array);
        }
    }
    private static int getIndexFromPartition(int lowestIndex, int highestIndex, int[] array)
    {
        int partitionIndex = lowestIndex;
        int partitionValue = array[highestIndex];
        
        for(int index = lowestIndex; index < highestIndex; ++index)
        {
            if(array[index] <= partitionValue)
            {
                swap(index, partitionIndex, array);
                ++partitionIndex;
            }
        }
        
        swap(highestIndex, partitionIndex, array);
        return partitionIndex;
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
}
