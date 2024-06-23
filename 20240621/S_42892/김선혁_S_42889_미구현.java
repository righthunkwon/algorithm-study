class Solution {
    public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
        // 일단 다 좌표 표시하면서
        // y좌표가 높은게 부모
        PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			pq.add(new Node(nodeinfo[i][1], nodeinfo[i][0], i + 1));
		}
        // 전위는 부모 높은거 우선순위에
        // x좌표 적은거 먼저
        // 후위는 ..
        
        return answer;
    }
}
