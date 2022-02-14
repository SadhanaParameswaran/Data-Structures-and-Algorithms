package Programs;
import java.util.*;
class PageRank
{
	int n;
	int arr[][];
	double rank[];
	PageRank(int n)
	{
		this.n = n;
		arr = new int[n][n];
		for(int i = 0; i < n; i++) 
			arr[i] = new int[n];
		rank = new double[n];
		for(int i = 0; i < n; i++) 
			rank[i] = 1/4d;
	}
	void adj_matrix(Scanner scan) 
	{
		int src;
		int dest;
		do 
		{
			System.out.print("Enter source node(enter -1 to stop) ");
			src = scan.nextInt();
			if(src == -1)
				break;
			System.out.print("Enter destination node ");
			dest = scan.nextInt();
			arr[src][dest] = 1;
		}
		while(src != -1);
	}
	void print_matrix() 
	{
		System.out.println("\nThe adjacency matrix is:");
		for(int i = 0; i < n; i++) 
		{
			for(int j = 0; j < n; j++) 
			{
				System.out.print(arr[i][j]+ " ");
			}		
			System.out.println();
		}
	}
	void page_rank() 
	{
		int p[] = new int[n];
		double page_rank[] = new double[n];
		double c_out;
		int node;
		for(int k = 0; k < n; k++) 
		{
			for(int i = 0; i < n; i++)
				p[i] = 0;
			node = k;
			for(int i = 0; i < n; i++) 
			{ 
				if(arr[i][node] == 1) 
					p[i] = 1;
			}	
			for(int i = 0; i < n; i++) 
			{
				c_out = 0;
				if(p[i] == 1) 
				{
					for(int j = 0; j < n; j++) 
					{
						if(arr[i][j] == 1) 
							c_out += 1;	
					}
					page_rank[node] += rank[i]/c_out;	
				}	
			}	
		}
		int index[] = new int[n];
		for(int i = 0; i < n; i++)
			index[i] = i + 1;
			for(int i = 0; i < n; i++) 
			{
				for(int j = i+1; j < n; j++) 
				{
					int t;
					if(page_rank[j] > page_rank[i]) 
					{
						t = index[i];
						index[i] = index[j];
						index[j] = t;
					}	
				}
			}
			System.out.println("Edge|Iteration 1|Page Rank");
			for(int i = 0; i < n; i++) 
				System.out.println(i+"|"+page_rank[i]+"|"+index[i]);
	}
}
public class Q13_PageRank 
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices in the array: ");
		int n = sc.nextInt();
		PageRank p = new PageRank(n);
		p.adj_matrix(sc);
		p.page_rank();		
	}
}
