package Programs;
import java.util.Scanner;
class nodequeue1
{
    int element;
    nodequeue1 next;
    nodequeue1()
    {
        element = 0;
        next = null;
    }
    nodequeue1(int x)
    {
        element = x;
        next = null;
    }
    nodequeue1(int x, nodequeue1 n1)
    {
        element = x;
        next = n1;
    }
}
class queueSLL
{
        nodequeue1 front;
        nodequeue1 rear;
        queueSLL()
        {
                front = null;
                rear = null;
        }
        queueSLL(int x)
        { 
                rear = new nodequeue1(x);
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
        if(rear == null)
        {
            rear = new nodequeue1(x);
            front = rear;
        }
        else
        {
            nodequeue1 temp = new nodequeue1(x);
            rear.next = temp;
            rear = temp;
        }
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
            nodequeue1 temp = front;
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
            nodequeue1 temp=front;
            int siz=1;
            if(temp==null)
            {
                return 0;
            }
            else
            {
                while(temp.next!=null)
                {
                       siz++;
                       temp=temp.next;
                }
                return siz;
            }
        }
}
public class Q10_QueueSLLMain 
{
        public static void main(String []args)
    {
            Scanner sc = new Scanner(System.in);
            queueSLL s = new queueSLL();
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
                                        break;
                                default: System.out.println("Invalid input!");
                        }
        }
        while(x!=10);
        }
}