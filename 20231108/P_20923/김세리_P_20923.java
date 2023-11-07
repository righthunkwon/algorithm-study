package _20231108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _20923_숫자할리갈리게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dodq = new LinkedList<>();
        Deque<Integer> sudq = new LinkedList<>();
        Deque<Integer> dodumy = new LinkedList<>();
        Deque<Integer> sudumy = new LinkedList<>();


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            // 맨 끝번호부터 주어지니까 앞에서부터 넣어주면
            // 맨 뒤에 숫자가 뒤에오고 앞에 숫자가 앞에 오지롱
            dodq.addFirst(Integer.parseInt(st.nextToken()));
            sudq.addFirst(Integer.parseInt(st.nextToken()));
        }//입력끝

        int cnt = 0;
        // 두 명 모두 카드가 있을 때 while문 반복
        while(!dodq.isEmpty() && !sudq.isEmpty()) {
            // 도도 먼저 시작
            // 맨 위에 카드를 꺼내서 더미카드에 추가한다
            int a = dodq.poll();
            // 이때 낸 다음에 카드가 없으면 바로 break
            if(dodq.isEmpty()) break;
            dodumy.add(a); // 더미 카드 맨 밑에 위치한게 결국 나중에 카드 합칠때 먼저 합쳐지니까 더미의 앞쪽이 맨 밑 방향으로 한다
            // 두 사람의 더미가 0이 아니고 낸 카드가 5일 땐 도도가 카드 먹는다
            if(a==5) {
                // 카드 먹을 땐 상대방꺼부터 합친다 냠
            	while(!sudumy.isEmpty()) {
                	int tmp = sudumy.poll();
                	dodq.add(tmp);
                }
                while(!dodumy.isEmpty()) {
                	int tmp = dodumy.poll();
                	dodq.add(tmp);
                }

            }
            // 합이 5일 땐 수연이가 카드 먹는다
            if(!sudumy.isEmpty() && !dodumy.isEmpty()) {
                int temp = sudumy.peekLast(); // 더미 방향에서 끝부분이 맨 위에 위치한 카드이므로 peekLast사용한다
                if(a + temp == 5) { // 뽑은 수랑 위에 있는 수
                	while(!dodumy.isEmpty()) {
                    	int tmp = dodumy.poll();
                    	sudq.add(tmp);
                    }
                	while(!sudumy.isEmpty()) {
                    	int tmp = sudumy.poll();
                    	sudq.add(tmp);
                    }
                }
            }
//            System.out.println("dodq:" + dodq);
//            System.out.println("dodumy:" + dodumy);
//            System.out.println("sudq:" + sudq);
//            System.out.println("sudumy:" + sudumy);
            // 횟수 추가
            cnt++;
            if(cnt==M) break;

            // 그다음 수연이 차례
            int b = sudq.poll();
            if(sudq.isEmpty()) break;
            sudumy.add(b);
            // 5일 땐 도도가 카드 먹는다
            if(b==5) {

                while(!sudumy.isEmpty()) {
                	int tmp = sudumy.poll();
                	dodq.add(tmp);
                }

                while(!dodumy.isEmpty()) {
                	int tmp = dodumy.poll();
                	dodq.add(tmp);
                }

            }
            // 합이 5일 땐 수연이가 카드 먹는다
            if(!dodumy.isEmpty() && !sudumy.isEmpty()) {
                int temp2 = dodumy.peekLast();
                if(b + temp2 ==5) {

                    while(!dodumy.isEmpty()) {
                    	int tmp = dodumy.poll();
                    	sudq.add(tmp);
                    }
                    while(!sudumy.isEmpty()) {
                    	int tmp = sudumy.poll();
                    	sudq.add(tmp);
                    }
                }
            }
//            System.out.println("dodq:" + dodq);
//            System.out.println("dodumy:" + dodumy);
//            System.out.println("sudq:" + sudq);
//            System.out.println("sudumy:" + sudumy);
//            System.out.println("----------------------------------");
            // 횟수 추가
            cnt++;
            if(cnt==M) break;
        }//while
//        System.out.println("----------------------------------");
//        System.out.println(dodq.size() +" "+ sudq.size());

        if(dodq.size() > sudq.size()) System.out.println("do");
        if(dodq.size() < sudq.size()) System.out.println("su");
        if(dodq.size() == sudq.size()) System.out.println("dosu");

    }//main

}
