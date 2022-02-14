package Programs;
//Hashing with key value pair
import java.util.*;
import java.util.Hashtable;

public class Q10_HashTable 
{
	public static void main(String[] args)
	{
		// Create an empty Hashtable
		Hashtable<String, Integer> has = new Hashtable<>();

		// Add elements to the hashtable
		has.put("Hello", 18);
		has.put("Hi", 55);
		has.put("Hey", 14);

		// Print size and content
		System.out.println("Size of map is: " + has.size());
		System.out.println(has);

		// Check if a key is present and if
		// present, print value
		if (has.containsKey("World")) 
		{
			Integer a = has.get("World");
			System.out.println("Value for key"+ " \"World\" : " + a);
      }
  }
}