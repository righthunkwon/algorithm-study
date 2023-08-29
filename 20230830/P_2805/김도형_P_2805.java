import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_Q2805_나무_자르기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 나무 갯수 N
		long M = sc.nextLong(); // 목표 나무의 길이
		
		int [] arr = new int [N]; //나무 높이 입력받을 배열
		
		
		for(int i = 0 ; i<N ; i++) {
			arr[i]=sc.nextInt();   //나무 높이 입력
		}
		Arrays.sort(arr); //나무 높이 오름차순 정렬
		
		
		//이분탐색 on
		long min = 0;  //절단기 최소 높이
		long max = arr[arr.length-1]; //절단기 최대 높이
		long mid =0;//min,max의 변화에 따라 달라질 중간값 계산
		int X = 0; //절단기 높이

		//절단기 높이가 X 일때 잘리는 값?
		// min~max구간 순회 하면서 
		// if ( arr[i]>X )
		//getTree+=arr[i]-X
		//getTree가 M보다 높으면 min=mid+1
		//getTree가 M보다 낮으면 max=mid-1
		
		while(min<max) {
			
			long getTree = 0 ; //잘라서 획득하는 나무의 길이
			 mid = (min + max)/2;  
			for(int i = 0; i < N; i++) {
				
				if(arr[i]>mid) {
					getTree+= (arr[i]-mid); //절단기 높이보다 긴 나무부분 획득가능
				}
			}
			
			if(getTree>=M) {  //목표보다 너무 많이 잘린다면 절단기 높이 up
				
				min=mid+1;
				
			}else  { //목표보다 모자라게 잘리면 절단기 높이 down
			
				max=mid;
				
			}
			
				
		}//while
		//while문이 끝났을 때의 max-1 값이 최대다
		System.out.println(max-1);
		
		
	}
	
}
