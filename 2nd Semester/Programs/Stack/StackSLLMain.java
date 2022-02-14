package Stack;
import java.util.*;
class Node4
{
	char element;
	Node4 next;
	Node4()
	{
		element = 0;
		next = null;
	}
	Node4(char data)
	{
		element = data;
		next = null;
	}
	Node4(char data, Node4 n)
	{
		element = data;
		next = n;
	}
}
class stackSLL
{
    Node4 head;
    stackSLL()
    {
        head = null;
    }
    stackSLL(char s)
    { 
        head = new Node4(s);    
    }
    boolean isEmpty() //to check if our stack is empty
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void push(char s)
	{
		Node4 temp = new Node4(s);
		temp.next = head;
		head = temp;
	}
	void pop()
	{
		if(head != null)
		{
			head = head.next;
		}
		else
		{
			System.out.println("The stack is empty!");
		}
	}
	void peek()
	{
		if(head != null) 
		{
			System.out.println(head.element);
		}
		else
		{
			System.out.println("The stack is empty!");
		}
	}
	void display()
	{
		Node4 temp = head;
        if(temp == null)
        {
        }
        else
        {
        	while(temp!=null)
        	{
        		System.out.println(temp.element);
        		temp=temp.next;
        	}
        }
	}
}
public class StackSLLMain
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		stackSLL s = new stackSLL();
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
                        s.push(sc.next().charAt(0));
                        System.out.println();
                        break;
                        
                case 2: System.out.println("The first data is popped");
                        s.pop();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The first data is peeked");
                		s.peek();
                		System.out.println();
                        break;
                
                case 4: System.out.println("The elements in the stack are: ");
                		s.display();
                		System.out.println();
                		break;
                		
                default: System.out.println("Invalid input!");
            }
		}
		while(x!=10);
	}
}