package Programs;
import java.util.Scanner;
public class Q4_NStacks
{
    // A Java class to represent k stacks in a single array of size n
    static class KStack 
    {
        int arr[];   // Array of size n to store actual content to be stored in stacks
        int top[];   // Array of size k to store indexes of top elements of stacks
                     // Array of size n to store next entry in all stacks
                     // and free list
        int n, k;
         // To store beginning index of free list  
        //constructor to create k stacks in an array of size n
        KStack(int k1, int n1) 
        {
            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;
            arr = new int[n];
            top = new int[k];
        
  
            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                top[i] = -1;
        }
        
        // To push an item in stack number 'sn' where sn is from 0 to k-1
        void push(int num,int sn)
        {
        	if(top[sn]==((n/k)*(sn+1))-1)
            {
        		System.out.println("Stack overflow");
            }
            else
            {
            	if(top[sn]==-1)
                { 
            		top[sn]=(n/k)*(sn);
                    arr[top[sn]]=num;
                }
                else
                {
                	top[sn]++;
                	arr[top[sn]]=num;
                }
             }   
        }
        int pop(int sn)
        {
            if(top[sn]==-1)
            {    System.out.println("Stack undeflow");
                return -1;
            }
            else 
            {
                --top[sn];
                return arr[top[sn]+1];
            }
        }
        // To check whether stack number 'sn' is empty or not
        void display(int sn)
        {
            if(top[sn]==-1)
            {
                System.out.println("No elements in the stack");
            }
            else
            {
                for(int i=top[sn];i>=(n/k)*sn;i--)
                System.out.println(arr[i]);
            }
        }

        int peek(int sn)
        {
            if(top[sn]==-1)
            {
                System.out.println("no elements to be peeked");
                return -1;
            }
            else
                return arr[top[sn]];
        }  
    }
  
    // Driver program
    public static void main(String[] args) 
    {
        // Let us create 3 stacks in an array of size 10
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        System.out.println("Enter number of stacks in the array");
        int k=sc.nextInt();
        int x;
        KStack ks = new KStack(k,n);
        do
        {
            System.out.println("Enter your choice: ");
            System.out.println("1. push");
            System.out.println("2. Display");
            System.out.println("3. pop");
            System.out.println("4. peek");
            x = sc.nextInt();
            System.out.println("Which stack do you want to do operations on");
            int s=sc.nextInt();            
            
            switch(x)
            {
                        case 1: System.out.println("Enter the data to be pushed to stack: ");
                                ks.push(sc.nextInt(),s);
                                break; 
                        case 2: System.out.println("The elements in Stack: ");
                                ks.display(s);
                                System.out.println();
                                break;
                        case 3: System.out.println();
                                System.out.println(ks.pop(s));
                                System.out.println();
                                break;
                        case 4: System.out.print("The last data is peeked: ");
                                System.out.println(ks.peek(s));
                                System.out.println();
                                break; 
            }
        }
        while(x!=10);
        sc.close();
    }
}