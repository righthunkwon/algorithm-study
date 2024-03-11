import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
public static class node implements Comparable<node> {
        int x;
        int y;
        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(node o) {
            return this.y - o.y;
        }
    }
    static int N;
    static int M;
    static ArrayList<node> ar;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ar = new ArrayList<>();
        count = sc.nextInt();
        int error = sc.nextInt();
        // 입력되는 높이 중 최소 높이를 저장한 후
        // 최대 100000까지니깐 y좌표만 저장 후 정렬
        // 색종이의 크기를 2분탐색으로 정해서
        // 다 덮이는지 확인 
        // 덮이면 줄이고 안되면 늘려서 무한 ㄱㄱ
        for (int i = 0; i < error; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar.add(new node(a,b));
        }
        Collections.sort(ar);
        // 이분탐색 돌려서 높이설정
        int left = 1;
        int right = 100000;
        int mid =0;
        while(true){
            mid = (right + left)/2;
            // 색종이의 크기가 mid라 생각하고
            // ar의 최소점부터 돌려
            // 색종이가 몇개 필요한지 구해봄
            // 더많이 필요하면 길이 늘림
            if(solve(mid)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }

            if(left > right){
                break;
            }
        }
        System.out.println(left);



    }
    static boolean solve(int len){
        int st = 0;
        // 0부터 시작해서
        // len길이 동안 세보고
        // 그다음 길이부터 cnt+1해서
        // 다시 세서 총 몇개필요한지 구함
        int cnt = 0;
        for(int i = 0; i < ar.size(); i++) {
            node n = ar.get(i);
            // 높이가 색종이 길이보다 길면 false
            if(n.x > len) {
                return false;
            }
            // 시작지점 + len이 y보다 크면
            // cnt++하고 개수넘어가면 break
            // 0일때는 시작
            if(st == 0 || st + len <= n.y) {
                st = n.y;
                cnt++;
                if(cnt > count) return false;
            }
        }
        return true;

    }
}
