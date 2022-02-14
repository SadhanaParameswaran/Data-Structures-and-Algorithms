package Stack;
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
		Stack S1 = new Stack();
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
		Stack S1 = new Stack();
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
public class StackMain 
{
	static int Precedence(int i)
	{
        switch (i)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression)
    {
        String result = "";
        Stack stack = new Stack();
        for (int i = 0; i <expression.length() ; i++) 
        {
            char c = expression.charAt(i);
            if(Precedence(c)>0)
            {
                while(stack.isEmpty()==false && Precedence(stack.peek())>=Precedence(c))
                {
                    result += (char) stack.pop();
                }
                stack.push(c);
            }
            else if(c==')')
            {
                char x = (char) stack.pop();
                while(x!='(')
                {
                    result += x;
                    x = (char) stack.pop();
                }
            }
            else if(c=='(')
            {
                stack.push(c);
            }
            else
            {
                result += (char) c;
            }
        }
        for (int i = 0; i <=stack.size ; i++) 
        {
            result += (char) stack.pop();
        }
        return result;
    }
    
    static StringBuilder infixToPreFix(String expression)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack stack = new Stack();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) 
        {

            if (charsExp[i] == '(') 
            {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') 
            {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) 
        {
            char c = charsExp[i];
            if(Precedence(c)>0)
            {
                while(stack.isEmpty()==false && Precedence(stack.peek())>=Precedence(c))
                {
                    result.append((char) stack.pop());
                }
                stack.push(c);
            }
            else if(c==')')
            {
                char x = (char) stack.pop();
                while(x!='(')
                {
                    result.append((char) x);
                    x = (char) stack.pop();
                }
            }
            else if(c=='(')
            {
                stack.push((char) c);
            }
            else
            {
                result.append((char) c);
            }
        }

        for (int i = 0; i <=stack.size ; i++) 
        {
        	result.append((char) stack.pop());
        }
        return result.reverse();
    }
    
	static int max(Stack s) 
	{
		Stack backup = new Stack(); 
		int maxValue = s.pop() ;
		backup.push(maxValue);
		while (!s.isEmpty()) 
		{
			int next = s.pop();
			backup.push(next); 
			maxValue = maxValue>next? maxValue:next; 
		}
		while (!backup.isEmpty()) 
		{
			s.push(backup.pop()); 
		}
		return maxValue;
	}
	
	public static void main(String []args)
	{	
		Scanner sc = new Scanner(System.in);
		Stack s1 = new Stack();
		Stack s2 = new Stack(10);
		int c;
		int x;
        do 
        {    
        	System.out.println("Enter your choice: ");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. display");
            System.out.println("4. peek");
            System.out.println("5. postFixChar");
            System.out.println("6. postFixNum");
            System.out.println("7. inFixToPostfix");
            System.out.println("8. infixToPreFix");
            System.out.println("9. max");
            
            x = sc.nextInt();
            
            switch(x)
            {
                case 1: System.out.println("Enter the data to be pushed: ");
                        s1.push(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: //System.out.println("The last element is popped!");
                        s1.pop();
                        System.out.println();
                        break;
                
                case 3: System.out.println("The elements are: ");
                		s1.display();
                 		//System.out.print((s1.push(s1.pop()+s1.pop())));
                        break;
                        
                case 4: System.out.println("The element is peeked!");
            		    s1.peek();
             		    System.out.println();
                        break;
                        
                case 5: System.out.println("Enter the equation: ");
    		    		s1.postFixChar(sc.next());
    		    		System.out.println();
    		    		break;
    		    		
                case 6: System.out.println("Enter the equation: ");
	    				s1.postFixNum(sc.next());
	    				System.out.println();
	    				break;
	    				
                case 7: System.out.println("Enter an infix expression: ");
                		String a1 = sc.next();
                		System.out.println("The postfix expression is: ");
                		String z1 = infixToPostFix(a1);
                		System.out.println(z1);
                		System.out.println();
                		break;
                		
                case 8: System.out.println("Enter an infix expression: ");
        				String a2 = sc.next();
        				System.out.println("The prefix expression is: ");
        				StringBuilder z2 = infixToPreFix(a2);
        				System.out.println(z2);
        				System.out.println();
        				break;
	    				
                case 9: System.out.println("The max element is: ");
						int z = max(s1);
						System.out.println(z);
						System.out.println();
						break;
						
                //case 10: System.out.println(s1.peek(s1.push(s1.pop()+s1.pop())));
                        
                default: System.out.println("Invalid input");
            }
        }
        while (x!=10);
	}
}
