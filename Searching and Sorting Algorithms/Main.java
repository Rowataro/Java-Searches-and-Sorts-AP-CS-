
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

   public static void testBinary()
   {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int index = 0; index < array.length; ++index)
        {
            Search.doBinarySearch(array, index);
            assert Search.getIndexOfLastKey() == index : "\nBinary search did not work";
            assert Search.wasSuccessful() : "\nBinary search flag should have been set to true.";
        }    
        Search.doBinarySearch(array, 10);
        assert Search.getIndexOfLastKey() == 9 : "\nBinary search should have failed.";
        assert !Search.wasSuccessful() : "\nBinary search flag should have been set to false.";
        System.out.println("\nSuccess!");
   }   
   
   public static void testLinear()
   {
       int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int index = 0; index < array.length; ++index)
        {
            Search.doLinearSearch(array, index);
            assert Search.getIndexOfLastKey() == index : "\nLinear search did not work";
            assert Search.wasSuccessful() : "\nLinear search flag should have been set to true.";
        }    
        Search.doLinearSearch(array, 10);
        assert Search.getIndexOfLastKey() == 9 : "\nLinear search should have failed.";
        assert !Search.wasSuccessful() : "\nLinear search flag should have been set to false.";
        System.out.println("\nSuccess!");
   }
   
   public static void testSelection()
   {
       int[] array1 = {22, 11, 99, 88, 9, 7, 42};
       array1 = Sort.doSelectionSort(array1);
       int[] expectedArray1 = {7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array1, expectedArray1) : "\nSelection sort didn't work.";
       
       int[] array2 = {22, 11, 99, 88, 9, 7, 42,1};
       array2 = Sort.doSelectionSort(array2);
       int[] expectedArray2 = {1, 7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array2, expectedArray2) : "\nSelection sort didn't work.";
       
       int[] array3 = {22, 11, 0, 88, 9, 7, 42,1};
       array3 = Sort.doSelectionSort(array3);
       int[] expectedArray3 = {0, 1, 7, 9, 11, 22, 42, 88};
       
       assert Arrays.equals(array3, expectedArray3) : "\nSelection sort didn't work.";
       
       System.out.println("\nSuccess!");
   }
   public static void testInsertion()
   {
       int[] array1 = {22, 11, 99, 88, 9, 7, 42};
       array1 = Sort.doInsertionSort(array1);
       int[] expectedArray1 = {7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array1, expectedArray1) : "\nSelection sort didn't work.";
       
       int[] array2 = {22, 11, 99, 88, 9, 7, 42,1};
       array2 = Sort.doInsertionSort(array2);
       int[] expectedArray2 = {1, 7, 9, 11, 22, 42, 88, 99};
       
       assert Arrays.equals(array2, expectedArray2) : "\nSelection sort didn't work.";
       
       int[] array3 = {22, 11, 0, 88, 9, 7, 42,1};
       array3 = Sort.doInsertionSort(array3);
       int[] expectedArray3 = {0, 1, 7, 9, 11, 22, 42, 88};
       
       assert Arrays.equals(array3, expectedArray3) : "\nSelection sort didn't work.";
       
       System.out.println("\nSuccess!");
   }
  
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
   public static void testBookConstructor()
   {
       Book testBook = new Book("Arthur", "Book", 12);
       assert testBook.author.equals("Arthur") : "Can't access author";
       assert testBook.title.equals("Book") : "Can't access title";
       assert testBook.numPages == 12 : "Can't access pages";
       System.out.println("Success!");
   }
   public static void testLibraryBook()
   {
       LibraryBook testBook = new LibraryBook(new Book("Arthur", "Book", 12), 24);
       assert testBook.getAuthor().equals("Arthur") : "Accessor didn't work.";
       assert testBook.getTitle().equals("Book") : "Accessor didn't work";
       assert testBook.getNumPages() == 12 : "Accessor didn't work";
       assert testBook.getCopies() == 24 : "Accessor didn't work";
       System.out.println("Success!");
   }

   public static void main(String[] args)
   {
       int sentinel = -1;
       int option = -2;
       do 
       {
        Library = new ArrayList<>
       (Arrays.asList
            (
                new LibraryBook(new Book("Tim O' Brien","The Things They Carried", 233),10),
                new LibraryBook(new Book("George Orwell", "Animal Farm", 112), 15),  
                new LibraryBook(new Book("Wilson Rawls","Where The Red Fern Grows", 208), 11),
                new LibraryBook(new Book("Margaret Peterson Haddix", "Found", 336), 2),
                new LibraryBook(new Book("Gayle Forman", "If I Stay", 210), 9),
                new LibraryBook(new Book("Raina Telgemeier","Smile", 224), 4),
                new LibraryBook(new Book("James Dashner", "The Eye of Minds", 312), 1),
                new LibraryBook(new Book("Chris Rylander", "The Fourth Stall", 320), 3),
                new LibraryBook(new Book("Ayn Rand", "Atlas Shrugged", 1168), 1),
                new LibraryBook(new Book("Carl Sandburg", "Remembrance Rock", 1067), 1)
            )
       );
           displayOptions();
           option = getChoice();
           doOption(option);
       }while(option != sentinel);
   }
   private static void displayOptions()
   {
       System.out.println
       (
       "\nOptions: " + 
       "\nSorts: " + 
       "\n  1. Use selection sort to organize by author's last name." + 
       "\n  2. Use insertion sort to organize by title." + 
       "\n  3. Use merge sort to organize by number of pages"+ 
       "\n  4. Use quick sort to organize by number of copies" +
       "\n Searches:" +
       "\n  5. Use sequential search to search for a word in the title" + 
       "\n  6. Use binary search to search for a word in the author's name" +
       "\nNOTE: Indexes from sequential and binary search correspond to a list that is sorted by author's last name." +
       "\nTo quit enter -1"
       );
   }
   private static int getChoice()
   {
       int choice = -1;
       do
       {
       System.out.println("\nEnter choice: ");
       choice = input.nextInt();
       } while(!(choice >= SELECTION_SORT || choice <=BINARY_SEARCH));
       if(!(choice >= SELECTION_SORT || choice <=BINARY_SEARCH))
       {
           System.out.println("\nInvalid option.");
       }
       return choice;
   }    
   private static void doOption(final int option)
   {
       if(option >= SELECTION_SORT && option <= QUICK_SORT)
       {
           System.out.println("\nHere is the library before: ");
           printLibrary();
           switch(option)
           {
               case MERGE_SORT:
                    Sort.doMergeSort(Library);
           }
           System.out.println("\nHere is the library after: ");
           printLibrary();
       }
       else 
       {
       }
   }
   public static void printLibrary()
   {
       System.out.println("\nLibrary: ");
       for(LibraryBook book: Library)
       {
           System.out.print(book);
       }
   }
   
   private static Scanner input = new Scanner(System.in);
   private static final int SELECTION_SORT = 1;
   private static final int INSERTION_SORT = 2;
   private static final int MERGE_SORT = 3;
   private static final int QUICK_SORT = 4;
   private static final int SEQUENTIAL_SEARCH = 5;
   private static final int BINARY_SEARCH = 6;
   private static ArrayList<LibraryBook> Library = new ArrayList<>
   (Arrays.asList
    (
        new LibraryBook(new Book("Tim O' Brien","The Things They Carried", 233),10),
        new LibraryBook(new Book("George Orwell", "Animal Farm", 112), 15),  
        new LibraryBook(new Book("Wilson Rawls","Where The Red Fern Grows", 208), 11),
        new LibraryBook(new Book("Margaret Peterson Haddix", "Found", 336), 2),
        new LibraryBook(new Book("Gayle Forman", "If I Stay", 210), 9),
        new LibraryBook(new Book("Raina Telgemeier","Smile", 224), 4),
        new LibraryBook(new Book("James Dashner", "The Eye of Minds", 312), 1),
        new LibraryBook(new Book("Chris Rylander", "The Fourth Stall", 320), 3),
        new LibraryBook(new Book("Ayn Rand", "Atlas Shrugged", 1168), 1),
        new LibraryBook(new Book("Carl Sandburg", "Remembrance Rock", 1067), 1)
    )
   );
   private static final int TOTAL_BOOKS = Library.size();
}
