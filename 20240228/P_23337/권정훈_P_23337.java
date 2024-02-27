package level_23_dynamic_programming;

import java.io.*;
import java.util.*;

// Drunk passenger
public class P_23337 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(1.0 / (n - 1) + (double) (n - 2) / (n - 1) / 2);
	}
}
