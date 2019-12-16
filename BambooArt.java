import java.util.*;
import java.io.*;
class BambooArt
{
    public static void main(String []args)throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().trim().split(" ");
        int N=Integer.parseInt(s[0]);
        int len[]=new int[N];
        for(int i=0;i<N;i++)
        {
            len[i]=Integer.parseInt(s[i+1]);
        }
        Arrays.sort(len);
        int ans=1;
        for(int i=0;i<N-1;i++)
        {

            for(int j=i+1;j<N;j++)
            {
                int temp=1;
                int pos=-1;
                a:
                for(int h=len[j]+len[j]-len[i];h<=len[N-1];h+=len[j]-len[i])
                {
                    pos=Arrays.binarySearch(len,pos+1,len.length,h);
                    if (pos<0)
                    {
                        break a;
                    }
                    temp++;
                }
                if(temp>ans)
                {
                    ans=temp+1;
                }

            }

        }
        System.out.print(ans);
    }
}