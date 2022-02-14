package Programs;
public class Q8_RK_Algorithm 
{
    static int letters[]=new int[26];
    static int corrval[]=new int[26];
    public static void main(String args[])
    {
        int i,j,index;
        for(index=0,i=97,j=1;i<=122;i++,j++,index++)
        {
            letters[index]=i;
            corrval[index]=j;
        }
        String text="ccaccaaedba";
        String pat="dba";
        String comp="";
        int patternhash=hash(pat);
        for(i=0;i<text.length()-2;i++)
        {
            comp="";
            for(j=i;j<=i+2;j++)
            {
                comp+=text.charAt(j);
            }
            if(hash(comp)==patternhash)
            {
                if(comp.compareTo(pat)==0)
                {
                    System.out.println("Pattern present at position:\t"+(i+1));
                }
            }
        }
    }
    public static int hash(String s)
    {
        int i,sum=0;
        int power=2;
        char c[]=new char[3];
        for(i=0;i<3;i++)
            c[i]=s.charAt(i);
        for(int times=0;times<3;times++)
        {
            for(i=0;i<26;i++)
            {
                if(letters[i]==((int)c[times]))
                {
                    sum+=corrval[i]*Math.pow(10,power--);
                    break;
                }
            }
        }
        return sum;
    }
}