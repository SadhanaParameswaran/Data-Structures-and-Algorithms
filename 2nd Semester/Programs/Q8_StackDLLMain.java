package Programs;
import java.util.Scanner;
class Node5
{
    int data;
    Node5 prev;
    Node5 next;
    Node5()
    { 
        data = 0;
        prev = null;
        next = null;
    }
    Node5(int x)
    { 
        data = x;
        prev = null;
        next = null;
    }
    Node5(Node5 n1, int x, Node5 n2)
    { 
        data = x;
        prev = n1;
        next = n2;
    }
}
class StackDList
{
	Node5 head;
	Node5 tail;
	StackDList()
    {
        head = null;
        tail = null;
    }
	StackDList(int x)
    { 
        head= new Node5(x);    
        tail = head;
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
	void push(int a) 
	{
		if(head == null)
    	{
    		head = new Node5(a);
    		tail = head;
    	}
    	else
    	{
    		Node5 t = new Node5(a);		
    		tail.next = t;
    		t.prev = tail;
    		tail = t;
    	}
	}
	void pop()
	{
		if(head == null) 
    	{  
            return;  
        }  
        else 
        {  
            if(head != tail) 
            {  
                tail = tail.prev;  
                tail.next = null;  
            }  
            else 
            {  
                head = tail = null;  
            }  
        } 
	}
	void peek()
	{
		if(head != null) 
		{
			System.out.println(head.data);
		}
		else
		{
			System.out.println("The stack is empty!");
		}
	}
	void display()
	{
		Node5 t = head;
    	while(t != null)
    	{
    		System.out.println(t.data);
    		t = t.next;
    	}
	}
}
public class Q8_StackDLLMain 
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		StackDList d = new StackDList();
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
                        d.push(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: System.out.println("The last data is popped");
                        d.pop();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The first data is peeked");
                		d.peek();
                		System.out.println();
                        break;
                
                case 4: System.out.println("The elements in the stack are: ");
                		d.display();
                		System.out.println();
                		break;
                		
                default: System.out.println("Invalid input!");
            }
		}
		while(x!=10);
	}
}
