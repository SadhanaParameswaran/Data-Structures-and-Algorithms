package Programs;
import java.util.Scanner;
public class Q9_DelimiterChecking 
{
    public static void main(String args[])
    {
        String expression;
        Q9_DelimiterChecking x = new Q9_DelimiterChecking();
        Scanner sc=new Scanner(System.in);
        int choice;
        do
        {  
        	System.out.println("Enter your choice: ");
            System.out.println("1. Expression checking");
            System.out.println("2. Exit");
            choice=sc.nextInt();
            if (choice==1)
            {
                System.out.println("Enter your expression: ");    
                expression = sc.next();
                boolean result = x.isDelimiterMatching(expression);
                System.out.println(expression +" == "+result);
                System.out.println();
            }
        }
        while(choice!=2);
    }
    public  boolean isDelimiterMatching(String inputExpr) 
    {
        int stackSize = inputExpr.length();
        StackImpl theStack = new StackImpl(stackSize);
        for (int j = 0; j < inputExpr.length(); j++) 
        {
            char ch = inputExpr.charAt(j);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                      theStack.push(ch);
                      break;
            case '}':
            case ']':
            case ')':
                      if (!theStack.isStackEmpty()) 
                      {
                         char stackContent = theStack.pop();
                         if ((ch == '}' && stackContent != '{') || (ch == ']' && stackContent != '[') || (ch == ')' && stackContent != '('))
                         {
                             System.out.println("Mismatch found");
                             return false;
                         }
                      } 
                      else 
                      { 
                         System.out.println("Mismatch found ");
                         return false;
                      }
                      break;
            default:  break;
            }
        }
        if (!theStack.isStackEmpty())
        {
            System.out.println("Error: missing right delimiter");
            System.out.println();
            return false;
        }
        return true;
    }
}
class StackImpl 
{
    int stackSize;
    char[] stackArr;
    int top;
    public StackImpl(int size) 
    {
        stackSize = size;
        stackArr = new char[stackSize];
        top = -1;
    }
    public void push(char entry) 
    {
        stackArr[++top] = entry;
    }
    public char pop() 
    {
        char entry = stackArr[top--];
        return entry;
    }
    public char peek() 
    {
        return stackArr[top];
    }
    public boolean isStackEmpty() 
    {
        return (top == -1);
    }
    public boolean isStackFull() 
    {
        return (top == stackSize - 1);
    }
}