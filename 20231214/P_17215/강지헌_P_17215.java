import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] arr=br.readLine().toCharArray();
		for(int i=0;i<arr.length;i++) if(arr[i]=='-') arr[i]='0';
		int ans=0,game=1;
		int[] chk={1,1};
		for(int i=0;i<arr.length;i++,game++) {
			if(game>=10) {
				if(arr[i]=='S') {
					ans+=chk[0]*10;
					if(arr[i+1]=='S') {
						ans+=chk[1]*10;
						if(arr[i+2]=='S') ans+=10;
						else ans+=arr[i+2]-'0';
					}
					else {
						int a=arr[i+1]-'0',b=0;
						if(arr[i+2]=='P') b=10-a;
						else b=arr[i+2]-'0';
						ans+=chk[1]*a+b;
					}
				}
				else {
					int a=arr[i]-'0';
					if(arr[i+1]=='P') {
						int b=10-a;
						ans+=chk[0]*a+chk[1]*b;
						if(arr[i+2]=='S') ans+=10;
						else ans+=arr[i+2]-'0';
					}
					else {
						int b=arr[i+1]-'0';
						ans+=chk[0]*a+chk[1]*b;
					}
				}
				System.out.println(ans);
				return;
			}
			if(arr[i]=='S') {
				ans+=chk[0]*10;
				chk[0]=chk[1]+1;
				chk[1]=2;
			}
			else {
				int a=arr[i]-'0';
				if(arr[i+1]=='P') {
					int b=10-a;
					ans+=chk[0]*a+chk[1]*b;
					chk[0]=2; chk[1]=1;
				}
				else {
					int b=arr[i+1]-'0';
					ans+=chk[0]*a+chk[1]*b;
					chk[0]=1; chk[1]=1;
				}
				i++;
			}
		}
	}
}
