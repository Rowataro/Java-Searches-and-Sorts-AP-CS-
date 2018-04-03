
/**
 * Write a description of class ShowAlgorithms here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
import java.util.Scanner;

 /* About: Here is where the searches and sorts are called, and the integer arrays are.
  * Feel free to change integer arrays to test a certain algorithm.
 */

public class ShowAlgorithm
{
    /*
     * precondition:
     *  Search algorithm is used from enum Algorithm
     * postcondition:
     *  Shows steps of search for values in searchArray.
     */
    public static void runSearch(Algorithm algorithm) throws InterruptedException
    {
        assert 
        (algorithm == Algorithm.BINARY_SEARCH 
        || algorithm == Algorithm.LINEAR_SEARCH) : "Not run with a search algorithm";
        
        Setting.setAll(algorithm);
                     
        searchArray = CreateTestArray.NPowers(total, power);
            
        moveOnToNextSearch = true;
        printAllAtOnce = askForFlag(UserOption.SEE_ALL);
            
        for(int index = 0; index < searchArray.length; ++index)
        {        
            if(!moveOnToNextSearch)
            {
                break;
            }
            
            System.out.println("\n\n\n\nNew " + algorithm.getName() 
            + "--Array: " + Arrays.toString(searchArray));
            executeSearchWithKey(algorithm, searchArray[index]);
            
            assert Search.getIndexOfLastKey() == index : "\nSearch did not work";
            assert Search.wasSuccessful() : "\nSearch flag should have been set to true.";
            
            if(!printAllAtOnce)
            {
                moveOnToNextSearch = askForFlag(UserOption.CONTINUE);
            }
        }   
        
        System.out.println("\nSuccessful " + algorithm.getName() + "es!");
       
        if
        ( 
            Setting.isEnabled(algorithm, Setting.KEY_NOT_FOUND)
        )
        {
            if(!printAllAtOnce)
            {
                moveOnToNextSearch = askForFlag(UserOption.CONTINUE);
                if(!moveOnToNextSearch)
                {
                    return;
                }
            }
            
            System.out.println("\n\n\nSearches with keys not in the array: ");
            
            executeSearchWithKey(algorithm, -1);
            
            assert !Search.wasSuccessful() : "\nSearch flag should have been set to false.";
           
            executeSearchWithKey(algorithm, (int)Math.pow(power, total));
           
            assert !Search.wasSuccessful() : "\nSearch flag should have been set to false."; 
        }
    }
    private static void executeSearchWithKey(Algorithm algorithm, int key) throws InterruptedException
    {
        switch(algorithm)
        {
            case BINARY_SEARCH:
                Search.doBinarySearch(searchArray, key);
            break;
            case LINEAR_SEARCH:
                Search.doLinearSearch(searchArray, key);
            break;
            default:
            break;
        }
    }
    private static boolean askForFlag(final UserOption option)
    {
        int choice;
        switch(option)
        {
            case SEE_ALL:
                System.out.println("\n\nDid you want to see everything printed at once?");
            break; 
            case CONTINUE:
                System.out.println("\n\nContinue?");
            break;
        }
        do
        {   
            System.out.println("\n  Yes: " + YES + "  No: " + NO);
            System.out.print("\nChoice: ");
            
            choice = input.nextInt();
            if(!(choice == YES || choice == NO))
            {
                System.out.println("\nInvalid option");
            }
        }while( !(choice == YES || choice == NO) );
        if(choice == YES)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
     /*
     * precondition:
     *  Sort algorithm is used from enum Algorithm
     * postcondition:
     *  Shows steps of sort for sorting unsortedSortArray
     */
    public static void runSort(Algorithm algorithm) throws InterruptedException
    {
         assert 
         (algorithm == Algorithm.SELECTION_SORT
         || algorithm == Algorithm.INSERTION_SORT 
         || algorithm == Algorithm.MERGE_SORT 
         || algorithm == Algorithm.QUICK_SORT) : "Not run with a sort algorithm";
        
         Setting.setAll(algorithm);
         
         System.out.println("\n\n\n\nNew " + algorithm.getName() 
               + "--Array: " + Arrays.toString(unsortedSortArray));
         unsortedSortArray = executeSort(algorithm);
         
         assert Arrays.equals(unsortedSortArray, expectedSortArray) : "Sort did not work.";
            
         System.out.println("\nSuccessful " + algorithm.getName() + "!");
    }
    private static int[] executeSort(Algorithm algorithm) throws InterruptedException
    {
        switch(algorithm)
        {
            case SELECTION_SORT:
                return Sort.doSelectionSort(unsortedSortArray);
            case INSERTION_SORT:
                return Sort.doInsertionSort(unsortedSortArray);
            case MERGE_SORT:
                return Sort.doMergeSort(unsortedSortArray);
            case QUICK_SORT:
                return Sort.doQuickSort(unsortedSortArray);
            default:
                return null;
        }
    }
    
    private static int[] unsortedSortArray  = {22, 11, 88, 0, 9, 7, 42,1};
    private static int[] expectedSortArray = {0, 1, 7, 9, 11, 22, 42, 88};
    
    private static int[] searchArray = null;   
    private static int total = 10;
    private static int power = 2;
    
    private static boolean printAllAtOnce;
    private static boolean moveOnToNextSearch;
    
    private static Scanner input = new Scanner(System.in);
    private static final int YES = 1;
    private static final int NO = 0;
}