package Programs;
public class Q5_Frequency 
{
    public static void main(String[] args) 
    {    
        int [][] arr = {{1,3,2},{2,4,1},{2,3,5}}; 
        int [] arr1d = new int[arr.length*arr[0].length];
        int [] fr = new int [arr.length*arr[0].length]; 
        int i, j, x = 0, count=0;
        for(i = 0; i < arr.length; i++)
        {    
            for(j=0;j<  arr[0].length;j++)
            {
                arr1d[x]=arr[i][j];
                x++;
            }
        } 
        for(i=0;i<arr.length*arr[0].length;i++)
        {
            count=1;
            for(j=i+1;j<arr.length*arr[0].length;j++)
            {
                if(arr1d[i]==arr1d[j])
                {
                    ++count;
                    arr1d[j]=-1;
                }
            }
            if(arr1d[i]!=-1)
            fr[i]=count;
        }
        System.out.println("---------------------");  
        System.out.println(" Element | Frequency");  
        System.out.println("---------------------");  
        for(i = 0; i < fr.length; i++)
        {  
            if(arr1d[i] != -1)  
            {
                System.out.println("    " + arr1d[i] + "    |    " + fr[i]);  
            }
        }  
        System.out.println("---------------------");  
    }
}