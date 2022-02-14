package Programs;
import java.util.Scanner;
class Stack1
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
	Stack1()
	{
		max = 56;
		s = new int[max];
		top = -1;
		size = 0;
	}
	Stack1(int MM)
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
}
public class Q9_InfixToPostfix 
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
        Stack1 stack = new Stack1();
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
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter an infix expression: ");
        String a1 = sc.next();
        System.out.println("The postfix expression is: ");
        String z1 = infixToPostFix(a1);
        System.out.println(z1);
        System.out.println();
        sc.close();
	}
}
