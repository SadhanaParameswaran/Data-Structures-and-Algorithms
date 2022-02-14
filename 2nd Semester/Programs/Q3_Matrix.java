package Programs; 
import java.io.*;    
import java.util.Scanner;
public class Q3_Matrix 
{
	public static void main(String[] args) 
	{
		int row = 3;
		int column = 3;
		int sum = 0;
		int row_sum = 0;
		int column_sum = 0;
		int diagonal_sum = 0;
		int [][] a = new int[row][column];
		try
		{
			File obj = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q3_Input.txt");
			Scanner sc = new Scanner(obj);
			FileWriter f1 = new FileWriter("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q3_Output.txt");
			
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			
			//find sum
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					sum = sum + a[i][j];
				}
			}
			System.out.println("Sum of all elements: "+sum);
			System.out.println();
			f1.write("Sum of all elements: "+sum);
            f1.write("\n");
			
			//find Row sum
			for(int i=0; i<3; i++)
			{
				row_sum = 0;
				for(int j=0; j<3; j++)
				{
					row_sum = row_sum + a[i][j];
				}
				System.out.println((i+1)+" row's sum is: " + row_sum);
				f1.write((i+1)+" row's sum is: " + row_sum);
	            f1.write("\n");
			}
			System.out.println();
			f1.write("\n");
			
			//find Column sum
			for(int i=0; i<3; i++)
			{
				column_sum = 0;
				for(int j=0; j<3; j++)
				{
					column_sum = column_sum + a[j][i];
				}
				System.out.println((i+1)+" column's sum is: " + column_sum);
				f1.write((i+1)+" column's sum is: " + column_sum);
	            f1.write("\n");
			}
			System.out.println();
			f1.write("\n");
			
			//find diagonal sum
			for(int i=0; i<3; i++)
		    { 
				for(int j=0; j<3; j++)
		        { 
		        	if(i==j) //this condition checks for diagonal
		        	{
		        		diagonal_sum = diagonal_sum + a[j][i];
		        	}
		        }
		    }
			System.out.println("The Diagonal sum is: " + diagonal_sum);
			System.out.println();
			f1.write("The Diagonal sum is: " + diagonal_sum);
            f1.write("\n");
            f1.write("\n");
			sc.close();
			
			System.out.println("The matrix is: ");
			f1.write("The matrix is: ");
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					//f.write(StringvalueOf(a[i][j]));
					System.out.print(a[i][j]+ " ");
					f1.write(a[i][j]+ " ");
				}
				System.out.println();
				f1.write("\n");
			}
		}
		catch (Exception e) 
	    {
	      System.out.println("An error occurred.");
	    }
	}
}

