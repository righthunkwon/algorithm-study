class Solution {
    public int solution(int a, int c, int[][] p) {
		int ma = a, mc = c;        
        for(int i=0;i<p.length;i++) {
			if(ma < p[i][0]) ma = p[i][0];
			if(mc < p[i][1]) mc = p[i][1];
		}
        int[][] dy = new int[ma + 1][mc + 1];
		for(int i=a;i<=ma;i++)
			for(int j=c;j<=mc;j++) dy[i][j] = Integer.MAX_VALUE;
		dy[a][c] = 0;
		for(int i=a;i<=ma;i++) {
			for(int j=c;j<=mc;j++) {
				if(i + 1 <= ma) dy[i + 1][j] = Math.min(dy[i + 1][j], dy[i][j] + 1);
				if(j + 1 <= mc) dy[i][j + 1] = Math.min(dy[i][j + 1], dy[i][j] + 1);
				for(int k=0;k<p.length;k++) {
					if(p[k][0] <= i && p[k][1] <= j) {
						int ia = p[k][2], ic = p[k][3];
						if(i + ia > ma) ia = ma - i;
						if(j + ic > mc) ic = mc - j;
						dy[i + ia][j + ic] = Math.min(dy[i + ia][j + ic], dy[i][j] + p[k][4]);
					}
				}
			}
		}
		return dy[ma][mc];
	}
}
