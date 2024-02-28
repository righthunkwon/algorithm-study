package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_23337_DrunkenPassenger {
	    public static void main(String[] args) throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int n = Integer.parseInt(br.readLine());
	    	
	    	if(n==1) System.out.println(0);
	    	if(n==2) System.out.println(1);
	    	if(n > 2) {
	    		double tmp = 0;
	    		for(int i = 3; i <= n; i++) tmp += ((1.0 / (n+1)));
	    		
	    		System.out.println(tmp);
	    	}
	    	
	    }

}
