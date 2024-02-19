import java.util.*;
import java.io.*;

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());
            cur = cur.child.get(c);
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 현재 노드의 자식 노드에 문자가 포함되지 않았을 경우
            // false 로 종료
            if (!cur.child.containsKey(c)) {
                return false;
            }
            cur = cur.child.get(c);
        }

        // 들어온 문자열이 접두사인 경우
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 집합 S에 포함되어 있는 문자열의 수
        int M = Integer.parseInt(st.nextToken());  // 검사해야 하는 문자열의 수
        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();  // 문자열
            trie.insert(str);  // trie 에 문자열 추가
        }
        int count = 0;  // 접두사의 개수
        for (int i = 0; i < M; i++) {
            String str = br.readLine();  // 문자열
            // trie 를 통해 접두사이라면 count 추가
            if (trie.search(str)) {
                count++;
            }
        }
        // 결과
        System.out.println(count);
    }
}
class Node {
    HashMap<Character, Node> child = new HashMap<>();
}
