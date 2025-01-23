import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    String s=br.readLine();
	    if(s.contains("::")) s=s.replace("::",":zero:");
	    String[] ip=s.split(":");
	    LinkedList<String> arr=new LinkedList<>();
	    LinkedList<String> rl=new LinkedList<>();	   
	    for(int i=0;i<ip.length;i++) arr.add(ip[i]);
	    for(int i=0;i<arr.size();i++) {
	 	    String str=arr.get(i);
		    if(str.isEmpty()) continue;
		    while(str.length()<4) str="0"+str;
		    rl.add(str);
	    }
	    String[] ans=new String[8];
	    int z=8-rl.size()+1;
	    int idx=0;
	    for(int i=0;i<rl.size();i++) {
		    if(rl.get(i).equals("zero")) {
			    while(z-->0) {
				    ans[idx]="0000";
				    idx++;
			    }
		    }
		    else ans[idx++]=rl.get(i);
	    }
	    System.out.print(ans[0]);
	    for(int i=1;i<ans.length;i++) System.out.print(":"+ans[i]);
    }   
}
