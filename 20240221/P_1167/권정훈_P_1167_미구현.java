import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 트리의 지름
// 리액트 다 듣고 돌아오겠습니다
public class P_1167 {

    private static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int v = Integer.parseInt(br.readLine()); // 정점의 개수
        List<Node> list = new ArrayList<>(); // 노드 배열

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int e = Integer.parseInt(st.nextToken());
        }
    }
}
