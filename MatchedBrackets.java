import java.util.*;
import java.io.*;
class MatchedBrackets
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

    public static void main(String[] args) throws Exception
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(next());
        String[] str = br.readLine().split("\\s+");
        int pos = 0;
        int depth = 1;
        int cdepth = 1;
        int maxsymbols = 1;
        int spos = 0;
        int mpos = 0;
        for(int i = 1;i<n;i++)
        {
            if(str[i].equals("1"))
            {
                cdepth++;
                if(cdepth==1)
                {
                    spos = i;
                }
                if(cdepth>depth)
                {
                    depth=cdepth;
                    pos = i;
                }
            }
            else if(str[i].equals("2"))
            {
                cdepth--;
            }
            if(cdepth==0){
                if((i-spos)>maxsymbols)
                {
                    maxsymbols = i-spos;
                    mpos = spos;
                }
            }
        }
        System.out.println(depth + " " + (pos+1) + " " + (maxsymbols+1) + " " + (mpos + 1));
    }
}