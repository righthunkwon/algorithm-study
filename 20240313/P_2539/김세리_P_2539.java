package _20240313;

import java.util.*;

public class _2539_모자이크 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int r = scan.nextInt(); // 행
        int c = scan.nextInt(); // 열
        int N = scan.nextInt(); // 사용할 색종이 장수
        int mistake = scan.nextInt(); // 잘못 칠해진 칸 개수
        
        // 잘못 칠해진 칸의 위치를 list로 저장
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<mistake;i++) {
        	// asList 사용시 list간편하게 생성 가능.
            list.add(Arrays.asList(scan.nextInt(), scan.nextInt()));
        }
        
        // Comparator를 사용하여 y좌표에 따라 정렬
        list.sort(Comparator.comparingInt(o -> o.get(1)));
        
        // 가로 세로 중 더 작은 값부터 색종이 크기를 이진 탐색함.
        int left = 1;
        int right = Math.min(r, c);
        
        while(left <= right) {
        	// mid: 색종이 크기
            int mid = (left + right)/2;

            if(possible(mid, N, list)) {
                right = mid-1;
            }
            else left = mid+1;
        }
        // 마지막으로 가능한 색종이 크기가 left에 저장된 값이므로 left출력
        System.out.println(left);
    }

    public static boolean possible(int mid, int N, List<List<Integer>> list) {
        int cnt = 0; // 사용된 색종이 개수
        int pre = 0; // 이전 손상된 부위의 열값
        for(int i=0;i<list.size();i++) {
        	
        	// 손상된 부분 좌표 하나 꺼낸다
            List<Integer> current = list.get(i);
            
            // 밑면에 닿게 붙였을 때 손상된 부분의 행이 색종이 크기보다 크면 가릴 수 없음
            if(current.get(0) > mid) return false;
            
            // pre==0: 아직 어떠한 부분도 가려지지 않은 경우
            // 이전에 가려진 부분의 열값에 mid를 더한 값보다 현재 손상된 부분의 열값이 큰 경우
            
            // 이 두경우엔 새로운 색종이로 가려야 하므로 cnt를 증가시키고,
            // 새롭게 열값을 pre에 업데이트한다
            if(pre==0 || pre + mid <= current.get(1)) {
                pre = current.get(1);
                cnt++;
                // 필요한 색종이 값이 사용 가능한 값보다 크면 false
                if(cnt > N) return false;
            }
        }
        
        // 나머지 경우엔 가능한 경우라 true반환
        return true;
    }
}
