package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
//일단 올리기... 
public class Pro_16719_ZOAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
//        char[] change=new char[arr.length];
//        Arrays.sort(change);
//        
        String result = "";
        int minindex = -1;
        int maxindex = arr.length - 1;
        boolean isExist = false;
        Stack<Integer> stack = new Stack<>();
        while (true) {
            for (int i = minindex + 1; i <= maxindex; i++) {
                int min = Integer.MAX_VALUE;
                isExist = true;
                if (arr[i] < min) {
                    minindex = i;
                    stack.add(minindex);
                }
            }
            if (!isExist) {
                minindex = stack.pop();
                maxindex = minindex - 1;
            }
                result += arr[minindex];
                System.out.println(result);
            
        }
    }
}

