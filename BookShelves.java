import java.util.*;
import java.io.*;
class BookShelves
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

    public static void main(String []args)throws Exception
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(next());
        int K=Integer.parseInt(next());
        int shelf1[]=new int [N];
        int s1[]=new int [N];
        int s2[]=new int [N];
        for(int i=0;i<N;i++)
        {
            shelf1[i]=Integer.parseInt(next());
        }
        int shelf2[]=new int [N];
        for(int i=0;i<N;i++)
        {
            shelf2[i]=Integer.parseInt(next());;
        }
        System.arraycopy(shelf1,0,s1,0,N);
        System.arraycopy(shelf2,0,s2,0,N);
        Arrays.sort(shelf1);
        Arrays.sort(shelf2);
        Arrays.sort(s1);
        Arrays.sort(s2);
        if(N==1)
        {
            System.out.println(s1[0]+s2[0]);
        }
        else
        {
            a:
            for(int i=0;i<K;i++)
            {
                if(s1[i]>=s2[N-1-i])
                {
                    break a;
                }
                else
                {
                    int temp=s1[i];
                    s1[i]=s2[N-1-i];
                    s2[N-1-i]=temp;
                }
            }	
            b:
            for(int i=0;i<K;i++)
            {
                if(shelf2[i]>=shelf1[N-1-i])
                {
                    break b;
                }
                else
                {
                    int temp=shelf2[i];
                    shelf2[i]=shelf1[N-1-i];
                    shelf1[N-1-i]=temp;
                }
            }
            Arrays.sort(shelf1);
            Arrays.sort(shelf2);
            Arrays.sort(s1);
            Arrays.sort(s2);
            System.out.println(Math.min(shelf2[N-1]+shelf1[N-1],s1[N-1]+s2[N-1]));
        }
    }
}