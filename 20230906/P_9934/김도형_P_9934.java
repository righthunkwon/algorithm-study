//   전체 수 배열 길이 = X
//  st , ed  ,  mid  
//   X/2 번째 원소를 넣고 다음 depth 로..


package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q9934_완전_이진_트리 {

	public static String[] arr; //처음에 입력받을 배열

	public static String[] arr2; //depth 별로 더해갈 배열

	static int K; // 깊이
	
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		sc.nextLine(); // 개행문자를 버려준다...★★

		arr = sc.nextLine().split(" ");

//		System.out.println(Arrays.toString(arr)); //출력확인

//		int N = arr.length;

		arr2 = new String[K]; // 길이가 K인 배열 생성 depth에 따라 string builder로 append 해준다!
		
		for (int i = 0; i < K; i++) {  //배열이 Null이 아니도록 공백 삽입..
			arr2[i]="";
		}
		
		
		tree(0, arr.length - 1, 0);

		for (int i = 0; i < K; i++) {

			sb=new StringBuilder(arr2[i]);
			sb.deleteCharAt(0);             //삽입해줬던 공백 제거..
			arr2[i]=sb.toString();
			System.out.println(arr2[i]);

		}

//		//아래의 방식으로 차례로 집어넣어 줄 것..
//		StringBuilder sb = new StringBuilder(arr[1]);   
//		
//		String x = "30";
//		
//		sb.append(" ").append(x);                   
//		
//		arr[1]=sb.toString();
//
//		System.out.println(arr[1]);
//		
//		System.out.println(Arrays.toString(arr));

	}// main

	public static void tree(int st, int ed, int depth) {

		// 기저파트
		if (depth == K) {
			return;
		}
		
		int mid = (st + ed) / 2;
		
//		System.out.println("st:"+st);
//		System.out.println("ed:"+ed);
//		System.out.println("mid:"+mid);
//		System.out.println("depth:"+depth);
//		System.out.println("arr[mid]:"+arr[mid]);
//		System.out.println("arr2[depth]:"+arr2[depth]);   //출력확인용..
//		System.out.println("===================");


		sb = new StringBuilder(arr2[depth]);

		sb.append(" ").append(arr[mid]);

		arr2[depth] = sb.toString();

		// 재귀파트

		tree(st, mid - 1, depth + 1);  

		tree(mid + 1, ed, depth + 1);

	}

}// class
