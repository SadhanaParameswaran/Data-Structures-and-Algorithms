package Queue;
import java.util.*;
class queue2
{
    int s[];
    int front;
    int rear;
    int size;
    boolean isEmpty() //to check if our queue is empty
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
    queue2()
    {
        s = new int[100];
        front=-1;
        rear=-1;
    }
    void enqueue(int a)
    {
        if(rear != -1)
        {
        	if(rear+1 % size == front)
        	{
        		System.out.println("Queue is full!");
        		return;
        	}
        	rear = rear + 1 % size;
        	s[rear] = a;
        }
    }
    int dequeue()
    {
        if(rear == -1)
        {
        	return -1;
        }
        else if(rear == front)
        {
        	int temp = s[front];
        	rear = -1;
        	front = 0;
        	return temp;
        }
        else
        {
        	int temp = s[front];
        	front = front + 1 % size;
        	return temp;
        }
    }
    void display()
    {
        if(rear==-1)
        {
            System.out.println("queue is empty");
            return;
        }
        if(front <= rear)
        {
        	for(int i=front; i<=size; i++)
        	{
        		System.out.println(s[i]);
        	}
        }
        else
        {
        	for(int i=front; i<=size; i++)
        	{
        		System.out.println(s[i]);
        		for(int j=0; j<=size; j++)
            	{
            		System.out.println(s[j]);
            	}
        	}
        }
    }
    void peek()
    {
        if(front == -1)
        {
             System.out.println("queue is empty");
        }
        else
        {
            System.out.println(s[front]);
        }
    }
}
public class QueueCircularMain 
{
	public static void main(String []args)
    {    
        Scanner sc = new Scanner(System.in);
        queue s1 = new queue();
        int x;
        do 
        {    
            System.out.println("Enter your choice: ");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. display");
            System.out.println("4. peek");
            x = sc.nextInt();
            switch(x)
            {
                case 1: System.out.println("Enter the data to be pushed: ");
                        s1.enqueue(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: System.out.println("The first element is removed!");
                        s1.dequeue();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The elements are: ");
                        s1.display();
                         System.out.println();
                        break;
                        
                case 4: System.out.println("The element is peeked!");
                        s1.peek();
                         System.out.println();
                        break;
                default: System.out.println("Invalid input");
            }
        }
        while (x!=10);
    }
}
