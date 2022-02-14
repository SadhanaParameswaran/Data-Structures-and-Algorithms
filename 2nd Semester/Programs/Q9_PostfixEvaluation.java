package Programs;
import java.util.Scanner;
class StackP
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
	StackP()
	{
		max = 56;
		s = new int[max];
		top = -1;
		size = 0;
	}
	StackP(int MM)
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
			return s[top];
		}
	}
	void postFixChar(String a)
	{
		Scanner sc = new Scanner(System.in);
		StackP S1 = new StackP();
		String PostFix = a;
		int i = 0;
		char x;
		while((x = PostFix.charAt(i)) != '#')
		{
			if ((x>='A' && x<='Z') || (x>='a' && x<='z'))
			{
				System.out.println("Enter the value of the operand: "+x);
				S1.push(sc.next().charAt(0));
			}
			else
			{
				int op2 = S1.pop();
				int op1 = S1.pop();
				switch(x)
				{
					case '+': S1.push((char) (op1+op2));
							  break;
							 
					case '-': S1.push((char) (op1-op2));
					          break;
					          
					case '*': S1.push((char) (op1*op2));
							  break;
							  
					case '/': S1.push((char) (op1/op2));
					  		  break;
					  		  
					case '^': S1.push((char) (op1^op2));
			  		          break;
			  		          
					case '&': S1.push((char) (op1&op2));
			  		           break;
			  		           
					case '|': S1.push((char) (op1|op2));
			  		          break;
			  		          
					case '%': S1.push((char) (op1%op2));
			  		          break;
				}
			}
			i++;
		}
		System.out.println(S1.peek());
	}
	void postFixNum(String a)
	{
		Scanner sc = new Scanner(System.in);
		StackP S1 = new StackP();
		String PostFix = a;
		int i=0;
	    char X;
		while((X = PostFix.charAt(i))!='#')
	    {
	    	if(X>='0' && X<='9')
	    	{
	    		  S1.push(Integer.parseInt(Character.toString(X)));
	    	}
	    	else if ((X>'A' && X<='Z') || (X>='a' && X<='z'))
	      	{
	      		S1.push(sc.nextInt());
	      	}
	      	else
	      	{
	      		int op2 = S1.pop();
	      		int op1 = S1.pop();
	      		switch(X)
	      		{
	      		case '+': S1.push(op1+op2);
						  break;
	      		case '-': S1.push(op1-op2);
						  break;
	      		case '*': S1.push(op1*op2);
						  break;
	      		case '/': S1.push(op1/op2);
					      break;
	      		case '^': S1.push(op1^op2);
	      				  break;
	      		}
	      	}
	      	i++;
	      }
	      System.out.println(S1.peek());
	}
}
public class Q9_PostfixEvaluation 
{
	public static void main(String []args)
	{	
		Scanner sc = new Scanner(System.in);
		StackP s1 = new StackP();
		int x;
        do 
        {    
        	System.out.println("Enter your choice: ");
            System.out.println("1. postFixChar");
            System.out.println("2. postFixNum");
            
            x = sc.nextInt();
            
            switch(x)
            {           
                case 1: System.out.println("Enter the equation with characters: ");
    		    		s1.postFixChar(sc.next());
    		    		System.out.println();
    		    		break;
    		    		
                case 2: System.out.println("Enter the equation with numbers: ");
	    				s1.postFixNum(sc.next());
	    				System.out.println();
	    				break;
                        
                default: System.out.println("Invalid input");
            }
        }
        while (x!=10);
	}
}
