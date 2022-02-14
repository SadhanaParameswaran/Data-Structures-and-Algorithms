package Programs;
class BinaryTreeMain 
{
	class Node
	{
		String key;
		Node left, right,temp;

		public Node(String item)
		{
			key = item;
			left = right = null;
		}
	}
	Node root;	
	BinaryTreeMain()
	{
		root = null;
	}	
	void insert(String key)
	{
		root = insertRec(root, key);
	}
	Node insertRec(Node root, String key)
	{		
		if (root == null)
		{
			root = new Node(key);
			return root;
		}		
		if (root.key.compareTo(key)>0)    
		{
			root.left = insertRec(root.left, key);
		}
		else if (root.key.compareTo(key)<0)       
		{
			root.right = insertRec(root.right, key);
		}		
		return root;
	}	
	// inorder traversal 
	void inorder()
	{
		inorderRec(root);
	}		
	void inorderRec(Node root)
	{
		if (root != null) 
		{
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}	    
    //preorder traversal
	void preorder()
	{
  		preorderRec(root);
	}
	
	void preorderRec(Node root)
	{
		if (root != null) 
		{
			System.out.println(root.key);
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}	
	static String OneChild;	
	Node All_oneChild_path(Node root,String M) 
	{
		if(root.key==M) 
		{
			System.out.println(root.key); 
		}
		else 
		{
			System.out.println(root.key);
			if (root.key.compareTo(M)>0)     ////////////////
			{   
				if(root.left==null) 
				{
					OneChild = root.key;
				}
				root.left = All_oneChild_path(root.left, M);
			}
			else if (root.key.compareTo(M)<0)         /////////////
			{   
				if(root.left==null) 
				{
					OneChild = root.key;
				}
				root.right = All_oneChild_path(root.right, M);
			}					 
		}
    	return root;
	}		
	void Child(String M)
	{
		root = All_oneChild_path(root, M);
	}
    public static void main(String[] args)
	{
		BinaryTreeMain tree = new BinaryTreeMain();
		
		tree.insert("judy");
		tree.insert("bill");
		tree.insert("mary");
		tree.insert("alice");
		tree.insert("fred");
		tree.insert("tom");
		tree.insert("dave");
		tree.insert("jane");
		tree.insert("joe");
		tree.preorder();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("All nodes:-");
		tree.Child("joe");
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(OneChild);

	}
}