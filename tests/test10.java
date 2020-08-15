import java.io;
import java.util.*;
class C
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while(T-->0)
        {
            String s[]=br.readLine().trim().split(" ");
            N=Integer.parseInt(s[0]);
            int K=Integer.parseInt(s[1]);
            int V=Integer.parseInt(s[2]);

            int a[]=new int[N];
            s=br.readLine().trim().split(" ");

            int sum=0;

            for(i=0;i<N;i++)
            {
                a[i] = Integer.parseInt(s[i]);
                sum+=a[i];
            }

            V*=(N+K);

            V-=sum;

            if(V>=0&&V%K==0)
                sb.append(V/K);
            else
                sb.append(-1);

            sb.append("\n");


        }
        System.out.println(sb);

    }
}





















