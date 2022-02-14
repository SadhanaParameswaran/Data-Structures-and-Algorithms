package Programs;
import java.util.Scanner;
class nodde 
{
    int key;
    nodde next;
    nodde prev;
    nodde() 
    {
        next = null;
        prev = null;
    }
    nodde(int k) 
    {
        key = k;
        next = null;
        prev = null;
    }
}

public class Q9_a_ChainingMethod
{
    //this is chaining, many nodes in one index
    public static void main(String[] args) 
    {
        nodde a[]=new nodde[10];
        int[] count=new int[10];
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the key");
        int index, key=s.nextInt();
        while(key!=0)
        {   
            index=key % 10;
            if (a[index]==null)
                {
                    a[index]=new nodde(key);
                    count[index]=1;
                }
            else
            {
                nodde t=a[index];
                a[index]=new nodde(key);
                a[index].next=t;
                t.prev=a[index];
                count[index]++;
            }
            System.out.println("Enter the key (0 to terminate)");
            key=s.nextInt();
        }
        int i=0;
        while(i!=10)
        { 
            if (a[i]!=null)
                if (a[i].next==null)
                    System.out.println("location/ bucket "+i+"----->"+a[i].key);
                else
                {
                    System.out.print("location/ bucket "+i+"----->");
                    nodde temp=a[i];
                    while(temp.next!=null)
                         temp=temp.next;
                    while(temp.prev!=null)
                    {
                        System.out.print(temp.key+"|");
                        temp=temp.prev;
                    }
                    System.out.println();
                }
            else
                System.out.println("location/ bucket "+i+"----->null");
        i++;
        s.close();
    }
//  44 | 64 |
    }
    
}