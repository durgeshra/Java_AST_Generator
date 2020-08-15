import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main
{
    public class trie
        {
            public class node
                {
                    node child[]=new node[2];
                }
            node head=null;
            public void insert(String s)
                {
                    head=add(head,s,0);
                }
            public node add(node root,String s,int d)
                {
                    if(root==null)root=new node();
                    if(s.length()==d)return root;
                    char c=s.charAt(d);
                    root.child[c-48]=add(root.child[c-48],s,d+1);
                    return root;
                }
            public long get(String s,int max)
                {
                  return query(head,s,0,max);
                }
            public long query(node root,String s,int d,int max)
                {
                    if(root==null)return 0;
                    if(d==s.length())return 0;
                    int c=s.charAt(d)-48;
                    if(c==1 && root.child[0]!=null)
                        return (long)Math.pow(2,max-d-1)+query(root.child[0],s,d+1,max);
                    else if(c==1 && root.child[0]==null)
                        return query(root.child[1],s,d+1,max);
                    else if(c==0 && root.child[1]!=null)
                        return (long)Math.pow(2,max-d-1)+query(root.child[1],s,d+1,max);
                    else if(c==0 && root.child[1]==null)
                        return query(root.child[0],s,d+1,max);
                    return 0;
                }
        }
    public static void main(String args[])throws IOException
        {
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(isr);
            int t=Integer.parseInt(br.readLine());
            while(t>0)
                {
                    HashMap<Long,Integer> map=new HashMap();
                    t--;
                    Main.trie T=new Main().new trie();
                    int n=Integer.parseInt(br.readLine());
                    String line=br.readLine();
                    String keep[]=line.split(" ");
                    long a[]=new long[n];
                    int max=0;
                for(int i=0;i<n;i++){a[i]=Long.parseLong(keep[i]);
                                     max=Math.max(max,Long.toBinaryString(a[i]).length());}
                    long ans=0;
                    for(int i=0;i<n;i++)
                        {
                            if(i>=2)
                            {
                            String s=Long.toBinaryString(a[i]);
                            while(s.length()!=max)s="0"+s;
                            ans=Math.max(ans,T.get(s,max));
                            }
                            for(int j=0;j<i;j++)
                                {
                                    long x=a[i] ^ a[j];
                                    if(map.get(x)!=null)continue;
                                    map.put(x,1);
                                    String s1=Long.toBinaryString(x);
                                    while(s1.length()!=max)
                                        s1="0"+s1;
                                    T.insert(s1);
                                }
                        }
                    System.out.println(ans);
                }
        }
}






















