import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		int arr[] = new int[N+1];

	        arr[0] = 1;
	        arr[2] = 3;
	        // 처음꺼는 그냥 1로 정해놓고
	        // 2부터 시작
	        // 홀수에는 불가능 
	        for(int i=2;i<=30;i+=2){
	            arr[i] = arr[i-2]*3;
	            // 2칸당 3개씩 가능하니깐 
	            // -2한거에서 x3씩 해준다.
	            // 4칸부터는 끝에는 일자고 가운데가 가로된 모형가능해서
	            // 2배씩 곱해줌
	            for(int j=i-4;j>=0;j-=2){
	                arr[i] += arr[j]*2;
	            }
	        }
	        
	        System.out.println(arr[N]);
		
		
	}

}    
