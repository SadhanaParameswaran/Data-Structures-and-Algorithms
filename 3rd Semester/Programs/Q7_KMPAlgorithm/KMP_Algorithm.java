// Modify the KMP Program to find the position of the pattern that is 
// found in every kth character of the text
package LabAssessment;
import java.util.Scanner;
public class KMP_Algorithm
{
    public static void KMP(String str1, String str2)
    {
    	// if pattern entered is missing
        if (str2 == null || str2.length() == 0)
        {
            System.out.println("No pattern entered");
            return;
        }
        // if no text is entered or pattern entered is longer that the text
        if (str1 == null || str2.length() > str1.length())
        {
            System.out.println("Pattern not found");
            return;
        }
        // converting the pattern to separate characters
        char[] c = str2.toCharArray();
        // converting the text to separate characters
        char[] a = str1.toCharArray();
        
        // code for lps array (finding prefix, postfix)
        int[] temp = new int[str2.length() + 1];
        for (int i = 1; i < str2.length(); i++)
        {
            int j = temp[i + 1];
 
            while (j > 0 && c[j] != c[i]) 
            {
                j = temp[j];
            }
 
            if (j > 0 || c[j] == c[i]) 
            {
                temp[i + 1] = j + 1;
            }
        }
 
        int flag = 0;
        int m, n;
        int k = 3;
        
        // check if the pattern is present in the test
        for (int i = 0, j = 0; i < str1.length(); i++)
        {
            if (j < str2.length() && str1.charAt(i) == str2.charAt(j))
            {
                if (++j + k == str2.length())
                {
                	flag = 0;
                    for(m = i, n = 0; m < str1.length()-k*4+1 && n<str2.length(); m += k, n++)
                    {
                        if(a[m] == c[n])
                        {
                           flag = 1;
                        }
                        else
                        {
                            flag = 0;
                        }
                    }
                    if(flag == 1)
                    {
                    	System.out.println("The pattern is found at index " + (i - j + 1));
                    }
                }
            }
            else if (j > 0)
            {
                j = temp[j];
                i--; 
            }
        }
    }
 
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	
        //String text = "ohTdTjfEooSytThfbhsj";
        //String pattern = "TEST";
    	
    	//String text = "0T00E00S00TBB";
    	//String pattern = "TEST";	
    	
    	// Asking user to enter a text
    	System.out.println("Enter a text: ");
    	String text = sc.nextLine();
    	// Asking user to enter a pattern
    	System.out.println("Enter the pattern for searching in the text: ");
    	String pattern = sc.nextLine();
    	//Using the KMP Algorithm to check if the pattern occurs in the text
        KMP(text, pattern);
        sc.close();
    }
}
