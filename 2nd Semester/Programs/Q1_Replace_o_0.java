package Programs;
import java.io.*; 
import java.util.Scanner;
public class Q1_Replace_o_0
{
	public static void main(String[] args) 
	{
		try 
	    {
	      File Obj = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q1_Input.txt");
	      File Obj1 = new File("C:\\Softwares\\Eclipse\\Programs\\DSA 1\\src\\Programs\\Q1_Output.txt");
	      Scanner sc = new Scanner(Obj);
	      String data = sc.nextLine();
	      String replaceString = data.replace("o","*"); 
	      System.out.println(replaceString);
	      FileWriter f1 = new FileWriter(Obj1);
	      f1.write(replaceString);
	      f1.close();
	      sc.close();
	    }
	    catch (Exception e) 
	    {
	      System.out.println("An error occurred.");
	    }
	}
}