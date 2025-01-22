// 1번 함수 => 연속으로 ':'이 나오면 그 갯수만큼 0000 복원
// 2번 함수 => 글자가 4개 미만일 경우 4개 될 때 까지 앞에 0 붙이기
// 반례 체크 => 1::1 / 1:1:: / ::1 / 1::
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String recoveredAddress = recoverBlank(input);
        String fullAddress = recoverZero(recoveredAddress);
        System.out.println(fullAddress);
    }

    public static String recoverBlank(String input) {
        StringBuilder result = new StringBuilder();
        String[] hexa = input.split("::");

        int l = hexa[0].isEmpty() ? 0 : hexa[0].split(":").length;

        int r = (hexa.length > 1 && !hexa[1].isEmpty()) ? hexa[1].split(":").length : 0;

        if (!hexa[0].isEmpty())result.append(hexa[0]);

        int repeatCnt = 8 - l - r;
        for (int i = 0; i < repeatCnt; i++) {
            if (result.length() > 0) result.append(":");
            result.append("0000");
        }

        if (hexa.length > 1 && !hexa[1].isEmpty()) {
            if (result.length() > 0) result.append(":");
            result.append(hexa[1]);
        }

        return result.toString();
    }

    public static String recoverZero(String input) {
        String[] hexa = input.split(":");
        for (int i = 0; i < 8; i++) {
            while (hexa[i].length() < 4) {
                hexa[i] = "0" + hexa[i];
            }
        }
        return String.join(":", hexa);
    }
}

// import java.util.*;
// import java.lang.StringBuilder;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String input = sc.next();
//         String recovered = recoverBlank(input);
//         String answer = recoverZero(recovered);
//         System.out.println(answer);
//     }
    
//     public static String recoverBlank(String input) {
//         if (input.contains("::")) {
//             String[] tmp = input.split("::");
//             int a = 1, b = 1;
//             StringBuilder result = new StringBuilder();

//             if (!tmp[0].equals("")) {
//                 a = tmp[0].split(":").length;
//                 result.append(tmp[0]);
//             } else {
//                 result.append("0000");
//             }

//             for (int i = 0; i < 8 - a - (tmp.length > 1 && !tmp[1].equals("") ? tmp[1].split(":").length : 0); i++) {
//                 result.append(":0000");
//             }

//             if (tmp.length > 1 && !tmp[1].equals("")) {
//                 result.append(":").append(tmp[1]);
//             } else if (tmp.length > 1) {
//                 result.append(":0000");
//             }

//             return result.toString();
//         } else {
//             return input;
//         }
//     }
    
//     public static String recoverZero(String input) {
//     	String[] hexa = input.split(":");
//     	// java 11 이상이면
//     	// for (int i = 0; i < 8; i++) {
//     	//     hexa[i] = "0".repeat(4 - hexa[i].length()) + hexa[i];
//     	// }
//     	// java 8 이하면
//     	 for (int i = 0; i < 8; i++) {
//     	        String tmp = "";
//     	        for (int j = 0; j < 4 - hexa[i].length(); j++) tmp += "0";
//     	        hexa[i] = tmp + hexa[i];
//     	    }
//     	return String.join(":",hexa);
//     }
// }