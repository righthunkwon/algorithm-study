import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int maxA = arrayA[0], maxB = arrayB[0];
        
        for (int a : arrayA){
            maxA = gcd(maxA, a);
        } 
        for (int b : arrayB){
            maxB = gcd(maxB, b);
        }
        int resultA = div(maxA, arrayB) ? maxA : 0;
        int resultB = div(maxB, arrayA) ? maxB : 0;
        
        return Math.max(resultA, resultB);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private boolean div(int tmp, int[] array) {
        for (int num : array) {
            if (num % tmp == 0) return false;
        }
        return true;
    }
}

import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 원소 값의 크기가 최대 1억이라 2부터 1억 까지 순회가 발생하면 안된다.
        // 방법1. arrayA의 첫 번째 원소와 arrayB의 첫 번째 원소 각각의 약수 리스트를 log n 속도로 가져온다.
        // 방법2. 그 다음에 각각 크로스해서 이중 for문 돌린다.
        // 그렇게 해서 최댓값 갱신한다. 
        int maxA = 0, minA = arrayA[0], minB = arrayB[0];
       ArrayList<Integer> listA = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(minA); i++){
            if(minA % i == 0){
                boolean toggle1 = true;
                for(int a : arrayA){
                    if(a % i != 0) toggle1 = false;
                }
                if(toggle1) listA.add(i);
                if(i*i != minA){
                    int tmp = minA / i;
                    boolean toggle2 = true;
                    for(int a : arrayA){
                        if(a % tmp != 0) toggle2 = false;
                    }
                    if(toggle2) listA.add(tmp);
                }
            }
        }
        
        ArrayList<Integer> listB = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(minB); i++){
            if(minB % i == 0){
                boolean toggle1 = true;
                for(int b : arrayB){
                    if(b % i != 0) toggle1 = false;
                }
                if(toggle1) listB.add(i);
                if(i*i != minB){
                    int tmp = minB / i;
                    boolean toggle2 = true;
                    for(int b : arrayB){
                        if(b % tmp != 0) toggle2 = false;
                    }
                    if(toggle2) listB.add(tmp);
                }
            }
        }
        
        for(Integer elA : listA){
            boolean toggle = true;
            for(int b : arrayB){
                if(b % elA == 0) toggle = false;
            }
            if(toggle){
                maxA = Math.max(maxA, elA);
            }
        }

        for(Integer elB : listB){
            boolean toggle = true;
            for(int a : arrayA){
                if(a % elB == 0) toggle = false;
            }
            if(toggle){
                maxA = Math.max(maxA, elB);
            }
        }
        return maxA;
    }
} 
