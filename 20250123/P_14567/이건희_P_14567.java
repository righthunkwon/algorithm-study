import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int id;
        int term;
        int degree;// 이거 0되면 처리리
        List<Integer> next;

        public Node(int id){
            this.id = id;
            this.term = 1;
            this.degree = 0;
            this.next = new ArrayList<>();
        }
        
        @Override
        public int compareTo(Node tmp){
            return Integer.compare(this.id, tmp.id);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Node[] graph = new Node[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new Node(i);

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].next.add(b);
            graph[b].degree++;// 선수 과목이 있으면 뒤로 미루기기
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) if(graph[i].degree == 0) pq.add(graph[i]);

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int nextId : cur.next){
                Node next = graph[nextId];
                next.degree--;

                next.term = Math.max(next.term, cur.term+1);

                if(next.degree == 0) pq.add(next);
            }
        }

        for(int i = 1; i <= N; i++) System.out.print(graph[i].term + " ");
    }
}