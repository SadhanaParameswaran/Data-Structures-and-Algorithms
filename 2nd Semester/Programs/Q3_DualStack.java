package Programs;
import java.util.Scanner;
class Q3_DualStack
{
  int[] arr;
  int[] temp;
  int size;
  int top1, top2;
 
  // Constructor
  Q3_DualStack(int n)
  {
    size = n;
    arr = new int[n];
    temp = new int[n];
    top1 = n / 2 + 1;
    top2 = n / 2;
  }
 
  // Method to push an element x to stack1
  void push1(int x)
  {
 
    // There is at least one empty
    // space for new element
    if (top1 > 0)
    {
      top1--;
      arr[top1] = x;
    }
    else
    {
      System.out.print("Stack1 Overflow");
      return;
    }
  }
 
  // Method to push an element
  // x to stack2
  void push2(int x)
  {
 
    // There is at least one empty
    // space for new element
    if (top2 < size - 1)
    {
      top2++;
      arr[top2] = x;
    }
    else
    {
      System.out.print("Stack2 Overflow");
      return;
    }
  }
 
  // Method to pop an element from first stack
  int pop1()
  {
    if (top1 <= size / 2)
    {
      int x = arr[top1];
      top1++;
      return x;
    }
    else
    {
      System.out.print("Stack UnderFlow");
      System.exit(1);
    }
    return 0;
  }
 
  // Method to pop an element
  // from second stack
  int pop2()
  {
    if (top2 >= size / 2 + 1)
    {
      int x = arr[top2];
      top2--;
      return x;
    }
    else
    {
      System.out.print("Stack UnderFlow");
      System.exit(1);
    }
    return 1;
  }

  public void display1()
  {
    if(top1!=size/2)
    {
      for(int i=top1;i<=size/2;i++)
      {
        System.out.println(arr[i]);
      }
    }
  }
  public void display2()
  {
    if(top2!=size/2+1)
    {
      for(int i=top2;i>=(size/2)+1;i--)
      {
        System.out.println(arr[i]);
      }
    }
  }

  int peek1()
  {
    if(top1!=size/2)
      return arr[top1];
    else 
      return -1;
  }
  int peek2()
  {
    if(top2!=(size/2)+1)
      return arr[top2];
    else 
      return -1;
  }
  public static void main(String[] args)
  {
    int x;
    Q3_DualStack stack = new Q3_DualStack(10);
    Scanner sc=new Scanner(System.in);
    do
    {
		 System.out.println("Enter your choice: ");
         System.out.println("1. push");
         System.out.println("2. Display");
         System.out.println("3. pop");
         System.out.println("4. peek");
         x = sc.nextInt();
         System.out.println("Which stack do you want to do operations on");
         int s=sc.nextInt();            
         switch(x)
         {
            case 1: System.out.println("Enter the data to be pushed to stack: ");
                    if(s==1)
                      stack.push1(sc.nextInt());
                    else
                      stack.push2(sc.nextInt());
                    break; 
            case 2: System.out.println("The elements in Stack: ");
                    if(s==1)
                      stack.display1();
                    else
                    stack.display2();
                    break; 
            case 3: System.out.println();
                    if(s==1)
                      stack.pop1();
                    else
                      stack.pop2();
                    break; 
                    
            case 4: System.out.print("The top data is peeked: ");
                    if(s==1)
                      System.out.println(stack.peek1());
                    else
                    System.out.println(stack.peek2());
                    break; 
            default: System.out.println("Invalid input!");
            }
 }
 while(x!=10);
 sc.close();
}
}

