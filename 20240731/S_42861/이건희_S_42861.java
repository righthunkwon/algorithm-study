// n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용
// => 모든 노드를 연결하면서, 비용 최소화 => 최소 비용 신장 트리(MST)
// 크루스칼 or 프림
// SWEA 1251 하나로
import java.util.*;

class Solution {
    static int[] arr; // 부모 노드 관리 할 배열
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (int[]c1, int[]c2) -> c1[2]-c2[2]);// 비용 기준 오름차
        arr = new int[n];// 부모노드관리 배열 초기화 때려 주고
        for(int i = 0; i < n; i++){// 처음에는 자기 자신이 부모노드
            arr[i] = i;
        }
        int answer = 0;
        for(int i = 0; i < costs.length; i++){
            int start = costs[i][0]; // 출발 노드
            int startNode = findNode(start); // 출발 노드의 루트 노드 => 여기서 개선 할 점이 있을까?
            int end = costs[i][1]; // 도착 노드
            int endNode = findNode(end);// 도착 노드의 루트 노드
            int cost = costs[i][2];// 비용

            if(startNode == endNode) continue;// 같으면 싸이클 생긴거니까 더 이상 진행 X
            answer += cost;
            arr[endNode] = startNode;// 노드 정보 갱신

        }
        return answer;
    }

    private int findNode(int tmp){
        if(arr[tmp] == tmp){ // 같은 노드 찾음
            return tmp;
        }else{ // 못 찾으면 찾으러 떠나기, 재귀 호출
            return arr[tmp] = findNode(arr[tmp]);
        }
    }
}
// https://mr-dan.tistory.com/43