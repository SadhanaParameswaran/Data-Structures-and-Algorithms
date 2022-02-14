package Stack;
import java.util.Scanner;
class Node6
{
	int element;
    Node6 next;
    Node6()
    { 
        element = 0;
        next = null;
    }
    Node6(int data)
    { 
        element = data;
        next = null;
    }
    Node6(int data, Node6 n)
    { 
        element = data;
        next = n;
    }
}
class StackCList
{
	Node6 Tail;
	StackCList()
    {
        Tail = null;
    }
    StackCList(int s)
    { 
        Tail = new Node6(s);    
        Tail.next = Tail;
    }
    boolean isEmpty() //to check if our stack is empty
	{
		if(Tail == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    void push(int a)
    {
    	Node6 temp = new Node6(a);  
        if(Tail == null) 
        {   
            Tail = temp;  
            Tail.next = Tail;  
        }  
        else 
        {   
            temp.next = Tail.next;    
            Tail.next = temp;
            Tail = temp; 
        } 
    }
    void pop()
    {
    	if(Tail == null)
    	{
    		System.out.println("The list is empty");
    	}
    	else
    	{
    		Node6 temp = Tail;
    		while(temp.next != Tail)
    		{
    			temp = temp.next;
    		}
    		temp.next = Tail.next;
    		Tail = temp;
    	}
    }
    void peek()
    {
    	if(Tail != null) 
		{
			System.out.println(Tail.element);
		}
		else
		{
			System.out.println("The stack is empty!");
		}
    }
    void display()
    {
    	Node6 temp = Tail.next;
    	do
    	{
    		System.out.println(temp.element);
    		temp = temp.next;
    	}
    	while(temp!=Tail.next);
    }
}
public class StackCLLMain 
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		StackCList c = new StackCList();
		int x;
		do
		{
			System.out.println("Enter your choice: ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            x = sc.nextInt();
            
            switch(x)
            {
                case 1: System.out.println("Enter the data to be pushed in the stack: ");
                        c.push(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: System.out.println("The last data is popped");
                        c.pop();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The last data is peeked");
                		c.peek();
                		System.out.println();
                        break;
                
                case 4: System.out.println("The elements in the stack are: ");
                		c.display();
                		System.out.println();
                		break;
                		
                default: System.out.println("Invalid input!");
            }
		}
		while(x!=10);
	}
}
