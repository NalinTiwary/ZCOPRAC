import java.util.*;
import java.io.*;
class SingingTour
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
    static StringTokenizer st; 
    static String next() throws Exception
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            st = new StringTokenizer(br.readLine()); 
        } 
        return st.nextToken(); 
    }

    static int nextInt() throws Exception
    {
        return Integer.parseInt(next());
    }

    static long nextLong() throws Exception
    {
        return Long.parseLong(next());
    }

    public static void main(String args[]) throws Exception
    {
        int T=0;
        T=nextInt();
        while(T>0)
        {
            int N=nextInt();
            long low[]=new long[N];
            long high[]=new long[N];
            long score[]=new long[N];
            for(int i=0;i<N;i++)
            {
                score[i]=0;
                low[i]=nextLong();
                high[i]=nextLong();
                low[i]=(low[i]*100000000)+i;
                high[i]=(high[i]*100000000)+i;
            }		    
            Arrays.sort(low);
            Arrays.sort(high);
            for(int i=0;i<N;i++)
            {
                int a=(int)(low[i]%100000000);
                int b=(int)(high[i]%100000000);
                score[a]+=N-1-i;
                score[b]+=i;
            }
            for(int i=0;i<N;i++)
            {
                System.out.println(score[i]);
            }
            T--;
        }
    }
}