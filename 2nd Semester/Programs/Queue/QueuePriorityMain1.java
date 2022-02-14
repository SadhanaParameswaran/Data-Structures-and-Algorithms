//Enqueue COSTLIER, Dequeue EASIER
package Queue;
import java.util.*;
class pQueue1
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
    pQueue1()
    {
        PQ = new int[100];
        front = 0;
        rear = -1;
    }
    //costlier enqueue
	void enqueueC(int x)
	{
		if(rear == -1)
		{
			rear++;
			PQ[rear] = x;
		}
		else
		{
			int i = rear;
			while(i>0 && x<PQ[i])
			{
				PQ[i+1] = PQ[i];
				i--;
			}
			PQ[i+1] = x;
			rear++;
		}
	}
	//easier dequeue
	int dequeueE() 
	{
		int temp;
		if(rear != -1)
		{
			temp = PQ[front];
			front++;
			return temp;
		}
		else
		{
			if(rear == front)
			{
				temp = PQ[front];
				front = 0;
				rear = -1;
				return temp;
			}
			else
			{
				return -1;
			}
		}
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
public class QueuePriorityMain1 
{
	public static void main(String []args)
    {    
        Scanner sc = new Scanner(System.in);
        pQueue1 s1 = new pQueue1();
        int x;
        do 
        {    
            System.out.println("Enter your choice: ");
            System.out.println("1. enqueueCostlier");
            System.out.println("2. dequeueEasier");
            System.out.println("3. display");
            x = sc.nextInt();
            switch(x)
            {        
                case 1: System.out.println("Enter the data to be pushed: ");
                		s1.enqueueC(sc.nextInt());
                		System.out.println();
                		break;
                        
                case 2: int z = s1.dequeueE();
                        System.out.println("The element "+z+" is removed!");
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

