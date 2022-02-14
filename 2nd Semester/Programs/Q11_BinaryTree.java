package Programs;
import java.util.*;
class NodeB
{
	int key;
	NodeB left, right;
	NodeB()
	{
		left = null;
		right = null;
		key = 0;
	}
	NodeB(int item)
	{
		key = item;
		left = right = null;
	}
	NodeB(int item, NodeB r, NodeB l)
	{
		key = item;
		right = r;
		left = l;
	}
}
class binaryTree
{
	NodeB root;
	int count = 0;
	NodeB pre;
	NodeB suc;
	binaryTree()
	{
		root = null;
	}
	NodeB insertIterative(NodeB root, int key)
	{
		NodeB nn = new NodeB(key);
		NodeB x = root;
		NodeB y = null;
			while(x!=null)
			{
				y = x;
				if(key < x.key)
				{
					x = x.left;
				}
				else
				{
					x = x.right;
				}
			}
			if(y==null)
			{
				y = nn;
			}
			else if(key<y.key)
			{
				y.left = nn;
			}
			else
			{
				y.right = nn;
			}
			return y;
	}	
	NodeB insertRecursive(NodeB r, int key)
	{
		if(r==null)
		{
			r = new NodeB(key);
			return r;
		}
		if(key<r.key)
		{
			r.left = insertRecursive(r.left, key);
		}
		else if(key>r.key)
		{
			r.right = insertRecursive(r.right, key);
		}
		return r;
	}
	boolean searchIterative(NodeB r, int key)
	{
		while(r!=null)
		{
			if(key>r.key)
			{
				r = r.right;
			}
			else if(key<r.key)
			{
				r = r.left;
			}
			else
			{
				return true;
			}
		}
		return false;
	}
	boolean searchRecursive(NodeB t, int value)
	{
		boolean flag = false;
		NodeB temp = t;
		if(t == null)
		{
			return flag;
		}
		else if (value == temp.key)
		{ 
			flag= true; return flag; 
		}
		else if (value < temp.key)
		{ 
			return(searchRecursive(temp.left, value)); 
		}
		else
		{ 
			return(searchRecursive(temp.right, value)); 
		}
	}
	void preOrder(NodeB r)
	{
		if(r!=null)
		{
			System.out.println(r.key);
			preOrder(r.left);
			preOrder(r.right);
		}
	}
	void inOrder(NodeB r) 
	{
		if(r!=null)
		{
			inOrder(r.left);
			System.out.println(r.key);
			inOrder(r.right);
		}
	}
	void postOrder(NodeB r)
	{
		if(r != null)
		{
			postOrder(r.left);
			postOrder(r.right);
			System.out.println(r.key);
		}
	}
	void countNode(NodeB r)
	{
		if(r != null)
		{
			countNode(r.left);
			countNode(r.right);
			count++;
		}
	}
	void leafCount(NodeB r)
	{
		if(r != null)
		{
			inOrder(r.left);
			if(r.left == null && r.right == null)
			{
				System.out.println("Leaves are: ");
				count++;
				inOrder(r.right);
			}
		}
	}
	void internalCount(NodeB r) 
	{
		if(r!=null)
		{
			inOrder(r.left);
			if((r.left!=null) || (r.right!=null))
			{
				count++;
				inOrder(r.right);
		   }
		}
	}	
	int MaxHeight(NodeB r)
	{ 
		if (r == null) 
			return 0; 
		else
		{ 
			int left_Depth = MaxHeight(r.left); 
			int right_Depth = MaxHeight(r.right); 
			//find the largest among the depths.
			if (left_Depth > right_Depth) 
				return (left_Depth + 1); 
			else
				return (right_Depth + 1); 
		} 
	} 
	int smallest(NodeB r)
	{
		NodeB p=r;
		while(r!=null)
		{
			p=r;
			r=r.left;
		}
		System.out.println(p.key);
		return p.key;
	}
	
	void largest(NodeB r)
	{
		NodeB p=r;
		while(r!=null)
		{
			p=r;
			r=r.right;
		}
		System.out.println(p.key);
	}
	
	boolean Path(NodeB r, int key) 
	{ 
		while (r != null) 
		{ 
			System.out.println(r.key); //count++;
			if (key > r.key) 
			{
				r = r.right; 
			}
			else if (key < r.key) 
			{
				r = r.left; 
			}
			else
			{
				return true; 
			}
		} 
		return false; 
	}
	//deleting a key
    void deleteKey(int key) 
    { 
        root = delete_Rec(root, key); 
    } 
   
    NodeB delete_Rec(NodeB root, int key) 
    {        
        if (root == null)  
        	return root;    
        if (key < root.key)     
            root.left = delete_Rec(root.left, key); 
        else if (key > root.key)  
            root.right = delete_Rec(root.right, key); 
        else  
        {            
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left;             
            root.key = smallest(root.right);            
            root.right = delete_Rec(root.right, root.key); 
        } 
        return root; 
    }
	 
	void InorderPreSuc(NodeB root, int key)
	{
	    if (root == null)
	        return;
	    while (root != null)
	    {
	        if (root.key == key)
	        {
	            if (root.right != null)
	            {
	                suc = root.right;
	                while (suc.left != null)
	                    suc = suc.left;
	            }
	            if (root.left != null)
	            {
	                pre = root.left;
	                while (pre.right != null)
	                    pre = pre.right;
	            }
	            return;
	        }
	        else if (root.key < key)
	        {
	            pre = root;
	            root = root.right;
	        }
	        else
	        {
	            suc = root;
	            root = root.left;
	        }
	    }
	    if (pre != null)
	        System.out.println("Predecessor is " +pre.key);
	    else
	        System.out.print("-1");
	 
	    if (suc != null)
	        System.out.print("Successor is " + suc.key);
	    else
	        System.out.print("-1");
	}
}
public class Q11_BinaryTree 
{
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		binaryTree s = new binaryTree();
		int x;
		do
		{
			System.out.println("Enter your choice: ");
            System.out.println("1. insertIterative");
            System.out.println("2. insertRecursive");
            System.out.println("3. searchIterative");
            System.out.println("4. searchRecursive");
            System.out.println("5. preOrder");
            System.out.println("6. inOrder");
            System.out.println("7. postOrder");
            System.out.println("8. countNode");
            System.out.println("9. leafCount");
            System.out.println("10. internalCount");
            System.out.println("11. MaxHeight");
            System.out.println("12. smallest");
            System.out.println("13. largest");
            System.out.println("14. Path");
            System.out.println("15. deleteKey"); 
            System.out.println("16. InorderPreSuc");
            x = sc.nextInt();
         
            switch(x)
            {
                case 1: System.out.println("Enter the data to be inserted (Iterative): ");
                        s.insertIterative(s.root, sc.nextInt());
                        System.out.println();
                        break;
                        
                case 2: System.out.println("Enter the data to be inserted (Recursive): ");
                        s.root = s.insertRecursive(s.root, sc.nextInt());
                        System.out.println();
                        break;
                
                case 3: System.out.println("Enter the element to be searched: ");
                		System.out.println(s.searchIterative(s.root, sc.nextInt()));
                		System.out.println();
                        break;
                
                case 4: System.out.println("Enter the element to be searched (Recursive): ");
                		System.out.println(s.searchRecursive(s.root, sc.nextInt()));
                		System.out.println();
                		break;
                		
                case 5: System.out.println("The data in preOrder: ");
                		s.preOrder(s.root);
                		System.out.println();
                		break;
                
                case 6: System.out.println("The data in inOrder: ");
                		s.inOrder(s.root);
                		System.out.println();
                		break;
        
                case 7: System.out.println("The data in postOrder: ");
        				s.postOrder(s.root);
        				System.out.println();
        				break;
        
                case 8: s.count = 0;
        				s.countNode(s.root);
        				System.out.println("The count is : "+s.count);
        				System.out.println();
        				break;
        				
                case 9: System.out.println("Leaf count: "+s.count);
						s.leafCount(s.root);
						System.out.println();
						break;
						
                case 10: System.out.println("Internal count: "+s.count);
						 s.internalCount(s.root);
						 System.out.println();
						 break;
						 
                case 11: System.out.println("The max height of the tree is: ");
                		 System.out.println(s.MaxHeight(s.root));
                		 System.out.println();
                		 break;
        
                case 12: System.out.println("The smallest element is: ");
        				 s.smallest(s.root);
        				 System.out.println();
        				 break;
        		
                case 13: System.out.println("The largest element is: ");
        				 s.largest(s.root);
        				 System.out.println();
        				 break;
        
                case 14: System.out.println("Enter an element to find its path: ");
                		 System.out.println(s.Path(s.root,sc.nextInt()));
        				 System.out.println();
        				 break;

                case 15: System.out.println("Enter a number: ");
						 s.deleteKey(sc.nextInt());
						 System.out.println();
						 break;

                case 16: System.out.println("Enter a number: ");
						 s.InorderPreSuc(s.root,sc.nextInt());
						 System.out.println();
						 break;
                		
                default: System.out.println("Invalid input!");
            }
		}
		while(x!=20);
	}
}

//NodeB deleteNodeRec(NodeB root, int k) 
//{ 
//	// Base case 
//	if (root == null) 
//		return root; 
//	// Recursive calls for ancestors of 
//	// node to be deleted 
//	if (root.key > k) 
//	{ 
//		root.left = deleteNodeRec(root.left, k); 
//		return root; 
//	} 
//	else if (root.key < k) 
//	{ 
//		root.right = deleteNodeRec(root.right, k); 
//		return root; 
//	} 
//	// We reach here when root is the node 
//	// to be deleted. 
//	// If one of the children is empty 
//	if (root.left == null) 
//	{ 
//		NodeB temp = root.right; 
//		delete root; 
//		return temp; 
//	} 
//	else if (root.right == null) 
//	{ 
//		NodeB temp = root.left; 
//		delete root; 
//		return temp; 
//	} 
//	// If both children exist 
//	else 
//	{ 
//		NodeB succParent = root; 
//		// Find successor 
//		NodeB succ = root.right; 
//		while (succ.left != null) 
//		{ 
//			succParent = succ; 
//			succ = succ.left; 
//		} 
//		// Delete successor. Since successor 
//		// is always left child of its parent 
//		// we can safely make successor's right 
//		// right child as left of its parent. 
//		// If there is no succ, then assign
//		// succ->right to succParent->right 
//		if (succParent != root) 
//		{
//			succParent.left = succ.right; 
//		}
//		else
//			succParent.right = succ.right; 
//			// Copy Successor Data to root 
//			root.key = succ.key; 
//			// Delete Successor and return root 
//			delete succ;
//			return root; 
//	} 
//}
//public boolean deleteNodeNonRec(NodeB value)
//{ 
//	NodeB current = root;
//	NodeB parent = root; 
//	boolean isLeftChild = false;
//	while(current.value != value)
//	{ 	
//		parent = current;
//	}
//	if(value < current.value)
//	{
//		// Move to the left if searched value is less 
//		current = current.left;
//		isLeftChild = true; 
//	}
//	else	
//	{ 
//		// Move to the right if searched value is >=
//		current = current.right;
//		isLeftChild = false; 
//	}
//	if(current == null)
//	{
//		return false; 
//	}
//} 
  