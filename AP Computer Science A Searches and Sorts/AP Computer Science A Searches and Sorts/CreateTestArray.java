
/**
 * Write a description of class CreateTestArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreateTestArray
{
  public static int[] NPowers(int total, int power )
  {
       int[] powers = new int[total];
       for(int index = 0; index < total; ++index)
        {
            powers[index] = (int)Math.pow(power, index);
        }
       return powers;
  }
}
