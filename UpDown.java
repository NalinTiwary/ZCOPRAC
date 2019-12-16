import java.util.*;
import java.io.*;
class UpDown
{
    static BufferedReader br;
    static StringTokenizer st;
    static int dp[][];
    static int N;
    static int seq[];
    private static String next() throws Exception
    {
        while(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private static int Long(int i,int state)
    {
        if(i>=N)
        {
            return 0;
        }
        else if(dp[i][state]!=0)
        {
            return dp[i][state];
        }
        else
        {
            if(i==N-1)
            {
                dp[i][state]=1;
            }
            else if(state==0 && seq[i+1]>=seq[i])
            {
                dp[i][0]+=1+Long(i+1,1);		
            }
            else if(state==1 && seq[i+1]<=seq[i])
            {
                dp[i][1]+=1+Long(i+1,0);
            }
            else
            {
                dp[i][state]=1;
            }
            return dp[i][state];
        }
    }

    public static void main(String []args)throws Exception
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(next());
        while(T>0)
        {
            N=Integer.parseInt(next());
            int count=1;
            dp=new int[N][2];
            seq=new int[N];
            int temp=0;
            for(int i=0;i<N;i++)
            {
                seq[i]=Integer.parseInt(next());
            }
            for(int i=0;i<N;i++)
            {
                temp=Long(i,0);
                temp=Long(i,1);
            }
            for(int i=0;i<N;i++)
            {
                temp=dp[i][0];
                if(i+temp>=N)
                {
                    count=Math.max(count,temp+1);
                }
                else if(temp%2==0)
                {
                    count=Math.max(count,temp+1+dp[i+temp][1]);
                }
                else
                {
                    count=Math.max(count,temp+1+dp[i+temp][0]);
                }
            }
            System.out.println(count);
            T--;
        }
    }
}
