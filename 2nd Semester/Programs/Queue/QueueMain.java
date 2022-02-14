package Queue;
import java.util.*;
class queue
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
    queue()
    {
        s = new int[100];
        front=-1;
        rear=-1;
    }
    void enqueue(int a)
    {
            if(front==-1)
            {
                 rear++;
                 front=0;
                 s[rear]=a;
            }
            else
            {
                rear++;
                s[rear]=a;
            }
    }
    void dequeue()
    {
        if(front==-1)
        {
            System.out.println("no elements to dequeue!");
        }
        else
        {
            front++;
        }
    }
    void display()
    {
        if(front==-1)
        {
            System.out.println("queue is empty");
        }
        else
        {
            for(int i=front; i<=rear; i++)
            {
                System.out.println(s[i]);
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
class QueueMain
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
                        
                case 2: System.out.println("The last element is removed!");
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