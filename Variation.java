import java.util.*;
import java.io.*;
class Variation
{
    static BufferedReader br;
    static StringTokenizer st;
    private static String next() throws Exception
    {
        while(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    public static void main(String args[]) throws Exception
    {
       br=new BufferedReader(new InputStreamReader(System.in));
       int N=Integer.parseInt(next());
       int K=Integer.parseInt(next());
       int arr[]=new int[N];
       for(int i=0;i<N;i++)
       {
           arr[i]=Integer.parseInt(next());
       }
       int count=0;
       Arrays.sort(arr);
       a:
       for(int i=N-1;i>=0;i--)
       {
           if(arr[i]<arr[0]+K)
           {
               break a;
           }
           else
           {
	           b:
	           for(int j=i-1;j>=0;j--)
	           {
	               if(Math.abs(arr[i]-arr[j])>=K)
	               {
	                   count+=j+1;
	                   break b;
	               }
	           }
           }
       }
       System.out.println(count);
    }
}