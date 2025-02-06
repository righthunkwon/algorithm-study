import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        m = 1 << n;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int sz = Integer.parseInt(st.nextToken());
            backup();
            transform(cmd, 1 << sz);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static int n, m, q;
    static int[][] mat = new int[128][128];
    static int[][] temp = new int[128][128];

    static void backup() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = mat[i][j];
            }
        }
    }

    static void copy(int x1, int y1, int x2, int y2, int sz) {
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                mat[x2 + i][y2 + j] = temp[x1 + i][y1 + j];
            }
        }
    }

    static void transform(int cmd, int sz) {
        for (int x = 0; x < m; x += sz) {
            for (int y = 0; y < m; y += sz) {
                if (cmd <= 4) {
                    for (int i = 0; i < sz; i++) {
                        for (int j = 0; j < sz; j++) {
                            if (cmd == 1) mat[x + i][y + j] = temp[x + (sz - 1 - i)][y + j];
                            else if (cmd == 2) mat[x + i][y + j] = temp[x + i][y + (sz - 1 - j)];
                            else if (cmd == 3) mat[x + i][y + j] = temp[x + (sz - 1 - j)][y + i];
                            else if (cmd == 4) mat[x + i][y + j] = temp[x + j][y + (sz - 1 - i)];
                        }
                    }
                } else if (cmd == 5) {
                    copy(x, y, m - sz - x, y, sz);
                } else if (cmd == 6) {
                    copy(x, y, x, m - sz - y, sz);
                } else if (cmd == 7) {
                    copy(x, y, (y / sz) * sz, (m / sz - 1 - x / sz) * sz, sz);
                } else if (cmd == 8) {
                    copy(x, y, (m / sz - 1 - y / sz) * sz, (x / sz) * sz, sz);
                }
            }
        }
    }
}