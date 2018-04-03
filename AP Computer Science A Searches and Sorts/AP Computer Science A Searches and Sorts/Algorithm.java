
/**
 * Enumeration class Algorithm - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Algorithm
{
   SELECTION_SORT("selection sort"),
   INSERTION_SORT("insertion sort"),
   MERGE_SORT("merge sort"),
   QUICK_SORT("quick sort"),
   BINARY_SEARCH("binary search"),
   LINEAR_SEARCH("linear search");
   
   Algorithm(String name)
   {
       this.name = name;
   }
   
   public final String getName()
   {
       return name;
   }
   
   private final String name;
}
