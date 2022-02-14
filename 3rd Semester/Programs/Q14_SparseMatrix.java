package Programs;

import java.util.Scanner;

public class Q14_SparseMatrix 
{

	int MAX = 100;
	int data[][] = new int[MAX][3]; //for column, row and value

	int row, col, len;

	public Q14_SparseMatrix(int r, int c)
	{

		row = r;
		col = c;
		len = 0;
	}

	public void insert(int r, int c, int val)
	{
		if (r > row || c > col) 
		{
         System.out.println("Array out of bounds");
		}	

		else 
		{
			data[len][0] = r;
			data[len][1] = c;
			data[len][2] = val;

			len++;
		}
	}

	public void add(Q14_SparseMatrix b)
	{
		if (row != b.row || col != b.col) 
		{
			System.out.println("Irregular dimensions, Matrices cannot be added");
		}

		else 
		{

			int apos = 0, bpos = 0;
			Q14_SparseMatrix result = new Q14_SparseMatrix(row, col);

			while (apos < len && bpos < b.len) 
			{
				if (data[apos][0] > b.data[bpos][0] || (data[apos][0] == b.data[bpos][0] && 
                data[apos][1] > b.data[bpos][1]))

				{
					result.insert(b.data[bpos][0], b.data[bpos][1], b.data[bpos][2]);
					bpos++;
				}
				
				else if (data[apos][0] < b.data[bpos][0] || (data[apos][0] == b.data[bpos][0] && data[apos][1] < b.data[bpos][1]))
				{
					result.insert(data[apos][0], data[apos][1], data[apos][2]);
					apos++;
				}

				else 
				{
					int addedval = data[apos][2] + b.data[bpos][2];

					if (addedval != 0)
						result.insert(data[apos][0], data[apos][1], addedval);

					apos++;
					bpos++;
				}
         }

         while (apos < len)
             result.insert(data[apos][0], data[apos][1], data[apos++][2]);

         while (bpos < b.len)
             result.insert(b.data[bpos][0], b.data[bpos][1], b.data[bpos++][2]);

         result.display();
		}
	}

	public Q14_SparseMatrix transpose()
	{
		Q14_SparseMatrix result = new Q14_SparseMatrix(col, row);

		result.len = len;

		int count[] = new int[col + 1];

		for (int i = 1; i <= col; i++)
			count[i] = 0;

		for (int i = 0; i < len; i++)
			count[data[i][1]]++;

		int[] index = new int[col + 1];

		index[1] = 0;

		for (int i = 2; i <= col; i++)

			index[i] = index[i - 1] + count[i - 1];

		for (int i = 0; i < len; i++) 
		{
			int rpos = index[data[i][1]]++;

			result.data[rpos][0] = data[i][1];
			result.data[rpos][1] = data[i][0];
			result.data[rpos][2] = data[i][2];
		}
		
		return result;
	}

	public void multiply(Q14_SparseMatrix b)
	{

		if (col != b.row) 
		{
         System.out.println("Irregular dimensions, Matrices cannot be multiplied");
         return;
		}
		b = b.transpose();
		int apos, bpos;

		Q14_SparseMatrix result = new Q14_SparseMatrix(row, b.row);

		for (apos = 0; apos < len;) 
		{
			int r = data[apos][0];

			for (bpos = 0; bpos < b.len;) 
			{
				int c = b.data[bpos][0];

				int tempa = apos;
				int tempb = bpos;

				int sum = 0;

				while (tempa < len && data[tempa][0] == r && tempb < b.len && b.data[tempb][0] == c) 
				{

					if (data[tempa][1] < b.data[tempb][1])

						tempa++;

					else if (data[tempa][1] > b.data[tempb][1])

						tempb++;
					else
						sum += data[tempa++][2] * b.data[tempb++][2];
				}

				if (sum != 0)
					result.insert(r, c, sum);

				while (bpos < b.len && b.data[bpos][0] == c)
					bpos++;
			}

			while (apos < len && data[apos][0] == r)
				apos++;
		}

		result.display();
	}


	public void display()
	{
		System.out.println("Dimension: " + row + "x" + col);
		System.out.println("Sparse Matrix: \nRow Column Value");

		for (int i = 0; i < len; i++) 
		{

         System.out.println(data[i][0] + "     " + data[i][1] + "     " + data[i][2]);
		}
	}

	public static void main(String args[])
	{

		// create two sparse matrices and insert values
		Q14_SparseMatrix a = new Q14_SparseMatrix(4, 4);
		Q14_SparseMatrix b = new Q14_SparseMatrix(4, 4);

		a.insert(1, 2, 10);
		a.insert(1, 4, 12);
		a.insert(3, 3, 5);
		a.insert(4, 1, 15);
		a.insert(4, 2, 12);
		b.insert(1, 3, 8);
		b.insert(2, 4, 23);
		b.insert(3, 3, 9);
		b.insert(4, 1, 20);
		b.insert(4, 2, 25);

		Scanner sc=new Scanner(System.in);
		int x;
		do
		{
			System.out.println("\nEnter your choice: ");
			System.out.println("1. Addition");
			System.out.println("2. Multiplication");
			System.out.println("3. Transpose a matrix");
			System.out.println("4. Transpose b matrix");
			System.out.println("5. Display matrix");
			x = sc.nextInt();            
			switch(x)
			{
				case 1: System.out.println("Added matrix (a and b): ");
                 		a.add(b);
                 		break; 
				case 2: System.out.print("Multiplied matrix (a and b): ");
                 		a.multiply(b);
                 		System.out.println();
                 		break;
				case 3: System.out.println("The transpose of matrix a is:");
						Q14_SparseMatrix atranspose = a.transpose();
  				 		atranspose.display();
  				 		System.out.println();
  				 		break;
				case 4: System.out.print("The transpose of matrix b is: ");
						Q14_SparseMatrix btranspose = b.transpose();
         				btranspose.display();
         				System.out.println();
         				break; 
				case 5: System.out.print("The sparse matrix a: ");
 						a.display();
 						System.out.println();
 						System.out.print("The sparse matrix b: ");
 						b.display();
 						System.out.println();
 						break; 
				default: System.out.println("Invalid input");
			}
		}
     
		while(x!=10);
		sc.close();

	}
}
