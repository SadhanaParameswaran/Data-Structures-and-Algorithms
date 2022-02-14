package Programs;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Q7_Website_KMPAlgorithm 
{
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
  
        // create lps[] that will hold the longest
        // prefix which has the same suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]
  
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);
  
        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                                   + "at index " + (i - j));
                j = lps[j - 1];
            }
  
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
  
    void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the longest proper prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
  
                    // Also, note that we do not increment
                    // i here
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
  
    // Driver program to test above function
    public static void main(String args[]) throws IOException
    {
    	URL url = new URL("https://www.amrita.edu");
        
        String pattern = "best";
        Scanner sc = new Scanner(url.openStream()); 
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
           sb.append(sc.next());
        }
        String content = sb.toString();
        //Removing the HTML tags
        
        content = content.replaceAll("<[^>]*>", "");
        System.out.println("Contents of the web page: "+content);
        
    	
//        String txt = "ABABDABACDABABCABAB";
//        String pat = "ABABCABAB";
        new Q7_Website_KMPAlgorithm().KMPSearch(pattern, content);
    }
}