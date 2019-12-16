import java.util.*;
import java.io.*;
class IPL
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
        int arr[]=new int [N];
        int dp[][]=new int[N][2];
        int total=0;
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(next());
            if(N<=3)
            {
                total+=arr[i];
            }
        }
        if(N<=2)
        {
            System.out.println(total);
        }
        else if(N==3)
        {
            System.out.println(Math.max(total-arr[2],Math.max(total-arr[1],total-arr[0])));
        }
        else
        {
            dp[0][0]=arr[0];
            dp[0][1]=arr[0];
            dp[1][0]=arr[1];
            dp[1][1]=arr[1]+arr[0];
            dp[2][0]=arr[2]+arr[0];
            dp[2][1]=arr[2]+arr[1];
            for(int i=3;i<N;i++)
            {
                int x=Math.max(dp[i-2][0],dp[i-2][1]);
                int y=Math.max(dp[i-3][0],dp[i-3][1]);
                int z=0;
                if(i>3)
                {
                    z=Math.max(dp[i-4][0],dp[i-4][1]);
                }
                dp[i][0]=arr[i]+Math.max(x, y);
                dp[i][1]=arr[i-1]+arr[i]+Math.max(y,z);   		
            }
        }
        int a = Math.max(Math.max(dp[N-1][0],dp[N-1][1]),Math.max(dp[N-2][0],dp[N-2][1]));
        int b = Math.max(dp[N-3][0],dp[N-3][1]);
        System.out.println(Math.max(a,b));
    }
}