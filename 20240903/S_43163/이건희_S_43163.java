class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = dfs(begin, target, words, visited, 0);
        return answer;
    }

    private int dfs(String current, String target, String[] words, boolean[] visited, int step) {
        if (current.equals(target)) return step; 
        
        int minStep = words.length+1;
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(current, words[i])) {
                visited[i] = true;
                int result = dfs(words[i], target, words, visited, step + 1);
                visited[i] = false;
                if (result > 0) minStep = Math.min(minStep, result);
            }
        }
        return minStep == words.length+1 ? 0 : minStep;  // 변환할 수 없으면 0 반환
    }

    private boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return cnt == 1;
    }
}