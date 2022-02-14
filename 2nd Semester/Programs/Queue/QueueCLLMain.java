package Queue;
import java.util.*;
class nodequeue2
{
	int element;
	nodequeue2 next;
	nodequeue2 prev;
	nodequeue2()
	{
		element = 0;
		next = null;
		prev = null;
	}
	nodequeue2(int x)
	{
		element = x;
		next = null;
		prev = null;
	}
	nodequeue2(nodequeue2 n1,int x, nodequeue2 n2)
	{
		element = x;
		next = n2;
		prev = n1;
	}
}
class queueCLL
{
	nodequeue2 front;
    nodequeue2 rear;
    queueCLL()
    {
    	front = null;
        rear = null;
    }
    queueCLL(int x)
    { 
    	rear = new nodequeue2(x);
        front = rear;
    }
    boolean isEmpty() //to check if our stack is empty
	{
       if(front == null)
       {
        	return true;
       }
       else
       {
            return false;
       }
	}
	void enqueue(int x)
	{
//		if(rear != -1)
//		{
//			
//		}
	}
    void dequeue()
	{
		if(front != null)
		{
			front = front.next;
		}
		else
		{
			System.out.println("The stack is empty!");
		}
	}
	void peek()
	{
		if(front != null) 
		{
			System.out.println(front.element);
		}
		else
		{
			System.out.println("The stack is empty!");
		}
	}
	void display()
	{
        nodequeue2 temp = front;
        if(temp == null)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            while(temp!=null)
            {
            	System.out.print(temp.element+"\t");
                temp=temp.next;
            }
        }
	}
    int size()
    {
    	nodequeue2 temp = front;
        int size=1;
        if(temp==null)
        {
            return size;
        }
        else
        {
            while(temp.next!=null)
            {
            	size++;
                temp=temp.next;
            }
            return size;
        }
    }
}
public class QueueCLLMain 
{
	public static void main(String []args)
	{
        Scanner sc = new Scanner(System.in);
        queueCLL s = new queueCLL();
		int x;
		do
		{
        		System.out.println("\n\nEnter your choice: ");
                System.out.println("1. enqueue");
                System.out.println("2. dequeue");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("5. size of queue");
                System.out.println("6. is queue empty?");
                System.out.println("10. exit");
                x = sc.nextInt();            
                switch(x)
                {
                                case 1: System.out.println("Enter the data to be enqueued is: ");
                                        s.enqueue(sc.nextInt());
                                        System.out.println();
                                        break;
                                        
                                case 2: System.out.println("The first data dequeued is");
                                        s.dequeue();
                                        System.out.println();
                                        break;
                                
                                case 3: System.out.println("The first data is peeked");
                                		s.peek();
                                		System.out.println();
                                        break;
                                
                                case 4: System.out.println("The elements in the queue are: ");
                                		s.display();
                                		System.out.println();
                                		break;
                                case 5:System.out.print("The size of the queue is: ");
                                        System.out.println(s.size());
                                	break;
                                case 6:System.out.print("is queue empty?\t");
                                        System.out.println(s.isEmpty());
                                default: System.out.println("Invalid input!");
                 }
		}
		while(x!=10);
    }
}
