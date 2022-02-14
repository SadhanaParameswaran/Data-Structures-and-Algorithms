package List;
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
    void insertAfter(int a, int b)
    {
    	
    }
    void insertBefore(int a, int b)
    {
    	
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
		/*
		 * Node2 t = new Node2(); Node2 p = new Node2(); t = Tail; p = Tail;
		 * while(t.next != p) { t = t.next; } t.next = p.next; t = Tail;
		 */
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
    void reverseDisplay()
    {
    	
    }
    void DeleteElement(Node1 s)    
    {

    }
    void delete_pos_element(int position)
    {

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
    void ReplaceElement(int s1,int s2) 
    {
    	
    }
    void MinElement()
    {
    	    
    } 
    void MaxElement()
    {
    	   
    }
    void RemoveDuplicate()
    {
    	
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
	
// 	DLL Merge(DLL LL2) 
// 	{
//	 
//	}
}
public class CLLMain 
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
			System.out.println("3. insertAfter"); 
			System.out.println("4. insertBefore");
            System.out.println("5. display");
			System.out.println("6. reverseDisplay"); 
            System.out.println("7. deleteFirst");
            System.out.println("8. deleteLast");
			System.out.println("9. Search"); 
			System.out.println("10. DeleteElement");
			System.out.println("11. ReplaceElement");
			System.out.println("12. MinElement"); 
			System.out.println("13. MaxElement");
			System.out.println("14. RemoveDuplicate");
			System.out.println("15. Concatenation"); 
			System.out.println("16. Split");
			System.out.println("17. Merge");
			System.out.println("18. delete_pos_element");
            
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
                
					
				case 3: System.out.println("Enter the element to be inserted and the element after which it should be inserted: "); 
						obj.insertAfter(sc.nextInt(), sc.nextInt()); 
						System.out.println(); 
						break;
					  
			    case 4: System.out.println("Enter the element to be inserted and the element before which it should be inserted: "); 
			    		obj.insertBefore(sc.nextInt(), sc.nextInt()); 
					  	System.out.println(); 
					  	break;
					 
                        
                case 5: System.out.println("The elements are: ");
        				obj.display();
        				System.out.println();
        				break;
        				
				case 6: System.out.println("The elements in reverse order are: ");
					    obj.reverseDisplay(); 
					    System.out.println(); 
					    break;
					 
						
                case 7: System.out.println("The first element is deleted");
        				obj.deleteFirst();
        				System.out.println();
        				break;
        
                case 8: System.out.println("The last element is deleted");
        				obj.deleteLast();
        				System.out.println();
        				break;
        		
        		
                case 9: System.out.println("Enter the element to be searched: ");
						obj.search(sc.nextInt());
						System.out.println();
						break;

//                case 10: System.out.println("Enter the element to be deleted: ");
//				 		 obj.DeleteElement(sc.nextInt());
//				 		 System.out.println();
//				 		 break;
		
                case 11: System.out.println("Enter the element to be replaced and the element you want to replace it with: ");
				  		 obj.ReplaceElement(sc.nextInt(),sc.nextInt());
				  		 System.out.println();
				  		 break;
		 
                case 12: 
                		 obj.MinElement();
                		 System.out.println();
                		 break;
		
                case 13: 
                		 obj.MaxElement();
                		 System.out.println();
                		 break;
	 	
                case 14: System.out.println("The duplicates are removed");
		 		 		 obj.RemoveDuplicate();
		 		 		 System.out.println();
		 		 		 break;
	   	 
                case 15: System.out.println("The lists are: ");
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
 		 
                case 16: System.out.println("The split list is: ");
		 	 	 		 //L2 = L1.Split_halves();
		 	 	 		 System.out.println("L1 is: ");
		 	 	 		 L1.display();
		 	 	 		 System.out.println("L2 is: ");
		 	 	 		 L2.display();
		 	 	 		 System.out.println();
		 	 	 		 break;

                case 17: System.out.println("List 1: ");
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
		 
                case 18: System.out.println("Enter the position of the element to be deleted: ");
        		 		 obj.delete_pos_element(sc.nextInt());
        		 		 System.out.println();
        		 		 break;
						
                default: System.out.println("Invalid input");

            }
        }
        while (x!=10);
    }
}
