package Programs; 
import java.util.LinkedHashMap; 
import java.util.Map;
import java.util.Scanner;
public class Q11_HashMap_HashRoman 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to get the roman of: ");
		System.out.println(getRomanEquivalentOfInteger(sc.nextInt()));
	}
  
	private static String getRomanEquivalentOfInteger(int number)
	{
		if(number<=0)
		{
			return "not defined";
		}
 
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
  
		String romanEqui="";
   
		for (Map.Entry<Integer, String> entry : map.entrySet()) 
		{
			int key = entry.getKey();
			if(number/key!=0)
			{
				for (int i = 0; i < (number/key); i++) 
				{
					romanEqui = romanEqui + map.get(key);
				}
				number = number % key;
			}   
		} 
		return romanEqui;
	}
}