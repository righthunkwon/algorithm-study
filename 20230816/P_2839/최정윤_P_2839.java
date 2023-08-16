import java.util.Scanner;
//2839번
public class Problem_2839 {
    public static void main(String[] args) {
//최대한 적은 봉지를 가져가려고 함 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N % 5 == 0) {//5의 배수면 당연히 몫
            System.out.println(N / 5);
        } else if (N % 5 == 1&&N>=6) {// 6 
                System.out.println(N / 5 - 1 + 2);//끝에 두개는  6으로 맞춰서 3개짜리 2개를 더해야하기 때문 몫에서 -1해서 6을 맞춘다 따라서 최소가 6
        } else if (N % 5 == 2 &&N>=12) {// 12
            System.out.println(N / 5 - 2 + 4);//위와 동일 12를 만들어야 3으로 나눠짐 따라서 최소가 12
        } else if (N % 5 == 3) {
            System.out.println(N / 5 + 1);//나머지만 3개 짜리로 들고감
        } else if(N%5==4&&N>=9){// 나머지 4 => 9
            System.out.println(N / 5 - 1 + 3); //최소가 9,위와 동일함
        }else {
            System.out.println(-1);//정확하게 N을 맞출 수 없을 때
        }

    }
}
