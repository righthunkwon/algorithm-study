package _20240228;

import java.util.*;
import java.io.*;

public class _23337_DrunkPassenger {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		 if (n == 1) {
	            System.out.println(1);
	        } else {
	        	
	        	// n=3 일때 못앉을 확률: 3/4
	        	// n=4 일때 못앉을 확률: 2/3 = 4/6
	        	// n=5 일때 못앉을 확률: 5/8
	        	
	            System.out.println((double)n/((n-1)*2));
	        	
	        }
	}//main

}
