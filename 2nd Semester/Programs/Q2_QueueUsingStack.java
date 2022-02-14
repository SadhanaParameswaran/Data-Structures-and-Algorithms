package Programs;
import java.util.Stack; 
import java.util.Scanner;
 
class Queue
{
	static class QueueUsingStack
	{
		static Stack<Integer> s1 = new Stack<Integer>();
		static Stack<Integer> s2 = new Stack<Integer>();
 
		public void enQueue(int x)
		{
			// Move all elements from s1 to s2
			while (!s1.isEmpty())
			{
				s2.push(s1.pop());
				//s1.pop();
			}
 
			// Push item into s1
			s1.push(x);
 
			// Push everything back to s1
			while (!s2.isEmpty())
			{
				s1.push(s2.pop());
				//s2.pop();
			}
		}	
 
		// Dequeue an item from the queue
		public int deQueue()
		{
			// if first stack is empty
			if (s1.isEmpty())
			{
				System.out.println("Q is Empty");
				System.exit(0);
			}
 
			// Return top of s1
			int x = s1.peek();
			s1.pop();
			return x;
		}

		void display() 
		{
			while(!s1.empty())
			{
				s2.push(s1.pop());
				//s1.pop();
			}
			System.out.println(s2);
			while(!s2.empty())
			{
				s1.push(s2.pop());
				//s1.pop();
			}
		}

		int peek()
		{
			int x=s1.pop();
			s1.push(x);
        
			return x;
		}
	}
 
	// Driver code
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		QueueUsingStack q=new QueueUsingStack();
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
            case 1: System.out.println("Enter the data to be enqueued: ");
                    q.enQueue(sc.nextInt());
                    break; 
            case 2: System.out.print("Element dequeued is: ");
                    System.out.println(q.deQueue());
                    System.out.println();
                    break;
            case 3: System.out.println("The elements of the queue are:");
                    q.display();
                    System.out.println();
                    break;
            case 4: System.out.print("The front data is peeked: ");
    				System.out.println(q.peek());
    				System.out.println();
    				break; 
            default: System.out.println("Invalid input!");
            }
        }
        while(x!=10);
        sc.close();
 	}
}


