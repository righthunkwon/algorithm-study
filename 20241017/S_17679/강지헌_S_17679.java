class Solution {
    public int solution(int m, int n, String[] board) {
		char[][] arr = new char[m][n];
		for(int i=0; i<m; i++) arr[i] = board[i].toCharArray();
		int cnt = 0;
		while(true) {
			boolean flag = false,  chk = new boolean[m][n];
			for(int i=1; i<m; i++) {
				for(int j=1; j<n; j++) {
					if(arr[i][j]!='X' && arr[i][j]==arr[i-1][j] && arr[i][j]==arr[i-1][j-1] && arr[i][j]==arr[i][j-1]) {
						flag = true;
						chk[i][j] = chk[i-1][j-1] = chk[i-1][j] = chk[i][j-1] = true;
					}
					
				}
			}
			if(!flag) break;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(chk[i][j]) {
						cnt++;
						for(int k=i; k>0; k--) {
							arr[k][j] = arr[k-1][j];
							arr[k-1][j] = 'X';
						}
					}
				}
			}
		} 
    return cnt;
  }
}
