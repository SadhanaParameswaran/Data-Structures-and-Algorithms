package Programs;
import java.util.*;   
import java.io.*; 
class Q2_SortAndStore10Numbers 
{
    public static void main(String args[])
    {
        try 
        {
            File Obj1 = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q2_Input.txt");
            File Obj2 = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q2_Output.txt");
            Scanner sc=new Scanner(Obj1);
             Scanner sc1=new Scanner(System.in);
            System.out.println("Enter number of integers: ");
            int size=sc1.nextInt();
            int a[]=new int[size];
            int i=0,j=0,temp;
            System.out.println("The Unsorted array is:");
            while(sc.hasNextInt())
            {
                a[i]=sc.nextInt();
                System.out.print(a[i]+" ");
                i++;
            }
            for (i = 0; i < size; i++) 
            {
                for (j = i + 1; j < size; j++) 
                {
                    if (a[i] > a[j]) 
                    {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            FileWriter f1=new FileWriter(Obj2);
            System.out.println();
            System.out.println("The Sorted array is:");
            String x="";
            for (i = 0; i < size; i++) 
            {
                x=x+a[i]+" ";
                System.out.print(a[i]+" ");
            }
            System.out.print("\n");
            f1.write(x);
            f1.close();
            sc.close();
            sc1.close();
        }
         catch (Exception e) 
        {
          System.out.println(e);
        }
    }
}