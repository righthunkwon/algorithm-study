package _20231214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6603_로또 {
    static int k;
    static int[] S,sel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;
            S = new int[k];
            sel = new int[6]; // 6개의 숫자 선택

            for (int i=0;i<k;i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void comb(int idx, int sidx) {
        if (sidx==6) { // 6개의 숫자가 선택되었을 때
            for (int i=0;i<6;i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx==k) return; // 더 이상 선택할 수 있는 숫자가 없을 때

        sel[sidx] = S[idx];
        comb(idx + 1, sidx + 1); // 현재 숫자를 선택한 경우
        comb(idx + 1, sidx); // 현재 숫자를 선택하지 않은 경우
    }//comb
}
