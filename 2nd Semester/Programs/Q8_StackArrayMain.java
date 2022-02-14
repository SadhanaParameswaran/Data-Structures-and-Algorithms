package Programs;
import java.util.*;
class Stack
{
	int max;
	int s[];
	int top;
	int size; //number of elements currently in the stack
	boolean isEmpty() //to check if our stack is empty
	{
		if(size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	Stack()
	{
		max = 56;
		s = new int[max];
		top = -1;
		size = 0;
	}
	Stack(int MM)
	{
		max = MM;
		s = new int[max];
		top = -1;
		size = 0;
	}
	void push(int a)
	{
		if(top >= max-1)
		{
			System.out.println("Stack overflow!");
		}
		else
		{
			top++;
			s[top] = a;
			size++;
		}
	}
	int pop()
	{
		int temp = '\0';
		if(top == -1)
		{
			System.out.println("Stack underflow!");
		}
		else
		{
			temp = s[top];
			top--;
			size--;
		}
		System.out.println("The last element "+temp+" is popped!");
		return temp;
	}
	void display()
	{
		for(int i=0; i<=top; i++)
		{
			System.out.println(s[i]);
		}
	}
	int peek()
	{
		if(top == -1)
		{
			return -1;
		}
		else
		{
			System.out.println("The element "+s[top]+" is peeked");
			return s[top];
		}
	}
}
public class Q8_StackArrayMain
{
	public static void main(String []args)
	{	
		Scanner sc = new Scanner(System.in);
		Stack s1 = new Stack();
		int x;
        do 
        {    
        	System.out.println("Enter your choice: ");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. display");
            System.out.println("4. peek");
            
            x = sc.nextInt();
            
            switch(x)
            {
                case 1: System.out.println("Enter the data to be pushed: ");
                        s1.push(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: s1.pop();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The elements are: ");
                		s1.display();
                		System.out.println();
                        break;
                        
                case 4: s1.peek();
             		    System.out.println();
                        break;
                        
                default: System.out.println("Invalid input");
            }
        }
        while (x!=10);
	}
}
