package _20240411;

import java.io.*;

public class _1992_쿼드트리 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j]=tmp.charAt(j)-'0';
			}
		}
		
		System.out.println(compress(0,0,N));
		
	}//main
	
	static String compress(int x,int y,int size) {
		// 영역이 모두 같은지 확인
		if (isSame(x, y, size)) {
            return String.valueOf(arr[x][y]);
        } else {
        	// 아니라면 4개 작은 영역으로 나눠서 확인한다
            int newSize = size/2;
            return "("
                    + compress(x, y, newSize)
                    + compress(x, y+newSize, newSize)
                    + compress(x+newSize, y, newSize)
                    + compress(x+newSize, y+newSize, newSize)
                    + ")";
        }
	}
	// 영역이 모두 같은지 확인
	static boolean isSame(int x, int y, int size) {
        int value = arr[x][y];
        for (int i=x;i<x+size;i++) {
            for (int j=y;j<y+size;j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

}
