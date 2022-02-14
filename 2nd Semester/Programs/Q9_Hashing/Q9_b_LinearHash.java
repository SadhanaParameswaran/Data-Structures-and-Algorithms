package Programs;
import java.util.Scanner;
public class Q9_b_LinearHash 
{
    public static void main(String[] args) 
    {
        int n=10;
        int loopcount;
        int a[]=new int[n];
        for(int zero=0;zero<a.length;zero++)
            a[zero]=-1;
        Scanner s= new Scanner(System.in);
        int key,index;
        while(true)
        {
            System.out.println("1)Insert\n2)Delete\n3)search\n4)Display hash\n5)exit");
            int choice=s.nextInt();
            switch(choice)
            {
                case 1: System.out.println("Enter the key to be inserted");
                        key=s.nextInt();
                        loopcount=0;
                        index=key % 10;
                        if (a[index]==-1)
                            a[index]=key;
                        else
                        {
                            while(loopcount!=n)
                            {
                                if(index!=n-1)
                                {    
                                    index++;
                                    if (a[index]==-1)
                                    {
                                        a[index]=key;
                                        break;
                                    }
                                }
                                else
                                {
                                    index=0;
                                    if (a[index]==-1)
                                    {
                                        a[index]=key;
                                        break;
                                    }
                                }
                                loopcount++;
                            }
                        }
                        if(loopcount==n)
                        {
                            System.out.println("No space to insert");
                        }
                        break;

                case 2: System.out.println("Enter element to be deleted");
                        key=s.nextInt();
                        index=key%10;
                        loopcount=0;
                        if(a[index]==key)
                            a[index]=-1;
                        else
                        {
                            while(loopcount!=n)
                            {
                                if(index!=n-1)
                                {    
                                    index++;
                                    if (a[index]==key)
                                    {
                                        a[index]=-1;
                                        break;
                                    }
                                }
                                else
                                {
                                    index=0;
                                    if (a[index]==key)
                                    {
                                        a[index]=-1;
                                        break;
                                    }
                                }
                                loopcount++;
                            }
                            if(loopcount==n)
                                System.out.println("Element "+key+" not found");
                        }
                        break;

                    case 3: System.out.println("Enter element to be searched");
                            key=s.nextInt();
                            index=key%10;
                            loopcount=0;
                            if(a[index]==key)
                                System.out.println("The element "+key+" was  found in position: "+index);
                            else
                            {
                                while(loopcount!=n)
                                {
                                    if(index!=n-1)
                                    {    
                                        index++;
                                        if (a[index]==key)
                                        {
                                            System.out.println("The element "+key+" was  found in position: "+index);
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        index=0;
                                        if (a[index]==key)
                                        {
                                            System.out.println("The element "+key+" was  found in position: "+index);
                                            break;
                                        }
                                    }
                                    loopcount++;
                                }
                                if(loopcount==n)
                                    System.out.println("Element "+key+" not found");
                            }
                            break;

                    case 4:int i=0;
                            while(i!=10)
                            { 
                                if (a[i]!=-1)
                                    System.out.println("location/ bucket "+i+"----->"+a[i]);
                                else
                                    System.out.println("location/ bucket "+i+"----->null");
                            i++;
                            }
                            break;
                    case 5: s.close();
                            System.exit(0);
            }
        }          
    }
}
