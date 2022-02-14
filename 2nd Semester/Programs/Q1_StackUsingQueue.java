package Programs;
import java.util.LinkedList;   
import java.util.Queue;
import java.util.Scanner;
 
public class Q1_StackUsingQueue 
{
 
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    Q1_StackUsingQueue()
    {
        queue1=new LinkedList<Integer>();
        queue2=new LinkedList<Integer>();
    }
 
    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public void push(int i){
        if(queue1.size()==0)
            queue1.add(i);
        else{
            int sizeOfQueue1 = queue1.size();
            // Copy elements of Queue1 to Queue2
            for(int j=0 ; j<sizeOfQueue1 ; j++)
                queue2.add(queue1.remove());
            queue1.add(i);
            // Copy elements for Queue2 to Queue1
            for(int k=0 ; k<sizeOfQueue1 ; k++)
                queue1.add(queue2.remove());
        }
    }
 
    public int pop(){
        if(queue1.size()==0)
            System.out.println("Underflow Exception");
        return queue1.remove();
    }

    public void display()
    {
        System.out.println(queue1);
    }

    public void peek()
    {
        System.out.println(queue1.peek());
    }
 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		Q1_StackUsingQueue d1 = new Q1_StackUsingQueue();
		int x;
        do
        {
		 System.out.println("Enter your choice: ");
         System.out.println("1. push");
         System.out.println("2. Display");
         System.out.println("3. pop");
         System.out.println("4. peek");
         x = sc.nextInt();            
         switch(x)
         {
            case 1: System.out.println("Enter the data to be pushed to stack: ");
                    d1.push(sc.nextInt());
                    break; 
            case 2: System.out.println("The elements in Stack: ");
                    d1.display();
                    System.out.println();
                    break;
            case 3: System.out.println();
                    d1.pop();
                    System.out.println();
                    break;
            case 4: System.out.print("The last data is peeked: ");
    				d1.peek();
    				System.out.println();
    				break; 
            default: System.out.println("Invalid input!");
            }
 }
 while(x!=10);
 sc.close();
 }
}


