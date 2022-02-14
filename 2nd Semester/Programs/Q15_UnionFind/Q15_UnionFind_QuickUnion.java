package Programs;

public class Q15_UnionFind_QuickUnion
{
	private int[] parent;
	
	public Q15_UnionFind_QuickUnion(int n)
	{
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
	}
	
	public int find(int p)
	{
		while (p != parent[p])
			p = parent[p];
		return p;
	}
	
	public void union(int p, int q)
	{
		int root1 = find(p);
		int root2 = find(q);
		parent[root1] = root2;
	}
	
	public static void main(String[] args)
	{
		Q15_UnionFind_QuickUnion quicku = new Q15_UnionFind_QuickUnion(5);
		System.out.println("Find at index 3: "+quicku.find(3));
		System.out.println("Find at index 4: "+quicku.find(4));
		System.out.println("Lets unionize 3 and 4");
		quicku.union(3, 4);
		System.out.println("Value at index 3: "+quicku.find(3));
		System.out.println("Value at index 3: "+quicku.find(4));
		
	}

}
