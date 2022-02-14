//Enqueue COSTLIER, Dequeue EASIER
package Queue;
import java.util.*;
class Pnode1
{
    int Data;
    int Priority;
    Pnode1 Next;
    Pnode1()
    {
    
    }
    Pnode1(int x,int p)
    {
        Data=x;
        Priority=p;
        Next=null;
    }
}
class PQueuelist1
{
    Pnode1 front=null, rear=null;
    void enqueueC(int x, int p)//costlier
    { 
        Pnode1 temp = new Pnode1(x,p);
        if (front == null)
        {
            front = temp;
            rear = front; 
            return;
        }
        else
        {
            Pnode1 t = front;
            if(temp.Priority < t.Priority)
            {
                temp.Next = front;
                front = temp; 
                return;
            }
            else
            {
                Pnode1 pr = t;
                while(t!=null && temp.Priority>t.Priority)
                { 
                    pr = t;
                    t = t.Next;
                }
                if (t == null)//insertlast
                {
                    rear.Next = temp;
                    rear = temp;
                }
                else
                {
                    if(temp.Priority<t.Priority)
                    { 
                        pr.Next= temp;
                        temp.Next=t;
                    }
                }
            }
        }
    }
    int dequeueE()
    {
        int temp=-1;
        if (front==null)
        {
            System.out.println("PQ is empty");
        }
        else
        {
            temp= front.Data;
            front=front.Next;
        }
        return temp;
    }
    void display()
    {
        Pnode1 temp=front;
        System.out.println("Display");
        if (front!=null)
        {
            while(temp!=null)
            {
                System.out.println("("+temp.Data+ " "+ temp.Priority+")");
                temp=temp.Next;
            }
        }
    }
}
public class QueuePrioritySLLMain1
{
    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	PQueuelist1 s1 = new PQueuelist1();
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
                case 1: System.out.println("Enter two elements to be pushed: ");
                		s1.enqueueC(sc.nextInt(), sc.nextInt());
                		System.out.println();
                		break;
                        
                case 2: int z = s1.dequeueE();
                        System.out.println("The first set is removed!");
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