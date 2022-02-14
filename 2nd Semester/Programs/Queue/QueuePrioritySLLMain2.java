//Enqueue EASIER, Dequeue COSTLIER
package Queue;
import java.util.*;
class Pnode2
{
  int Data;
  int Priority;
  Pnode2 Next;
  Pnode2()
  {
  
  }
  Pnode2(int x,int p)
  {
      Data=x;
      Priority=p;
      Next=null;
  }
}
class PQueuelist2
{
  Pnode2 front = null;
  Pnode2 rear = null;
  void enqueueE(int x, int p)//costlier
  { 
      Pnode2 temp=new Pnode2(x,p);
      if (front==null)
      {
          front = temp;
          rear = front; 
          return;
      }
      else
      {
          Pnode2 t = front;
          if(temp.Priority<t.Priority)
          {
              temp.Next = front;
              front = temp; 
              return;
          }
          else
          {
              Pnode2 pr=t;
              while(t!=null && temp.Priority>t.Priority)
              { 
                  pr=t;
                  t=t.Next;
              }
              if (t==null)//insertlast
              {
                  rear.Next=temp;
                  rear=temp;
              }
              else
              {
                  if(temp.Priority<t.Priority)
                  { 
                      pr.Next= temp;
                      temp.Next=t;
                  }
              }
          }
      }
  }
  int dequeueC()
  {
      int temp=-1;
      if (front==null)
      {
          System.out.println("PQ is empty");
      }
      else
      {
          temp= front.Data;
          front=front.Next;
      }
      return temp;
  }
  void display()
  {
      Pnode2 temp = front;
      System.out.println("Display");
      if (front!=null)
      {
          while(temp!=null)
          {
              System.out.println("("+temp.Data+ " "+ temp.Priority+")");
              temp=temp.Next;
          }
      }
  }
}
public class QueuePrioritySLLMain2 
{
  public static void main(String[] args) 
  {
	  Scanner sc = new Scanner(System.in);
	  PQueuelist2 s1 = new PQueuelist2();
      int x;
      do 
      {    
          System.out.println("Enter your choice: ");
          System.out.println("1. enqueueEasier");
          System.out.println("2. dequeueCostlier");
          System.out.println("3. display");
          x = sc.nextInt();
          switch(x)
          {
              case 1: System.out.println("Enter two elements to be pushed: ");
                      s1.enqueueE(sc.nextInt(), sc.nextInt());
                      System.out.println();
                      break;

              case 2: int u = s1.dequeueC();
                      System.out.println("The first set is removed!");
                      System.out.println();
                      break;
              
              case 3: System.out.println("The elements are: ");
                      s1.display();
                       System.out.println();
                      break;

              default: System.out.println("Invalid input");
          }
      }
      while (x!=10);
  }
}