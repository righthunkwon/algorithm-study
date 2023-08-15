import java.io.*;
import java.util.StringTokenizer;

public class Problem_1018 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            String word = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = word.split("")[j];
            }
        }
        int min = 2500;
        for (int i = 0; i < N - 7; i++) {// 시작점
            for (int j = 0; j < M - 7; j++) {
                int count = 0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        if ((k + l-i-j) % 2 == 0 && !arr[i][j].equals(arr[k][l]) )// 짝수는 시작점과 같아야함 다르면 고치기
                            count++;
                        else if ((k + l-i-j) % 2 == 1 && arr[i][j].equals(arr[k][l]))// 홀수는 시작점과 달라야함 같으면 고치기
                            count++;
                    }
                }
                min = Math.min(count, min);
            }
        }
        
        for (int i = N-1; i >=7; i--) {// 끝점
            for (int j = M-1; j >=7; j--) {
                int count = 0;
                for (int k = i; k > i-8; k--) {
                    for (int l = j; l > j-8; l--) {
                        if ((-k - l+i+j) % 2 == 0 && !arr[i][j].equals(arr[k][l]) )// 짝수는 시작점과 같아야함 다르면 고치기
                            count++;
                        else if ((-k - l+i+j) % 2 == 1 && arr[i][j].equals(arr[k][l]))// 홀수는 시작점과 달라야함 같으면 고치기
                            count++;
                    }
                }
                min = Math.min(count, min);
            }
        }
        System.out.println(min);
    }
}
