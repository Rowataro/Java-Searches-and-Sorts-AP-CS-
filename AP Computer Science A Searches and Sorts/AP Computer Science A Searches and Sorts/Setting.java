
import java.util.Scanner;
/*
 * About: If one needs extra details about steps of each algorithm, use this class.
 */
public class Setting
{
    /*
     * Use Case:
     *  Settings need to be set before running algorithms.
     * precondition: 
     *  Valid algorithm from enum Algorithm
     * postcondition:
     *  Sets optional text settings (extra info) for each algorithm.
     */
    public static void setAll(Algorithm algorithm)
    {   
        System.out.println
        (
        "\nThe following are optional help settings. Turn them on or off. Enter appropriate number for yes or no." 
        + "\n(settings correspond to each number):"
        );
        
        displayOptions(algorithm);
        
        boolean[] textOptions = getOptionArray(algorithm); 
        
        for(int index = 0; index < textOptions.length; ++index)
        {
            setOption(index, textOptions);
        }
    }
    private static boolean[] getOptionArray(Algorithm algorithm)
    {
        switch(algorithm)
        {
            case SELECTION_SORT:
                selectionSortOptions = new boolean[TOTAL_SELECTION_SORT_OPTIONS];
                return selectionSortOptions;
            case INSERTION_SORT:
                insertionSortOptions = new boolean[TOTAL_INSERTION_SORT_OPTIONS];
                return insertionSortOptions;
            case MERGE_SORT:
                mergeSortOptions = new boolean[TOTAL_MERGE_SORT_OPTIONS];
                return mergeSortOptions;
            case QUICK_SORT:
                quickSortOptions = new boolean[TOTAL_QUICK_SORT_OPTIONS];
                return quickSortOptions;
            case BINARY_SEARCH:
                binarySearchOptions = new boolean[TOTAL_BINARY_SEARCH_OPTIONS];
                return binarySearchOptions;
            case LINEAR_SEARCH:
                linearSearchOptions = new boolean[TOTAL_LINEAR_SEARCH_OPTIONS];
                return linearSearchOptions;
        }
        
        return null;
    }
    private static void displayOptions(Algorithm algorithm) 
    {
        switch(algorithm)
        {     
            case SELECTION_SORT:
                System.out.println
                (
                    "\n 1. Show step 1 of selection sort?" +
                    "\n    (show next minimum at each step.)" +
                    "\n 2. Show step 2 of selection sort?" + 
                    "\n    (shows values to be swapped.)"
                );
            break;
            case INSERTION_SORT:
                System.out.println
                (
                    "\n 1. Show step 1 of insertion sort?" + 
                    "\n    (defines where insertion occurs in the array and what value is being inserted.)" +
                    "\n 2. Show step 2 of insertion sort?" +
                    "\n    (shows when and how a COMPUTER inserts the value from step 1.)"
                );
            break;
            case MERGE_SORT:
                System.out.println
                (
                    "\n 1. Show step 1 of merge sort?" + 
                    "\n    (recursive calls and the order which they call)" +
                    "\n 2. Show step 2 of merge sort?" +
                    "\n    (dividing upper and lower halves)" +
                    "\n 3. Show step 3 of merge sort?" +
                    "\n    (conquering (sorting subarrays in array) and combining)"
                );
            break;
            case QUICK_SORT:
            break;
            case BINARY_SEARCH:
                System.out.println
                (
                    "\n 1. Show step 1 of binary search?" + 
                    "\n    (defines range of indices where search occurs)" +
                    "\n 2. Show step 2 of binary search?" +
                    "\n    (defines how computer decides to narrow down the array for searching)" +
                    "\n 3. Include optional binary searches?" +
                    "\n    (shows binary search working where keys are not in array. prints at bottom of terminal.)"
                );
            break;
            case LINEAR_SEARCH:
                System.out.println
                (
                    "\n 1. Show step 1 of linear search?" + 
                    "\n    (defines range of indices where search occurs)" +
                    "\n 2. Show step 2 of linear search?" + 
                    "\n    (defines how computer decides if it needs to keep narrowing the array)" +
                    "\n 3. Include optional linear searches?" + 
                    "\n    (shows linear search working where keys are not in array. prints at bottom of terminal.)"
                );
            break;
        }
    }
    private static void setOption(int index, boolean[] options)
    {
        int option;
        
        do
        {
            System.out.println("\nSetting " + (index + 1) + ": ");
            System.out.println("\n Yes: " + YES + "  No: " + NO);
            System.out.print("\nChoice: ");
            
            option = input.nextInt();
            
            if( !(option == YES || option == NO) )
            {
                System.out.println("\nInvalid option.");
            }
        }while( !(option == YES || option == NO) );
        
        if(option == YES)
        {
            options[index] = true;
        }
        else
        {
            options[index] = false;
        }
    }
    
    
    public static boolean isEnabled(Algorithm algorithm, int index)
    {
        switch(algorithm)
        {
            case SELECTION_SORT:
                assert selectionSortOptions != null : "Set help settings.";
                return selectionSortOptions[index];
            case INSERTION_SORT:
                assert insertionSortOptions != null : "Set help settings.";
                return insertionSortOptions[index];
            case MERGE_SORT:
                assert mergeSortOptions != null : "Set help settings";
                return mergeSortOptions[index];
            case QUICK_SORT:
                assert quickSortOptions != null : "Set help settings";
                return quickSortOptions[index];
            case BINARY_SEARCH:
                assert binarySearchOptions != null : "Set help settings.";
                return binarySearchOptions[index];
            case LINEAR_SEARCH:
                assert linearSearchOptions != null : "Set help settings.";
                return linearSearchOptions[index];
        }
        return false;
    }
    
    private static final int YES = 1;
    private static final int NO = 0; 
    
    //indices for option arrays. corresponds together
    
    public static final int NEXT_MINIMUM = 0;
    public static final int SHOW_SWAP_VALUES = 1;
    public static final int TOTAL_SELECTION_SORT_OPTIONS = 2;
    private static boolean[] selectionSortOptions = null;
    
    public static final int INSERTION_GUIDELINES = 0;
    public static final int PROCESS_OF_INSERTION = 1;
    public static final int TOTAL_INSERTION_SORT_OPTIONS = 2;
    private static boolean[] insertionSortOptions = null;
    
    public static final int SHOW_RECURSIVE_CALLS = 0;
    public static final int SHOW_DIVIDE = 1;
    public static final int SHOW_CONQUER_AND_COMBINE = 2;
    public static final int TOTAL_MERGE_SORT_OPTIONS = 3;
    private static boolean[] mergeSortOptions = null; 
    
    public static final int TOTAL_QUICK_SORT_OPTIONS = 0;
    private static boolean[] quickSortOptions = null;
    
    
    
    public static final int KEY_NOT_FOUND = 2;
    
    
    public static final int SEARCH_RANGE_VALUES = 0;
    public static final int NARROWING_THE_SEARCH = 1;
    
    public static final int TOTAL_BINARY_SEARCH_OPTIONS = 3;
    private static boolean[] binarySearchOptions = null;
    
    
    public static final int SEARCH_RANGE = 0;
    public static final int CHECKING_EQUALITY = 1;
    
    public static final int TOTAL_LINEAR_SEARCH_OPTIONS = 3;
    private static boolean[] linearSearchOptions = null;
   
    
    private static Scanner input = new Scanner(System.in);
}
