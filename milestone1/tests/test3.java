import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

class PLIND {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	int mod = 1000000007;
	
	void solve()
	{
		for(int T = ni();T > 0;T--){
			char[] L = minus1(ns().toCharArray());
			char[] R = ns().toCharArray();
			out.println((count(R) - count(L) + mod) % mod);
		}
	}
	
	long count(char[] R)
	{
		if(R.length == 0)return 0;
		int n = R.length;
		long[] dp = new long[11];
		int ptn = 0;
		for(int i = 0;i < n;i++){
			long[] ndp = new long[11];
			for(int j = 0;j < 11;j++){
				if(j+1 <= 10){
					ndp[j+1] += dp[j] * (10-j);
				}
				if(j-1 >= 0){
					ndp[j-1] += dp[j] * j;
				}
			}
			
			if(i == 0){
				for(int j = 1;j < R[i]-'0';j++){
					ndp[1]++;
				}
			}else{
				ndp[1] += 9;
				for(int j = 0;j < R[i]-'0';j++){
					int x = ptn^1<<j;
					ndp[Integer.bitCount(x)]++;
				}
			}
			for(int j = 0;j < 11;j++){
				ndp[j] %= mod;
			}
			ptn ^= 1<<R[i]-'0';
			
			dp = ndp;
		}
		
		dp[Integer.bitCount(ptn)]++;
		
		return (dp[0]+dp[1])%mod;
	}
	
	public static char[] minus1(char[] a)
	{
		if(a.length == 1 && a[0] == '0')throw new RuntimeException();
		for(int i = a.length-1;i >= 0;i--){
			if(--a[i] < '0'){
				a[i] = '9';
			}else{
				break;
			}
		}
		if(a[0] == '0'){
			return Arrays.copyOfRange(a, 1, a.length);
		}else{
			return a;
		}
	}

	
	void run() throws Exception
	{










		
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new PLIND().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ 
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
}





















