package Programs;
import java.util.*;
class Node1
{
    int data;
    Node1 prev;
    Node1 next;
    Node1()
    { 
        data = 0;
        prev = null;
        next = null;
    }
    Node1(int x)
    { 
        data = x;
        prev = null;
        next = null;
    }
    Node1(Node1 n1, int x, Node1 n2)
    { 
        data = x;
        prev = n1;
        next = n2;
    }
}
class DLL
{
	Node1 head;
	Node1 tail;
	DLL()
    {
        head = null;
        tail = null;
    }
    DLL(int x)
    { 
        head= new Node1(x);    
        tail = head;
    }
    void insertFront(int x)
    {
        Node1 t = new Node1(x);
        if (head == null)
        {
        	head = tail = t;
        }
        else
        {
        	head.prev = t;
        	t.next = head;
        	head = t;
        }
    }
    void insertLast(int x)
    {
    	if(head == null)
    	{
    		head = new Node1(x);
    		tail = head;
    	}
    	else
    	{
    		Node1 t = new Node1(x);		
    		tail.next = t;
    		t.prev = tail;
    		tail = t;
    	}
    }
    void insertAfter(int x, int after)
    { 
    	Node1 temp = head;
		if(head == null)
		{
			System.out.println("List is empty");
		}
		else
		{	while((temp!=null)&&(temp.data!=after))
			{
				temp = temp.next;
			}
			if(temp == null)
			{
				System.out.println("the searching element is not found");
			}
			else
			{
				Node1 t1 = new Node1(x);
				t1.prev = temp;
				t1.next = temp.next;
				temp.next = t1;
				t1.next.prev = t1;
			}
			if(temp.next == null)
			{
				
			}
		}
    }
    void insertBefore(int x, int before)
    { 
    	Node1 temp = head;
		if(head == null)
		{
			System.out.println("List is empty");
		}
		else
		{	while((temp!=null)&&(temp.data!=before))
			{
				temp = temp.prev;
			}
		
			if(temp == null)
			{
				System.out.println("the searching eelement is not found");
			}
			else
			{
				Node1 t1 = new Node1(x);
				t1.next = temp;
				t1.prev = temp.prev;
				temp.prev.next = t1;
				t1.prev = t1;
			}
		}
    }
    void display()
    {
    	Node1 t = head;
    	while(t != null)
    	{
    		System.out.println(t.data);
    		t = t.next;
    	}
    }
    void reverseDisplay()
    {
    	Node1 t = tail;
    	while(t != null)
    	{
    		System.out.println(t.data);
    		t = t.prev;
    	}
    } 
    void deleteFirst()
    {
    	if (head == null)
    	{
            System.out.println("List is empty!");
    	}
        Node1 temp = head;
        head = head.next;
    }
    void deleteLast()
    {
    	if(head == null) 
    	{  
            return;  
        }  
        else 
        {  
            if(head != tail) 
            {  
                tail = tail.prev;  
                tail.next = null;  
            }  
            else 
            {  
                head = tail = null;  
            }  
        } 
    }
    void DeleteElement(int a)    
    {
    	Node1 traverse = head;
		if (head == null)
		{
	        System.out.println("list is empty");
		}
	    else if(head.data == a)
	    {
	        head=head.next;
	    }
	    else
	    {
	    	Node1 temp = head;
	        while(temp!=null)
            {  
	        	if (temp.data == a)
	        	{
	                break;
	        	}
	            else 
	            {
	                temp = temp.next;}

	            }
	            if (temp == null) 
	            {
	                System.out.println("Element not found");
	            }
	            else
	            {
	        	    temp.prev.next = temp.next;
	        	    temp.next.prev = temp.prev;
	            }

	      }
    }
    void delete_pos_element(int position)
    {
    	 Node1 temp = head;
	    	if (head == null)
	    	{
	    		System.out.println("list is empty");
	    	}
	    	if(position == 0)
	    	{
	    		head = temp.next;
	    		System.out.println("Element deleted");
	    	}
	    	for(int i=0; temp!=null && i<position-1; i++)
	    	{
	    		temp = temp.next;
	    	}
	    	if(temp==null || temp.next==null)
	    	{
	    		System.out.println("Position invalid");
	    	}
	    	Node1 next = temp.next.next;
	    	temp.next = next;
    }
	/*
	 * void deleteAfter (Node1 head, Node1 tail, int after) { Node1 temp, loc; temp
	 * = head; loc = search(temp,after); if (loc == null) { return; } temp =
	 * loc.next; loc.next = temp.next; if(temp.next == null) { tail = loc; } else {
	 * temp.next.prev = loc; } }
	 */
    
	/*
	 * void deleteBefore (Node1 head, int before) { Node1 temp, loc; temp = head;
	 * loc = search(temp,before); if(loc == null) { return; } temp = loc.prev;
	 * loc.prev = temp.prev; if(temp.prev == null) { head=loc; } else {
	 * temp.prev.next = loc; } }
	 */
    void search(int s1)
    {
    	int i = 1;  
        boolean flag = false;  
        Node1 current = head;  
        if(head == null) 
        {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) 
        {  
            if(current.data == s1) 
            {  
                flag = true;  
                break;  
            }  
            current = current.next;  
            i++;  
        }  
        if(flag) 
        {
             System.out.println("Node is present in the list at the position : " + i);  
        }
        else  
        {
             System.out.println("Node is not present in the list");  
        }
    }
    void ReplaceElement(int s1,int s2) 
    {
    	if(head == null) 
    	{
    		System.out.println("List is empty");
        }
    	else 
    	{
            Node1 traverse = head;
            while(traverse != null) 
            {
                if(s1 == traverse.data)
                {
                	traverse.data = s2;
                	break;
                }
                traverse = traverse.next;
                if(traverse == null) 
                {
                	System.out.println("No such element exists");
                }
            }
    	}
    }
    void MinElement()
    {
    	  Node1 current = head;  
          int min ;  
          if(head == null) 
          {  
              System.out.println("List is empty");  
          }  
          else 
          {  
              min = head.data;  
              while(current != null) 
              {  
                  if(min > current.data)  
                  {
                      min = current.data;  
                  }
                  current = current.next;  
              }  
              System.out.println("The minimum element is: " +min);
          }    
    } 
    void MaxElement()
    {
    	Node1 current = head;  
        int max;  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else 
        {  
            max = head.data;   
            while(current != null) 
            {  
                if(current.data > max)  
                {
                    max = current.data;  
                }
                current = current.next;  
            }  
            System.out.println("The maximum element is: " +max);
        }   
    }
    void RemoveDuplicate()
    {
    	if(head==null)
    	{
    		System.out.println("List is Empty");
    	}
    	else if(head.next==null)
    	{
    		System.out.println("There is one Element");
    	}
    	else 
    	{
    		Node1 temp = head;
    		//DNode h=tail;
    		while(temp.next != null)
    		{
    			Node1 t = temp.next;
    			//System.out.println("temp.element"+temp.element);
    			while(t != null)
    			{
    				if(temp.data == t.data)
    				{
    					if(t.next == null)
    					{
    						tail = t.prev;
    						t.prev.next = null;
    						break;
    					}
    					else 
    					{
    						t.prev.next = t.next;
    						t.next.prev = t.prev;
    						t = t.next;
    					}
    				}
    				else
    				{
    					t = t.next;
    				}
    			}
    			if(temp.next == null)
    			{
    				tail = temp;
    				break;
    			}
    			else 
    			{
    				temp = temp.next;
    			}
    		}
    	}
    }
    void concatenation(DLL L2)
    {
    	Node1 temp = this.head;
    	while(temp.next != null)
    	{
    		temp = temp.next;
    	}
    	L2.head.prev = temp;
    	temp.next = L2.head;
    }
    
	DLL Split_halves() 
	{
		DLL L3 = new DLL();
    	Node1 p;
    	Node1 temp = head;
    	p = temp;
    	while(temp!=null && temp.next!=null && temp.next.next!=null)
    	{
    		p = p.next;
    		temp = temp.next.next;
    	}
    	L3.head = p.next;
    	p.next = null;
    	return L3;
	}
    
	DLL Merge(DLL LL2) 
	{
		DLL L3 = new DLL();
		Node1 t1 = this.head;
		Node1 t2 = LL2.head;
		while(t1 != null && t2 != null) 
		{
			if(t1.data < t2.data) 
			{
				L3.insertLast(t1.data);
				t1 = t1.next;
			}
			else 
			{
				L3.insertLast(t2.data);
				t2 = t2.next;
			}
		}
		while(t2 != null) 
		{
			L3.insertLast(t2.data);
			t2 = t2.next;
		}
		while(t1 != null) 
		{
			L3.insertLast(t1.data);
			t1 = t1.next;
		}
		return L3;
	}
}
public class Q7_ListDLLMain
{
	public static void main(String[] args) 
    {
		Scanner sc = new Scanner(System.in);
        DLL obj = new DLL();
        DLL L1 = new DLL();
        DLL L2 = new DLL();
        DLL L3 = new DLL();
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
        
                case 10: System.out.println("Enter the element to be deleted: ");
						 obj.DeleteElement(sc.nextInt());
						 System.out.println();
						 break;
				
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
			   	 
                case 15: System.out.println("The Concatenated list is: ");
		 		 		 obj.concatenation(L2);
		 		 		 obj.display();
		 		 		 System.out.println();
		 		 		 break;
		 		 
                case 16: System.out.println("The split list is: ");
        		 	 	 L2 = L1.Split_halves();
        		 	 	 System.out.println("L1 is: ");
        		 	 	 L1.display();
        		 	 	 System.out.println("L2 is: ");
        		 	 	 L2.display();
        		 	 	 break;
        
                case 17: System.out.println("List 1: ");
        		 		 L1.display();
        		 		 System.out.println();
        		 		 System.out.println("List 2 ");
        		 		 L2.display();
        		 		 System.out.println();
        		 		 System.out.println("The merged list is: ");
        		 		 L3 = L1.Merge(L2);
        		 		 L3.display();
        		 		 break;
        		 
                case 18: System.out.println("Enter the position of the element to be deleted: ");
                		 obj.delete_pos_element(sc.nextInt());
                		 break;
						
                default: System.out.println("Invalid input");

            }
        }
        while (x!=20);
    }
}