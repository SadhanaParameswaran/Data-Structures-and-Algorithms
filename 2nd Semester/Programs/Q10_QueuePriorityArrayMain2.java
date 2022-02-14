//Enqueue EASIER, Dequeue COSTLIER
package Programs;
import java.util.*;
class pQueue2
{
	int PQ[];
    int front;
    int rear;
    int size;
    boolean isEmpty() //to check if our stack is empty
    {
        if(front == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    pQueue2()
    {
        PQ = new int[100];
        front = 0;
        rear = -1;
    }
    //easier Enqueue
  	void enqueueE(int x)
  	{
  		if(rear != 9)
  		{
  			PQ[++rear] = x;
  		}
  		else
  		{
  			System.out.println("PQ is full, Overflow");
  		}
  	}
	//costlier Dequeue
	int dequeueC()
	{
		if (rear!=-1)
	    {
	        int min=999;
	        int pos=-1;
	        for(int i=front;i<=rear;i++) //O(n)
	        {
	            if (PQ[i]<min)
	            {
	                min=PQ[i];
	                pos=i;
	            }
	        }
	        System.out.println("Element at Position "+pos+" is deleted");
	        int i=pos;
	        while( i<=rear)//O(n)
	        {
	            PQ[i]=PQ[i+1];
	            i++;
	        }
	        rear--;
	        return min;
	    }
	    return -1;
	}
	void display()
	{
		if(front==-1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            for(int i=front; i<=rear; i++)
            {
                System.out.println(PQ[i]);
            }
        }
	}
}
public class Q10_QueuePriorityArrayMain2 
{
	public static void main(String []args)
    {    
        Scanner sc = new Scanner(System.in);
        pQueue2 s1 = new pQueue2();
        int x;
        do 
        {    
            System.out.println("Enter your choice: ");
            System.out.println("1. enqueueEasier");
            System.out.println("2. dequeueCostlier");
            System.out.println("3. display");
            x = sc.nextInt();
            switch(x)
            {
                case 1: System.out.println("Enter the data to be pushed: ");
                        s1.enqueueE(sc.nextInt());
                        System.out.println();
                        break;

                case 2: int u = s1.dequeueC();
                        System.out.println("The element "+u+" is removed!");
                        System.out.println();
                        break;
                
                case 3: System.out.println("The elements are: ");
                        s1.display();
                         System.out.println();
                        break;

                default: System.out.println("Invalid input");
            }
        }
        while (x!=10);
    }
}