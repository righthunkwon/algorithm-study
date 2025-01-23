import java.io.*;
import java.util.*;

public class Main {
    public static class Room {
        int type, a, h;

        public Room(int type, int a, int h) {
            this.type = type;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long start = Long.parseLong(st.nextToken());
        long l = 1;
        long r = Long.MAX_VALUE / 2; 
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Room(type, a, h));
        }

        long mid;
        long answer = 0;

        while (l <= r) {
            mid = (l + r) / 2;
            long my_a = start;
            long my_h = mid;

            for (int i = 0; i < N; i++) {
                Room room = list.get(i);
                if (room.type == 1) { // 몬스ㅌㅓ
                    long cnt;
                    if (room.h%my_a== 0) { 
                        cnt =room.h/my_a; 
                    } else {
                        cnt =room.h/my_a + 1; // ㅎㅏㄴㅂㅓㄴ ㄷㅓ ㄱㅗㅇㄱㅕㄱ
                    }
                    long sum = (cnt - 1)*room.a;//ㅁㅏㅈㅣㅁㅏㄱㅇㅡㄴ ㅁㅗㄴㅅㅡㅌㅓ ㅈㅜㄱㅇㅡㅁ 

                    if (my_h <= sum) { 
                        l = mid + 1;
                        my_h = -1; 
                        break;
                    }

                    my_h -= sum; 
                } else { // 포션
                    my_a += room.a;
                    my_h = Math.min(my_h + room.h, mid); 
                }
            }

            if (my_h > 0) { 
                r = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}