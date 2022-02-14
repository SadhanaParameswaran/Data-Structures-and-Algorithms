package Programs;

public class Q15_UnionFind_QuickFind
{
	private int[] id;
	
	public Q15_UnionFind_QuickFind(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
		{
			if(id[i] == pid)
			{
				id[i] = qid;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Q15_UnionFind_QuickFind quickf = new Q15_UnionFind_QuickFind(5);
		System.out.println("Is 3 and 4 connected?: "+quickf.connected(3, 4));
		System.out.println("Lets unionize 3 and 4");
		quickf.union(3, 4);
		System.out.println("Is 3 and 4 connected?: "+quickf.connected(3, 4));
	}

}
