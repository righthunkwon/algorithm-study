import java.util.Scanner;
//2839번
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N % 5 == 0) {
            System.out.println(N / 5);
        } else if (N % 5 == 1&&N>=6) {// 6
                System.out.println(N / 5 - 1 + 2);
        } else if (N % 5 == 2 &&N>=12) {// 12
            System.out.println(N / 5 - 2 + 4);
        } else if (N % 5 == 3) {
            System.out.println(N / 5 + 1);
        } else if(N%5==4&&N>=9){// 나머지 4 => 9
            System.out.println(N / 5 - 1 + 3);
        }else {
            System.out.println(-1);
        }

    }
}
