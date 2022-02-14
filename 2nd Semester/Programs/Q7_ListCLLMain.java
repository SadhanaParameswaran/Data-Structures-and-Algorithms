//Replace, min, max, splitHalves, merge, deleteElement, deletePosElement,
package Programs;
import java.util.*;
class Node2
{
	int element;
	Node2 next;
	Node2()
	{ 
		element = 0;
		next = null;
	}
	Node2(int data)
	{ 
		element = data;
		next = null;
	}
	Node2(int data, Node2 n)
	{ 
		element = data;
		next = n;
	}
}
class CLL
{
	Node2 Tail;
	CLL()
	{
		Tail = null;
	}
	CLL(int s)
	{	 
		Tail = new Node2(s);    
		Tail.next = Tail;
	}
	void insertFront(int a)
	{
		Node2 t = new Node2(a);
		if(Tail == null)
		{
			Tail = t;
			Tail.next = Tail;
		}
		else
		{
			t.next = Tail.next;
			Tail.next = t;
		}
	}
	void insertLast(int a)
	{ 
		Node2 temp = new Node2(a);  
		if(Tail == null) 
		{   
			Tail = temp;  
			Tail.next = Tail;  
		}  
		else 
		{   
			temp.next = Tail.next;    
			Tail.next = temp;
			Tail = temp; 
		} 
	}
	void deleteFirst()
	{
		if(Tail != null)
		{
			Tail.next = Tail.next.next;
		}
		else
		{
			System.out.println("The list is empty");
		}
	}	
	void deleteLast()
	{
		if(Tail == null)
		{
			System.out.println("The list is empty");
		}
		else
		{
			Node2 temp = Tail;
			while(temp.next != Tail)
			{
				temp = temp.next;
			}
			temp.next = Tail.next;
			Tail = temp;
		}
	}	
	void display()
	{
		Node2 temp = Tail.next;
		do
		{
			System.out.println(temp.element);
			temp = temp.next;
		}
		while(temp!=Tail.next);
	}
	void DeleteElement(int ss)    
	{
		Node2 p = Tail.next;
	    if (Tail.next==null)
	         System.out.println("list is empty");
	    else if(Tail.next.element==ss)
	         Tail.next = Tail.next.next;
	    else
	    {
	    	Node2 temp = Tail.next;
	        while(temp!=null)
	        {  
	        	if (temp.element== ss)
	                break;
	            else 
	            	p=temp; temp=temp.next;
	        }
	        if (temp==null) 
	             System.out.println("Element not found");
	        else
	             p.next=temp.next;
	    }
	}
	void delete_pos_element(int pos)
	{
		if (Tail.next == null)
	        return;
	    Node2 temp = Tail.next;
	    if (pos == 0)
	    {
	    	Tail.next = temp.next;
	        return;
	    }
	    for (int i=0; temp!=null && i<pos-1; i++)
	        temp = temp.next;
	    if (temp == null || temp.next == null)
	        return;
	    Node2 next = temp.next.next;
	    temp.next = next; 
	}
	void search(int s1)
	{
		Node2 temp = Tail;
		int cc = 0;
		if(temp == null)
		{
			System.out.println("No such element");
		}
		while(temp != Tail)
		{
			if(s1 == temp.element)
			{
				System.out.println("Found at position: "+cc);
				break;
			}
			temp = temp.next;
			cc++;
		}
	}	
	void ReplaceElement(int x, int replacewith) 
	{
		Node2 temp=Tail.next;
    	if(temp==null) 
    		System.out.println("the list is empty");
    	while(temp!=Tail) 
    	{
    		if(temp.element==x)
    			temp.element=replacewith;
    		temp=temp.next;
    	}
    	System.out.println(+x+ " has been replaced with " +replacewith);
	}
	void MinElement()
	{
		Node2 temp = Tail.next;  
        int min = Tail.next.element;  
        if(Tail.next == null)  
            System.out.println("List is empty");  
        else {  
             do{
                 if(min > temp.element)  
                     min = temp.element;  
                 temp= temp.next;  
            }while(temp != Tail.next);  
            System.out.println("Minimum value node in the list: "+ min);   
         }
	}	 
	void MaxElement()
	{
		Node2 temp = Tail.next;  
    	int max = Tail.next.element;  
    	if(Tail.next == null) 
    	    System.out.println("List is empty");  
    	else 
    	{  
    	     do{
    	         if(max < temp.element)  
    	             max = temp.element;  
    	         temp= temp.next;  
    	       }while(temp != Tail.next);  
    	     System.out.println("Maximmum value node in the list: "+ max);   
    	}  
	}
	void RemoveDuplicate()
	{
		Node2 current = Tail.next;
    	Node2 index = null;
    	Node2 temp = null;  
        if(Tail.next == null) 
            return;  
        else 
        {  
            while(current != null)
            {  
                temp = current;  
                index = current.next;  
                while(index != null) 
                {  
                    if(current.element == index.element)  
                        temp.next = index.next;  
                    else  
                        temp = index;   
                    index = index.next;  
                }  
                current = current.next;  
            }  
        }
	}	
	void concatenation(CLL L2)
	{
		Node2 temp = L2.Tail.next;
		L2.Tail.next = this.Tail.next;
		this.Tail.next = temp;   
		this.Tail = L2.Tail;
	}
  
//	DLL Split_halves() 
//	{
//	 
//	}    
	
//	DLL Merge(DLL LL2) 
//	{
//	 
//	}
}
public class Q7_ListCLLMain
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		CLL obj = new CLL();
		CLL L1 = new CLL(); 
		CLL L2 = new CLL(); 
		CLL L3 = new CLL();
		
		int x;
		do 
		{    
			
			System.out.println("Which list do you want to work on? List 1 or List 2?");
			int listNum = sc.nextInt(); 
			if(listNum == 1) 
			{ 
				  obj = L1; 
			} 
			else 
			{ 
				  obj = L2; 
			}
			 
      	
			System.out.println();
			System.out.println("Enter your choice: ");
			System.out.println("1. insertFront");
			System.out.println("2. insertLast");			
			System.out.println("4. display");
			System.out.println("5. deleteFirst");
			System.out.println("6. deleteLast");
			System.out.println("7. Search"); 
			System.out.println("8. DeleteElement");
			System.out.println("9. ReplaceElement");
			System.out.println("10. MinElement"); 
			System.out.println("11. MaxElement");
			System.out.println("12. RemoveDuplicate");
			System.out.println("13. Concatenation"); 
			System.out.println("14. Split");
			System.out.println("15. Merge");
			System.out.println("16. delete_pos_element");
         
			x = sc.nextInt();
          
			switch(x)
			{
              case 1: System.out.println("Enter the data to be inserted in the front: ");
                      obj.insertFront(sc.nextInt());
                      System.out.println();
                      break;
                      
              case 2: System.out.println("Enter the data to be inserted in the last: ");
                      obj.insertLast(sc.nextInt());
                      System.out.println();
                      break;
              
			  case 4: System.out.println("The elements are: ");
      				  obj.display();
      				  System.out.println();
      				  break;
      				
			  case 5: System.out.println("The first element is deleted");
      				  obj.deleteFirst();
      				  System.out.println();
      				  break;
      
	          case 6: System.out.println("The last element is deleted");
      				  obj.deleteLast();
      			      System.out.println();
      				  break;
      		
      		
	          case 7: System.out.println("Enter the element to be searched: ");
					  obj.search(sc.nextInt());
					  System.out.println();
					  break;

              case 8: System.out.println("Enter the element to be deleted: ");
				 		obj.DeleteElement(sc.nextInt());
				 		System.out.println();
				 		break;
		
			  case 9:  System.out.println("Enter the element to be replaced and the element you want to replace it with: ");
				  	   obj.ReplaceElement(sc.nextInt(),sc.nextInt());
				  	   System.out.println();
				  	   break;
		 
			  case 10: 
              		   obj.MinElement();
              		   System.out.println();
              		   break;
		
			  case 11: 
              		   obj.MaxElement();
              		   System.out.println();
              		   break;
	 	
			  case 12: System.out.println("The duplicates are removed");
		 		 	   obj.RemoveDuplicate();
		 		 	   System.out.println();
		 		 	   break;
	   	 
			  case 13: System.out.println("The lists are: ");
                       System.out.println("The list L1 is: ");
              		   L1.display();
              		   System.out.println();
                 	   System.out.println("The list L2 is: ");
                	   L2.display();
              		   System.out.println();
              		   System.out.println("The Concatenated list L1 to L2 is: ");
		 		       L1.concatenation(L2);
		 		 	   L1.display();
		 		 	   System.out.println();
		 		 	   System.out.println("The Concatenated list L2 to L1 is: ");
		 		 	   L2.concatenation(L1);
		 		 	   L2.display();
		 		 	   break;
		 
	          case 14: System.out.println("The split list is: ");
		 	 	 	   //L2 = L1.Split_halves();
		 	 	 	   System.out.println("L1 is: ");
		 	 	 	   L1.display();
		 	 	 	   System.out.println("L2 is: ");
		 	 	 	   L2.display();
		 	 	 	   System.out.println();
		 	 	 	   break;

              case 15: System.out.println("List 1: ");
		 		 	   L1.display();
		 		       System.out.println();
		 		 	   System.out.println("List 2 ");
		 		 	   L2.display();
		 		 	   System.out.println();
		 		 	   System.out.println("The merged list is: ");
		 		 	   //L3 = L1.Merge(L2);
		 		 	   L3.display();
		 		 	   System.out.println();
		 		 	   break;
		 
              case 16: System.out.println("Enter the position of the element to be deleted: ");
      		 		   obj.delete_pos_element(sc.nextInt());
      		 		   System.out.println();
      		 		   break;
						
              default: System.out.println("Invalid input");

          }
      }
      while (x!=10);
  }
}
