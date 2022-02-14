//package Programs;
//import java.util.*; 
//class TNode
//{
//	int key;
//	TNode left, right;
//	
//	public TNode()
//	{
//		left=right=null;
//		key=0;
//	}
//
//	public TNode(int item)
//	{
//		key=item;
//		left=right=null;
//	}
//	
//	public TNode(int item,TNode l, TNode r)
//	{
//		key=item;
//		left=l;
//		right=r;
//	}
//}
//
//class Tree
//{
//	int count=0;
//	TNode root;
//	package BinaryTrees;
//
//	import java.util.*;
//
//	class TNode
//	{
//		int key;
//		TNode left, right;
//		
//		public TNode()
//		{
//			left=right=null;
//			key=0;
//		}
//
//		public TNode(int item)
//		{
//			key=item;
//			left=right=null;
//		}
//		
//		public TNode(int item,TNode l, TNode r)
//		{
//			key=item;
//			left=l;
//			right=r;
//		}
//	}
//
//	class Tree
//	{
//		int count=0;
//		TNode root;
//		TNode pre;
//		TNode suc;
//		Tree()
//		{
//			root=null;
//		}
//		TNode insert(TNode root, int key)
//		{
//			TNode nn=new TNode(key);
//			TNode x=root;
//			TNode y=null;
//			while(x!=null) 
//			{
//				y=x;
//				if(key<x.key)
//				{
//					x=x.left;
//				}
//				else
//				{
//					x=x.right;
//				}
//			}
//			if(y==null)
//			{
//				y=nn;
//			}
//			else if(key<y.key)
//			{
//				y.left=nn;
//				
//			}
//			else
//			{
//				y.right=nn;
//			}
//			return y;
//		}
//		
//		TNode insertRec(TNode r,int key)
//		{
//			if(r==null)
//			{
//				r=new TNode(key);
//				return r;
//			}
//			if(key<r.key)
//			{
//				r.left=insertRec(r.left,key);
//			}
//			else if(key>r.key)
//			{
//				r.right=insertRec(r.right,key);
//			}
//			return r;
//		}
//		
//		void Display()
//		{
//			
//		}
//		
//		void preOrder(TNode root)
//		{
//			if(root!=null)
//			{
//				System.out.println(root.key);
//				preOrder(root.left);
//				preOrder(root.right);
//			}
//		}
//		
//		void postOrder(TNode r)
//		{
//			if(r!=null)
//			{
//				postOrder(r.left);
//				postOrder(r.right);
//				System.out.println(r.key);
//			}
//		}
//		
//		void inOrder(TNode r)
//		{
//			if(r!=null)
//			{
//				inOrder(r.left);
//				System.out.println(r.key);
//				inOrder(r.right);
//			}
//		}
//		
//		void Count(TNode r)
//		{
//			if(r!=null)
//			{
//				Count(r.left);
//				Count(r.right);
//				count++;
//			}
//		}
//
//		void countOfLeafs(TNode r)
//		{
//			if(r!=null)
//			{
//				inOrder(r.left);
//				if((r.left==null) && (r.right==null))
//				{
//					count++;
//					inOrder(r.right);
//				}
//			}
//			
//		}
//		
//		void countOfInternal(TNode r)
//		{
//			if(r!=null)
//			{
//				inOrder(r.left);
//				if((r.left!=null) || (r.right!=null))
//				{
//					count++;
//					inOrder(r.right);
//				}
//			}
//			
//		}
//		
//		int least(TNode r)
//		{
//			TNode p=r;
//			while(r!=null)
//			{
//				p=r;
//				r=r.left;
//			}
//			System.out.println(p.key);
//			return p.key;
//		}
//		
//		void largest(TNode r)
//		{
//			TNode p=r;
//			while(r!=null)
//			{
//				p=r;
//				r=r.right;
//			}
//			System.out.println(p.key);
//		}
//		
//		boolean Path(TNode r, int key) 
//		{ 
//			while (r != null) 
//			{ 
//				System.out.println(r.key); 
//				count++;
//				if (key > r.key) 
//				{
//					r = r.right; 
//				}
//				else if (key < r.key) 
//				{
//					r = r.left; 
//				}
//				else
//				{
//					return true; 
//				}
//			} 
//			return false; 
//		} 
//
//		
//		int Height(TNode r)
//		{
//			if(r==null)
//			{
//				return 0;
//			}
//			else
//			{
//				int left_depth=Height(r.left);
//				int right_depth=Height(r.right);
//				if (left_depth>right_depth)
//				{
//					return(left_depth+1);
//				}
//				else
//				{
//					return(right_depth+1);
//				}
//
//			}
//		}
//		
//
//		
//		boolean SearchRec(TNode T, int key)
//		{
//			boolean flag = false;
//			TNode temp = T;
//			if (T==null) 
//				{
//				return flag;
//				}
//				else 
//				{  
//					if (key == temp.key)
//					{ 
//						flag= true;
//						return flag; 
//						}
//					else if (key < temp.key)
//					{ 
//						return(SearchRec(temp.left, key)); 
//					}
//					else
//					{ 
//						return(SearchRec(temp.right, key)); 
//					}
//				}
//		}
//
//		
//		
//		//deleting a key
//	    void deleteKey(int key) 
//	    { 
//	        root = delete_Rec(root, key); 
//	    } 
//	   
//	    TNode delete_Rec(TNode root, int key) 
//	    {        
//	        if (root == null)  
//	        	return root;    
//	        if (key < root.key)     
//	            root.left = delete_Rec(root.left, key); 
//	        else if (key > root.key)  
//	            root.right = delete_Rec(root.right, key); 
//	        else  
//	        {            
//	            if (root.left == null) 
//	                return root.right; 
//	            else if (root.right == null) 
//	                return root.left;             
//	            root.key = least(root.right);            
//	            root.right = delete_Rec(root.right, root.key); 
//	        } 
//	        return root; 
//	    }
//		
//		void findPreSuc(TNode root, int key)
//		{
//
//		    if (root == null)
//		        return;
//		 
//		    while (root != null)
//		    {
//		 
//		        if (root.key == key)
//		        {
//
//		            if (root.right != null)
//		            {
//		                suc = root.right;
//		                while (suc.left != null)
//		                    suc = suc.left;
//		            }
//		 
//		            if (root.left != null)
//		            {
//		                pre = root.left;
//		                while (pre.right != null)
//		                    pre = pre.right;
//		            }
//		            return;
//		        }
//		 
//		        else if (root.key < key)
//		        {
//		            pre = root;
//		            root = root.right;
//		        }
//		 
//		        else
//		        {
//		            suc = root;
//		            root = root.left;
//		        }
//		    }
//		    if (pre != null)
//		        System.out.println("Predecessor is " +pre.key);
//		    else
//		        System.out.print("-1");
//		 
//		    if (suc != null)
//		        System.out.print("Successor is " + suc.key);
//		    else
//		        System.out.print("-1");
//		
//		}
//	}
//		
//
//
//
//
//	public class BinaryTrees 
//	{
//		public static void main(String args[])
//		{
//			Scanner sc=new Scanner(System.in);
//			int x;
//			Tree t1=new Tree();
//			do
//			{
//				System.out.println("");
//				System.out.println("1. Insert");
//				System.out.println("2. Insert recursive");
//				System.out.println("3. Node count");
//				System.out.println("4. Leaf count");
//				System.out.println("5. Internal node count");
//				System.out.println("6. preOrder traversal");
//				System.out.println("7. inOrder traversal");
//				System.out.println("8. postOrder traversal");
//				System.out.println("9. Find predecessor and successor");
//				System.out.println("10. Search Recursively");
//				System.out.println("11. Least element");
//				System.out.println("12. Largest element");
//				System.out.println("13. Find path of element");
//				System.out.println("14. Delete an element");
//	        	x = sc.nextInt();
//				switch(x)
//				{
//				case 1: System.out.println("Enter the data to insert: ");
//						t1.insert(t1.root,sc.nextInt());
//						break;
//				case 2: System.out.println("Enter the data to insert: ");
//						t1.root=t1.insertRec(t1.root,sc.nextInt());
//						break;
//				case 3: t1.count=0;
//						t1.Count(t1.root);
//						System.out.println("The node count is: "+t1.count);
//						break;
//				case 4: t1.count=0;
//						t1.countOfLeafs(t1.root);
//						System.out.println("The leaf count is: "+t1.count);
//						break;
//				case 5: t1.count=0;
//						t1.countOfInternal(t1.root);
//						System.out.println("The internal node count is: "+t1.count);
//						break;
//				case 6: System.out.println("Preorder traversal: ");
//						t1.preOrder(t1.root);
//						break;
//				case 7: System.out.println("inorder traversal: ");
//						t1.inOrder(t1.root);
//						break;
//				case 8: System.out.println("postorder traversal: ");
//						t1.postOrder(t1.root);
//						break;
//				case 9: System.out.println("Enter a number: ");
//						t1.findPreSuc(t1.root,sc.nextInt());
//						break;
//				case 10: System.out.println("Enter an element to be searched: ");
//						System.out.println(t1.SearchRec(t1.root,sc.nextInt()));
//						break;
//				case 11: System.out.println("Least element: ");
//						t1.least(t1.root);
//						break;
//				case 12: System.out.println("Largest element: ");
//						t1.largest(t1.root);
//						break;
//				case 13: System.out.println("Enter element to find its path: ");
//						 System.out.println(t1.Path(t1.root,sc.nextInt()));
//						break;
//				case 14: System.out.println("Enter element to delete: ");
//				 		 t1.deleteKey(sc.nextInt());
//				 		 break;
//				default: System.out.println("Invalid");	
//				
//				}
//			}
//			while(x!=10);
//		}
//
//	}
//	Tree()
//	{
//		root=null;
//	}
//	TNode insert(TNode root, int key)
//	{
//		TNode nn=new TNode(key);
//		TNode x=root;
//		TNode y=null;
//		while(x!=null) 
//		{
//			y=x;
//			if(key<x.key)
//			{
//				x=x.left;
//			}
//			else
//			{
//				x=x.right;
//			}
//		}
//		if(y==null)
//		{
//			y=nn;
//		}
//		else if(key<y.key)
//		{
//			y.left=nn;
//			
//		}
//		else
//		{
//			y.right=nn;
//		}
//		return y;
//	}
//	
//	TNode insertRec(TNode r,int key)
//	{
//		if(r==null)
//		{
//			r=new TNode(key);
//			return r;
//		}
//		if(key<r.key)
//		{
//			r.left=insertRec(r.left,key);
//		}
//		else if(key>r.key)
//		{
//			r.right=insertRec(r.right,key);
//		}
//		return r;
//	}
//	
//	void Display()
//	{
//		
//	}
//	
//	void preOrder(TNode root)
//	{
//		if(root!=null)
//		{
//			System.out.println(root.key);
//			preOrder(root.left);
//			preOrder(root.right);
//		}
//	}
//	
//	void postOrder(TNode r)
//	{
//		if(r!=null)
//		{
//			postOrder(r.left);
//			postOrder(r.right);
//			System.out.println(r.key);
//		}
//	}
//	
//	void inOrder(TNode r)
//	{
//		if(r!=null)
//		{
//			inOrder(r.left);
//			System.out.println(r.key);
//			inOrder(r.right);
//		}
//	}
//	
//	void Count(TNode r)
//	{
//		if(r!=null)
//		{
//			Count(r.left);
//			Count(r.right);
//			count++;
//		}
//	}
//
//	void countOfLeafs(TNode r)
//	{
//		if(r!=null)
//		{
//			inOrder(r.left);
//			if((r.left==null) && (r.right==null))
//			{
//				count++;
//				inOrder(r.right);
//			}
//		}
//		
//	}
//	
//	void countOfInternal(TNode r)
//	{
//		if(r!=null)
//		{
//			inOrder(r.left);
//			if((r.left!=null) || (r.right!=null))
//			{
//				count++;
//				inOrder(r.right);
//			}
//		}
//		
//	}
//	
//	void least(TNode r)
//	{
//		TNode p=r;
//		while(r!=null)
//		{
//			p=r;
//			r=r.left;
//		}
//		System.out.println(p.key);
//	}
//	
//	void largest(TNode r)
//	{
//		TNode p=r;
//		while(r!=null)
//		{
//			p=r;
//			r=r.right;
//		}
//		System.out.println(p.key);
//	}
//	
//	boolean Path(TNode r, int key) 
//	{ 
//		while (r != null) 
//		{ 
//			System.out.println(r.key); //count++;
//			if (key > r.key) 
//			{
//				r = r.right; 
//			}
//			else if (key < r.key) 
//			{
//				r = r.left; 
//			}
//			else
//			{
//				return true; 
//			}
//		} 
//		return false; 
//	} 
//
//	
//	int Height(TNode r)
//	{
//		if(r==null)
//		{
//			return 0;
//		}
//		else
//		{
//			int left_depth=Height(r.left);
//			int right_depth=Height(r.right);
//			if (left_depth>right_depth)
//			{
//				return(left_depth+1);
//			}
//			else
//			{
//				return(right_depth+1);
//			}
//
//		}
//	}
//	
//
//	
//	boolean SearchRec(TNode T, int key)
//	{
//		boolean flag = false;
//		TNode temp = T;
//		if (T==null) 
//			{
//			return flag;
//			}
//			else 
//			{  
//				if (key == temp.key)
//				{ 
//					flag= true;
//					return flag; 
//					}
//				else if (key < temp.key)
//				{ 
//					return(SearchRec(temp.left, key)); 
//				}
//				else
//				{ 
//					return(SearchRec(temp.right, key)); 
//				}
//			}
//	}
//
//	
//	
////	public boolean deletenode(int value) //Non recursive
////	{ 
////		int i=0;
////		TNode current = root;
////		TNode parent = root; 
////		boolean isLeftChild= false;
////		while(current.key!= value)
////		{ 
////			parent = current;
////			if(value < current.key)
////			{
////				// Move to the left if searched value is less 
////				current = current.left;
////				isLeftChild= true; 
////			}
////			else
////			{ 
////				// Move to the right if searched value is >=
////				current = current.right;
////				isLeftChild= false; 
////				
////			}
////			if(current == null)
////			{
////				return false; 
////				
////			}
////		}// if reached here means node to be deleted is found
////		// Leaf node deletion case
////		if(current.left== null && current.right== null)
////		{ 
////			System.out.println("Leaf node deletion case");
////			// if the leaf node is a root node is to be deleted
////			if(current == root)
////			{ 
////				root = null; 
////			}
////			// the leaf node which is a left child of parent node
////			else if(isLeftChild)
////			{ 
////				parent.left= null;
////			}
////			// the leaf node which is a right child of parent node
////			else
////			{ 
////				parent.right= null; 
////			}
////		}
////		// Node to be deleted has one child case
////		// Node to be deleted has right child only
////		else if(current.left== null)
////		{
////			System.out.println("One right child deletion case");
////			// if root node(to be deleted) is the node with  only right child
////			if(current == root)
////			{ 
////				root = current.right; 
////				}
////			// if deleted node(with only right child) is a left child of the parent
////			else if(isLeftChild)
////			{ 
////				parent.left= current.right; 
////			}
////			// if deleted node(with only right child  is a  right child of the parent
////			else
////			{ 
////				parent.right= current.right; 
////			}
////		} 
////		// Node to be deleted has only left child 
////		else if(current.right== null)
////		{ 
////			System.out.println("One left child deletion case");
////			if(current == root)
////			{ 
////				root = current.left; 
////			} 
////			// if deleted node is left child of the parent
////			else if(isLeftChild)
////			{ 
////				parent.left= current.left; 
////			}
////			// if deleted node is right child of the parent
////			else
////			{ 
////				parent.right= current.left; 
////			}
////		} 
////		else
////		{ 
////			System.out.println("Two children deletion case");
////			// find in-order predecessor of the node to be deleted 
////			TNode predecessor = current;
////			TNode pred_parent=current;
////			predecessor=predecessor.left;
////			boolean  predisleft=true;
////			while (predecessor.right!=null)
////			{ 
////				pred_parent=predecessor;
////				predisleft=false;predecessor=predecessor.right;
////			}
////			current.key= predecessor.key;
////			parent=pred_parent;   
////			// to repeat the process for the predecessor node which is a  leaf/node with one child
////			current=predecessor;
////			isLeftChild=predisleft;
////			System.out.println(current.key);
////			i=1;
////			continue label; 
////		}      
////	return true; 
////}
//	
//	void findPreSuc(TNode root, int key)
//	{
//
//	    if (root == null)
//	        return;
//	 
//	    while (root != null)
//	    {
//	 
//	        if (root.key == key)
//	        {
//
//	            if (root.right != null)
//	            {
//	                suc = root.right;
//	                while (suc.left != null)
//	                    suc = suc.left;
//	            }
//	 
//	            if (root.left != null)
//	            {
//	                pre = root.left;
//	                while (pre.right != null)
//	                    pre = pre.right;
//	            }
//	            return;
//	        }
//	 
//	        else if (root.key < key)
//	        {
//	            pre = root;
//	            root = root.right;
//	        }
//	 
//	        else
//	        {
//	            suc = root;
//	            root = root.left;
//	        }
//	    }
//	    if (pre != null)
//	        System.out.println("Predecessor is " +pre.key);
//	    else
//	        System.out.print("-1");
//	 
//	    if (suc != null)
//	        System.out.print("Successor is " + suc.key);
//	    else
//	        System.out.print("-1");
//	
//	}
//}
//	
//
//
//
//
//public class BinaryTrees 
//{
//	public static void main(String args[])
//	{
//		Scanner sc=new Scanner(System.in);
//		int x;
//		Tree t1=new Tree();
//		do
//		{
//			System.out.println("");
//			System.out.println("1. Insert");
//			System.out.println("2. Insert recursive");
//			System.out.println("3. Node count");
//			System.out.println("4. Leaf count");
//			System.out.println("5. Internal node count");
//			System.out.println("6. preOrder traversal");
//			System.out.println("7. inOrder traversal");
//			System.out.println("8. postOrder traversal");
//			System.out.println("9. Find predecessor and successor");
//			System.out.println("10. Search Recursively");
//			System.out.println("11. Least element");
//			System.out.println("12. Largest element");
//        	x = sc.nextInt();
//			switch(x)
//			{
//			case 1: System.out.println("Enter the data to insert: ");
//					t1.insert(t1.root,sc.nextInt());
//					break;
//			case 2: System.out.println("Enter the data to insert: ");
//					t1.root=t1.insertRec(t1.root,sc.nextInt());
//					break;
//			case 3: t1.count=0;
//					t1.Count(t1.root);
//					System.out.println("The node count is: "+t1.count);
//					break;
//			case 4: t1.count=0;
//					t1.countOfLeafs(t1.root);
//					System.out.println("The leaf count is: "+t1.count);
//					break;
//			case 5: t1.count=0;
//					t1.countOfInternal(t1.root);
//					System.out.println("The internal node count is: "+t1.count);
//					break;
//			case 6: System.out.println("Preorder traversal: ");
//					t1.preOrder(t1.root);
//					break;
//			case 7: System.out.println("inorder traversal: ");
//					t1.inOrder(t1.root);
//					break;
//			case 8: System.out.println("postorder traversal: ");
//					t1.postOrder(t1.root);
//					break;
//			case 9: System.out.println("Enter a number: ");
//					t1.findPreSuc(t1.root,sc.nextInt());
//					break;
//			case 10: System.out.println("Enter an element to be searched: ");
//					System.out.println(t1.SearchRec(t1.root,sc.nextInt()));
//					break;
//			case 11: System.out.println("Least element: ");
//					t1.least(t1.root);
//					break;
//			case 12: System.out.println("Largest element: ");
//					t1.largest(t1.root);
//					break;
//			default: System.out.println("Invalid");		
//			}
//		}
//		while(x!=10);
//	}
//
//}