import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        // 이거 입력 다받으면서 
        // 만약 이어지는 숫자는 부모를 입력해놓자
        
         arr = new int[N];
        for(int i = 0;i<N;i++) {
        	arr[i] = i ;
        }
        
        for(int i = 0 ; i<M;i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	// 입력되는 두점의 부모를 찾아서
        	// 만약 다르면 union
        	// 같으면 끝
//        	System.out.println(arr[a]+" "+arr[b]);
        	if(find(a) == find(b)) {
        		System.out.println(i+1);
        		System.exit(0);
        	}
        	else {
        		union(a, b);
        	}
        	
        }
        System.out.println(0);
    
    }
    // 현재 들어온 a와 a의 부모가 같으면 그대로 return
    // 만약 다르면 a의 부모를 다시 find해서 설정하고 
    // arr[a]를 return
    public static int find(int a) {
    	if(a == arr[a]) {
    		return a;
    	}
    	arr[a] = find(arr[a]);
    	return arr[a];
    }
    
    // 작은 숫자쪽으로 통합
    public static void union(int a, int b) {
    	if(a > b) {
    		arr[find(a)] = arr[find(b)];
    	}
    	else {
    		arr[find(b)] = arr[find(a)];
    	}
    	
    }

}
