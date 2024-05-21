class Solution {
    public int solution(int[] topping) {
        int[] l = new int[10001], r = new int[10001];
        int e = 0;
        for (int x : topping) {
            if (r[x] == 0) e++;
            r[x]++;
        }
        int ans = 0;
        int s = 0;
        for (int x : topping) {
            if (r[x] == 1) e--;
            if (l[x] == 0) s++;
            r[x]--; l[x]++;
            if (s == e) ans++;
        }
        return ans;
    }
}
