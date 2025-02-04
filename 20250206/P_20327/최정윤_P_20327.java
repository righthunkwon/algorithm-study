import java.io.*;
import java.util.*;
//2의 14제곱 *1000 그냥 구현해도 시간초과 안날듯...?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        len = (int) Math.pow(2, N);

        A = new int[len][len];

        for (int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            game(k, l);
        }


        for (int a = 0; a < len; a++) {
            for (int q = 0; q < len; q++) {
                System.out.print(A[a][q] + " ");
            }
            System.out.println();
        }
    }

    static int[][] A;
    static int len;

    public static void game(int k, int l) {
        int small = (int) Math.pow(2, l);
        if (k == 1) { // 1번 부분 배열 내 상하 반전
            int[][] arr = new int[small][small];
            for (int r = 0; r < A.length; r += small) {
                for (int c = 0; c < A.length; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[small - 1 - i][j] = A[r + i][c + j];
                        }
                    }

                    // 복붙
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            A[r + i][c + j] = arr[i][j];
                        }
                    }
                }
            }
        } else if (k == 2) { // 2번 부분 배열 내 좌우 반전
            int[][] arr = new int[small][small];
            for (int r = 0; r < A.length; r += small) {
                for (int c = 0; c < A.length; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[i][small - 1 - j] = A[r + i][c + j];
                        }
                    }

                    // 복붙
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            A[r + i][c + j] = arr[i][j];
                        }
                    }
                }
            }
        } else if (k == 3) { // 3번 부분 배열 내 90도 오른쪽 회전
            int[][] arr = new int[small][small];
            for (int r = 0; r < A.length; r += small) {
                for (int c = 0; c < A.length; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[j][small - 1 - i] = A[r + i][c + j];//0,0->0,3 0,1->1,3 2,0->0,1
                        }
                    }

                    // 복붙
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            A[r + i][c + j] = arr[i][j];
                        }
                    }
                }
            }
        } else if (k == 4) { // 4번 부분 배열 내 90도 왼쪽 회전
            int[][] arr = new int[small][small];
            for (int r = 0; r < A.length; r += small) {
                for (int c = 0; c < A.length; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[small - 1 - j][i] = A[r + i][c + j];//0,0->3,0 0,1->2,0 2,0->3,2
                        }
                    }

                    // 복붙
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            A[r + i][c + j] = arr[i][j];
                        }
                    }
                }
            }
        } else if (k == 5) { //5번 부분 배열끼리 상하반전
            int[][] arr = new int[len][len];
            for (int r = 0; r < len; r += small) {
                for (int c = 0; c < len; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[len - small - r + i][c + j] = A[r + i][c + j];
                        }
                    }
                }
            }

            // 복붙
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    A[i][j] = arr[i][j];
                }
            }
        } else if (k == 6) { // 6번 부분 배열끼리 좌우반전
            int[][] arr = new int[len][len];
            for (int r = 0; r < len; r += small) {
                for (int c = 0; c < len; c += small) {
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[r + i][len - small - c + j] = A[r + i][c + j];
                        }
                    }
                }
            }

            // 복붙
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    A[i][j] = arr[i][j];
                }
            }
        }else if (k == 7) { // 7번 배열을 오른쪽 90도 회전
            int[][] arr = new int[len][len];
            for (int r = 0; r < len; r += small) {
                for (int c = 0; c < len; c += small){
     				//r/small c/small ->c/small, len/small-r/small-1               
					for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[c + i][len -r- small + j] = A[r + i][c + j];
                        }
                    }
                }
            }

            // 복붙
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    A[i][j] = arr[i][j];
                }
            }
        }else if (k == 8) { // 8번 배열을 왼쪽 90도 회전
            int[][] arr = new int[len][len];
            for (int r = 0; r < len; r += small) {
                for (int c = 0; c < len; c += small) {
                    
                    for (int i = 0; i < small; i++) {
                        for (int j = 0; j < small; j++) {
                            arr[len-c-small+i][r + j] = A[r + i][c + j];
                        }
                    }
                }
            }

            // 복붙
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    A[i][j] = arr[i][j];
                }
            }
        }
    }
}