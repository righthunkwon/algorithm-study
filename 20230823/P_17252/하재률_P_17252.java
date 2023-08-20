package 백준;

import java.util.Scanner;

public class bj17252_삼삼한수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String res = "YES";
        String N = Integer.toString(sc.nextInt(), 3);
        if(N.equals("0"))res="NO";
        for(int i = 0 ; i < N.length(); i++) {
            if(N.charAt(i)-'0' != 0 && N.charAt(i)-'0' != 1) {
                res = "NO";
            }
        }
        System.out.println(res);
        
    }
}
