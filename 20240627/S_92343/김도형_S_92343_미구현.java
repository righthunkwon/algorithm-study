class Solution {
    public int solution(int[] info, int[][] edges) {
        
        List<Integer>[] list= new List[info.length];
        
        //인접 정보 리스트
        for (int i = 0; i < len; ++i)
			list[i] = new ArrayList<>();
		for (int[] edge : edges)
			list[edge[0]].add(edge[1]);

      
        int answer = 0;
        return answer;
    }
}
