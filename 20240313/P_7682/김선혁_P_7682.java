import java.util.Scanner;


public class Main {
    static String[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력받은것이 가로 또는 세로 또는 대각선으로
        // 2개이상 만족하면 invalid
         arr=  new String[3][3];
        while(true){
            String line = sc.next();
            if(line.equals("end")){
                break;
            }
            // end면 break
            int a=  0;
            int b= 0;
            for(int i = 0;i<3;i++){
                for(int j=0;j<3;j++){
                    arr[i][j] = line.substring(i*3+j,i*3+j+1);
                    if(arr[i][j].equals("X")){
                        a++;
                    }
                    else if(arr[i][j].equals("O")){
                    b++;
                    }
                }
            }
            // 각자 x와 o의 개수 count
            // 입력끝

            // 1. 현재 a가 +1인경우
            // 합이 9개일땐 무조건 b가 빙고 x면됨 + 다 안찼을땐 a가 빙고
            // 2. 같은경우
            // a가 노빙고, b가 빙고
            if(a == b+1){
                if(a+b==9 && !solve("O")){
                    System.out.println("valid");
                }
                else if(!solve("O") && solve("X")){
                    System.out.println("valid");
                }
                else{
                    System.out.println("invalid");
                }
            }
            else if(a == b){
                if(solve("O") && !solve("X")){
                    System.out.println("valid");
                }
                else{
                    System.out.println("invalid");
                }
            }
            else {
                System.out.println("invalid");
            }

        }


    }

    public static boolean solve(String tmp) {
        // 가로로 3개 같으면 true
        for (int i = 0; i < 3; i++) {
            if (arr[i][0].equals(tmp) && arr[i][1].equals(tmp) && arr[i][2].equals(tmp)) {
                return true;
            }
        }
        // 세로도 탐색
        for (int i = 0; i < 3; i++) {
            if (arr[0][i].equals(tmp) && arr[1][i].equals(tmp) && arr[2][i].equals(tmp)) {
                return true;
            }
        }
        // 대각선
        if (arr[0][0].equals(tmp) && arr[1][1].equals(tmp) && arr[2][2].equals(tmp)) {
            return true;
        }
        if (arr[0][2].equals(tmp) && arr[1][1].equals(tmp) && arr[2][0].equals(tmp)) {
            return true;
        }
        // 전부아니면 false
        return false;
    }
}
