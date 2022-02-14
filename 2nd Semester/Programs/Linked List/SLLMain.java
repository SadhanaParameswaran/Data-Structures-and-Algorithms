package List;
import java.util.*;
class Node
{
    int element;
    Node next;
    Node()
    { 
        element = 0;
        next = null;
    }
    Node(int data)
    { 
        element = data;
        next = null;
    }
    Node(int data, Node n)
    { 
        element = data;
        next = n;
    }
}

class SLIST
{
    Node head;
    SLIST()
    {
        head = null;
    }
    SLIST(int s)
    { 
        head = new Node(s);    
    }
    void insertfront(int s)
    {
        Node temp = new Node(s);
        temp.next = head;
        head = temp;
    }
    void insertLast(int s) 
    {
        Node t = new Node(s);
        if(head == null)
        {
        	head = t;
        }
        else
        {
        	Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = t; 
        }       
    }
    void display()
    {
        Node temp = head;
        if(temp == null)
        {
        	System.out.println("List is empty");
        }
        else
        {
        	while(temp!=null)
        	{
        		System.out.println(temp.element);
        		temp=temp.next;
        	}
        }
    }
    void deleteFirst()
    {
    	if(head!=null)
    	{
    		head = head.next;
    	}
    	else
    	{
    		System.out.println("List is Empty");
    	}
    }
    void deleteLast()
    {
    	if(head==null)
    	{
    		System.out.println("List is Empty");
    	}
    	else if(head.next == null)
    	{
    		head = null;
    	}
    	else
    	{
    		Node p = head;
    		Node t = head;
    		while(t.next!=null)
    		{	
    			p=t;
    			t=t.next;
    		}
    		p.next = null;
    	}
    }
    void addFirst(int s1, int s2)
    {
    	Node traverse = head;
    	Node newNode = new Node(s2);
    	while(traverse != null)
    	{
    		if(s1 != 0 && s1 == traverse.element)
    		{
    			newNode.next = traverse.next;
    			traverse.next = newNode;
    		}
    		traverse = traverse.next;
    	}
    }
    void search(int s1)
    {
    	Node t = head;
    	int cc = 0;
    	if(t == null)
    	{
    		System.out.println("No such element");
    	}
    	while(t != null)
    	{
    		if(s1 == t.element)
    		{
    			System.out.println("Found at position: "+cc);
    			break;
    		}
    		t = t.next;
    		cc++;
    	}
    }
    void DeleteElement(int s)    
    {
      	Node p = head;
        if (head == null)
        {
             System.out.println("list is empty");
        }
        else if(head.element == s)
        {
               head = head.next;
        }
        else
        {
        	Node temp = head;
        	while(temp != null)
            {
            	if (temp.element == s)
            	{
                   break;
            	}
                else 
                {
                	p = temp; 
                	temp = temp.next;
                }
            }
            if (temp == null) 
            {
                 System.out.println("Element not found");
            }
            else
            {
                 p.next = temp.next;
            }
        }
    }
    void delete_pos_element(int position)
    {
    	Node temp = head;
    	if (head == null)
    	{
    		System.out.println("list is empty");
    	}
        if (position == 0)
        {
            head = temp.next;   
            System.out.println("Element deleted");
        }
        for (int i=0; temp!=null && i<position-1; i++)
        {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
        {
        	System.out.println("Position invalid");
        }
        Node next = temp.next.next;
        temp.next = next; 
    }
    void ReplaceElement(int s1,int s2) 
    {
    	if(head == null) 
    	{
    		System.out.println("List is empty");
        }
    	else 
    	{
            Node traverse = head;
            while(traverse != null) 
            {
                if(s1 == traverse.element)
                {
                	traverse.element = s2;
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
    	Node current = head;  
        int min;  
          
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else 
        {  
            min = head.element;  
              
            while(current != null)
            {  
                 if(min > current.element) 
                 {  
                     min = current.element;  
                 }  
                 current = current.next;  
            }          
            System.out.println("Minimum value node in the list: "+ min);  
        }  
    } 
    void MaxElement()
    {
    	Node current = head;  
        int max;  
        if(head == null) 
        {  
            System.out.println("List is empty");  
        }  
        else 
        {  
            max = head.element;               
            while(current != null)
            {
                 if(max < current.element) 
                 {  
                     max = current.element;  
                 }  
                 current = current.next;  
            }               
            System.out.println("Maximum value node in the list: "+ max);  
        }  
    }
    void RemoveDuplicate()
    {
    	Node current = head;
    	Node index = null;
    	Node temp = null;  
    	  
        if(head == null) 
        {  
            return;  
        }  
        else 
        {  
            while(current != null)
            {  
                temp = current;  
                index = current.next;  
  
                while(index != null) 
                {  
                    if(current.element == index.element) 
                    {  
                        temp.next = index.next;  
                    }  
                    else 
                    {  
                        temp = index;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }  
        }
    }
    void concatenation(SLIST L2)
    {
    	Node temp = head;
    	while(temp.next != null)
    	{
    		temp = temp.next;
    	}
    	temp.next = L2.head;
    }
    SLIST Split_halves()
    {
    	SLIST L3 = new SLIST();
    	Node p;
    	Node temp = head;
    	p = temp;
    	while(temp != null && temp.next != null && temp.next.next != null)
    	{
    		p = p.next;
    		temp = temp.next.next;
    	}
    	L3.head = p.next;
    	p.next = null;
    	return L3;
    }
    SLIST Merge(SLIST LL2)
    {
    	SLIST L3 = new SLIST();
    	Node t1 = this.head;
    	Node t2 = LL2.head;
    	while(t1 != null && t2 != null)
    	{
    		if(t1.element < t2.element)
    		{
    			L3.insertLast(t1.element);
                t1 = t1.next;
    		}
    		else
    		{
    			L3.insertLast(t2.element);
                t2 = t2.next;
    		}
    	}
    	while (t2 != null) 
        {
        	L3.insertLast(t2.element);
            t2 = t2.next;
        }
    	while (t1 != null) 
    	{
            L3.insertLast(t1.element);
            t1 = t1.next;
        }
    	return L3;
    }
}

class SLLMain 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        SLIST SLL = new SLIST();
        SLIST L1 = new SLIST();
        SLIST L2 = new SLIST();
        SLIST L3 = new SLIST();
        int x;
        do 
        {
        	System.out.println("Which list do you want to work on? List 1 or List 2?");
        	int listNum = sc.nextInt();
        	if(listNum == 1)
        	{
        		SLL = L1;
        	}
        	else
        	{
        		SLL = L2;
        	}
        	
        	System.out.println();
        	System.out.println("Enter your choice: ");
            System.out.println("1. insertfront");
            System.out.println("2. insertLast");
            System.out.println("3. Display");
            System.out.println("4. deleteFirst");
            System.out.println("5. deleteLast");
            System.out.println("6. Search");
            System.out.println("7. DeleteElement");
            System.out.println("8. ReplaceElement");
            System.out.println("9. MinElement");
            System.out.println("10. MaxElement");
            System.out.println("11. RemoveDuplicate");
            System.out.println("12. Concatenation");
            System.out.println("13. Split");
            System.out.println("14. Merge");
            System.out.println("15. delete_pos_element");
            
            x = sc.nextInt();
            
            switch(x)
            {
                case 1: System.out.println("Enter the data to be inserted in the front: ");
                        SLL.insertfront(sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: System.out.println("Enter the data to be inserted in the last: ");
                        SLL.insertLast(sc.nextInt());
                        System.out.println();
                        break;
                
                case 3: System.out.println("The elements are: ");
                		SLL.display();
                		System.out.println();
                        break;
                
                case 4: System.out.println("The first element is deleted: ");
                		SLL.deleteFirst();
                		System.out.println();
                		break;
                
                case 5: System.out.println("The last element is deleted: ");
                		SLL.deleteLast();
                		
                        break;
                
                case 6: System.out.println("Enter the element to be searched: ");
                		SLL.search(sc.nextInt());
                		System.out.println();
                		break;
                
                case 7: System.out.println("Enter the element to be deleted: ");
        				SLL.DeleteElement(sc.nextInt());
        				System.out.println();
        				break;
        				
                case 8: System.out.println("Enter the element to be replaced and the element you want to replace it with: ");
						SLL.ReplaceElement(sc.nextInt(),sc.nextInt());
						System.out.println();
						break;
						 
                case 9: 
						SLL.MinElement();
						System.out.println();
						break;
						
                case 10: 
						 SLL.MaxElement();
						 System.out.println();
					   	 break;
					 	
                case 11: System.out.println("The duplicates are removed");
						 SLL.RemoveDuplicate();
						 System.out.println();
					   	 break;
					   	 
                case 12: System.out.println("The Concatenated list is: ");
				 		 SLL.concatenation(L2);
				 		 SLL.display();
				 		 System.out.println();
				 		 break;
				 		 
                case 13: System.out.println("The split list is: ");
                		 L2 = L1.Split_halves();
                		 System.out.println("L1 is: ");
                		 L1.display();
                		 System.out.println("L2 is: ");
                		 L2.display();
                		 break;
                
                case 14: System.out.println("List 1: ");
                		 L1.display();
                		 System.out.println();
                		 System.out.println("List 2 ");
                		 L2.display();
                		 System.out.println();
                		 System.out.println("The merged list is: ");
                		 L3 = L1.Merge(L2);
                		 L3.display();
                		 break;
                		 
                case 15: System.out.println("Enter the position of the element to be deleted: ");
                 		 SLL.delete_pos_element(sc.nextInt());
                 		System.out.println("Element deleted");
                 		 break;
                		 
                default: System.out.println("Invalid input");
                		 break;
            }
        }
        while(x!=10);
    }
}






