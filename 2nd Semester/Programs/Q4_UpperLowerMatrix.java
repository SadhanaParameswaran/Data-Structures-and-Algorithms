package Programs;
import java.util.Scanner; 
import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class Q4_UpperLowerMatrix
{
	public static void main(String[] args) 
	{
		int row = 3;
		int column = 3;
		int [][] a = new int[row][column];
		try
		{
			File obj = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q4_Input.txt");
			Scanner sc = new Scanner(obj);
			
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			//printing initial matrix
			System.out.println("The matrix is: ");
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					//f.write(StringvalueOf(a[i][j]));
					System.out.print(a[i][j]+ " ");
				}
				System.out.println();
			}
			if(row != column)
			{    
	            System.out.println("Matrix should be a square matrix");    
	        }    
	        else 
	        {    
	        	FileWriter f1 = new FileWriter("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q4_Output.txt");
	            //Performs required operation to convert given matrix into upper triangular matrix   
	        	System.out.println();
	            System.out.println("Upper triangular matrix: ");    
	            f1.write("Upper triangular matrix: ");
	            f1.write("\n");
	            for(int i = 0; i < row; i++)
	            {    
	                for(int j = 0; j < column; j++)
	                {    
	                  if(i > j)   
	                  {
	                    System.out.print("0 ");    
	                    f1.write("0 ");
	                  }
	                  else    
	                  {
	                    System.out.print(a[i][j] + " ");  
	                    f1.write(a[i][j]+" ");
	                  }
	                }    
	                System.out.println(); 
	                f1.write("\n");
	            }    
	            
	            System.out.println();
	            System.out.println("Lower triangular matrix: ");   
	            f1.write("\n"); 
	            f1.write("Lower triangular matrix: ");
	            f1.write("\n"); 
				for(int i = 0; i < row; i++)
				{    
					for(int j = 0; j < column; j++)
					{    
						if(j > i)    
						{
							System.out.print("0 ");  
							f1.write("0 ");
						}
						else    
						{
							System.out.print(a[i][j] + " "); 
							f1.write(a[i][j]+" ");
						}
					}
					System.out.println();
		            f1.write("\n");
                }    
				f1.close();
	        }
			sc.close();
		}
		catch (Exception e) 
	    {
	      System.out.println("An error occurred.");
	    }
	}
}

