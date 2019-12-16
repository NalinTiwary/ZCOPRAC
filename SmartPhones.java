import java.util.*;
class SmartPhones 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long arr[]=new long[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextLong();
		}
		Arrays.sort(arr);
		long budget=0;
		for(int i=0;i<N;i++)
		{
			long temp=(N-i)*arr[i];
			if(temp>budget)
			{
				budget=temp;
			}
		}
		System.out.println(budget);
	}
}