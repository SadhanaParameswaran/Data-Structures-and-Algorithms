package Programs;
import java.util.*;
public class Q5_KMP_Algorithm
{
    public static void KMP(String s1, String s2)
    {
        if (s2 == null || s2.length() == 0)
        {
            System.out.println("The pattern occurs with shift 0");
            return;
        }

        if (s1 == null || s2.length() > s1.length())
        {
            System.out.println("Pattern not found");
            return;
        }
 
        char[] chars = s2.toCharArray();
        
        int[] next = new int[s2.length() + 1];
        for (int i = 1; i < s2.length(); i++)
        {
            int j = next[i + 1];
 
            while (j > 0 && chars[j] != chars[i]) {
                j = next[j];
            }
 
            if (j > 0 || chars[j] == chars[i]) {
                next[i + 1] = j + 1;
            }
        }
 
        for (int i = 0, j = 0; i < s1.length(); i++)
        {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j))
            {
                if (++j == s2.length())
                {
                    System.out.println("The pattern occurs at index " + (i - j + 1));
                }
            }
            else if (j > 0)
            {
                j = next[j];
                i--; 
            }
        }
    }
 
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
        //String text = "ABCABAABCABAC";
        //String pattern = "CAB";
    	System.out.println("Enter a text to implement the algo: ");
    	String text=sc.nextLine();
    	System.out.println("Enter the pattern: ");
    	String pattern=sc.nextLine();
    	
        KMP(text, pattern);
        sc.close();
    }
}
